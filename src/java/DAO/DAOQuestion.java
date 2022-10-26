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
public class DAOQuestion extends DBContext.DBContext {

    private String status = "";

    public String getStatus() {
        return status;
    }

    public ArrayList<SupportCenter> getAllQna() {
        ArrayList<SupportCenter> qnaList = new ArrayList<>();
        String query = "select sc.id, sc.created_at, sc.updated_at, question, answer, [name]\n"
                + "from SupportCenter sc, TypeSupportCenter tsc\n"
                + "where sc.typeId = tsc.id";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                qnaList.add(new SupportCenter(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }

        } catch (SQLException e) {
            status += "Error at get all QnA" + e.getMessage();
            System.out.println(status);
        }
        return qnaList;
    }

    public String deleteQna(int id) {
        try {
            String sql = "delete from SupportCenter \n"
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

    public int getTotalQna() {
        String query = "select count(*) from SupportCenter";
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

    public ArrayList<SupportCenter> paginate(int index) {
        ArrayList<SupportCenter> list = new ArrayList<>();
        String query = "select sc.id, sc.created_at, sc.updated_at, question, answer, [name]\n"
                + "from SupportCenter sc, TypeSupportCenter tsc\n"
                + "where sc.typeId = tsc.id\n"
                + "order by id\n"
                + "offset ? rows fetch next ? rows only";
        final int recordsPerPage = 3;
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, (index - 1) * recordsPerPage);
            stm.setInt(2, recordsPerPage);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new SupportCenter(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public int getTotalQnaSearch(String seachValue) {
        String query = "select count(*) from \n"
                + "(select sc.id, sc.created_at, sc.updated_at, question, answer, [name]\n"
                + "from SupportCenter sc, TypeSupportCenter tsc\n"
                + "where (sc.typeId = tsc.id) and ((question like ?) or (answer like ?))\n"
                + ") as totalRecord";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, '%' + seachValue + '%');
            stm.setString(2, '%' + seachValue + '%');
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public ArrayList<SupportCenter> searchQna(String seachValue, int index) {
        ArrayList<SupportCenter> qnaList = new ArrayList<>();
        String query = "select sc.id, sc.created_at, sc.updated_at, question, answer, [name]\n"
                + "from SupportCenter sc, TypeSupportCenter tsc\n"
                + "where (sc.typeId = tsc.id) and ((question like ?) or (answer like ?))\n"
                + "order by id\n"
                + "offset ? rows fetch next ? rows only";
        final int recordsPerPage = 3;

        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, '%' + seachValue + '%');
            stm.setString(2, '%' + seachValue + '%');
            stm.setInt(3, (index - 1) * recordsPerPage);
            stm.setInt(4, recordsPerPage);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                qnaList.add(new SupportCenter(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
            if (!qnaList.isEmpty()) {
                return qnaList;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public ArrayList<TypeSupportCenter> getAllQnaType() {
        ArrayList<TypeSupportCenter> qnaTypeList = new ArrayList<>();
        String query = "select * from TypeSupportCenter";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                qnaTypeList.add(new TypeSupportCenter(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4)));
            }

        } catch (SQLException e) {
            status += "Error at get all QnA type" + e.getMessage();
            System.out.println(status);
        }
        return qnaTypeList;
    }

    public SupportCenter getQnaById(int id) {
        String query = "select sc.id, sc.created_at, sc.updated_at, question, answer, [name], typeId\n"
                + "from SupportCenter sc, TypeSupportCenter tsc\n"
                + "where (sc.typeId = tsc.id) and sc.id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
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

        } catch (SQLException e) {
            status += "Error at get all QnA by id" + e.getMessage();
            System.out.println(status);
        }
        return null;
    }

    public String update(int id, int typeId, String question, String answer) {
        String query = "UPDATE SupportCenter\n"
                + "SET question = ?, answer= ?, typeId = ?\n"
                + "WHERE id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, question);
            stm.setString(2, answer);
            stm.setInt(3, typeId);
            stm.setInt(4, id);
            stm.executeUpdate();
            return "true";
        } catch (SQLException e) {
            status += "Error at update" + e.getMessage();
            System.out.println(status);
            return "false";
        }
    }

    public String add(int typeId, String question, String answer) {
        String query = "insert into SupportCenter \n"
                + "values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setDate(1, Date.valueOf(LocalDate.now()));
            stm.setDate(2, Date.valueOf(LocalDate.now()));
            stm.setString(3, question);
            stm.setString(4, answer);
            stm.setInt(5, typeId);
            stm.executeUpdate();
            return "true";
        } catch (SQLException e) {
            status += "Error at add " + e.getMessage();
            System.out.println(status);
            return "false";
        }
    }

    public static void main(String[] args) {
        DAOQuestion dao = new DAOQuestion();
    }
}
