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



}
