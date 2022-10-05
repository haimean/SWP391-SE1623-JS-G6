/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Category;

/**
 *
 * @author Mr Tuan
 */
public class CategoryDBContext extends DBContext.DBContext {

    public ArrayList<Category> getCategories() {
        ArrayList<Category> listCategory = new ArrayList<>();
        try {
            String sql = "select * from Category";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                listCategory.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listCategory;
    }

    public void deleteCategory(int id) {
        try {
            String sql = "delete from Category  where id=?\n"
                    + "delete from Product where categoryID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }

    public void updateCategory(String id, String name) {
        try {
            String sql = "UPDATE Category\n"
                    + "   SET [name] = ?\n"
                    + " WHERE id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public ArrayList<Category> searchName(String txtname) {
        ArrayList<Category> listCategory = new ArrayList<>();
        try {
            String sql = "Select * from Category c where c.[name] like '%'+?+'%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, txtname);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                listCategory.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listCategory;
    }

    public void createCategory(String name) {
        try {
            String sql = "insert into Category values(?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Category getCategory(int id) {
        Category category = new Category();
        try {
            String sql = "select * from Category where id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
<<<<<<<< HEAD:src/java/DAO/DAOCategory.java
        return category;
========
        return listCategory;
    }


    public static void main(String[] args) {
        CategoryDBContext db = new CategoryDBContext();
        db.updateInfo("1","loan");
>>>>>>>> b44df51c32cb7cb4de5c667f2149d26803b60d53:src/java/DAO/CategoryDBContext.java
    }
}
