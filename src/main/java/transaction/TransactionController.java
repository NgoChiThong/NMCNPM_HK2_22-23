package transaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import until.HttpUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/transaction"})
public class TransactionController extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
    TransactionService service = new TransactionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");


        mapper.writeValue(response.getOutputStream(), service.getAll());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        Transaction transaction = HttpUtil.of(request.getReader()).toModel(Transaction.class);
        System.out.println(transaction);
        service.save(transaction);


        mapper.writeValue(response.getOutputStream(), transaction);

    }

}
