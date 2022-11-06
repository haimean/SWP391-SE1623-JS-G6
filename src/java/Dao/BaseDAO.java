/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface BaseDAO<T> {

    T get(int id);

    List<T> getAll();

    boolean insert(T t);

    boolean update(T t);

    boolean delete(int id);

}
