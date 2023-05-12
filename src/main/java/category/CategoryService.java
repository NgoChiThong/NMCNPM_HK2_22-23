package category;

import java.util.List;

public class CategoryService {

    public static List<Category> getAll(String type) {

        return CategoryDAO.getAll(type);

    }


}
