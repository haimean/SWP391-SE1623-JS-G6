/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Model.User;
import Dao.DBContext;
import Dao.UserDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MrTuan
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User login(String Email, String password) {
        DBContext dBContext = new DBContext();
        User user = new User();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select u.id, role, fullname, email, phone, status, u.created_at, updated_at\n"
                    + "                from UserInformation as ui, [User] as u\n"
                    + "                where u.id = ui.userId and u.email = ? and u.password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getDate(7),
                        rs.getDate(8));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }

    @Override
    public boolean updateUserStatusByID(int id, boolean status) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "UPDATE [User]\n"
                    + "SET [status] = ?\n"
                    + "WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(2, id);
            ps.setBoolean(1, status);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean updateUserRoleByID(int id, int role) {
        String query = "UPDATE [User]\n"
                + "SET [role] = ?\n"
                + "WHERE id = ?";
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(2, id);
            ps.setInt(1, role);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public ArrayList<User> search(String seachValue) {
        ArrayList<User> userList = new ArrayList<>();
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select u.id, role, fullname, email, phone,"
                    + " status, u.created_at, updated_at"
                    + "from UserInformation as ui, [User] as u\n"
                    + "where (u.id = ui.id) and (email like ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + seachValue + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userList.add(new User(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getDate(7),
                        rs.getDate(8)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return userList;
    }

    @Override
    public User get(int id) {
        DBContext dBContext = new DBContext();
        User user = new User();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select u.id, role, fullname, email, phone, status,"
                    + " u.created_at, updated_at "
                    + "from [User] u ,[UserInformation] ui"
                    + " where u.id = ui.userId and u.id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getDate(7),
                        rs.getDate(8));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        DBContext dBContext = new DBContext();
        ArrayList<User> users = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select u.id, role, fullname, email, phone, status,"
                    + " u.created_at, updated_at "
                    + "from [User] u ,[UserInformation] ui"
                    + " where u.id = ui.userId";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getDate(7),
                        rs.getDate(8)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }

    @Override
    public boolean insert(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "delete from [Notification] where userId = ?\n"
                    + "delete from [Message] where userSenderId = ?\n"
                    + "delete from [UserInformation] where userId = ?\n"
                    + "delete from [AddressReceiver] where userId = ?\n"
                    + "delete from [User] where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.setInt(3, id);
            ps.setInt(4, id);
            ps.setInt(5, id);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
