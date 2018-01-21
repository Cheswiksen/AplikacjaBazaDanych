package backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "Users", schema = "dbo", catalog = "bd2")
public class UsersEntity {
    private int id;
    private String login;
    private String password;
    private String salt;
    private int access;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "access")
    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity usersEntity = (UsersEntity) o;

        if (id != usersEntity.id) return false;
        if (access != usersEntity.access) return false;
        if (login != null ? !login.equals(usersEntity.login) : usersEntity.login != null) return false;
        if (password != null ? !password.equals(usersEntity.password) : usersEntity.password != null) return false;
        return salt != null ? salt.equals(usersEntity.salt) : usersEntity.salt == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + access;
        return result;
    }
}
