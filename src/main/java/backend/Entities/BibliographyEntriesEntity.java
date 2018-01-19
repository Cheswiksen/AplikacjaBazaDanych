package backend.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Bibliography_entries", schema = "dbo", catalog = "bd2")
public class BibliographyEntriesEntity {
    private int bibliographyEntryId;
    private String sourceExtension;

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
        return sourceExtension != null ? sourceExtension.equals(that.sourceExtension) : that.sourceExtension == null;
    }

    @Override
    public int hashCode() {
        int result = bibliographyEntryId;
        result = 31 * result + (sourceExtension != null ? sourceExtension.hashCode() : 0);
        return result;
    }
}
