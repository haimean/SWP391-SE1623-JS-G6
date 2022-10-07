/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author MrTuan
 */
public class UserlistDBContext extends DBContext {

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
                        rs.getString(3), rs.getString(10), rs.getDate(5), rs.getDate(6)));
            }

        } catch (SQLException e) {
            status += "Error at get all users" + e.getMessage();
            System.out.println(status);
        }
        return userList;
    }

    public void deleteUser(String id) {
//        String query = "delete from [User] where [User].id = ?\n"
//                + "delete from [UserInformation] where [UserInformation].id = ?";
        String query = "delete from [Notification] where userId = ?\n"
                + "delete from [Message] where userSenderId = ?\n"
                + "delete from [UserInformation] where userId = ?\n"
                + "delete from [AddressReceiver] where userId = ?\n"
                + "delete from [User] where id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, id);
            stm.setString(2, id);
            stm.setString(3, id);
            stm.setString(4, id);
            stm.setString(5, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            status += "Error at delete user " + e.getMessage();
            System.out.println(status);
        }
    }

    public static void main(String[] args) {
        UserlistDBContext db = new UserlistDBContext();
        ArrayList<User> lu=db.getAllUsers();
        for (User user : lu) {
            System.out.println(user.getFullName());
        }

    }
}
