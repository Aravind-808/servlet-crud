package com.corent.servlet_crud;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/delete-user")
public class DeleteUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        userdao dao = new userdao();
        dao.deleteUser(id);

        response.sendRedirect("list-users");
    }
}
