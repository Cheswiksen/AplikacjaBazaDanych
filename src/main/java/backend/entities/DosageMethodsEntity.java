package backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "Dosage_methods", schema = "dbo", catalog = "bd2")
public class DosageMethodsEntity {
    private int dosageMethodId;
    private int dosageId;
    private int unitId;
    private float unitLowerValue;
    private Float unitHigherValue;
    private int dosageMethodTypeId;
    private DosagesEntity dosagesByDosageId;
    private UnitsEntity unitsByUnitId;
    private DosageMethodTypesEntity dosageMethodTypesByDosageMethodTypeId;

    @Id
    @Column(name = "dosage_method_id")
    public int getDosageMethodId() {
        return dosageMethodId;
    }

    public void setDosageMethodId(int dosageMethodId) {
        this.dosageMethodId = dosageMethodId;
    }

    @Basic
    @Column(name = "dosage_id")
    public int getDosageId() {
        return dosageId;
    }

    public void setDosageId(int dosageId) {
        this.dosageId = dosageId;
    }

    @Basic
    @Column(name = "unit_id")
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
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

    @Basic
    @Column(name = "dosage_method_type_id")
    public int getDosageMethodTypeId() {
        return dosageMethodTypeId;
    }

    public void setDosageMethodTypeId(int dosageMethodTypeId) {
        this.dosageMethodTypeId = dosageMethodTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DosageMethodsEntity that = (DosageMethodsEntity) o;

        if (dosageMethodId != that.dosageMethodId) return false;
        if (dosageId != that.dosageId) return false;
        if (unitId != that.unitId) return false;
        if (Float.compare(that.unitLowerValue, unitLowerValue) != 0) return false;
        if (dosageMethodTypeId != that.dosageMethodTypeId) return false;
        if (unitHigherValue != null ? !unitHigherValue.equals(that.unitHigherValue) : that.unitHigherValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dosageMethodId;
        result = 31 * result + dosageId;
        result = 31 * result + unitId;
        result = 31 * result + (unitLowerValue != +0.0f ? Float.floatToIntBits(unitLowerValue) : 0);
        result = 31 * result + (unitHigherValue != null ? unitHigherValue.hashCode() : 0);
        result = 31 * result + dosageMethodTypeId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dosage_id", referencedColumnName = "dosage_id", nullable = false)
    public DosagesEntity getDosagesByDosageId() {
        return dosagesByDosageId;
    }

    public void setDosagesByDosageId(DosagesEntity dosagesByDosageId) {
        this.dosagesByDosageId = dosagesByDosageId;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id", nullable = false)
    public UnitsEntity getUnitsByUnitId() {
        return unitsByUnitId;
    }

    public void setUnitsByUnitId(UnitsEntity unitsByUnitId) {
        this.unitsByUnitId = unitsByUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "dosage_method_type_id", referencedColumnName = "dosage_method_type_id", nullable = false)
    public DosageMethodTypesEntity getDosageMethodTypesByDosageMethodTypeId() {
        return dosageMethodTypesByDosageMethodTypeId;
    }

    public void setDosageMethodTypesByDosageMethodTypeId(DosageMethodTypesEntity dosageMethodTypesByDosageMethodTypeId) {
        this.dosageMethodTypesByDosageMethodTypeId = dosageMethodTypesByDosageMethodTypeId;
    }
}
