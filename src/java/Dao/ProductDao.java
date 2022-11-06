/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Product;
import java.util.List;

/**
 *
 * @author haimi
 */
public interface ProductDao extends BaseDAO<Product> {

    List<Product> getAllProductByConstrain(int index, int order_by, int CategoryID, long begin, long end, String name);

    int getPageCount(int CategoryID, long begin, long end, String name);

    List<Product> searchByName(String txtSearch);
}
