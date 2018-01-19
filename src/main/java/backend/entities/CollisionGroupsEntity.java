package backend.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Collision_groups", schema = "dbo", catalog = "bd2")
public class CollisionGroupsEntity {
    private int collisionGroupId;
    private String comment;
    private Integer bibliographyId;
    private int collisionSeverityId;
    private BibliographiesEntity bibliographiesByBibliographyId;
    private CollisionSeveritiesEntity collisionSeveritiesByCollisionSeverityId;
    private Collection<DosageCollisionsEntity> dosageCollisionsByCollisionGroupId;

    @Id
    @Column(name = "collision_group_id")
    public int getCollisionGroupId() {
        return collisionGroupId;
    }

    public void setCollisionGroupId(int collisionGroupId) {
        this.collisionGroupId = collisionGroupId;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "bibliography_id")
    public Integer getBibliographyId() {
        return bibliographyId;
    }

    public void setBibliographyId(Integer bibliographyId) {
        this.bibliographyId = bibliographyId;
    }

    @Basic
    @Column(name = "collision_severity_id")
    public int getCollisionSeverityId() {
        return collisionSeverityId;
    }

    public void setCollisionSeverityId(int collisionSeverityId) {
        this.collisionSeverityId = collisionSeverityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollisionGroupsEntity that = (CollisionGroupsEntity) o;

        if (collisionGroupId != that.collisionGroupId) return false;
        if (collisionSeverityId != that.collisionSeverityId) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (bibliographyId != null ? !bibliographyId.equals(that.bibliographyId) : that.bibliographyId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collisionGroupId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (bibliographyId != null ? bibliographyId.hashCode() : 0);
        result = 31 * result + collisionSeverityId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "bibliography_id", referencedColumnName = "bibliography_id")
    public BibliographiesEntity getBibliographiesByBibliographyId() {
        return bibliographiesByBibliographyId;
    }

    public void setBibliographiesByBibliographyId(BibliographiesEntity bibliographiesByBibliographyId) {
        this.bibliographiesByBibliographyId = bibliographiesByBibliographyId;
    }

    @ManyToOne
    @JoinColumn(name = "collision_severity_id", referencedColumnName = "collision_severity_id", nullable = false)
    public CollisionSeveritiesEntity getCollisionSeveritiesByCollisionSeverityId() {
        return collisionSeveritiesByCollisionSeverityId;
    }

    public void setCollisionSeveritiesByCollisionSeverityId(CollisionSeveritiesEntity collisionSeveritiesByCollisionSeverityId) {
        this.collisionSeveritiesByCollisionSeverityId = collisionSeveritiesByCollisionSeverityId;
    }

    @OneToMany(mappedBy = "collisionGroupsByCollisionGroupId")
    public Collection<DosageCollisionsEntity> getDosageCollisionsByCollisionGroupId() {
        return dosageCollisionsByCollisionGroupId;
    }

    public void setDosageCollisionsByCollisionGroupId(Collection<DosageCollisionsEntity> dosageCollisionsByCollisionGroupId) {
        this.dosageCollisionsByCollisionGroupId = dosageCollisionsByCollisionGroupId;
    }
}
