// Lidiya Mamo Kibret  ugr/2485/14 
package com.exam.ead;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/books")
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BookRegistrationServlet bookRegistrationServlet;
    private SearchBooksServlet searchBooksServlet;
    private DisplayBooksServlet displayBooksServlet;
    private DeleteBookServlet deleteBookServlet;

    @Override
    public void init() throws ServletException {
        super.init();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        bookRegistrationServlet = (BookRegistrationServlet) context.getBean("bookRegistrationServlet");
        searchBooksServlet = (SearchBooksServlet) context.getBean("searchBooksServlet");
        displayBooksServlet = (DisplayBooksServlet) context.getBean("displayBooksServlet");
        deleteBookServlet = (DeleteBookServlet) context.getBean("deleteBookServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        String contextPath = request.getContextPath();
        String requestPath = path.substring(contextPath.length());
        // System.out.println("Processing: " + requestPath);
        switch (requestPath) {
            case "/books/addBook":
                if ("GET".equalsIgnoreCase(request.getMethod())) {
                    bookRegistrationServlet.doGet(request, response);
                } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                    bookRegistrationServlet.doPost(request, response);
                }
                break;
            case "/books/searchBooks":
                searchBooksServlet.doGet(request, response);
                break;
            case "/books/displayBooks":
                displayBooksServlet.doGet(request, response);
                break;
            case "/books/deleteBook":
                deleteBookServlet.doPost(request, response);
                break;
            default:
                response.getWriter().println("Invalid URL");
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

}
