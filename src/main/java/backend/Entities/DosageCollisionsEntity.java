package backend.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dosage_collisions", schema = "dbo", catalog = "bd2")
public class DosageCollisionsEntity {
    private int dosageCollisionId;

    @Id
    @Column(name = "dosage_collision_id")
    public int getDosageCollisionId() {
        return dosageCollisionId;
    }

    public void setDosageCollisionId(int dosageCollisionId) {
        this.dosageCollisionId = dosageCollisionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DosageCollisionsEntity that = (DosageCollisionsEntity) o;

        return dosageCollisionId == that.dosageCollisionId;
    }

    @Override
    public int hashCode() {
        return dosageCollisionId;
    }
}
