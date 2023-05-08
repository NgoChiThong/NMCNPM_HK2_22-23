package category;


import java.sql.Timestamp;

public class Category {
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String name;
    private String type;
    private String icon;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    public Category() {
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

    public String getType() {
        return type;
    }

    public String getIcon() {
        return icon;
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

    public void setType(String type) {
        this.type = type;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Category(Integer id, Timestamp created_at, Timestamp updated_at, String name, String type, String icon) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.name = name;
        this.type = type;
        this.icon = icon;
    }
}
