/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Blog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface BlogDao extends BaseDAO<Blog> {
  public int getPageCount() throws Exception;

  public List<Blog> getAllBlogByConstrain(int index);

  public ArrayList<Blog> getTop3Blog();

  public void increaseView(int proId);
}
