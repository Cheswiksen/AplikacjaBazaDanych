package backend.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Collision_severities", schema = "dbo", catalog = "bd2")
public class CollisionSeveritiesEntity {
    private int collisionSeverityId;
    private String severityText;

    @Id
    @Column(name = "collision_severity_id")
    public int getCollisionSeverityId() {
        return collisionSeverityId;
    }

    public void setCollisionSeverityId(int collisionSeverityId) {
        this.collisionSeverityId = collisionSeverityId;
    }

    @Basic
    @Column(name = "severity_text")
    public String getSeverityText() {
        return severityText;
    }

    public void setSeverityText(String severityText) {
        this.severityText = severityText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollisionSeveritiesEntity that = (CollisionSeveritiesEntity) o;

        if (collisionSeverityId != that.collisionSeverityId) return false;
        return severityText != null ? severityText.equals(that.severityText) : that.severityText == null;
    }

    @Override
    public int hashCode() {
        int result = collisionSeverityId;
        result = 31 * result + (severityText != null ? severityText.hashCode() : 0);
        return result;
    }
}
