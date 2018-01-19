package backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "Dosage_collisions", schema = "dbo", catalog = "bd2")
public class DosageCollisionsEntity {
    private int dosageCollisionId;
    private int drugId;
    private int collisionGroupId;
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

    @Basic
    @Column(name = "drug_id")
    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    @Basic
    @Column(name = "collision_group_id")
    public int getCollisionGroupId() {
        return collisionGroupId;
    }

    public void setCollisionGroupId(int collisionGroupId) {
        this.collisionGroupId = collisionGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DosageCollisionsEntity that = (DosageCollisionsEntity) o;

        if (dosageCollisionId != that.dosageCollisionId) return false;
        if (drugId != that.drugId) return false;
        if (collisionGroupId != that.collisionGroupId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dosageCollisionId;
        result = 31 * result + drugId;
        result = 31 * result + collisionGroupId;
        return result;
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
