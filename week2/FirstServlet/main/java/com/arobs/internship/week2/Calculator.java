package com.arobs.internship.week2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calculator", name = "calculator")
public class Calculator extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int firstNumer = Integer.parseInt(req.getParameter("first"));
        int secondNumer = Integer.parseInt(req.getParameter("second"));

        System.out.printf("First number %s and second number %s.%n", firstNumer, secondNumer);

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.printf("<h2>First number: %s</h2>", firstNumer);
        printWriter.printf("<h2>Second number: %s</h2>", secondNumer);
        printWriter.printf("<h1 style=\"color:red\">The sum of the numbers: %s</h1>", firstNumer + secondNumer);

    }
}
