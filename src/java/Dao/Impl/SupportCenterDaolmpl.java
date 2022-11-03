/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.DBContext;
import Dao.SupportCenterDao;
import Model.SupportCenter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PiPi
 */
public class SupportCenterDaolmpl implements SupportCenterDao {

    @Override
    public ArrayList<SupportCenter> searchQna(String seachValue, int index) {
        ArrayList<SupportCenter> qnas = new ArrayList<>();
        final int RECORD_PER_PAGE = 4;
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select sc.id, sc.created_at, sc.updated_at, question, answer, [name]\n"
                    + "from SupportCenter sc, TypeSupportCenter tsc\n"
                    + "where (sc.typeId = tsc.id) and ((question like ?) or (answer like ?))\n"
                    + "order by id\n"
                    + "offset ? rows fetch next ? rows only";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, '%' + seachValue + '%');
            ps.setString(2, '%' + seachValue + '%');
            ps.setInt(3, (index - 1) * RECORD_PER_PAGE);
            ps.setInt(4, RECORD_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                qnas.add(new SupportCenter(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(SupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return qnas;
    }

    @Override
    public int getTotalQna() {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select count(*) from SupportCenter";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(SupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public int getTotalQnaSearch(String seachValue) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select count(*) from \n"
                    + "(select sc.id, sc.created_at, sc.updated_at, question, answer, [name]\n"
                    + "from SupportCenter sc, TypeSupportCenter tsc\n"
                    + "where (sc.typeId = tsc.id) and ((question like ?) or (answer like ?))\n"
                    + ") as totalRecord";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, '%' + seachValue + '%');
            ps.setString(2, '%' + seachValue + '%');
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(SupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public ArrayList<SupportCenter> paginate(int index) {
        DBContext dBContext = new DBContext();
        final int RECORD_PER_PAGE = 4;
        ArrayList<SupportCenter> qnas = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select sc.id, sc.created_at, sc.updated_at, question, answer, [name]\n"
                    + "from SupportCenter sc, TypeSupportCenter tsc\n"
                    + "where sc.typeId = tsc.id\n"
                    + "order by id\n"
                    + "offset ? rows fetch next ? rows only";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, (index - 1) * RECORD_PER_PAGE);
            ps.setInt(2, RECORD_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                qnas.add(new SupportCenter(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(SupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return qnas;
    }

    @Override
    public SupportCenter get(int id) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select sc.id, sc.created_at, sc.updated_at, question, answer, [name], typeId\n"
                    + "from SupportCenter sc, TypeSupportCenter tsc\n"
                    + "where (sc.typeId = tsc.id) and sc.id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new SupportCenter(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(SupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public List<SupportCenter> getAll() {
        DBContext dBContext = new DBContext();
        ArrayList<SupportCenter> qnas = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select sc.id, sc.created_at, sc.updated_at, question, answer, [name]\n"
                    + "from SupportCenter sc, TypeSupportCenter tsc\n"
                    + "where sc.typeId = tsc.id";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                qnas.add(new SupportCenter(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(SupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return qnas;
    }

    @Override
    public boolean insert(SupportCenter t) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "insert into SupportCenter \n"
                    + "values(?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            ps.setString(3, t.getQuestion());
            ps.setString(4, t.getAnswer());
            ps.setInt(5, t.getTypeId());
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(SupportCenter.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean update(SupportCenter t) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "UPDATE SupportCenter\n"
                    + "SET question = ?, answer= ?, typeId = ?\n"
                    + "WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, t.getQuestion());
            ps.setString(2, t.getAnswer());
            ps.setInt(3, t.getTypeId());
            ps.setInt(4, t.getId());
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(SupportCenter.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "delete from SupportCenter \n"
                    + "where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(SupportCenter.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

}
