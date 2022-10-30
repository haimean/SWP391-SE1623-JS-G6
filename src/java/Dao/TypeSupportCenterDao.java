/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.TypeSupportCenter;
import java.util.ArrayList;

/**
 *
 * @author PiPi
 */
public interface TypeSupportCenterDao extends BaseDAO<TypeSupportCenter> {

    ArrayList<TypeSupportCenter> searchQnaType(String seachValue, int index);

    int getTotalQnaType();

    int getTotalQnaTypeSearch(String seachValue);

    ArrayList<TypeSupportCenter> paginate(int index);
}
