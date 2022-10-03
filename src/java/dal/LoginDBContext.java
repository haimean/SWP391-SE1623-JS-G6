/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author MrTuan
 */
public class LoginDBContext extends DBContext {

    public User search(String Email, String password){
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
            Logger.getLogger(LoginDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
