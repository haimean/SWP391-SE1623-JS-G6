/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Blog;
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

    List<Product> getTop7Products(int id, int categoryId);

    List<Product> getNextTop45Products(int productExisted);

    List<Product> getNextTop45ProductsByCategoryId(int productExisted, int categoryId);

    List<Blog> getTop7Blogs(int productId);

    void updateProductViewNumber(int viewNumber, int id);
    
    boolean addFavorite(int userId, int productId);
    
    List<Product> getFavoriteProducts(int userId);
    
    boolean removeFavoriteProducts(int userId, int productId);
    
    boolean removeAllFavoriteProducts(int userId);

}
