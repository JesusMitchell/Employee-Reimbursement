package service;

import models.User;
import repository.UserDAO;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User login(String email, String password){
        User u = userDAO.getByEmail(email);

        if (u != null) {
            System.out.println(u.getEmail());
            System.out.println(u.getPassword());
            // check to make sure credentials match
            if (email.equals(u.getEmail()) && password.equals(u.getPassword())) {
                return u;
            }
        }
        System.out.println("Credentials do not match"); // this would be a great place to use a custom exception
        return null;
    }

    public User Register(User u){
        userDAO.add(u);
        return null;
    }



    }



