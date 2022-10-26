/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Impl;

import Dao.DBContext;
import Dao.OrderDAO;
import Model.Order;
import Model.OrderDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author ngolu
 */
public class OrderDaoimpl implements OrderDAO {

    DBContext dBContext = new DBContext();
    Connection connection = dBContext.getConnection();

    @Override
    public List<Order> search(String userName) {
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
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getString(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getInt(6));
                list.add(o);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

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
            System.out.println(ex);
        }
        return list;
    }

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
            System.out.println(ex);
        }
        return null;
    }

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
            System.out.println(ex);
        }
        return null;
    }
}
