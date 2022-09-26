package Dal;

import Context.DBContext;
import Context.DBContext;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PiPi
 */
public class DAOUser {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
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
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                userList.add(new User(rs.getInt(1), rs.getInt(4), rs.getString(9), rs.getString(2),
                        rs.getString(3), rs.getString(10), rs.getDate(5), rs.getDate(6)));
            }

        } catch (Exception e) {
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
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, id);
            ps.setString(3, id);
            ps.setString(4, id);
            ps.setString(5, id);
            ps.executeQuery();
        } catch (Exception e) {
            status += "Error at delete user " + e.getMessage();
            System.out.println(status);
        }
    }

    public static void main(String[] args) {
        DAOUser dao = new DAOUser();
        for (User u : dao.getAllUsers()) {
            System.out.println(u.toString());
        }
    }
}
