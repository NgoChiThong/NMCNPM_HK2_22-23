package user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "registerController", value = "/register")
public class registerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String users=request.getParameter("user");
        String pass=request.getParameter("password");
        Timestamp create=new Timestamp(System.currentTimeMillis());
        UserService u=new UserService();
        User us=new User(create,name,users,pass);
        u.create(us);
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
