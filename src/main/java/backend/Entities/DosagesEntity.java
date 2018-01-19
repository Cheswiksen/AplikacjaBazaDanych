package backend.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dosages", schema = "dbo", catalog = "bd2")
public class DosagesEntity {
    private int dosageId;

    @Id
    @Column(name = "dosage_id")
    public int getDosageId() {
        return dosageId;
    }

    public void setDosageId(int dosageId) {
        this.dosageId = dosageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DosagesEntity that = (DosagesEntity) o;

        return dosageId == that.dosageId;
    }

    @Override
    public int hashCode() {
        return dosageId;
    }
}
