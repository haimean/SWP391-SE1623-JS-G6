/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Message;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haimi
 */
public class DAOMessage extends DBContext.DBContext {

    public ArrayList<Message> getMessageList(int id) {
        ArrayList<Message> messages = new ArrayList<>();
        ArrayList<Integer> listId = new ArrayList<>();
        String sql = "select top 1 * from Message"
                + " where( userSenderId = ?  and userReceiverId = ?) "
                + " or ( userSenderId = ?  and userReceiverId = ?)";
        String sqlgetListIdReceiver = "select DISTINCT   userReceiverId from Message where userSenderId = ?";
        String sqlgetListIdSender = "select DISTINCT   userSenderId from Message where userReceiverId = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlgetListIdReceiver);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                listId.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sqlgetListIdSender);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));

                listId.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        Set<Integer> set = new LinkedHashSet<>();
        set.addAll(listId);
        listId.clear();
        listId.addAll(set);
        for (Integer userId : listId) {
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, userId);
                ps.setInt(2, id);
                ps.setInt(3, id);
                ps.setInt(4, userId);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    messages.add(new Message(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5), rs.getDate(6)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return messages;
    }

    public ArrayList<Message> getMessage(int id, int userReceiverId) {
        ArrayList<Message> list = new ArrayList<>();
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

    public void insertMessage(int id, int userIdReceiver, String message) {
        long millis = System.currentTimeMillis();
        String sql = "INSERT INTO Message (userSenderId,userReceiverId,content,"
                + "created_at,updated_at) VALUES(?,?,?,?,?)";
        Date createAt = new Date(millis);
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, userIdReceiver);
            ps.setString(3, message);
            ps.setDate(4, createAt);
            ps.setDate(5, createAt);
            ps.executeUpdate();
            System.out.println("ok");
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        ArrayList<Message> list = new DAOMessage().getMessageList(3);
        for (Message message : list) {
            System.out.println(message.toString());
        }

    }
}