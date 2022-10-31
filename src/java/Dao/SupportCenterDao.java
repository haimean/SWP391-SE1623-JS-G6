/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.SupportCenter;
import java.util.ArrayList;

/**
 *
 * @author PiPi
 */
public interface SupportCenterDao extends BaseDAO<SupportCenter> {

    ArrayList<SupportCenter> searchQna(String seachValue, int index);

    int getTotalQna();

    int getTotalQnaSearch(String seachValue);

    ArrayList<SupportCenter> paginate(int index);
}
