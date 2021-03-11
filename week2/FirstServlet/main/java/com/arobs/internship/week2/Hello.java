package com.arobs.internship.week2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello", name = "hello")
public class Hello extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("user");
        System.out.println(userName);
        if (userName.equals("")) {
            userName = "anonymous";
        }
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        session.setAttribute("TEST", "testSession");
        System.out.println(session.getAttribute("TEST"));
        req.setAttribute("user", userName);
        resp.addCookie(new Cookie("test", "valueTest"));
        req.getRequestDispatcher("hello.jsp").forward(req, resp);

    }
}
