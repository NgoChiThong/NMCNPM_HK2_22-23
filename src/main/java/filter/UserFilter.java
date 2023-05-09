package filter;

import until.SessionUntil;
import user.User;
import user.UserService;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class UserFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        SessionUntil.set((HttpServletRequest) request, "USER", new UserService().get(1));
        chain.doFilter(request, response);
    }
}
