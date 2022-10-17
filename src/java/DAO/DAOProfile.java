/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.UserInformation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author MrTuan
 */
public class DAOProfile extends DBContext.DBContext {

    public UserInformation getProfile(int id) {
        UserInformation listprofile = new UserInformation();
        try {
            String sql = "select uf.userId,u.email,uf.fullname,uf.phone,a.[address],a.city from [User] u  join UserInformation uf \n"
                    + "on u.id=uf.userId\n"
                    + "join AddressReceiver a\n"
                    + "on u.id= a.userId\n"
                    + "where uf.userId=?";
            PreparedStatement stm=connection.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {                
                listprofile.setId(rs.getInt("userId"));
                listprofile.setFullname(rs.getString("fullname"));
//                listprofile.setBio(rs.getString("bio"));
                listprofile.setPhone(rs.getString("phone"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listprofile;
    }
}
