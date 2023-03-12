package rest.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "documentId")
public class SecurityDocuments {
    @Id
    @GeneratedValue
    private int documentId;
    private String document1;
    private String document2;
    private String document3;
    private String document4;

    @OneToOne(mappedBy = "securityDocuments")
    private Customer customer;
    public SecurityDocuments(String document1, String document2, String document3, String document4) {
        this.document1 = document1;
        this.document2 = document2;
        this.document3 = document3;
        this.document4 = document4;
    }

    public SecurityDocuments() {
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getDocument1() {
        return document1;
    }

    public void setDocument1(String document1) {
        this.document1 = document1;
    }

    public String getDocument2() {
        return document2;
    }

    public void setDocument2(String document2) {
        this.document2 = document2;
    }

    public String getDocument3() {
        return document3;
    }

    public void setDocument3(String document3) {
        this.document3 = document3;
    }

    public String getDocument4() {
        return document4;
    }

    public void setDocument4(String document4) {
        this.document4 = document4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityDocuments that = (SecurityDocuments) o;
        return documentId == that.documentId && Objects.equals(document1, that.document1) && Objects.equals(document2, that.document2) && Objects.equals(document3, that.document3) && Objects.equals(document4, that.document4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId, document1, document2, document3, document4);
    }
}
