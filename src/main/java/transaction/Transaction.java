package transaction;


import category.Category;
import DB.JDBiConnector;
import user.User;

import java.sql.Timestamp;

public class Transaction {
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Integer money;
    private Integer categoryId;
    private String note;
    private Timestamp started_at;

    private Integer userId;

    public Category getCategory() {
        return _getCategory();
    }

    public User getUser() {
        return _getUser();
    }

    private Category _getCategory() {
        return JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM categories WHERE id = :id").bind("id", this.categoryId).mapToBean(Category.class).findOnly();
        });
    }

    private User _getUser() {
        return JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM users WHERE id = :id").bind("id", this.userId).mapToBean(User.class).findOnly();
        });
    }


    public Transaction(Integer id, Timestamp created_at, Timestamp updated_at, Integer money, Integer categoryId, String note, Timestamp started_at, Integer userId) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.money = money;
        this.categoryId = categoryId;
        this.note = note;
        this.started_at = started_at;
        this.userId = userId;
    }

    public Transaction() {
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

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setStarted_at(Timestamp started_at) {
        this.started_at = started_at;
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

    public Integer getMoney() {
        return money;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getNote() {
        return note;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getStarted_at() {
        return started_at;
    }

}
