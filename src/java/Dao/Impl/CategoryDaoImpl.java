/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Category;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import Dao.CategoryDao;

/**
 *
 * @author Mr Tuan
 */
public class CategoryDaoImpl implements CategoryDao {

    @Override
    public ArrayList<Category> search(String name) {
        DBContext dBContext = new DBContext();
        ArrayList<Category> listCategory = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "Select * from Category c where c.[name] like '%'+?+'%'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                listCategory.add(category);
            }
            dBContext.closeConnection(connection, ps, rs);
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, e);
        }
        return listCategory;
    }

    @Override
    public Category get(int id) {
        DBContext dBContext = new DBContext();
        Category category = new Category();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select * from Category where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }
            dBContext.closeConnection(connection, ps, rs);
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, e);
        }
        return category;
    }

    @Override
    public ArrayList<Category> getAll() {
        DBContext dBContext = new DBContext();
        ArrayList<Category> listCategory = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select * from Category";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                listCategory.add(category);
            }
            dBContext.closeConnection(connection, ps, rs);
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, e);
        }
        return listCategory;
    }

    @Override
    public boolean insert(Category t) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "insert into Category values(?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, e);

        }
        return false;
    }

    @Override
    public boolean update(Category t) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "UPDATE Category\n"
                    + "   SET [name] = ?\n"
                    + " WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setInt(2, t.getId());
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, e);

        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "delete from Category  where id=?\n"
                    + "delete from Product where categoryID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public int getTotalCategory() {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select count(*) from Category";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public ArrayList<Category> getAll(int page) {
        Dao.DBContext dBContext = new Dao.DBContext();
        ArrayList<Category> listCategory = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select * from Category\n"
                    + "order by id\n"
                    + "offset ? rows fetch next 5 rows only";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (page - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                listCategory.add(category);
            }
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, e);
        }
        return listCategory;
    }
}
