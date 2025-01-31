package com.corent.servlet_crud;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

@WebServlet("/list-users")
public class ListUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        userdao dao = new userdao();
        List<User> users = dao.getAllUsers();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>User List</title>");
        out.println("<style>");
        out.println("table { border-collapse: collapse; margin: 20px auto; width: 80%; }");
        out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("a { text-decoration: none; color: #007bff; }");
        out.println("a:hover { text-decoration: underline; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 style='text-align: center;'>User List</h1>");
        out.println("<div style='text-align: center; margin-bottom: 20px;'>");
        out.println("<a href='add-user.html'>Add New User</a>");
        out.println("</div>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Country</th>");
        out.println("<th>Actions</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        for (User user : users) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getName() + "</td>");
            out.println("<td>" + user.getEmail() + "</td>");
            out.println("<td>" + user.getCountry() + "</td>");
            out.println("<td><a href='edit-user.html?id=" + user.getId() + "'>Edit</a> | " +
                        "<a href='delete-user?id=" + user.getId() + "'>Delete</a></td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
