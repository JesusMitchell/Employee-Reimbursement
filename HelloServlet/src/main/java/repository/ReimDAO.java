package repository;

import models.Reim;
import models.User;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimDAO implements GenericDAO<Reim>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Reim add(Reim reim) {

        String sql = "insert into reimbursment values (default,?, ?, ?, ?, ?, ?,?,?,?,?) returning *" ;

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, reim.getEvent());
            ps.setString(2, reim.getDateofe());
            ps.setString(3, reim.getLocation());
            ps.setDouble(4, reim.getCost());
            ps.setString(5, reim.getProof() );
            ps.setString(6, reim.getDescription());
            ps.setString(7, reim.getJustification());
            ps.setString(8, reim.getNowtime());
            ps.setString(9, reim.getStatus());
            ps.setString(10, reim.getEmail());


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Reim a = new Reim(
                        rs.getInt("id"),
                        rs.getString("evento"),
                        rs.getString("dateofe"),
                        rs.getString("locatio"),
                        rs.getDouble("costo"),
                        rs.getString("proof"),
                        rs.getString("description"),
                        rs.getString("justification"),
                        rs.getString("submissiontime"),
                        rs.getString("status"),
                        rs.getString("email")

                );
                System.out.println(a.toString());
                return a;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Reim getById(Integer id) {
        return null;
    }

    @Override
    public List<Reim> getAll() {
       List<Reim> reims = new ArrayList<>();
       String sql = "select * from reimbursment";
        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reim a = new Reim(
                        rs.getInt("id"),
                        rs.getString("evento"),
                        rs.getString("dateofe"),
                        rs.getString("locatio"),
                        rs.getDouble("costo"),
                        rs.getString("proof"),
                        rs.getString("description"),
                        rs.getString("justification"),
                        rs.getString("submissiontime"),
                        rs.getString("status"),
                        rs.getString("email")
                );

                reims.add(a);
            }
            return reims;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reim> getAllbyEmail(String email) {
        List<Reim> reims = new ArrayList<>();
        String sql = "select * from reimbursment where email = ?";
        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reim a = new Reim(
                        rs.getInt("id"),
                        rs.getString("evento"),
                        rs.getString("dateofe"),
                        rs.getString("locatio"),
                        rs.getDouble("costo"),
                        rs.getString("proof"),
                        rs.getString("description"),
                        rs.getString("justification"),
                        rs.getString("submissiontime"),
                        rs.getString("status"),
                        rs.getString("email")
                );

                reims.add(a);
            }
            return reims;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Reim> getAllbyStatus() {
        List<Reim> reims = new ArrayList<>();
        String sql = "select * from reimbursment where status = 'Pending'";
        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reim a = new Reim(
                        rs.getInt("id"),
                        rs.getString("evento"),
                        rs.getString("dateofe"),
                        rs.getString("locatio"),
                        rs.getDouble("costo"),
                        rs.getString("proof"),
                        rs.getString("description"),
                        rs.getString("justification"),
                        rs.getString("submissiontime"),
                        rs.getString("status"),
                        rs.getString("email")
                );

                reims.add(a);
            }
            return reims;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void changeStatusById(Integer id, String status) {
        try (Connection conn = cu.getConnection()) {

            String sql = "update reimbursment set status = ? where id = ?";


            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, id);

            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void subtractCost(String email, double cost, Integer id) {
        try (Connection conn = cu.getConnection()) {

            String Statement= "select allowance from users where email = ?";
            PreparedStatement lol = conn.prepareStatement(Statement);
            lol.setString(1, email);
            ResultSet rs = lol.executeQuery();

            Double Allowance= 0.0;

            if (rs.next()) {
                Allowance = rs.getDouble("allowance");
            }

            if(cost>Allowance){
                changeStatusById(id,"Denied");
            }else {
                String sql = "update users set allowance=allowance -? where email= ?";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setDouble(1, cost);
                ps.setString(2, email);

                ps.execute();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    @Override
    public void update(Reim reim) {

    }

    @Override
    public void delete(Integer id) {

    }
}
