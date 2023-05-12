package until;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUntil {

    public static void set(HttpServletRequest request, String name, Object value) {
        HttpSession session = request.getSession(true);
        session.setAttribute(name, value);
    }


    public static Object get(HttpServletRequest request, String name) {
        HttpSession session = request.getSession(true);
        return session.getAttribute(name);
    }

    public static void invalidate(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.invalidate();
    }


    public static void delItem(HttpServletRequest request, String name) {
        HttpSession session = request.getSession();
        session.removeAttribute(name);
    }


}
