package backend.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Bibliographies", schema = "dbo", catalog = "bd2")
public class BibliographiesEntity {
    private int bibliographyId;
    private Collection<BibliographyEntriesEntity> bibliographyEntriesByBibliographyId;
    private Collection<CollisionGroupsEntity> collisionGroupsByBibliographyId;
    private Collection<DosageCommentsEntity> dosageCommentsByBibliographyId;
    private Collection<DosagesEntity> dosagesByBibliographyId;

    @Id
    @Column(name = "bibliography_id")
    public int getBibliographyId() {
        return bibliographyId;
    }

    public void setBibliographyId(int bibliographyId) {
        this.bibliographyId = bibliographyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BibliographiesEntity that = (BibliographiesEntity) o;

        if (bibliographyId != that.bibliographyId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return bibliographyId;
    }

    @OneToMany(mappedBy = "bibliographiesByBibliographyId")
    public Collection<BibliographyEntriesEntity> getBibliographyEntriesByBibliographyId() {
        return bibliographyEntriesByBibliographyId;
    }

    public void setBibliographyEntriesByBibliographyId(Collection<BibliographyEntriesEntity> bibliographyEntriesByBibliographyId) {
        this.bibliographyEntriesByBibliographyId = bibliographyEntriesByBibliographyId;
    }

    @OneToMany(mappedBy = "bibliographiesByBibliographyId")
    public Collection<CollisionGroupsEntity> getCollisionGroupsByBibliographyId() {
        return collisionGroupsByBibliographyId;
    }

    public void setCollisionGroupsByBibliographyId(Collection<CollisionGroupsEntity> collisionGroupsByBibliographyId) {
        this.collisionGroupsByBibliographyId = collisionGroupsByBibliographyId;
    }

    @OneToMany(mappedBy = "bibliographiesByBibliographyId")
    public Collection<DosageCommentsEntity> getDosageCommentsByBibliographyId() {
        return dosageCommentsByBibliographyId;
    }

    public void setDosageCommentsByBibliographyId(Collection<DosageCommentsEntity> dosageCommentsByBibliographyId) {
        this.dosageCommentsByBibliographyId = dosageCommentsByBibliographyId;
    }

    @OneToMany(mappedBy = "bibliographiesByBibliographyId")
    public Collection<DosagesEntity> getDosagesByBibliographyId() {
        return dosagesByBibliographyId;
    }

    public void setDosagesByBibliographyId(Collection<DosagesEntity> dosagesByBibliographyId) {
        this.dosagesByBibliographyId = dosagesByBibliographyId;
    }
}
