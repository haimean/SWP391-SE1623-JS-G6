/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Context.DBContext;
import Model.Category;
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
public class DAOCategory {
    
    private Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    public Category getCategoryById(int id) throws Exception
    {
        String sql = "select * from categories where id = "+id;
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Category category = new Category(rs.getInt(1), rs.getString(2));
                return category;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public List<Category> getAllCategory() throws Exception {
        List<Category> list = new ArrayList<>();

        try {
            String sql = "select * from Category";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt(1), rs.getString(2));
                list.add(category);
            }
        } catch (SQLException e) {
        }
        return list;
    }
}
