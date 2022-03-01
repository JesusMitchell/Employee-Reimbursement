package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Reim;
import models.User;
import repository.ReimDAO;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper om = new ObjectMapper();
        HttpSession session = request.getSession();
        ReimDAO reimDAO = new ReimDAO();


        User u = (User) session.getAttribute("user");
        Double Balance = u.getAllowance();
        Double Cost = 0.0;


        List<Reim> submissions = new ArrayList<>();

        submissions= reimDAO.getAllbyEmail(u.getEmail());

        for(int i =0; i < submissions.size(); i++){

            Reim q = submissions.get(i);
            System.out.println(q.toString());

            if(q.getStatus().equalsIgnoreCase("pending")){
                Cost = Cost + q.getCost();
            }

        }
        Balance= Balance- Cost;
        System.out.println(Balance);

        response.getWriter().write(om.writeValueAsString(reimDAO.getAllbyEmail(u.getEmail())));

        //response.getWriter().write(String.valueOf(Balance));






    }
}
