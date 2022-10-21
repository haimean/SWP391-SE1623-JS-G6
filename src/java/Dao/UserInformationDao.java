/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.UserInformation;

/**
 *
 * @author MrTuan
 */
public interface UserInformationDao extends BaseDAO<UserInformation>{

    @Override
    UserInformation get(int id);

    @Override
    boolean update(UserInformation t);
    
}
