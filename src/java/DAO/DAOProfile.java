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

    public UserInformation getProfile(String mail) {
        UserInformation listprofile = new UserInformation();
        try {
            String sql = "select u.id,u.email,uf.fullname,uf.gender,uf.bio,uf.phone,uf.[address],uf.city from [User] u inner join UserInformation uf\n"
                    + "on u.id=uf.id\n"
                    + "where u.email=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, mail);
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

//    public void updateProfile(String id, String fullname, int sex, String phone, String mail, String address, String city) {
//        try {
//            String sql = "update UserInformation\n"
//                    + "set fullname=?,sex=?,phone=?,mail=?,[address]=?,city=?\n"
//                    + "where userId=?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(7, id);
//            stm.setString(1, fullname);
//            stm.setBoolean(2, sex);
//            stm.setString(3, phone);
//            stm.setString(4, mail);
//            stm.setString(5, address);
//            stm.setString(6, city);
//            stm.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }

    public static void main(String[] args) {
        DAOProfile db = new DAOProfile();
        System.out.println(db.getProfile("user2@gmail.com").isGender());
    }
}
