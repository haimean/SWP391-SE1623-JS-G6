/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.DBContext;
import Model.Blog;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class BlogDaoImpl implements Dao.BlogDao {

    //Blog List (tât ca moi thu lien quan den list ra blog, vi du nhu method getAllBlog, deu se duoc de o duoi nay):
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
    
    public int getPageCount(int id) throws Exception {
        DBContext dBContext = new DBContext();
        int st = 0;
        String sql = "SELECT COUNT(*) FROM Blog WHERE userId = "+id;

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
        String sql = "SELECT b.id, b.title, b.[description], b.viewNumber, ib.[image], b.content, b.created_at, b.updated_at\n"
                + "FROM Blog b\n"
                + "LEFT JOIN ImageBlog ib\n"
                + "ON b.id = ib.blogID ";
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
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
                list.add(blog);

            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Blog> getAllBlogByConstrain(int index, int id) {
        DBContext dBContext = new DBContext();
        List<Blog> list = new ArrayList<>();
        String sql = "SELECT b.id, b.title, b.[description], b.viewNumber, ib.[image], b.content, b.created_at, b.updated_at, b.userId\n"
                + "FROM Blog b\n"
                + "LEFT JOIN ImageBlog ib\n"
                + "ON b.id = ib.blogID \n"
                + "where b.userId = " + id;
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
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
                list.add(blog);

            }
        } catch (Exception e) {
        }
        return list;
    }

