package com.example.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubtractionServlet
 */
@WebServlet("/subtractservlet")

public class SubtractionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int difference = num1 - num2;
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<h2>Result of Subtraction</h2>");
        pw.println("<p>" + num1 + " - " + num2 + " = " + difference + "</p>");
    }
}
