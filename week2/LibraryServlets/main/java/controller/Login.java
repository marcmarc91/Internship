package controller;

import model.Book;
import model.User;
import utils.BookRepo;
import utils.UserRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns = "/login", name = "login")
public class Login extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Init Login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRepo repo = UserRepo.getInstance();

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);

        User user = repo.getUserByName(username, password);
        if (user != null) {
            request.getSession().setAttribute("userLogin", user);
            response.addCookie(new Cookie("username", user.getName()));
            response.addCookie(new Cookie("role", user.getRoleType().name()));
            request.setAttribute("userName", user.getName());
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);

        } else {
            response.setContentType("text/html");
            out.print("<h3 style=\"color:red\">Your user does not exist</h3>");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.include(request, response);
        }

    }
}
