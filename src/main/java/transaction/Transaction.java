package transaction;


import category.Category;
import DB.JDBiConnector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import user.User;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Integer money;
    private Integer categoryId;
    private String note;
    private Timestamp started_at;

    private Integer userId;


    public Category _getCategory() {
        return JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM categories WHERE id = :id").bind("id", this.categoryId).mapToBean(Category.class).findOnly();
        });
    }

    public User _getUser() {
        return JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM users WHERE id = :id").bind("id", this.userId).mapToBean(User.class).findOnly();
        });
    }


}
