/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.DBContext;
import Dao.UserGoogleDao;
import Model.UserGoogle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MrTuan
 */
public class UserGoogleDaoImpl implements UserGoogleDao {

    public UserGoogle getByEmail(String email) {
        DBContext dBContext = new DBContext();
        UserGoogle user = new UserGoogle();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select * from UserGoogle ug where ug.email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getString("id"));
                user.setEmail(rs.getString("email"));
                user.setVerified_email(rs.getBoolean("verified_email"));
                return user;
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(UserGoogle.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public UserGoogle get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UserGoogle> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean insertUser(String email, boolean verified_email) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "insert into UserGoogle (email,verified_email)\n"
                    + "values(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setBoolean(2, verified_email);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
        return false;
        }
//        try {
//            Connection connection = dBContext.getConnection();
//            String sql = "INSERT INTO UserInformation (userId,fullName,create_at)  VALUES(?,?,?)";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, item.getId());
//            ps.setString(2, item.getFullName());
//            ps.executeUpdate();
//            dBContext.closeConnection(connection, ps);
//            return true;
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return false;
    }

    public UserGoogle loginWithGoogle(String email, boolean verified_email) {
        DBContext dBContext = new DBContext();
        UserGoogle user = new UserGoogle();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select * from UserGoogle ug where ug.email=? and ug.verified_email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setBoolean(2, verified_email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setEmail(rs.getString("email"));
                user.setVerified_email(rs.getBoolean("verified_email"));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(UserGoogle.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }

    @Override
    public boolean update(UserGoogle t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(UserGoogle t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static void main(String[] args) {
        UserGoogleDaoImpl db= new UserGoogleDaoImpl();
        System.out.println(db.loginWithGoogle("tn4490523@gmail.com",true).isVerified_email());
    }

}
