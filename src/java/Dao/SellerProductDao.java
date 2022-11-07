/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Product;
import java.util.List;

/**
 *
 * @author ngolu
 */
public interface SellerProductDao {
    public List<Product> getProduct();
    
    public List<Product> searchByName(String txtSearch);
    
    public int getTotalProduct();
    
    public List<Product> getProduct(int page);
    
    public boolean insert(Product item);
    
    public boolean update(Product item);
     
    public boolean delete(int id);
    
    public Product get(int id);
}
