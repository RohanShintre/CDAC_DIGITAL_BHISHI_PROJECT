package rest.controller;

import com.razorpay.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.json.JSONObject;
import com.razorpay.RazorpayException;
import org.springframework.web.servlet.view.RedirectView;
import rest.entity.Bhishi;
import rest.entity.Customer;
import rest.entity.Payment;
import rest.service.BhishiService;
import rest.service.CustomerService;
import rest.service.PaymentService;

import java.util.Optional;
import java.util.UUID;

@RestController

public class NewPaymentController {

    @Autowired
    PaymentService paymentService;


    @Autowired
    CustomerService customerService;

    @Autowired
    BhishiService bhishiService;
    private String referenceId;

    public void generateReferenceId() {
        String uniqueId = UUID.randomUUID().toString().substring(0, 8); // truncate UUID to 8 characters
        String timestamp = Long.toString(System.currentTimeMillis());
        this.referenceId = timestamp + "-" + uniqueId;

        // check if reference ID length exceeds 40 characters and truncate if necessary
        if (this.referenceId.length() > 40) {
            this.referenceId = this.referenceId.substring(0, 40);
        }
    }

    @GetMapping("/newPayment/{amount}")
    public String newPayment(HttpSession session, @PathVariable Integer amount) throws RazorpayException {
        amount = amount * 100;
        String mobileNumber = (String) session.getAttribute("customerMobileNo");
        if(mobileNumber == null){
            System.out.println(mobileNumber);
        }
        System.out.println("MobileNumber" + mobileNumber);
        generateReferenceId();
        //String mobileNumber ="9766594663";
        Customer customer= customerService.getOneCustomer(mobileNumber);
        Bhishi bhishi = customer.getBhishiDetails();
        System.out.println(referenceId);
        Payment paymentEntity = new Payment(referenceId, amount/100, bhishi, false);
        RazorpayClient razorpay = new RazorpayClient("rzp_test_o3sAPlXAniW3L2", "hk8i7Xk2ociOld0PLyaV00TA");
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1691097057);
        paymentLinkRequest.put("reference_id",referenceId);
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customerJson = new JSONObject();
        customerJson.put("mobileNumber", "+919545105137");
        paymentLinkRequest.put("customer",customerJson);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","http://localhost:8082/paymentSuccess");
        paymentLinkRequest.put("callback_method","get");
        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        System.out.println(payment);
        String url =  payment.get("short_url");
        System.out.println(url);
        System.out.println("Hello");
        paymentService.createPayment(paymentEntity);
        return url;
    }

    @GetMapping("/paymentSuccess")
    public void paymentSuccsess(HttpServletResponse response, @RequestParam String razorpay_payment_id, @RequestParam String razorpay_payment_link_id,
                                @RequestParam String razorpay_payment_link_reference_id, @RequestParam String razorpay_payment_link_status,
                                @RequestParam String razorpay_signature ) {
        Payment paymentEntity =  paymentService.getOnePayment(razorpay_payment_link_reference_id);
        Integer amount = paymentEntity.getAmount();

        Bhishi bhishi = paymentEntity.getBhishi();
        double paidUpValues = bhishi.getPaidUpValues();
        bhishiService.updatePadeUpValues(bhishi.getBhishiId(), amount + paidUpValues);
        paymentService.updatePaymentStatus(razorpay_payment_link_reference_id,true);
        System.out.println(razorpay_payment_link_reference_id);
        response.setHeader("Location", "http://localhost:3000/userBhishi");
        response.setStatus(302);
    }

    @GetMapping("/redirect-to-react")
    public String redirectToReactPage() {
        return "redirect:/http://localhost:3000/userBhishi";
    }




}