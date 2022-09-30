/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Context.DBContext;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class DAOProduct extends DBContext{
    
    private Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select p.id, p.categoryID, p.name, p.description, p.origin, p.quantity, p.price, p.status, p.viewNumer from Product p";
        try {
connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        (new DAOCategory()).getCategoryById(rs.getInt(2)),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getBoolean(8),
                        
                        rs.getInt(9));
                list.add(product);

            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public int getPageCount(int CategoryID, long begin, long end, String name) throws Exception {
        int st = 0;
        String sql = "SELECT COUNT(*) FROM Product WHERE 1=1";
        sql = addCategoryID(sql, CategoryID);
        sql = addUnitPrice(sql, begin, end);
        sql = addSearchByName(sql, name);
        connection = new DBContext().getConnection();
        try {
            
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
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
connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sb.toString());
            ps.setInt(1, index * 6);
            System.out.println("SQL: " + sb.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
               Product product = new Product(rs.getInt(1),
                        (new DAOCategory()).getCategoryById(rs.getInt(2)),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getBoolean(8),
                        
                        rs.getInt(9));                
               list.add(product);

            }
        } catch (Exception e) {
        }
        return list;
    }
}
