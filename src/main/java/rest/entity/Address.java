package rest.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "addressId")
@Entity
public class Address {

    @Id
    @GeneratedValue
    private int addressId;
    private String street;
    private String locality;
    private String cityOrVillage;
    private String tahasil;
    private String district;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "address") // instance variable name not a column name;
    private Admin admin;

    @OneToOne(mappedBy = "customerAddress")
    private Customer customer;

    @OneToOne(mappedBy = "newCustomerAddress")
    private NewCustomer newCustomer;

    public void setAdminDetails(Admin admin) {
        this.admin = admin;
    }

    public Address(int addressId, String street, String locality, String cityOrVillage, String tahasil, String district, String state, String zipCode) {
        this.addressId = addressId;
        this.street = street;
        this.locality = locality;
        this.cityOrVillage = cityOrVillage;
        this.tahasil = tahasil;
        this.district = district;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address() {
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setCityOrVillage(String cityOrVillage) {
        this.cityOrVillage = cityOrVillage;
    }

    public void setTahasil(String tahasil) {
        this.tahasil = tahasil;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public String getLocality() {
        return locality;
    }

    public String getCityOrVillage() {
        return cityOrVillage;
    }

    public String getTahasil() {
        return tahasil;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address adresses = (Address) o;
        return addressId == adresses.addressId && Objects.equals(street, adresses.street) && Objects.equals(locality, adresses.locality) && Objects.equals(cityOrVillage, adresses.cityOrVillage) && Objects.equals(tahasil, adresses.tahasil) && Objects.equals(district, adresses.district) && Objects.equals(state, adresses.state) && Objects.equals(zipCode, adresses.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, street, locality, cityOrVillage, tahasil, district, state, zipCode);
    }
}
