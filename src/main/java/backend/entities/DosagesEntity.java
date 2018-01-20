package backend.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Dosages", schema = "dbo", catalog = "bd2")
public class DosagesEntity {
    private int dosageId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DosagesEntity dosagesEntity = (DosagesEntity) o;

        if (dosageId != dosagesEntity.dosageId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return dosageId;
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
