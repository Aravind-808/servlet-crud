package com.corent.servlet_crud;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/update-user")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);

        userdao dao = new userdao();
        dao.updateUser(user);

        response.sendRedirect("list-users");
    }
}
