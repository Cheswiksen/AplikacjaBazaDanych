package backend.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Dosage_methods", schema = "dbo", catalog = "bd2")
public class DosageMethodsEntity {
    private int dosageMethodId;
    private float unitLowerValue;
    private Float unitHigherValue;

    @Id
    @Column(name = "dosage_method_id")
    public int getDosageMethodId() {
        return dosageMethodId;
    }

    public void setDosageMethodId(int dosageMethodId) {
        this.dosageMethodId = dosageMethodId;
    }

    @Basic
    @Column(name = "unit_lower_value")
    public float getUnitLowerValue() {
        return unitLowerValue;
    }

    public void setUnitLowerValue(float unitLowerValue) {
        this.unitLowerValue = unitLowerValue;
    }

    @Basic
    @Column(name = "unit_higher_value")
    public Float getUnitHigherValue() {
        return unitHigherValue;
    }

    public void setUnitHigherValue(Float unitHigherValue) {
        this.unitHigherValue = unitHigherValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DosageMethodsEntity that = (DosageMethodsEntity) o;

        if (dosageMethodId != that.dosageMethodId) return false;
        if (Float.compare(that.unitLowerValue, unitLowerValue) != 0) return false;
        return unitHigherValue != null ? unitHigherValue.equals(that.unitHigherValue) : that.unitHigherValue == null;
    }

    @Override
    public int hashCode() {
        int result = dosageMethodId;
        result = 31 * result + (unitLowerValue != +0.0f ? Float.floatToIntBits(unitLowerValue) : 0);
        result = 31 * result + (unitHigherValue != null ? unitHigherValue.hashCode() : 0);
        return result;
    }
}
