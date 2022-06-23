package com.google.sps.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class PortfolioUserServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;");
        PortfolioUsers portfolioUsers = new PortfolioUsers(null, null, null, null);
        String json = convertToJson(portfolioUsers);
        // Send the JSON as the response
        response.setContentType("application/json;");
        response.getWriter().println(json);

    }
    private String convertToJson(PortfolioUsers portfolioUsers) {
        String json = "{";
        json += "\"fname\": ";
        json += "\"" + portfolioUsers.getFname() + "\"";
        json += ", ";

        json += "\"lname\": ";
        json += "\"" + portfolioUsers.getLname() + "\"";
        json += ", ";

        json += "\"subject\": ";
        json += "\"" + portfolioUsers.getSubject() + "\"";
        json += ", ";

        json += "\"email\": ";
        json += "\"" + portfolioUsers.getEmail() + "\"";
        json += ", ";
        
        json += "}";
        return json;
    }
    
}