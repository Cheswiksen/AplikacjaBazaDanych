package backend.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Drugs", schema = "dbo", catalog = "bd2")
public class DrugsEntity {
    private int drugId;
    private String drugName;
    private String drugPurpose;

    @Id
    @Column(name = "drug_id")
    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    @Basic
    @Column(name = "drug_name")
    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Basic
    @Column(name = "drug_purpose")
    public String getDrugPurpose() {
        return drugPurpose;
    }

    public void setDrugPurpose(String drugPurpose) {
        this.drugPurpose = drugPurpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrugsEntity that = (DrugsEntity) o;

        if (drugId != that.drugId) return false;
        if (drugName != null ? !drugName.equals(that.drugName) : that.drugName != null) return false;
        return drugPurpose != null ? drugPurpose.equals(that.drugPurpose) : that.drugPurpose == null;
    }

    @Override
    public int hashCode() {
        int result = drugId;
        result = 31 * result + (drugName != null ? drugName.hashCode() : 0);
        result = 31 * result + (drugPurpose != null ? drugPurpose.hashCode() : 0);
        return result;
    }
}
