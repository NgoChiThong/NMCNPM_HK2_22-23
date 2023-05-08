package category;

import DB.JDBiConnector;

import java.util.List;

public class CategoryDAO {
    public static List<Category> getAll(String type) {

        return JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM categories where `type` = :type")
                    .bind("type", type)
                    .mapToBean(Category.class)
                    .list();
        });

    }
}
