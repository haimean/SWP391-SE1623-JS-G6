/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Message;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haimi
 */
public class DAOMessage extends DBContext.DBContext {

    public ArrayList<Message> getMessageList(int id) {
        ArrayList<Message> list = new ArrayList<Message>();
        String sql = "select * from Message where userSenderId = ? or userReceiverId= ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Message(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5), rs.getDate(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ArrayList<Message> getMessage(int id, int userReceiverId) {
        ArrayList<Message> list = new ArrayList<Message>();
        String sql = "select * from Message where (userSenderId = ? AND userReceiverId= ?) OR  (userSenderId = ? AND userReceiverId= ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userReceiverId);
            ps.setInt(2, id);
            ps.setInt(3, id);
            ps.setInt(4, userReceiverId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Message(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5), rs.getDate(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public static void main(String[] args) {
        ArrayList<Message> messagesUser = new DAOMessage().getMessage(1, 2);
        for (Message message : messagesUser) {
            System.out.println(message.getContent());
        }
    }
}
