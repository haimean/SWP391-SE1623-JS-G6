/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.DBContext;
import Dao.MessageDao;
import Model.Message;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haimi
 */
public class MessageDaoImpl implements MessageDao {

    @Override
    public ArrayList<Message> getAll(int id) {
        DBContext dBContext = new DBContext();
        ArrayList<Message> messages = new ArrayList<>();
        ArrayList<Integer> listId = new ArrayList<>();

        try {
            Connection connection = dBContext.getConnection();
            String sql = "select DISTINCT   userReceiverId from Message where userSenderId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listId.add(rs.getInt(1));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select DISTINCT   userSenderId from Message where userReceiverId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));

                listId.add(rs.getInt(1));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
        Set<Integer> set = new LinkedHashSet<>();
        set.addAll(listId);
        listId.clear();
        listId.addAll(set);
        for (Integer userId : listId) {
            try {
                String sql = "select top 1 * from Message"
                        + " where( userSenderId = ?  and userReceiverId = ?) "
                        + " or ( userSenderId = ?  and userReceiverId = ? ) ORDER BY id  DESC";

                Connection connection = dBContext.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, userId);
                ps.setInt(2, id);
                ps.setInt(3, id);
                ps.setInt(4, userId);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    messages.add(new Message(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5),
                            rs.getDate(6)));
                }
                dBContext.closeConnection(connection, ps);
            } catch (SQLException ex) {
                Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return messages;
    }

    @Override
    public ArrayList<Message> get(int userId, int userReceiverId) {
        DBContext dBContext = new DBContext();
        ArrayList<Message> list = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select * from Message where (userSenderId = ? AND userReceiverId= ?) OR  (userSenderId = ? AND userReceiverId= ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userReceiverId);
            ps.setInt(2, userId);
            ps.setInt(3, userId);
            ps.setInt(4, userReceiverId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Message(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5),
                        rs.getDate(6)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<Message> getAll(int id, String search) {
        DBContext dBContext = new DBContext();
        ArrayList<Message> messages = new ArrayList<>();
        ArrayList<Integer> listId = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select DISTINCT   userReceiverId from Message where userSenderId = ? and Message.userReceiverId = UserInformation.userId and UserInformation.fullname LIKE  '%'+?+'%'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, search);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                listId.add(rs.getInt(1));

            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select DISTINCT   userSenderId from Message where userReceiverId = ? and Message.userSenderId = UserInformation.userId and UserInformation.fullname LIKE  '%'+?+'%'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, search);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));

                listId.add(rs.getInt(1));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
        Set<Integer> set = new LinkedHashSet<>();
        set.addAll(listId);
        listId.clear();
        listId.addAll(set);
        for (Integer userId : listId) {
            try {
                Connection connection = dBContext.getConnection();
                String sql = "select top 1 * from Message"
                        + " where( userSenderId = ?  and userReceiverId = ?) "
                        + " or ( userSenderId = ?  and userReceiverId = ? ) ORDER BY id  DESC";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, userId);
                ps.setInt(2, id);
                ps.setInt(3, id);
                ps.setInt(4, userId);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    messages.add(new Message(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5),
                            rs.getDate(6)));
                }
                dBContext.closeConnection(connection, ps);
            } catch (SQLException ex) {
                Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return messages;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Message message) {
        DBContext dBContext = new DBContext();
        Timestamp ts = Timestamp.from(Instant.now());
        long millis = System.currentTimeMillis();
        String sql = "INSERT INTO Message (userSenderId,userReceiverId,content,"
                + "created_at,updated_at) VALUES(?,?,?,?,?)";
        Date createAt = new Date(millis);
        try {
            Connection connection = dBContext.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, message.getUserSenderId());
            ps.setInt(2, message.getUserReceiverId());
            ps.setString(3, message.getContent());
            ps.setTimestamp(4, ts);
            ps.setTimestamp(5, ts);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Message t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Message get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Message> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
