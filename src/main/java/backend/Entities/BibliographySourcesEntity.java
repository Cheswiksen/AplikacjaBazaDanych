package backend.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Bibliography_sources", schema = "dbo", catalog = "bd2")
public class BibliographySourcesEntity {
    private int bibliographySourceId;
    private String source;

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
        return source != null ? source.equals(that.source) : that.source == null;
    }

    @Override
    public int hashCode() {
        int result = bibliographySourceId;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }
}
