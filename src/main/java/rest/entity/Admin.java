package rest.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "adminId")
public class Admin {
    @Id
    @GeneratedValue
    private Integer adminId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNumber;
    private String alternateNumber;
    @Column(unique=true)
    private String aadharNumber;
    private String aadharPic;
    private String panNumber;
    private String panPic;

    private  String password;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // attributes are necessary
    @JoinColumn(name="AddressId")
    private Address address;

    @OneToMany(mappedBy = "admin")
    private Set<Customer> customerDetails;

    public Admin(String firstName, String middleName, String lastName, String mobileNumber, String alternateNumber, String aadharNumber, String aadharPic, String panNumber, String panPic, Address address) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.alternateNumber = alternateNumber;
        this.aadharNumber = aadharNumber;
        this.aadharPic = aadharPic;
        this.panNumber = panNumber;
        this.panPic = panPic;
        this.address = address;
    }

    public Admin() {
    }

    public int getAdminId() {
        return adminId;
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

    public String getPanNumber() {
        return panNumber;
    }

    public String getPanPic() {
        return panPic;
    }

    public Address getAddress() {
        return address;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public void setPanPic(String panPic) {
        this.panPic = panPic;
    }

    public void setAddressId(Address addressId) {this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}