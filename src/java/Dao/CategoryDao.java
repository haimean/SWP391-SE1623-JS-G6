/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Category;
import java.util.ArrayList;

/**
 *
 * @author haimi
 */
public interface CategoryDao extends BaseDAO<Category> {

    public ArrayList<Category> search(String name);

    @Override
    public Category get(int id);

    @Override
    public ArrayList<Category> getAll();

    @Override
    public boolean insert(Category category);
    
    @Override
    public boolean update(Category category);
    
    @Override
    public boolean delete(int id);
    
    public int getTotalCategory();
    
    public ArrayList<Category> getAll(int page);
}
