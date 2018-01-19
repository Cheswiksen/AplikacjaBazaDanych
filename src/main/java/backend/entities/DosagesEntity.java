package backend.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Dosages", schema = "dbo", catalog = "bd2")
public class DosagesEntity {
    private int dosageId;
    private int drugId;
    private Integer animalId;
    private Integer bibliographyId;
    private Collection<DosageCommentsEntity> dosageCommentsByDosageId;
    private Collection<DosageMethodsEntity> dosageMethodsByDosageId;
    private DrugsEntity drugsByDrugId;
    private AnimalsEntity animalsByAnimalId;
    private BibliographiesEntity bibliographiesByBibliographyId;

    @Id
    @Column(name = "dosage_id")
    public int getDosageId() {
        return dosageId;
    }

    public void setDosageId(int dosageId) {
        this.dosageId = dosageId;
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
    @Column(name = "animal_id")
    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
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

        DosagesEntity that = (DosagesEntity) o;

        if (dosageId != that.dosageId) return false;
        if (drugId != that.drugId) return false;
        if (animalId != null ? !animalId.equals(that.animalId) : that.animalId != null) return false;
        if (bibliographyId != null ? !bibliographyId.equals(that.bibliographyId) : that.bibliographyId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dosageId;
        result = 31 * result + drugId;
        result = 31 * result + (animalId != null ? animalId.hashCode() : 0);
        result = 31 * result + (bibliographyId != null ? bibliographyId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dosagesByDosageId")
    public Collection<DosageCommentsEntity> getDosageCommentsByDosageId() {
        return dosageCommentsByDosageId;
    }

    public void setDosageCommentsByDosageId(Collection<DosageCommentsEntity> dosageCommentsByDosageId) {
        this.dosageCommentsByDosageId = dosageCommentsByDosageId;
    }

    @OneToMany(mappedBy = "dosagesByDosageId")
    public Collection<DosageMethodsEntity> getDosageMethodsByDosageId() {
        return dosageMethodsByDosageId;
    }

    public void setDosageMethodsByDosageId(Collection<DosageMethodsEntity> dosageMethodsByDosageId) {
        this.dosageMethodsByDosageId = dosageMethodsByDosageId;
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
    @JoinColumn(name = "animal_id", referencedColumnName = "animal_id")
    public AnimalsEntity getAnimalsByAnimalId() {
        return animalsByAnimalId;
    }

    public void setAnimalsByAnimalId(AnimalsEntity animalsByAnimalId) {
        this.animalsByAnimalId = animalsByAnimalId;
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
