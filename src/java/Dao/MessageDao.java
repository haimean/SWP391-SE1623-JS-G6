/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Message;
import java.util.ArrayList;

/**
 *
 * @author haimi
 */
public interface MessageDao extends BaseDAO<Message> {
ArrayList<Message> getAll(int id);
ArrayList<Message> get(int userid, int userReceiverId);
ArrayList<Message> getAll(int id, String search);
}
