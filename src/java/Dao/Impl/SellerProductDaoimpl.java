/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.DBContext;
import Dao.SellerProductDao;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngolu
 */
public class SellerProductDaoimpl implements SellerProductDao {

    DBContext db = new DBContext();
    Connection connection = db.getConnection();
    Timestamp ts = Timestamp.from(Instant.now());

    // get all product
    @Override
    public List<Product> getProduct() {
        String sql = "Select * from Product";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getBoolean(8),
                        rs.getInt(9),
                        rs.getTimestamp(10),
                        rs.getTimestamp(11),
                        rs.getString(12));
                list.add(p);
            }
            db.closeConnection(connection, ps);
        } catch (SQLException ex) {
            Logger.getLogger(SellerProductDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // search product by name 
    @Override
    public List<Product> searchByName(String txtSearch) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * from Product\n"
                + "where [name] like ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getBoolean(8),
                        rs.getInt(9),
                        rs.getTimestamp(10),
                        rs.getTimestamp(11), "image");
                products.add(p);
                db.closeConnection(connection, ps);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SellerProductDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    // get total product 
    @Override
    public int getTotalProduct() {
        String sql = "Select count(*) from Product";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SellerProductDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    // paging product
    @Override
    public List<Product> getProduct(int page) {
        String sql = "select * from Product\n"
                + "order by id \n"
                + "offset ? rows fetch next 5 rows only";
        List<Product> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (page-1)*5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Product p = new Product(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getBoolean(8),
                        rs.getInt(9),
                        rs.getTimestamp(10),
                        rs.getTimestamp(11),
                        rs.getString(12));
                list.add(p);               
            }
            db.closeConnection(connection, ps);
        } catch (SQLException ex) {
            Logger.getLogger(SellerProductDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    // insert product
    @Override
    public boolean insert(Product item) {
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
            ps.setInt(1, item.getCategoryID());
            ps.setString(2, item.getName());
            ps.setString(3, item.getDescription());
            ps.setString(4, item.getOriginal());
            ps.setInt(5, item.getQuantity());
            ps.setDouble(6, item.getPrice());
            ps.setBoolean(7, item.getStatus());
            ps.setInt(8, 0);
            ps.setTimestamp(9, ts);
            ps.setTimestamp(10, ts);
            ps.executeUpdate();
            db.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SellerProductDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // update product
    @Override
    public boolean update(Product item) {
        Timestamp ts = Timestamp.from(Instant.now());
        try {
            String sql = "UPDATE [dbo].[Product]\n"
                    + "   SET [categoryID] = ?\n"
                    + "      ,[name] = ?\n"
                    + "      ,[description] =?\n"
                    + "      ,[origin] = ?\n"
                    + "      ,[quantity] = ?\n"
                    + "      ,[price] = ?\n"
                    + "      ,[status] = ?\n"
                    + "      ,[viewNumer] = ?\n"
                    + "      ,[updated_at] = ?\n"
                    + " WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, item.getCategoryID());
            ps.setString(2, item.getName());
            ps.setString(3, item.getDescription());
            ps.setString(4, item.getOriginal());
            ps.setInt(5, item.getQuantity());
            ps.setDouble(6, item.getPrice());
            ps.setBoolean(7, item.getStatus());
            ps.setInt(8, item.getViewNumber());
            ps.setTimestamp(9, ts);
            ps.setInt(10, item.getId());
            db.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SellerProductDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // delete product
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM [dbo].[Product]\n WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            db.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SellerProductDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // get product by id
    @Override
    public Product get(int id) {
        String sql = "select * from Product where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getBoolean(8),
                        rs.getInt(9),
                        rs.getTimestamp(10),
                        rs.getTimestamp(11),
                        rs.getString(12));
            }
            db.closeConnection(connection, ps);
        } catch (SQLException ex) {
            Logger.getLogger(SellerProductDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   
}
