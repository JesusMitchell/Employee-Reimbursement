package repository;

import models.User;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements GenericDAO<User> {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public User add(User user) {

        String sql = "insert into users values (default, ?, ?, ?, ?, ?,?) returning *" ;

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());
            ps.setDouble(6,1000.00);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User a = new User(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("passwor"),
                        rs.getString("rol")
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
    public User getById(Integer id) {
        String sql = "select * from users where id = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User a = new User(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("passwor"),
                        rs.getString("rol"),
                        rs.getDouble("allowance")
                );
                return a;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> authors = new ArrayList<>();
        // this is our sequel statement -> we want it to return all records from the table
        String sql = "select * from users";
        // try-with-resources -> used to automatically close resources after the try/catch/finally
        try (Connection conn = cu.getConnection()) {

            // Prepare the statement
            PreparedStatement ps = conn.prepareStatement(sql);

            // Execute the statement and save the ResultSet into an object
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User a = new User(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("passwor"),
                        rs.getString("rol"),
                        rs.getDouble("allowance")
                );

                authors.add(a);
            }
            return authors;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User user) {
        String sql = "update users set first_name = ?, last_name = ?, email = ?, passwor = ?, rol = ? where id = ?";
        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());
            ps.setInt(6, user.getId());

            ps.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from users where id = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }


    }

    public User getByEmail(String email) {
        String sql = "select * from users where email = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("passwor"),
                        rs.getString("rol"),
                        rs.getDouble("allowance")
                );
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // try-with-resources - automatically closes resources after execution
//        finally {
//            conn.close();
//        }

        return null;

    }



}










