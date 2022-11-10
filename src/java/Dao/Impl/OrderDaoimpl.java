/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.DBContext;
import Dao.OrderDao;
import Model.Order;
import Model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngolu
 */
public class OrderDaoimpl implements OrderDao {

    DBContext db = new DBContext();
    Connection connection = db.getConnection();

    // get all Order 
    @Override
    public List<Order> getOrder() {
        List<Order> list = new ArrayList<>();
        String sql = "select [order].id, [UserInformation].fullname,[UserInformation].phone, [user].email ,\n"
                + "(select sum( price * quantity) from  OrderDetail where [order].id = OrderDetail.orderId) as price,\n"
                + "[order].status\n"
                + "from  [order],UserInformation ,[User]\n"
                + "where [order].userId = UserInformation.userId\n"
                + "and  [order].userId = [user].id";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getString(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getInt(6));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // get order by id
    @Override
    public Order getOrderById(String id) {
        String sql = "select [order].id, [UserInformation].fullname,[UserInformation].phone, [user].email ,\n"
                + "(select sum( price * quantity) from  OrderDetail where [order].id = OrderDetail.orderId) as price,\n"
                + "[order].status\n"
                + "from  [order],UserInformation ,[User]\n"
                + "where [order].userId = UserInformation.userId\n"
                + "and  [order].userId = [user].id\n"
                + "and [order].id = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //get order detail by id 
    @Override
    public OrderDetail getOrderDetailById(String id) {
        String sql = "Select [Order].id,[Product].name ,\n"
                + "[OrderDetail].quantity , [Product].price,\n"
                + "(select sum( price * quantity) from  OrderDetail\n"
                + "where [order].id = OrderDetail.orderId) as Totalprice\n"
                + "from [Product] , [OrderDetail] ,[Order]\n"
                + "where [Product].id = [OrderDetail].productID \n"
                + "and [Order].id = [OrderDetail].orderId and [Order].id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new OrderDetail(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getDouble(4), rs.getDouble(5));

            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // search by full name 
    @Override
    public List<Order> searchByFullName(String txtFullName) {
        String sql = "select [order].id, [UserInformation].fullname,\n"
                + "[UserInformation].phone, [user].email ,\n"
                + "(select sum( price * quantity) from  OrderDetail\n"
                + "where [order].id = OrderDetail.orderId) as price,[order].status\n"
                + "from  [order],UserInformation ,[User]\n"
                + "where [order].userId = UserInformation.userId\n"
                + "and  [order].userId = [user].id\n"
                + "and [UserInformation].fullname = ?";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, txtFullName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getString(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getInt(6));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    // get total order
    @Override
    public int getTotalOrder() {
        String sql = "select count(*)\n"
                + "from  [order],UserInformation ,[User]\n"
                + "where [order].userId = UserInformation.userId\n"
                + "and  [order].userId = [user].id ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    // paging order
    @Override
    public List<Order> getOrder(int page) {
        String sql = "select [order].id, [UserInformation].fullname,[UserInformation].phone, [user].email ,\n"
                + "(select sum( price * quantity) from  OrderDetail where [order].id = OrderDetail.orderId) as price,\n"
                + "[order].status\n"
                + "from  [order],UserInformation ,[User]\n"
                + "where [order].userId = UserInformation.userId\n"
                + "and  [order].userId = [user].id\n"
                + "order by [order].id\n"
                + "offset ?  rows fetch next 5 rows only";
        List <Order> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (page-1)*5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Order o = new Order(rs.getString(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getInt(6));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

}
