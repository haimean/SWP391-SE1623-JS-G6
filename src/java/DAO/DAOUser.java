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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MrTuan
 */
public class DAOUser extends DBContext.DBContext {

    private String status = "";

    public String getStatus() {
        return status;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "select u.id, role, fullname, email, phone, status,"
                + " u.created_at, updated_at "
                + "from [User] u ,[UserInformation] ui"
                + " where u.id = ui.userId";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
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

        } catch (SQLException e) {
            status += "Error at get all users" + e.getMessage();
            System.out.println(status);
        }
        return userList;
    }

    public void deleteUser(String id) {
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

    public User login(String Email, String password) {
        String sql = "select u.id, role, fullname, email, phone, status, u.created_at, updated_at\n"
                + "                from UserInformation as ui, [User] as u\n"
                + "                where u.id = ui.userId and u.email = ? and u.password = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, Email);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getDate(7),
                        rs.getDate(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public User getUser(int userSenderId) {
        try {
            String sql = "select u.id, role, fullname, email, phone, status,"
                    + " u.created_at, updated_at "
                    + "from [User] u ,[UserInformation] ui"
                    + " where u.id = ui.userId and u.id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userSenderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getDate(7),
                        rs.getDate(8));
            }
        } catch (SQLException ex) {
        }
        return null;
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

    public ArrayList<User> searchUser(String seachValue, int index) {
        ArrayList<User> userList = new ArrayList<>();
        String query = "select u.id, role, fullname, email, phone,\n"
                + "status, u.created_at, updated_at\n"
                + "from UserInformation as ui, [User] as u\n"
                + "where (u.id = ui.id) and (email like ?)\n"
                + "order by id\n"
                + "offset ? rows fetch next ? rows only";
        final int recordsPerPage = 4;

        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, '%' + seachValue + '%');
            stm.setInt(2, (index - 1) * recordsPerPage);
            stm.setInt(3, recordsPerPage);
            ResultSet rs = stm.executeQuery();
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
            if (!userList.isEmpty()) {
                return userList;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public int getTotalUsers() {
        String query = "select count(*) from [User]";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public int getTotalUsersSearch(String seachValue) {
        String query = "select count(*) from \n"
                + "(select u.id, role, fullname, email, phone,\n"
                + "status, u.created_at, updated_at\n"
                + "from UserInformation as ui, [User] as u\n"
                + "where (u.id = ui.id) and (email like ?)\n"
                + ") as totalRecord";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, '%' + seachValue + '%');
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public ArrayList<User> paginate(int index) {
        ArrayList<User> list = new ArrayList<>();
        String query = "select u.id, role, fullname, email, phone, status,\n"
                + "u.created_at, updated_at\n"
                + "from [User] u ,[UserInformation] ui\n"
                + "where u.id = ui.userId\n"
                + "order by id\n"
                + "offset ? rows fetch next ? rows only";
        final int recordsPerPage = 4;
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, (index - 1) * recordsPerPage);
            stm.setInt(2, recordsPerPage);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new User(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getDate(7),
                        rs.getDate(8)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        DAOUser dao = new DAOUser();
        ArrayList<User> userList = dao.searchUser("i", 1);
//        int a = dao.getTotalUsersSearch("@", 1);

        for (User user : userList) {
            System.out.println(user.toString());
        }
    }
}
