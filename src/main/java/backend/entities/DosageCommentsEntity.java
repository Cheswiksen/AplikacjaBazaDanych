package backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "Dosage_comments", schema = "dbo", catalog = "bd2")
public class DosageCommentsEntity {
    private int dosageCommentId;
    private int dosageId;
    private String comment;
    private Integer bibliographyId;
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
    @Column(name = "dosage_id")
    public int getDosageId() {
        return dosageId;
    }

    public void setDosageId(int dosageId) {
        this.dosageId = dosageId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DosageCommentsEntity that = (DosageCommentsEntity) o;

        if (dosageCommentId != that.dosageCommentId) return false;
        if (dosageId != that.dosageId) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (bibliographyId != null ? !bibliographyId.equals(that.bibliographyId) : that.bibliographyId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dosageCommentId;
        result = 31 * result + dosageId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (bibliographyId != null ? bibliographyId.hashCode() : 0);
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
