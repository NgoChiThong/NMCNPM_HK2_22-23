package controller;

import category.Category;
import category.CategoryService;
import transaction.Transaction;
import transaction.TransactionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/transaction"})
public class TransactionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("transaction", new TransactionService().getAll());
        request.setAttribute("category", CategoryService.getAll("THU"));
        request.getRequestDispatcher("/transaction.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
