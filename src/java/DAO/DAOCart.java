/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Cart;
import Model.ItemCart;
import Model.User;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PiPi
 */
public class DAOCart extends DBContext.DBContext {

    private String status = "";

    public String getStatus() {
        return status;
    }

    public void addOrder(User user, Cart cart) {
//        LocalDate date = java.time.LocalDate.now();
//        Date date = new Date(Date.getTime());
        Date date = new Date(System.currentTimeMillis());

//        String date = curDate.toString();
        try {
            String query = "insert into [Order] values(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getRole() == 1 ? "Admin" : user.getRole() == 2 ? "Seller" : "Customer");
            ps.setInt(3, 1); // status mac dinh luc dau la 1 - dat hang
            ps.setDate(4, date);
            ps.setDate(5, date);
            ps.executeUpdate();

            String query1 = "select top 1 id from [Order] order by id desc";
            PreparedStatement ps1 = connection.prepareStatement(query1);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                int oid = rs.getInt(1);
                for (ItemCart item : cart.getItems()) {
                    String query2 = "insert into OrderDetail values(?,?,?,?,?,?)";
                    PreparedStatement ps2 = connection.prepareStatement(query2);
                    ps2.setInt(1, oid);
                    ps2.setInt(2, item.getProduct().getId());
                    ps2.setInt(3, item.getQuantity());
                    ps2.setDouble(4, item.getPrice());
                    ps2.executeUpdate();
                }
            }

            String query3 = "update Product set quantity = quantity - ? where id = ?";
            PreparedStatement ps3 = connection.prepareStatement(query3);
            for (ItemCart i : cart.getItems()) {
                ps3.setInt(1, i.getQuantity());
                ps3.setInt(2, i.getProduct().getId());
                ps3.executeUpdate();
            }
        } catch (SQLException e) {
            status += "Error at add order " + e.getMessage();
            System.out.println(status);
        }
    }
}
