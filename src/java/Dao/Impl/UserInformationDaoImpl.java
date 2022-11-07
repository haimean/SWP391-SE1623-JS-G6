/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.UserInformationDao;
import Model.UserInformation;
import Dao.DBContext;
import Model.UserGoogle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MrTuan
 */
public class UserInformationDaoImpl implements UserInformationDao {

    @Override
    public UserInformation get(int id) {
        DBContext dBContext = new DBContext();
        UserInformation listprofile = new UserInformation();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select u.id,u.email,uf.fullname,uf.image,uf.gender,uf.biography,uf.phone,uf.[address],uf.city from [User] u inner join UserInformation uf\n"
                    + "on u.id=uf.id\n"
                    + "where u.id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listprofile.setId(rs.getInt("id"));
                listprofile.setFullname(rs.getString("fullname"));
                listprofile.setImage(rs.getString("image"));
                listprofile.setBiography(rs.getString("biography"));
                listprofile.setGender(rs.getInt("gender"));
                listprofile.setPhone(rs.getString("phone"));
                listprofile.setMail(rs.getString("email"));
                listprofile.setAddress(rs.getString("address"));
                listprofile.setCity(rs.getString("city"));
            }
        } catch (SQLException e) {
            Logger.getLogger(UserInformation.class.getName()).log(Level.SEVERE, null, e);
        }
        return listprofile;
    }

    public boolean updateProfile(int id, String fullname, String image, String gender, String biography, String address, String city) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "update UserInformation\n"
                    + "set fullname=?,image=?,gender=?,biography=?,[address]=?,city=?\n"
                    + "where id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(7, id);
            stm.setString(1, fullname);
            stm.setString(2, image);
            stm.setString(3, gender);
            stm.setString(4, biography);
            stm.setString(5, address);
            stm.setString(6, city);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(UserInformation.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<UserInformation> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(UserInformation t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(UserInformation t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
    }

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
}
