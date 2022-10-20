/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Category;
import java.util.List;

/**
 *
 * @author haimi
 */
public interface CatergoryDao extends BaseDAO<Category> {

    List<Category> search(String name);
}
