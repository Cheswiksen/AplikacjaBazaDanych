package backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "Dosage_collisions", schema = "dbo", catalog = "bd2")
public class DosageCollisionsEntity {
    private int dosageCollisionId;
    private DrugsEntity drugsByDrugId;
    private CollisionGroupsEntity collisionGroupsByCollisionGroupId;

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

        if (dosageCollisionId != that.dosageCollisionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return dosageCollisionId;
    }

    @ManyToOne
    @JoinColumn(name = "drug_id", referencedColumnName = "drug_id", nullable = false)
    public DrugsEntity getDrugsByDrugId() {
        return drugsByDrugId;
    }

    public void setDrugsByDrugId(DrugsEntity drugsByDrugId) {
        this.drugsByDrugId = drugsByDrugId;
    }

    @ManyToOne
    @JoinColumn(name = "collision_group_id", referencedColumnName = "collision_group_id", nullable = false)
    public CollisionGroupsEntity getCollisionGroupsByCollisionGroupId() {
        return collisionGroupsByCollisionGroupId;
    }

    public void setCollisionGroupsByCollisionGroupId(CollisionGroupsEntity collisionGroupsByCollisionGroupId) {
        this.collisionGroupsByCollisionGroupId = collisionGroupsByCollisionGroupId;
    }
}
