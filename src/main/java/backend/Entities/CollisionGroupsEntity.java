package backend.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Collision_groups", schema = "dbo", catalog = "bd2")
public class CollisionGroupsEntity {
    private int collisionGroupId;
    private String comment;

    @Id
    @Column(name = "collision_group_id")
    public int getCollisionGroupId() {
        return collisionGroupId;
    }

    public void setCollisionGroupId(int collisionGroupId) {
        this.collisionGroupId = collisionGroupId;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollisionGroupsEntity that = (CollisionGroupsEntity) o;

        if (collisionGroupId != that.collisionGroupId) return false;
        return comment != null ? comment.equals(that.comment) : that.comment == null;
    }

    @Override
    public int hashCode() {
        int result = collisionGroupId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
