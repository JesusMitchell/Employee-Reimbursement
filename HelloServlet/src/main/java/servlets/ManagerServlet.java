package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Book;
import models.Reim;
import repository.ReimDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManagerServlet extends HttpServlet {

    ObjectMapper om = new ObjectMapper();

    ReimDAO reimDAO = new ReimDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Reim> submissions = new ArrayList<>();

        submissions= reimDAO.getAllbyStatus();

        for(int i =0; i < submissions.size(); i++){

            Reim q = submissions.get(i);
            System.out.println(q.toString());

        }

        response.setStatus(200);
        response.getWriter().write(om.writeValueAsString(reimDAO.getAllbyStatus()));

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book b = om.readValue(req.getReader(), Book.class);
        System.out.println(b);

        if (b.getStatus().equalsIgnoreCase("Approved")){
            reimDAO.changeStatusById(b.getId(),b.getStatus());
            reimDAO.subtractCost(b.getEmail(),b.getCost(),b.getId());
        }else {
        reimDAO.changeStatusById(b.getId(),b.getStatus());
        }

    }
}
