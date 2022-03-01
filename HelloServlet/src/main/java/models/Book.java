package models;

public class Book {

    private Integer id;
    private String status;
    private String email;
    private double cost;


    public Book(){}

    public Book(Integer id, String status){
        this.id= id;
        this.status=status;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
