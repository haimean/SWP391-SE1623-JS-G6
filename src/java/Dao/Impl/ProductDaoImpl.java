/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.DBContext;
import Dao.ProductDao;
import Model.Blog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Product;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 * @author MrTuan
 */
public class ProductDaoImpl implements ProductDao {

    Timestamp ts = Timestamp.from(Instant.now());

    @Override
    public Product get(int id) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "select * from Product where id = ?";
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
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        DBContext dBContext = new DBContext();
        List<Product> list = new ArrayList<>();

        try {
            Connection connection = dBContext.getConnection();
            String sql = "Select * from Product";
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
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    @Override
    public boolean insert(Product item) {
        DBContext dBContext = new DBContext();
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
            Connection connection = dBContext.getConnection();
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
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Product item) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            Timestamp ts = Timestamp.from(Instant.now());
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
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "DELETE FROM [dbo].[Product]\n WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Product> searchByName(String txtSearch) {
        DBContext dBContext = new DBContext();
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * from Product\n"
                + "where [name] like ? ";
        try {
            Connection connection = dBContext.getConnection();
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
                dBContext.closeConnection(connection, ps);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public int getPageCount(int CategoryID, long begin, long end, String name) {
        DBContext dBContext = new DBContext();
        int st = 0;
        String sql = "SELECT COUNT(*) FROM Product WHERE 1=1";
        sql = addCategoryID(sql, CategoryID);
        sql = addUnitPrice(sql, begin, end);
        sql = addSearchByName(sql, name);
        try {
            Connection connection = dBContext.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                st = (int) Math.ceil(rs.getInt(1) / 6.0);
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public List<Product> getAllProductByConstrain(int index, int order_by, int CategoryID, long begin, long end,
            String name) {
        DBContext dBContext = new DBContext();

        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product p WHERE 1=1";
        sql = addCategoryID(sql, CategoryID); // WHERE CategoryID=
        sql = addUnitPrice(sql, begin, end); // WHERE UnitsPrice BETWEEN
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
            Connection connection = dBContext.getConnection();
            PreparedStatement ps = connection.prepareStatement(sb.toString());
            ps.setInt(1, index * 6);
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
                        rs.getInt(9),
                        rs.getTimestamp(10),
                        rs.getTimestamp(11),
                        rs.getString(12));

                products.add(product);

            }
            dBContext.closeConnection(connection, ps);
        } catch (Exception e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

    @Override
    public List<Product> getTop7Products(int id, int categoryId) {
        DBContext dBContext = new DBContext();
        List<Product> products = new ArrayList<>();
        String sql = "select top 7 * from Product\n"
                + "where categoryID = ? and id <> ?";
        try {
            Connection connection = dBContext.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(2, id);
            ps.setInt(1, categoryId);
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
                products.add(p);
            }
            dBContext.closeConnection(connection, ps);
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Product> getNextTop45Products(int productExisted) {
        DBContext dBContext = new DBContext();
        final int RECORD_PER_PAGE = 45;
        ArrayList<Product> list = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select *\n"
                    + "from Product \n"
                    + "order by id\n"
                    + "offset ? rows fetch next ? rows only";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productExisted);
            ps.setInt(2, RECORD_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
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
                        rs.getString(12)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    @Override
    public List<Blog> getTop7Blogs(int productId) {
        DBContext dBContext = new DBContext();
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select m.blogId, b.title, b.[description],b.viewNumber, \n"
                    + "b.image,b.content\n"
                    + "from MapBlogAndProduct m\n"
                    + "inner join Blog b on b.id = m.blogId\n"
                    + "where m.productId = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                blogs.add(new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        return blogs;
    }

    @Override
    public List<Product> getNextTop45ProductsByCategoryId(int productExisted, int categoryId) {
        DBContext dBContext = new DBContext();
        final int RECORD_PER_PAGE = 45;
        ArrayList<Product> list = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select *\n"
                    + "from Product\n"
                    + "where categoryId = ? \n"
                    + "order by id\n"
                    + "offset ? rows fetch next ? rows only";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, categoryId);
            ps.setInt(2, productExisted);
            ps.setInt(3, RECORD_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
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
                        rs.getString(12)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    @Override
    public void updateProductViewNumber(int viewNumber, int id) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "UPDATE Product\n"
                    + "SET viewNumer = ?\n"
                    + "WHERE id = ?;";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, viewNumber);
            ps.setInt(2, id);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void increaseView(int proId) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "update Blog\n"
                    + "set viewNumber = viewNumber +1 \n"
                    + "where id = " + proId;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Product> getFavoriteProducts(int userId) {
        DBContext dBContext = new DBContext();
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection connection = dBContext.getConnection();
            String query = "select fp.productId, p.categoryID, p.[name], p.[description],\n"
                    + "p.origin, p.quantity, p.price, p.[status], p.viewNumer, p.proImg\n"
                    + "from FavoriteProduct fp\n"
                    + "inner join Product p on p.id = fp.productId\n"
                    + "where fp.userId = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getBoolean(8),
                        rs.getInt(9),
                        rs.getString(10)));
            }
            dBContext.closeConnection(connection, ps);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

    public static void main(String[] args) {
        List<Product> list = new ProductDaoImpl().getFavoriteProducts(5);
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

    @Override
    public boolean addFavorite(int userId, int productId) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String query = "insert into FavoriteProduct\n"
                    + "values(?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean removeFavoriteProducts(int userId, int productId) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "DELETE FROM FavoriteProduct WHERE ((userId = ?) and (productId = ?))";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean removeAllFavoriteProducts(int userId) {
        DBContext dBContext = new DBContext();
        try {
            Connection connection = dBContext.getConnection();
            String sql = "DELETE FROM FavoriteProduct WHERE userId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
            dBContext.closeConnection(connection, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
