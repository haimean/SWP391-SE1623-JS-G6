/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.UserInformation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MrTuan
 */
public class DAOProfile extends DBContext.DBContext {

    public UserInformation getProfileById(String id) {
        UserInformation listprofile = new UserInformation();
        try {
            String sql = "select u.id,u.email,uf.fullname,uf.gender,uf.bio,uf.phone,uf.[address],uf.city from [User] u inner join UserInformation uf\n"
                    + "on u.id=uf.id\n"
                    + "where u.id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listprofile.setId(rs.getInt("id"));
                listprofile.setFullname(rs.getString("fullname"));
                listprofile.setBio(rs.getString("bio"));
                listprofile.setGender(rs.getInt("gender"));
                listprofile.setPhone(rs.getString("phone"));
                listprofile.setMail(rs.getString("email"));
                listprofile.setAddress(rs.getString("address"));
                listprofile.setCity(rs.getString("city"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listprofile;
    }

    public void updateProfile(String id, String fullname, String gender, String bio, String address, String city) {
        try {
            String sql = "update UserInformation\n"
                    + "set fullname=?,gender=?,bio=?,[address]=?,city=?\n"
                    + "where id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(6, id);
            stm.setString(1, fullname);
            stm.setString(2, gender);
            stm.setString(3, bio);
            stm.setString(4, address);
            stm.setString(5, city);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        DAOProfile db = new DAOProfile();
        System.out.println(db.getProfileById("1").isGender());
    }
}
