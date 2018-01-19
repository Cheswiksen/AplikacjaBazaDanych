package backend.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Divisions", schema = "dbo", catalog = "bd2")
public class DivisionsEntity {
    private int divisionId;
    private String divisionName;
    private Collection<AnimalsEntity> animalsByDivisionId;

    @Id
    @Column(name = "division_id")
    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    @Basic
    @Column(name = "division_name")
    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DivisionsEntity that = (DivisionsEntity) o;

        if (divisionId != that.divisionId) return false;
        if (divisionName != null ? !divisionName.equals(that.divisionName) : that.divisionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = divisionId;
        result = 31 * result + (divisionName != null ? divisionName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "divisionsByDivisionId")
    public Collection<AnimalsEntity> getAnimalsByDivisionId() {
        return animalsByDivisionId;
    }

    public void setAnimalsByDivisionId(Collection<AnimalsEntity> animalsByDivisionId) {
        this.animalsByDivisionId = animalsByDivisionId;
    }
}
