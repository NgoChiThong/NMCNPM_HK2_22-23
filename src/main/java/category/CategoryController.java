package category;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CategoryController", value = "/api/category")
public class CategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        String type = request.getParameter("type");

        mapper.writeValue(response.getOutputStream(), CategoryService.getAll(type));

    }
}
