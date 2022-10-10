/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Category;

/**
 *
 * @author Mr Tuan
 */
public class CategoryDBContext extends DBContext implements CategoryDAO{
//tìm hieu lai interface va tai sao phai lam nhu vay
    public ArrayList<Category> getAllCategory() {
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

    public void deleteByID(String id) {
        try {
            String sql = "delete from Category  where id=?\n"
                    + "delete from Product where categoryID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateInfo(String id,String name ) {
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

    public ArrayList<Category> SearchName(String txtname) {
        ArrayList<Category> listCategory=new ArrayList<>();
        try {
            String sql = "Select * from Category c where c.[name] like '%'+?+'%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, txtname);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                Category category= new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                listCategory.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listCategory;
    }
    
    public void CreateCategory(String name){
        try {
            String sql="insert into Category values(?)";
            PreparedStatement stm=connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Category> GetCategoryById(String id){
        ArrayList<Category> listCategory =new ArrayList<>();
        try {
            String sql="select * from Category where id=?";
            PreparedStatement stm= connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs= stm.executeQuery();
            while(rs.next()){
                Category category= new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                listCategory.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listCategory;
    }
     public Category getCategoryById(int id) throws Exception
    {
        String sql = "select * from categories where id = "+id;
        try {
            PreparedStatement stm= connection.prepareStatement(sql);
            ResultSet rs= stm.executeQuery();
            if (rs.next()) {
                Category category = new Category(rs.getInt(1), rs.getString(2));
                return category;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public static void main(String[] args) {
        CategoryDBContext db = new CategoryDBContext();
        db.CreateCategory("kinh");

    }
}
