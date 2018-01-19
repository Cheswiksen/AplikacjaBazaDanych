package backend.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Divisions", schema = "dbo", catalog = "bd2")
public class DivisionsEntity {
    private int divisionId;
    private String divisionName;

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
        return divisionName != null ? divisionName.equals(that.divisionName) : that.divisionName == null;
    }

    @Override
    public int hashCode() {
        int result = divisionId;
        result = 31 * result + (divisionName != null ? divisionName.hashCode() : 0);
        return result;
    }
}
