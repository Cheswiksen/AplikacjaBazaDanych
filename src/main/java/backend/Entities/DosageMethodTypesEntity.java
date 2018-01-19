package backend.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Dosage_method_types", schema = "dbo", catalog = "bd2")
public class DosageMethodTypesEntity {
    private int dosageMethodTypeId;
    private String methodTypeName;

    @Id
    @Column(name = "dosage_method_type_id")
    public int getDosageMethodTypeId() {
        return dosageMethodTypeId;
    }

    public void setDosageMethodTypeId(int dosageMethodTypeId) {
        this.dosageMethodTypeId = dosageMethodTypeId;
    }

    @Basic
    @Column(name = "method_type_name")
    public String getMethodTypeName() {
        return methodTypeName;
    }

    public void setMethodTypeName(String methodTypeName) {
        this.methodTypeName = methodTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DosageMethodTypesEntity that = (DosageMethodTypesEntity) o;

        if (dosageMethodTypeId != that.dosageMethodTypeId) return false;
        return methodTypeName != null ? methodTypeName.equals(that.methodTypeName) : that.methodTypeName == null;
    }

    @Override
    public int hashCode() {
        int result = dosageMethodTypeId;
        result = 31 * result + (methodTypeName != null ? methodTypeName.hashCode() : 0);
        return result;
    }
}
