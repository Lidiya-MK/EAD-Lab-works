// Lidiya Mamo Kibret  ugr/2485/14 
package com.exam.ead;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Setter;

public class BookRegistrationServlet {
    private static final String query = "insert into books(title, author, price) values(?, ?, ?)";

    @Setter
    private DBConnectionManager db;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>"
                + "<h2>Book Registration Form</h2>"
                + "<form method='post' action='/bookStore/books/addBook'>"
                + "Title: <input type='text' name='title'><br>"
                + "Author: <input type='text' name='author'><br>"
                + "Price: <input type='text' name='price'><br>"
                + "<input type='submit' value='Add Book'>"
                + "</form>"
                + "</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");

        db.openConnection();

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, price);
            int count = ps.executeUpdate();
            db.closeConnection();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (count == 1) {
                out.println(" Your Book has been  Registered Successfully!!");
            } else {
                out.println("OOPs! Book Registration Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Book Registration Failed");
        } finally {
            db.closeConnection();
        }
    }
}
