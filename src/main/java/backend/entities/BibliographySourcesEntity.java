package backend.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Bibliography_sources", schema = "dbo", catalog = "bd2")
public class BibliographySourcesEntity {
    private int bibliographySourceId;
    private String source;
    private Collection<BibliographyEntriesEntity> bibliographyEntriesByBibliographySourceId;

    @Id
    @Column(name = "bibliography_source_id")
    public int getBibliographySourceId() {
        return bibliographySourceId;
    }

    public void setBibliographySourceId(int bibliographySourceId) {
        this.bibliographySourceId = bibliographySourceId;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BibliographySourcesEntity that = (BibliographySourcesEntity) o;

        if (bibliographySourceId != that.bibliographySourceId) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bibliographySourceId;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bibliographySourcesBySourceId")
    public Collection<BibliographyEntriesEntity> getBibliographyEntriesByBibliographySourceId() {
        return bibliographyEntriesByBibliographySourceId;
    }

    public void setBibliographyEntriesByBibliographySourceId(Collection<BibliographyEntriesEntity> bibliographyEntriesByBibliographySourceId) {
        this.bibliographyEntriesByBibliographySourceId = bibliographyEntriesByBibliographySourceId;
    }
}
