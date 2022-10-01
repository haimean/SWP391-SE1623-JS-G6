/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author MrTuan
 */
public class ProductDBContext extends DBContext {

    public List<Product> getProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from Product";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),
                        rs.getDouble(7), rs.getBoolean(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * from Product\n"
                + "where [name] like ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),
                        rs.getDouble(7), rs.getBoolean(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insertProduct(String name, int categoryId, int quantity, String description) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([categoryID]\n"
                + "           ,[name]\n"
                + "           ,[description]\n"
                + "           ,[origin]\n"
                + "           ,[quantity]\n"
                + "           ,[price]\n"
                + "           ,[status]\n"
                + "           ,[viewNumer]\n"
                + "           ,[created_at]\n"
                + "           ,[updated_at])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, categoryId);
            ps.setInt(3, quantity);
            ps.setString(4, description);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
