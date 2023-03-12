package rest.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "referenceId")
public class Payment {
    @Id
    private String referenceId;

    private Integer amount;

    private  boolean status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bhishiId")
    private Bhishi bhishi;

    public Payment() {
    }

    public Payment(String referenceId, Integer amount, Bhishi bhishi, boolean status) {
        this.referenceId = referenceId;
        this.amount = amount;
        this.status = status;
        this.bhishi = bhishi;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Bhishi getBhishi() {
        return bhishi;
    }

    public void setBhishi(Bhishi bhishi) {
        this.bhishi = bhishi;
    }
}
