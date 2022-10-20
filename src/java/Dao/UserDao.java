/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.User;
import java.util.ArrayList;

/**
 *
 * @author haimi
 */
public interface UserDao extends BaseDAO<User> {

    User login(String Email, String password);

    boolean updateUserStatusByID(int id, boolean status);

    boolean updateUserRoleByID(int id, int role);

    ArrayList<User> search(String seachValue);

}
