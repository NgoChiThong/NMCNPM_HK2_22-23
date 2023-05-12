package user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String name;
    private String email;
    private String pass;
    private String avatar;
    private Integer money;


}
