/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.User;

/**
 *
 * @author MrTuan
 */
public class UserlistDBContext extends DBContext.DBContext {

    private String status = "";

    public String getStatus() {
        return status;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "select * \n"
                + "from [User] u ,[UserInformation] ui\n"
                + "where u.id = ui.id";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                userList.add(new User(rs.getInt(1), rs.getInt(4), rs.getString(9), rs.getString(2),
                        rs.getString(3), rs.getString(10), rs.getDate(5), rs.getDate(6), rs.getBoolean(7)));
            }

        } catch (SQLException e) {
            status += "Error at get all users" + e.getMessage();
            System.out.println(status);
        }
        return userList;
    }

    public void updateUserStatusByID(int id, boolean status) {
        String query = "UPDATE [User]\n"
                + "SET [status] = ?\n"
                + "WHERE id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(2, id);
            stm.setBoolean(1, status);
            stm.executeUpdate();
        } catch (SQLException e) {
            this.status += "Error at ban user" + e.getMessage();
            System.out.println(this.status);
        }
    }
    
    public void updateUserRoleByID(int id, int role) {
        String query = "UPDATE [User]\n"
                + "SET [role] = ?\n"
                + "WHERE id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(2, id);
            stm.setInt(1, role);
            stm.executeUpdate();
        } catch (SQLException e) {
            status += "Error at update role user" + e.getMessage();
            System.out.println(status);
        }
    }

    public ArrayList<User> searchUser(String seachValue) {
        ArrayList<User> userList = new ArrayList<>();
        String query = "select * \n"
                + "from [User] u ,[UserInformation] ui\n"
                + "where (u.id = ui.id) and (email like ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, "%" + seachValue + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                userList.add(new User(rs.getInt(1), rs.getInt(4), rs.getString(9), rs.getString(2),
                        rs.getString(3), rs.getString(10), rs.getDate(5), rs.getDate(6), rs.getBoolean(7)));
            }

        } catch (SQLException e) {
            status += "Error at search user " + e.getMessage();
            System.out.println(status);
        }
        return userList;
    }

    public static void main(String[] args) {
        UserlistDBContext db = new UserlistDBContext();
//        ArrayList<User> lu = db.updateUserStatusByID(3, true);
        db.updateUserStatusByID(3, false);
//        for (User user : lu) {
//            System.out.println(user.toString());
//        }

    }
}
