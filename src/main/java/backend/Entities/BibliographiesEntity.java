package backend.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bibliographies", schema = "dbo", catalog = "bd2")
public class BibliographiesEntity {
    private int bibliographyId;

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

        return bibliographyId == that.bibliographyId;
    }

    @Override
    public int hashCode() {
        return bibliographyId;
    }
}
