package user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

public class User {
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String name;
    private String email;
    private String pass;
    private String avatar;
    private Integer money;

    public User() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getAvatar() {
        return avatar;
    }

    public Integer getMoney() {
        return money;
    }

    public User(Integer id, Timestamp created_at, Timestamp updated_at, String name, String email, String pass, String avatar, Integer money) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.avatar = avatar;
        this.money = money;
    }

    public User(Timestamp created_at, String name, String email, String pass) {
        this.created_at = created_at;
        this.name = name;
        this.email = email;
        this.pass = pass;
    }
}
