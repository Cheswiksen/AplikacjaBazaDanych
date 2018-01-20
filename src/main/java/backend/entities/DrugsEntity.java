package backend.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Drugs", schema = "dbo", catalog = "bd2")
public class DrugsEntity {
    private int drugId;
    private String drugName;
    private String drugPurpose;
    private Collection<DosageCollisionsEntity> dosageCollisionsByDrugId;
    private Collection<DosagesEntity> dosagesByDrugId;

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

        DrugsEntity drugsEntity = (DrugsEntity) o;

        if (drugId != drugsEntity.drugId) return false;
        if (drugName != null ? !drugName.equals(drugsEntity.drugName) : drugsEntity.drugName != null) return false;
        if (drugPurpose != null ? !drugPurpose.equals(drugsEntity.drugPurpose) : drugsEntity.drugPurpose != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = drugId;
        result = 31 * result + (drugName != null ? drugName.hashCode() : 0);
        result = 31 * result + (drugPurpose != null ? drugPurpose.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "drugsByDrugId")
    public Collection<DosageCollisionsEntity> getDosageCollisionsByDrugId() {
        return dosageCollisionsByDrugId;
    }

    public void setDosageCollisionsByDrugId(Collection<DosageCollisionsEntity> dosageCollisionsByDrugId) {
        this.dosageCollisionsByDrugId = dosageCollisionsByDrugId;
    }

    @OneToMany(mappedBy = "drugsByDrugId")
    public Collection<DosagesEntity> getDosagesByDrugId() {
        return dosagesByDrugId;
    }

    public void setDosagesByDrugId(Collection<DosagesEntity> dosagesByDrugId) {
        this.dosagesByDrugId = dosagesByDrugId;
    }
}
