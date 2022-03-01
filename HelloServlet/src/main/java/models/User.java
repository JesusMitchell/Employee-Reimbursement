package models;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role;
    private double allowance;

    public User(){}

    public User(Integer id, String firstname, String lastname,String email, String password, String role){
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.password=password;
        this.role=role;

    }
    public User(String firstname, String lastname,String email, String password, String role){
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.password=password;
        this.role=role;

    }

    public User(Integer id, String firstname, String lastname,String email, String password, String role, double allowance){
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.password=password;
        this.role=role;
        this.allowance=allowance;

    }
    public User(String firstname, String lastname,String email, String password, String role, double allowance){
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.password=password;
        this.role=role;
        this.allowance=allowance;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", allowance=" + allowance +
                '}';
    }
}
