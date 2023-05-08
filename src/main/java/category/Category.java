package category;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String name;
    private String type;
    private String icon;

}
