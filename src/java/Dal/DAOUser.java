<<<<<<<HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

=======
package Dal;

import Context.DBContext;
import Model.User;
import java.sql.Connection;>>>>>>>8ec 4d 3 b(n)
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;<<<<<<<HEAD
import Model.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MrTuan
 */
public class DAOUser extends DBContext.DBContext {

	=======

	/**
	 *
	 * @author PiPi
	 */
	public class DAOUser extends Context.DBContext {

		private Connection con;
		private PreparedStatement ps;
		private ResultSet rs;>>>>>>>8ec 4d 3b (n)

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
<<<<<<< HEAD
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
=======
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
>>>>>>> 8ec4d3b (n)
            while (rs.next()) {
                userList.add(new User(rs.getInt(1), rs.getInt(4), rs.getString(9), rs.getString(2),
                        rs.getString(3), rs.getString(10), rs.getDate(5), rs.getDate(6)));
            }

<<<<<<< HEAD
        } catch (SQLException e) {
=======
        } catch (Exception e) {
>>>>>>> 8ec4d3b (n)
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
			String sql = "select u.id, u.role, ui.fullname, u.email,	"
					+ "u.password, ui.phone, u.created_at, u.updated_at\n"
					+ "from UserInformation as ui, [User] as u\n"
					+ "where u.id = ui.userId and u.email = '" + Email + "' and u.password = '" + password + "'";
			try {
				PreparedStatement stm = connection.prepareStatement(sql);
				ResultSet rs = stm.executeQuery();
				if (rs.next()) {
					return new User(
							rs.getInt(1),
							rs.getInt(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getDate(7),
							rs.getDate(8));
				}
			} catch (SQLException ex) {
			}

			return null;

		}
}
