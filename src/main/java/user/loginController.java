package user;

import until.SessionUntil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginController", value = "/login")
public class loginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. Lấy ra user và password từ form đăng nhập ở trang login.jsp
        String user=request.getParameter("email");
        String pass=request.getParameter("password");
//        2. Gọi phương thức getUser trong lớp UserDao để lấy ra tìm ra user theo đúng email và password
        UserDAO dao=new UserDAO();
        User u=dao.getUser(user,pass);
//        3. Lưu user vào session
        HttpSession session = request.getSession(true);
        session.setAttribute("user",u);
//        4. Nếu không tìm thấy user ( tức là email hoặc password bị sai) trả về trang login.jsp
        if(u==null || !user.equals(u.getEmail()) || !(pass.equals(u.getPass()))){
            request.setAttribute("error", "User và mật khẩu bị sai ! Vui lòng đăng nhập lại");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
//        5. Nếu tìm thấy user ( tức là đúng email và password) trả về index.jsp
        else{
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
