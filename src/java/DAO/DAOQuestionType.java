/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author PiPi
 */
public class DAOQuestionType extends DBContext.DBContext {

    private String status = "";

    public String getStatus() {
        return status;
    }

    public ArrayList<TypeSupportCenter> getAllQnaType() {
        ArrayList<TypeSupportCenter> qnaTypeList = new ArrayList<>();
        String query = "select * from TypeSupportCenter";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                qnaTypeList.add(new TypeSupportCenter(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4)));
            }
        } catch (SQLException e) {
            status += "Error at get all QnA type" + e.getMessage();
            System.out.println(status);
        }
        return qnaTypeList;
    }

    public int getTotalQnaType() {
        String query = "select count(*) from TypeSupportCenter";
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

    public ArrayList<TypeSupportCenter> paginate(int index) {
        ArrayList<TypeSupportCenter> list = new ArrayList<>();
        String query = "select *\n"
                + "from TypeSupportCenter tsc\n"
                + "order by id\n"
                + "offset ? rows fetch next ? rows only";
        final int recordsPerPage = 4;
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, (index - 1) * recordsPerPage);
            stm.setInt(2, recordsPerPage);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new TypeSupportCenter(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public int getTotalQnaTypeSearch(String seachValue) {
        String query = "select count(*) from\n"
                + "(select *\n"
                + "from TypeSupportCenter tsc\n"
                + "where (name like ?)) as totalRecord";
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

    public ArrayList<TypeSupportCenter> searchQnaType(String seachValue, int index) {
        ArrayList<TypeSupportCenter> qnaTypeList = new ArrayList<>();
        String query = "select *\n"
                + "from TypeSupportCenter tsc\n"
                + "where (name like ?)\n"
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
                qnaTypeList.add(new TypeSupportCenter(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4)));
            }
            if (!qnaTypeList.isEmpty()) {
                return qnaTypeList;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public String add(String name) {
        String query = "insert into TypeSupportCenter\n"
                + "values(?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, name);
            stm.setDate(2, Date.valueOf(LocalDate.now()));
            stm.setDate(3, Date.valueOf(LocalDate.now()));
            stm.executeUpdate();
            return "true";
        } catch (SQLException e) {
            status += "Error at add " + e.getMessage();
            System.out.println(status);
            return "false";
        }
    }

    public String deleteQnaType(int id) {
        try {
            String sql = "delete from TypeSupportCenter \n"
                    + "where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            return "true";
        } catch (SQLException e) {
            System.out.println(e);
            return "false";
        }
    }
    
    public String update(int id, String name) {
        String query = "UPDATE TypeSupportCenter\n"
                + "SET name = ?\n"
                + "WHERE id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, name);
            stm.setInt(2, id);
            stm.executeUpdate();
            return "true";
        } catch (SQLException e) {
            status += "Error at update" + e.getMessage();
            System.out.println(status);
            return "false";
        }
    }

    public TypeSupportCenter getQnaTypeById(int id) {
        String query = "select * from TypeSupportCenter\n"
                + "where id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new TypeSupportCenter(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4));
            }

        } catch (SQLException e) {
            status += "Error at get all QnA type by id" + e.getMessage();
            System.out.println(status);
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<TypeSupportCenter> list = new DAOQuestionType().searchQnaType("asus", 1);
        int a = new DAOQuestionType().getTotalQnaTypeSearch("asus");
        System.out.println(a);
        for (TypeSupportCenter typeSupportCenter : list) {
            System.out.println(typeSupportCenter.toString());
        }
    }

}