//Blog Details: day la noi de nem nhung code lien quan den details blog:
    public Blog getWithDate(int id) {
        DBContext dBContext = new DBContext();
        Blog blog = new Blog();
        try {
            String sql = "SELECT b.id, b.title, b.[description], b.viewNumber, ib.[image], b.content, b.created_at, b.updated_at\n"
                    + "               FROM Blog b\n"
                    + "                LEFT JOIN ImageBlog ib\n"
                    + "                ON b.id = ib.blogID\n"
                    + "                WHERE b.id = ?";
            Connection connection = dBContext.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setDescription(rs.getString("description"));
                blog.setViewNumber(rs.getInt("viewNumber"));
                blog.setImage(rs.getString("image"));
                blog.setContent(rs.getString("content"));
                blog.setCreate_at(rs.getString("created_at"));
                blog.setUpdate_at(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return blog;
    }

    public Blog getWithDate2(int id) {
        DBContext dBContext = new DBContext();
        Blog blog = new Blog();
        try {
            String sql = "SELECT b.id, b.title, b.[description], ib.[image], b.content, b.created_at, b.updated_at\n"
                    + "               FROM Blog b\n"
                    + "                LEFT JOIN ImageBlog ib\n"
                    + "                ON b.id = ib.blogID\n"
                    + "                WHERE b.id = ?";
            Connection connection = dBContext.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setDescription(rs.getString("description"));
                blog.setImage(rs.getString("image"));
                blog.setContent(rs.getString("content"));
                blog.setCreate_at(rs.getString("created_at"));
                blog.setUpdate_at(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return blog;
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Blog> getTop3Blog() {
        DBContext dBContext = new DBContext();
        ArrayList<Blog> listBlog = new ArrayList<>();
        try {

            String sql = "SELECT TOP(4) b.id, b.title, b.[description], b.viewNumber, ib.[image], b.content, b.created_at, b.updated_at\n"
                    + "                   FROM Blog b\n"
                    + "               LEFT JOIN ImageBlog ib\n"
                    + "                ON b.id = ib.blogID\n"
                    + "                    ORDER BY b.viewNumber DESC";
            Connection connection = dBContext.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setDescription(rs.getString("description"));
                blog.setViewNumber(rs.getInt("viewNumber"));
                blog.setImage(rs.getString("image"));
                blog.setContent(rs.getString("content"));
                blog.setCreate_at(rs.getString("created_at"));
                blog.setUpdate_at(rs.getString("updated_at"));
                listBlog.add(blog);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listBlog;
    }

    public static void main(String[] args) {
        BlogDaoImpl daoB = new BlogDaoImpl();

        ArrayList<Blog> listB = daoB.getTop3Blog();
        for (Blog blog : listB) {
            System.out.println(blog);
        }
    }

    @Override
    public Blog get(int id) {
        DBContext dBContext = new DBContext();
        Blog blog = new Blog();
        try {
            String sql = "SELECT b.id, b.title, b.[description], b.viewNumber, ib.[image], b.content\n"
                    + "               FROM Blog b\n"
                    + "                LEFT JOIN ImageBlog ib\n"
                    + "                ON b.id = ib.blogID\n"
                    + "                WHERE b.id = ?";
            Connection connection = dBContext.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setDescription(rs.getString("description"));
                blog.setViewNumber(rs.getInt("viewNumber"));
                blog.setImage(rs.getString("image"));
                blog.setContent(rs.getString("content"));
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
        DBContext dBContext = new DBContext();

        try {
            Connection connection = dBContext.getConnection();
//            Timestamp ts = Timestamp.from(Instant.now());
            String sql = "INSERT INTO Blog(\n"
                    + "   [title]\n"
                    + "   ,[description]\n"
                    + "   ,[created_at]\n"
                    + "	  ,[updated_at]\n"
                    + "   ,[content]\n"
                    + "	  ,[status]\n"
                    + "	  ,[userId])\n"
                    + "VALUES( ? , ?, ?, ?, ?, 1, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setDate(3, new Date(System.currentTimeMillis()));
            ps.setDate(4, new Date(System.currentTimeMillis()));
            ps.setString(5, t.getContent());
            ps.setInt(6, t.getUserId());
            ps.execute();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean insert2(Blog t) {
        DBContext dBContext = new DBContext();

        try {
            Connection connection = dBContext.getConnection();
//            Timestamp ts = Timestamp.from(Instant.now());
            String sql = "INSERT INTO Blog(\n"
                    + "   [title]\n"
                    + "   ,[description]\n"
                    + "   ,[created_at]\n"
                    + "	  ,[updated_at]\n"
                    + "   ,[content]\n"
                    + "	  ,[status])\n"
                    + "VALUES( ? , ?, ?, ?, ?, 1)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setDate(3, new Date(System.currentTimeMillis()));
            ps.setDate(4, new Date(System.currentTimeMillis()));
            ps.setString(5, t.getContent());
            ps.execute();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Blog t) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "UPDATE [dbo].[Blog]\n"
                    + "SET [title] = ?,[description] = ?,[content] = ?\n"
                    + "WHERE id = ?\n";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setString(3, t.getContent());
            ps.setInt(4, t.getId());

            ps.execute();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateImage(Blog t) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
//            Timestamp ts = Timestamp.from(Instant.now());
            String sql = "UPDATE [dbo].[ImageBlog]\n"
                    + "              SET [image] = ?                   \n"
                    + "                 WHERE blogID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, t.getImage());

            ps.setInt(2, t.getId());
            ps.executeQuery();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean insertIntoImageBlog(Blog t) {
        DBContext dBContext = new DBContext();

        try {
            Connection connection = dBContext.getConnection();
//            Timestamp ts = Timestamp.from(Instant.now());
            String sql = "INSERT INTO ImageBlog(\n"
                    + "      [blogID]\n"
                    + "      ,[image]\n"
                    + "      ,[created_at]\n"
                    + "      ,[updated_at])\n"
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getId());
            ps.setString(2, t.getImage());
            ps.setDate(3, new Date(System.currentTimeMillis()));
            ps.setDate(4, new Date(System.currentTimeMillis()));

            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        DBContext dBContext = new DBContext();

        try {
            Connection connection = dBContext.getConnection();
//            Timestamp ts = Timestamp.from(Instant.now());
            String sql = "delete from ImageBlog where blogID = " + id;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int getIdByTitle(String title) {
        DBContext dBContext = new DBContext();
        try {
            String sql = "select id\n"
                    + "  from Blog \n"
                    + "  where title like N'" + title + "'";
            Connection connection = dBContext.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

}
