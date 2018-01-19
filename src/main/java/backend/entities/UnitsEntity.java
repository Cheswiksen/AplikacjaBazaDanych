package backend.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Units", schema = "dbo", catalog = "bd2")
public class UnitsEntity {
    private int unitId;
    private String unitText;
    private String unitShortcut;
    private Collection<DosageMethodsEntity> dosageMethodsByUnitId;

    @Id
    @Column(name = "unit_id")
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "unit_text")
    public String getUnitText() {
        return unitText;
    }

    public void setUnitText(String unitText) {
        this.unitText = unitText;
    }

    @Basic
    @Column(name = "unit_shortcut")
    public String getUnitShortcut() {
        return unitShortcut;
    }

    public void setUnitShortcut(String unitShortcut) {
        this.unitShortcut = unitShortcut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitsEntity that = (UnitsEntity) o;

        if (unitId != that.unitId) return false;
        if (unitText != null ? !unitText.equals(that.unitText) : that.unitText != null) return false;
        if (unitShortcut != null ? !unitShortcut.equals(that.unitShortcut) : that.unitShortcut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitId;
        result = 31 * result + (unitText != null ? unitText.hashCode() : 0);
        result = 31 * result + (unitShortcut != null ? unitShortcut.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "unitsByUnitId")
    public Collection<DosageMethodsEntity> getDosageMethodsByUnitId() {
        return dosageMethodsByUnitId;
    }

    public void setDosageMethodsByUnitId(Collection<DosageMethodsEntity> dosageMethodsByUnitId) {
        this.dosageMethodsByUnitId = dosageMethodsByUnitId;
    }
}
