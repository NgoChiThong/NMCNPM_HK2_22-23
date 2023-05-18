package user;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "profileController", value = "/profile")
public class profileController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        int id = Integer.parseInt(request.getParameter("id"));
        UserDAO.updateProfile(name,pass,email,id);

        UserDAO dao=new UserDAO();
        User u= dao.getUser(email,pass);
        HttpSession session = request.getSession(true);
        session.setAttribute("user",u);


        request.getRequestDispatcher("/profile.jsp").forward(request,response);

    }

}
