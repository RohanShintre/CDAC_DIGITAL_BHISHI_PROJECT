package rest.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "loanId")
public class Loan {
    @Id
    @GeneratedValue
    private int loanId;
    private LocalDateTime dateTime;
    private String endDate;
    private double principalAmount;
    private float interestPercent;
    private double repaidAmount;


    @OneToOne(mappedBy = "loan")
    private Bhishi bhishi;

    public Loan(LocalDateTime dateTime, String endDate, double principalAmount, float interestPercent, double repaidAmount) {
        this.dateTime = dateTime;
        this.endDate = endDate;
        this.principalAmount = principalAmount;
        this.interestPercent = interestPercent;
        this.repaidAmount = repaidAmount;
    }

    public Loan() {
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public float getInterestPercent() {
        return interestPercent;
    }

    public void setInterestPercent(float interestPercent) {
        this.interestPercent = interestPercent;
    }

    public double getRepaidAmount() {
        return repaidAmount;
    }

    public void setRepaidAmount(double repaidAmount) {
        this.repaidAmount = repaidAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan that = (Loan) o;
        return loanId == that.loanId && Double.compare(that.principalAmount, principalAmount) == 0 && Float.compare(that.interestPercent, interestPercent) == 0 && Double.compare(that.repaidAmount, repaidAmount) == 0 && Objects.equals(dateTime, that.dateTime) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, dateTime, endDate, principalAmount, interestPercent, repaidAmount);
    }


}
