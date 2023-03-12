package rest.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerId")
public class Customer {
    @Id
    @GeneratedValue
    private Integer customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNumber;
    private String alternateNumber;
    @Column(unique=true)
    private String aadharNumber;
    private String aadharPic;
    private String guarantor1Aadhar;
    private String guarantor2Aadhar;

    private String password;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // attributes are necessary
    @JoinColumn(name="addressId")
    private Address customerAddress;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="adminId")
    private Admin admin;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="bhishiId")
    private Bhishi bhishi;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="documentId")
    private SecurityDocuments securityDocuments;


    public Customer(String firstName, String middleName, String lastName, String mobileNumber, String alternateNumber, String aadharNumber, String aadharPic, String guarantor1Aadhar, String guarantor2Aadhar, String password,Address address, Admin admin, Bhishi bhishi, SecurityDocuments securityDocuments) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.alternateNumber = alternateNumber;
        this.aadharNumber = aadharNumber;
        this.aadharPic = aadharPic;
        this.guarantor1Aadhar = guarantor1Aadhar;
        this.guarantor2Aadhar = guarantor2Aadhar;
        this.password = password;
        this.customerAddress = address;
        this.admin = admin;
        this.bhishi = bhishi;
        this.securityDocuments = securityDocuments;
    }

    public Customer() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setAlternateNumber(String alternateNumber) {
        this.alternateNumber = alternateNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public void setAadharPic(String aadharPic) {
        this.aadharPic = aadharPic;
    }

    public void setGuarantor1Aadhar(String guarantor1Aadhar) {
        this.guarantor1Aadhar = guarantor1Aadhar;
    }

    public void setGuarantor2Aadhar(String guarantor2Aadhar) {
        this.guarantor2Aadhar = guarantor2Aadhar;
    }

    public Admin getAdminDetails() {
        return admin;
    }

    public void setAdminDetails(Admin admin) {
        this.admin = admin;
    }

    public Bhishi getBhishiDetails() {
        return bhishi;
    }

    public void setBhishiDetails(Bhishi bhishi) {
        this.bhishi = bhishi;
    }

    public SecurityDocuments getSecurityDocuments() {
        return securityDocuments;
    }

    public void setSecurityDocuments(SecurityDocuments securityDocuments) {
        this.securityDocuments = securityDocuments;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAlternateNumber() {
        return alternateNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public String getAadharPic() {
        return aadharPic;
    }

    public String getGuarantor1Aadhar() {
        return guarantor1Aadhar;
    }

    public String getGuarantor2Aadhar() {
        return guarantor2Aadhar;
    }

    public void setAddress(Address address) {
        this.customerAddress = address;
    }

    public Address getAddress() {
        return customerAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
