package com.corent.servlet_crud;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);

        userdao dao = new userdao();
        dao.insertUser(user);

        response.sendRedirect("list-users");
    }
}
