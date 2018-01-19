package backend.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Collision_severities", schema = "dbo", catalog = "bd2")
public class CollisionSeveritiesEntity {
    private int collisionSeverityId;
    private String severityText;
    private Collection<CollisionGroupsEntity> collisionGroupsByCollisionSeverityId;

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
        if (severityText != null ? !severityText.equals(that.severityText) : that.severityText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collisionSeverityId;
        result = 31 * result + (severityText != null ? severityText.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "collisionSeveritiesByCollisionSeverityId")
    public Collection<CollisionGroupsEntity> getCollisionGroupsByCollisionSeverityId() {
        return collisionGroupsByCollisionSeverityId;
    }

    public void setCollisionGroupsByCollisionSeverityId(Collection<CollisionGroupsEntity> collisionGroupsByCollisionSeverityId) {
        this.collisionGroupsByCollisionSeverityId = collisionGroupsByCollisionSeverityId;
    }
}
