package com.example.calculator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OperationServlet
 */
@WebServlet("/OperationServlet")


public class OperationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("Operation");
        RequestDispatcher dispatcher = null;

        switch (operation) {
            case "add":
                dispatcher = request.getRequestDispatcher("/addservlet");
                break;
            case "subtract":
                dispatcher = request.getRequestDispatcher("/subtractservlet");
                break;
            case "multiply":
                dispatcher = request.getRequestDispatcher("/multiplyservlet");
                break;
            case "divide":
                dispatcher = request.getRequestDispatcher("/divideservlet");
                break;
            default:
                response.getWriter().println("<h2>Invalid Operation</h2>");
                return;
        }

        dispatcher.forward(request, response);
    }
}
