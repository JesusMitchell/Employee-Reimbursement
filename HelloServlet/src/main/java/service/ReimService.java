package service;

import models.Reim;
import models.User;
import repository.ReimDAO;

import java.util.List;

public class ReimService {

    private ReimDAO reimDAO = new ReimDAO();



    public Reim add(Reim u){
        reimDAO.add(u);
        return null;
    }

    public List<Reim> GetAllByEmail(String email){
        reimDAO.getAllbyEmail(email);
        return null;
    }






}
