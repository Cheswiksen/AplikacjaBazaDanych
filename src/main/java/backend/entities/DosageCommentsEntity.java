package backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "Dosage_comments", schema = "dbo", catalog = "bd2")
public class DosageCommentsEntity {
    private int dosageCommentId;
    private String comment;
    private DosagesEntity dosagesByDosageId;
    private BibliographiesEntity bibliographiesByBibliographyId;

    @Id
    @Column(name = "dosage_comment_id")
    public int getDosageCommentId() {
        return dosageCommentId;
    }

    public void setDosageCommentId(int dosageCommentId) {
        this.dosageCommentId = dosageCommentId;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DosageCommentsEntity that = (DosageCommentsEntity) o;

        if (dosageCommentId != that.dosageCommentId) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dosageCommentId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dosage_id", referencedColumnName = "dosage_id", nullable = false)
    public DosagesEntity getDosagesByDosageId() {
        return dosagesByDosageId;
    }

    public void setDosagesByDosageId(DosagesEntity dosagesByDosageId) {
        this.dosagesByDosageId = dosagesByDosageId;
    }

    @ManyToOne
    @JoinColumn(name = "bibliography_id", referencedColumnName = "bibliography_id")
    public BibliographiesEntity getBibliographiesByBibliographyId() {
        return bibliographiesByBibliographyId;
    }

    public void setBibliographiesByBibliographyId(BibliographiesEntity bibliographiesByBibliographyId) {
        this.bibliographiesByBibliographyId = bibliographiesByBibliographyId;
    }
}
