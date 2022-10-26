/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Order;
import Model.OrderDetail;
import java.util.List;

/**
 *
 * @author ngolu
 */
public interface OrderDAO {
    
    public List<Order> search(String userName);
    
    public List<Order> getOrder();
     
    public Order getOrderById(String id);
    
    public OrderDetail getOrderDetailById(String id);
     
    
}
