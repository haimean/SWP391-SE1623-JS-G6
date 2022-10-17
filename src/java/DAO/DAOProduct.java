/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Product;

/**
 *
 * @author MrTuan
 */
public class DAOProduct extends DBContext.DBContext {

    // get product
    public List<Product> getProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from Product";

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
                        rs.getString(10),
                        rs.getString(11));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // search by name 
    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
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
                        rs.getString(10),
                        rs.getString(11));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // insert Product 
    public void insertProduct(int categoryId, String name, String description, String origin,
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
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // get product by id
    public Product getProductById(String id) {
        String sql = "select * from Product\n where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
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
                        rs.getString(10),
                        rs.getString(11));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // delete Product
    public void deleteProduct(int pid) {
        String sql = "DELETE FROM [dbo].[Product]\n WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // update Product 
    public void updateProductById(
            String id,
            int categoryId,
            String name,
            String description,
            String origin,
            int quantity,
            double price,
            boolean status,
            int viewNumber,
            String created,
            String updated) {
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
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getPageCount(int CategoryID, long begin, long end, String name) throws Exception {
        int st = 0;
        String sql = "SELECT COUNT(*) FROM Product WHERE 1=1";
        sql = addCategoryID(sql, CategoryID);
        sql = addUnitPrice(sql, begin, end);
        sql = addSearchByName(sql, name);
        
        try {
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                st = (int) Math.ceil(rs.getInt(1) / 6.0);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return st;
    }
    
     private String addCategoryID(String sql, int CategoryID) {
        StringBuilder sb = new StringBuilder(sql);
        if (CategoryID > 0) {
            sb.append(" AND id=").append(CategoryID);
        }
        return sb.toString();
    }

    private String addUnitPrice(String sql, long begin, long end) {
        StringBuilder sb = new StringBuilder(sql);
        if (end > 0) {
            sb.append(" AND price BETWEEN ").append(begin).append(" AND ").append(end);
        }
        return sb.toString();
    }

    private String addSearchByName(String sql, String name) {
        StringBuilder sb = new StringBuilder(sql);
        if (!name.isEmpty()) {
            sb.append(" AND name like '%").append(name).append("%'");
        }
        return sb.toString();
    }
    
     public List<Product> getAllProductByConstrain(int index, int order_by, int CategoryID, long begin, long end, String name) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.id, p.categoryID, p.name, p.description, p.origin, p.quantity, p.price, p.status, p.viewNumer FROM Product p WHERE 1=1";
        sql = addCategoryID(sql, CategoryID);  //WHERE CategoryID=
        sql = addUnitPrice(sql, begin, end);    //WHERE UnitsPrice BETWEEN
        sql = addSearchByName(sql, name);
        StringBuilder sb = new StringBuilder(sql);
        switch (order_by) {
            case 1: {
                sb.append(" ORDER BY name ASC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY");
                break;
            }
            case 2: {
                sb.append(" ORDER BY price ASC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY");
                break;
            }
            case 3: {
                sb.append(" ORDER BY price DESC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY");
                break;
            }
            default: {
                sb.append(" ORDER BY id DESC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY");
                break;
            }
        }
        try {
           
    
            PreparedStatement ps = connection.prepareStatement(sb.toString());
            ps.setInt(1, index * 6);
            System.out.println("SQL: " + sb.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDouble(7), 
                        rs.getBoolean(8), 
                        rs.getInt(9)
                );              
               list.add(product);

            }
        } catch (Exception e) {
        }
        return list;
    }
}
