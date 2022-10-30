/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Cart;
import Model.User;

/**
 *
 * @author haimi
 */
public interface CartDao extends BaseDAO<Cart> {

    String getStatus();

    Boolean addOrder(User user, Cart cart);
}
