package backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "Bibliography_entries", schema = "dbo", catalog = "bd2")
public class BibliographyEntriesEntity {
    private int bibliographyEntryId;
    private String sourceExtension;
    private BibliographiesEntity bibliographiesByBibliographyId;
    private BibliographySourcesEntity bibliographySourcesBySourceId;

    @Id
    @Column(name = "bibliography_entry_id")
    public int getBibliographyEntryId() {
        return bibliographyEntryId;
    }

    public void setBibliographyEntryId(int bibliographyEntryId) {
        this.bibliographyEntryId = bibliographyEntryId;
    }

    @Basic
    @Column(name = "source_extension")
    public String getSourceExtension() {
        return sourceExtension;
    }

    public void setSourceExtension(String sourceExtension) {
        this.sourceExtension = sourceExtension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BibliographyEntriesEntity that = (BibliographyEntriesEntity) o;

        if (bibliographyEntryId != that.bibliographyEntryId) return false;
        if (!bibliographySourcesBySourceId.equals(that.bibliographySourcesBySourceId)) return false;
        if (sourceExtension != null ? !sourceExtension.equals(that.sourceExtension) : that.sourceExtension != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bibliographyEntryId;
        result = 31 * result + bibliographySourcesBySourceId.hashCode();
        result = 31 * result + (sourceExtension != null ? sourceExtension.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "bibliography_id", referencedColumnName = "bibliography_id", nullable = false)
    public BibliographiesEntity getBibliographiesByBibliographyId() {
        return bibliographiesByBibliographyId;
    }

    public void setBibliographiesByBibliographyId(BibliographiesEntity bibliographiesByBibliographyId) {
        this.bibliographiesByBibliographyId = bibliographiesByBibliographyId;
    }

    @ManyToOne
    @JoinColumn(name = "source_id", referencedColumnName = "bibliography_source_id", nullable = false)
    public BibliographySourcesEntity getBibliographySourcesBySourceId() {
        return bibliographySourcesBySourceId;
    }

    public void setBibliographySourcesBySourceId(BibliographySourcesEntity bibliographySourcesBySourceId) {
        this.bibliographySourcesBySourceId = bibliographySourcesBySourceId;
    }
}
