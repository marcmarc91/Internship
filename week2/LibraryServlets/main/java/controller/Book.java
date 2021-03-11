package controller;

import utils.BookRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/book", name = "book")
public class Book extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookRepo bookRepo = BookRepo.getInstance();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String title = req.getParameter("title");
        String scope = req.getParameter("scope");

        out.printf("<h2>%s - %s</h2>", title, scope);
        switch (scope) {
            case "delete":
                bookRepo.deleteBookByTitle(title);
                req.getRequestDispatcher("welcome.jsp").forward(req, resp);
                break;
            case "edit":
                //   bookRepo.updateBookByTitle(title, new model.Book());
                break;
        }

    }


}
