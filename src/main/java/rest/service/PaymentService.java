package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entity.Payment;
import rest.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService{
    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> getAllPayment(){
        List<Payment> allPayment = paymentRepository.findAll();
        return allPayment;
    }

    public Payment getOnePayment(String referenceId) {
        Optional<Payment> foundPayment = paymentRepository.findById(referenceId);
        Payment payment = foundPayment.get();
        return payment;
    }

    public Payment createPayment(Payment Payment) {
        Payment createdPayment = paymentRepository.save(Payment);
        return createdPayment;
    }

    public void deleteOnePayment(String referenceId) {
        paymentRepository.deleteById(referenceId);
    }

    public void updatePaymentStatus(String referenceId, Boolean status) {
        paymentRepository.updatePaymentStatus(referenceId, status);
    }
}
