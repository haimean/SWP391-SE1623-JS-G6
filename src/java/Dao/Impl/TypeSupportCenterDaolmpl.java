/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.DBContext;
import Dao.TypeSupportCenterDao;
import Model.TypeSupportCenter;
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
public class TypeSupportCenterDaolmpl implements TypeSupportCenterDao {

    @Override
    public ArrayList<TypeSupportCenter> searchQnaType(String seachValue, int index) {
        DBContext dBContext = new DBContext();
        final int RECORD_PER_PAGE = 4;
        ArrayList<TypeSupportCenter> qnaTypeList = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select *\n"
                    + "from TypeSupportCenter tsc\n"
                    + "where (name like ?)\n"
                    + "order by id\n"
                    + "offset ? rows fetch next ? rows only";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, '%' + seachValue + '%');
            ps.setInt(2, (index - 1) * RECORD_PER_PAGE);
            ps.setInt(3, RECORD_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                qnaTypeList.add(new TypeSupportCenter(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(TypeSupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return qnaTypeList;
    }

    @Override
    public int getTotalQnaType() {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select count(*) from TypeSupportCenter";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(TypeSupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public int getTotalQnaTypeSearch(String seachValue) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select count(*) from\n"
                    + "(select *\n"
                    + "from TypeSupportCenter tsc\n"
                    + "where (name like ?)) as totalRecord";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, '%' + seachValue + '%');
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(TypeSupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public ArrayList<TypeSupportCenter> paginate(int index) {
        DBContext dBContext = new DBContext();
        final int RECORD_PER_PAGE = 4;
        ArrayList<TypeSupportCenter> qnaTypeList = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select *\n"
                    + "from TypeSupportCenter tsc\n"
                    + "order by id\n"
                    + "offset ? rows fetch next ? rows only";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, (index - 1) * RECORD_PER_PAGE);
            ps.setInt(2, RECORD_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                qnaTypeList.add(new TypeSupportCenter(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(TypeSupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return qnaTypeList;
    }

    @Override
    public TypeSupportCenter get(int id) {
        DBContext dBContext = new DBContext();
        ArrayList<TypeSupportCenter> qnaTypeList = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select * from TypeSupportCenter\n"
                    + "where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new TypeSupportCenter(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(TypeSupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public List<TypeSupportCenter> getAll() {
        DBContext dBContext = new DBContext();
        ArrayList<TypeSupportCenter> qnaTypeList = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select * from TypeSupportCenter";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                qnaTypeList.add(new TypeSupportCenter(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(TypeSupportCenter.class.getName()).log(Level.SEVERE, null, e);
        }
        return qnaTypeList;
    }

    @Override
    public boolean insert(TypeSupportCenter t) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "insert into TypeSupportCenter\n"
                    + "values(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, t.getName());
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(TypeSupportCenter.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean update(TypeSupportCenter t) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "UPDATE TypeSupportCenter\n"
                    + "SET name = ?\n"
                    + "WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, t.getName());
            ps.setInt(2, t.getId());
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(TypeSupportCenter.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "delete from TypeSupportCenter \n"
                    + "where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(TypeSupportCenter.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
}
