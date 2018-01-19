package backend.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Animals", schema = "dbo", catalog = "bd2")
public class AnimalsEntity {
    private int animalId;
    private String animalName;
    private int divisionId;
    private DivisionsEntity divisionsByDivisionId;
    private Collection<DosagesEntity> dosagesByAnimalId;

    @Id
    @Column(name = "animal_id")
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    @Basic
    @Column(name = "animal_name")
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Basic
    @Column(name = "division_id")
    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalsEntity that = (AnimalsEntity) o;

        if (animalId != that.animalId) return false;
        if (divisionId != that.divisionId) return false;
        if (animalName != null ? !animalName.equals(that.animalName) : that.animalName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = animalId;
        result = 31 * result + (animalName != null ? animalName.hashCode() : 0);
        result = 31 * result + divisionId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id", nullable = false)
    public DivisionsEntity getDivisionsByDivisionId() {
        return divisionsByDivisionId;
    }

    public void setDivisionsByDivisionId(DivisionsEntity divisionsByDivisionId) {
        this.divisionsByDivisionId = divisionsByDivisionId;
    }

    @OneToMany(mappedBy = "animalsByAnimalId")
    public Collection<DosagesEntity> getDosagesByAnimalId() {
        return dosagesByAnimalId;
    }

    public void setDosagesByAnimalId(Collection<DosagesEntity> dosagesByAnimalId) {
        this.dosagesByAnimalId = dosagesByAnimalId;
    }
}
