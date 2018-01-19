package backend.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Animals", schema = "dbo", catalog = "bd2")
public class AnimalsEntity {
    private int animalId;
    private String animalName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalsEntity that = (AnimalsEntity) o;

        if (animalId != that.animalId) return false;
        return animalName != null ? animalName.equals(that.animalName) : that.animalName == null;
    }

    @Override
    public int hashCode() {
        int result = animalId;
        result = 31 * result + (animalName != null ? animalName.hashCode() : 0);
        return result;
    }
    @Override
    public String toString(){
        return "ID: "+animalId+" | animalName: "+animalName;
    }
}
