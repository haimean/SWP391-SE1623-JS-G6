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
                Product p = new Product(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),
                        rs.getDouble(7), rs.getBoolean(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
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
                Product p = new Product(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),
                        rs.getDouble(7), rs.getBoolean(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public void insertProduct(int categoryId,String name,  String description, String origin,
            int quantity, double price, boolean status, int viewNumber, String created, String updated) {
        
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
            ps.setInt(1, categoryId);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setString(4, origin);
            ps.setInt(5, quantity);
            ps.setDouble(6, price);
            ps.setBoolean(7, status);
            ps.setInt(8, viewNumber);
            ps.setString(9, created);
            ps.setString(10, updated);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Product getProductById(String id) {
        String sql = "select * from Product\n"
                + "where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),
                        rs.getDouble(7), rs.getBoolean(8), rs.getInt(9), rs.getString(10), rs.getString(11));
            }
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        return null;
    }

    public void deleteProduct(int pid) {
        String sql = "DELETE FROM [dbo].[Product]\n"
                + "      WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.executeUpdate();
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }

    public void updateProductById(String id ,int categoryId,String name,  String description, String origin,
            int quantity, double price, boolean status, int viewNumber, String created, String updated ) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [categoryID] = ?\n"
                + "      ,[name] = ?\n"
                + "      ,[description] =?\n"
                + "      ,[origin] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[viewNumer] = ?\n"
                + "      ,[created_at] = ?\n"
                + "      ,[updated_at] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ps.setString(2, name);          
            ps.setString(3, description);
            ps.setString(4, origin);
            ps.setInt(5, quantity);
            ps.setDouble(6, price);
            ps.setBoolean(7, status);
            ps.setInt(8, viewNumber);
            ps.setString(9, created);
            ps.setString(10, updated);
            ps.setString(11, id);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        
    }
}
