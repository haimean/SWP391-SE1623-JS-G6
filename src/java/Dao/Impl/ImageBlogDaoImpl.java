/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.DBContext;
import Model.Blog;
import Model.ImageBlog;
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
public class ImageBlogDaoImpl implements Dao.ImageBlogDao{

    @Override
    public ImageBlog get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ImageBlog> getAll() {
DBContext dBContext = new DBContext();
        List<ImageBlog> listImageBlog = new ArrayList<>();
        try {
            String sql = "SELECT * From ImageBlog";
            Connection connection = dBContext.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ImageBlog imageblog = new ImageBlog();
                imageblog.setId(rs.getInt(1));
                imageblog.setId(rs.getInt(2));
                imageblog.setImage(rs.getString(3));
                imageblog.setCreate_at(rs.getString(4));
                imageblog.setUpdate_at(rs.getString(5));
                listImageBlog.add(imageblog);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listImageBlog;    
    }

    @Override
    public boolean insert(ImageBlog t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(ImageBlog t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
