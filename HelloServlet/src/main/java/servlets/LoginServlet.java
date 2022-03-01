package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import repository.UserDAO;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper om = new ObjectMapper();
        UserDAO userdao = new UserDAO();

        // Get the parameters of username and password from the request.
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println("servlet " + email);
        System.out.println("servlet " + password);

        User u = userService.login(email, password);
        if (u != null) {
            resp.getWriter().write("Successfully logged in");
            HttpSession session = req.getSession();

            // 'Save' the user details in that session object
            session.setAttribute("user", u);

            if (u.getRole().equalsIgnoreCase("manager")){
                resp.sendRedirect("home2.html");
                }else{resp.sendRedirect("home1.html");
            }
        } else {
            resp.setStatus(401);
        }
        resp.getWriter().write(om.writeValueAsString(userdao.getByEmail(u.getEmail())));
    }

}
