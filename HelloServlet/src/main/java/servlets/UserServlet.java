package servlets;

import models.Role;
import models.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        UserService userservice = new UserService();

        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");


        User u = new User();
        u.setFirstname(fname);
        u.setLastname(lname);
        u.setEmail(email);
        u.setPassword(password);
        u.setRole(role);


        userservice.Register(u);

        HttpSession session = request.getSession();


        session.setAttribute("user", u);
        response.sendRedirect("login.html");

    }
}


