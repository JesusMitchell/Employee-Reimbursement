package models;

public class Reim {
    private int id;
    private String event;
    private String dateofe;
    private String location;
    private double cost;
    private String proof;
    private String description;
    private String justification;
    private String nowtime;

    private String status;
    private String email;

    public Reim(){}

    public Reim(String event, String dateofe, String location, double cost, String test, String description, String justification, String nowtime){
        this.event=event;
        this.dateofe = dateofe;
        this.location = location;
        this.cost = cost;
        this.proof = test;
        this.description= description;
        this.justification= justification;
        this.nowtime=nowtime;
    }
    public Reim(int id, String event, String dateofe, String location, double cost, String test, String description, String justification, String nowtime){
        this.id=id;
        this.event=event;
        this.dateofe = dateofe;
        this.location = location;
        this.cost = cost;
        this.proof = test;
        this.description= description;
        this.justification= justification;
        this.nowtime=nowtime;
    }
    public Reim(int id, String event, String dateofe, String location, double cost, String test, String description, String justification, String nowtime,String status, String email){
        this.id=id;
        this.event=event;
        this.dateofe = dateofe;
        this.location = location;
        this.cost = cost;
        this.proof = test;
        this.description= description;
        this.justification= justification;
        this.nowtime=nowtime;
        this.status=status;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDateofe() {
        return dateofe;
    }

    public void setDateofe(String dateofe) {
        this.dateofe = dateofe;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getNowtime() {
        return nowtime;
    }

    public void setNowtime(String nowtime) {
        this.nowtime = nowtime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reim{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", dateofe='" + dateofe + '\'' +
                ", location='" + location + '\'' +
                ", cost=" + cost +
                ", proof='" + proof + '\'' +
                ", description='" + description + '\'' +
                ", justification='" + justification + '\'' +
                ", nowtime='" + nowtime + '\'' +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
