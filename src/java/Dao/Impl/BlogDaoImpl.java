/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;


import Dao.DBContext;
import Model.Blog;
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
public class BlogDaoImpl implements Dao.BlogDao{

    //Blog List (tât ca moi thu lien quan den list ra blog, vi du nhu method getAllBlog, deu se duoc de o duoi nay):

    public ArrayList<Blog> getAllBlog() {
        DBContext dBContext = new DBContext();
        ArrayList<Blog> listBlog = new ArrayList<>();
        try {
            String sql = "SELECT id, title, description, viewNumber FROM Blog WHERE 1=1";
            Connection connection = dBContext.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setDescription(rs.getString("description"));
                blog.setViewNumber(rs.getInt("viewNumber"));
                listBlog.add(blog);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listBlog;
    }

    public int getPageCount() throws Exception {
        DBContext dBContext = new DBContext();
        int st = 0;
        String sql = "SELECT COUNT(*) FROM Blog WHERE 1=1";

        try {

            Connection connection = dBContext.getConnection();
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

    @Override
    public List<Blog> getAllBlogByConstrain(int index) {
        DBContext dBContext = new DBContext();
        List<Blog> list = new ArrayList<>();
        String sql = "SELECT id, title, description, viewNumber FROM Blog ";
        StringBuilder sb = new StringBuilder(sql);
        sb.append(" ORDER BY id ASC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY");
        try {

            Connection connection = dBContext.getConnection();
            PreparedStatement ps = connection.prepareStatement(sb.toString());
            ps.setInt(1, index * 6);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                list.add(blog);

            }
        } catch (Exception e) {
        }
        return list;
    }

//Blog Details: day la noi de nem nhung code lien quan den details blog:
    public ArrayList<Blog> getTop3Blog() {
        DBContext dBContext = new DBContext();
        ArrayList<Blog> listBlog = new ArrayList<>();
        try {
            String sql = "SELECT TOP(4) id, title,  [description], viewNumber,created_at, updated_at\n"
                    + "FROM [Blog]\n"
                    + "ORDER BY viewNumber DESC";
            Connection connection = dBContext.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setDescription(rs.getString("description"));
                blog.setViewNumber(rs.getInt("viewNumber"));
                blog.setCreate_at(rs.getDate("created_at"));
                blog.setUpdate_at(rs.getDate("updated_at"));
                listBlog.add(blog);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listBlog;
    }

   

//    public static void main(String[] args) {
//        
//        
//        ArrayList<Blog> list = dao.getTop3Blog();
//        Blog b = dao.getBlogById(1);
//        for (Blog blog : list) {
//            if (b.getId() == blog.getId()) {
//                list.remove(blog);
//            }
//        }
//        for (Blog blog : list) {
//            System.out.println(blog);
//        }
////System.out.println(b);
//
//    }

    @Override
    public Blog get(int id) {
 DBContext dBContext = new DBContext();
        Blog blog = new Blog();
        try {
            String sql = "SELECT id, title,  [description], viewNumber,created_at, updated_at\n"
                    + "FROM [Blog]\n"
                    + "WHERE id = ?";
            Connection connection = dBContext.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setDescription(rs.getString("description"));
                blog.setViewNumber(rs.getInt("viewNumber"));
                blog.setCreate_at(rs.getDate("created_at"));
                blog.setUpdate_at(rs.getDate("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return blog;
    }

    public void increaseView(int proId) {
        DBContext dBContext = new DBContext();
        String sql = "UPDATE Blog \n"
                + "SET viewNumber = viewNumber +1 \n"
                + "WHERE id =  " + proId;
        try {
            Connection connection = dBContext.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex);
        }    
    }

    @Override
    public List<Blog> getAll() {
DBContext dBContext = new DBContext();
        List<Blog> listBlog = new ArrayList<>();
        try {
            String sql = "SELECT id, title, description, viewNumber FROM Blog WHERE 1=1";
            Connection connection = dBContext.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setDescription(rs.getString("description"));
                blog.setViewNumber(rs.getInt("viewNumber"));
                listBlog.add(blog);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listBlog;
    }
    
    
//Tat ca lien quan den Blog update and Create
    
    
    @Override
    public boolean insert(Blog t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Blog t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        BlogDaoImpl dao = new BlogDaoImpl();
        List<Blog> list = dao.getAllBlogByConstrain(0);
//        Blog b = dao.getBlogById(1);
//        for (Blog blog : list) {
//            if (b.getId() == blog.getId()) {
//                list.remove(blog);
//            }
//        }
        for (Blog blog : list) {
            System.out.println(blog);
        }
//System.out.println(b);

    }
}
