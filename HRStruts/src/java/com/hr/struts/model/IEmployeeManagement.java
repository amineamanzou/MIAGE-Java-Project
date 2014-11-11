/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author pierregaillard
 */
public interface IEmployeeManagement {
    
    public void setProperties (Properties p);
    
    public Connection getConnection();
    
    // Search for employees by firstname.
    public ArrayList findBy(String column, String arg);
    
    public ArrayList findAll();
    
    public boolean add(String firstName, String lastName, String ssNum, String phone, String gender, String mail, String hireDate, String salary);

    public boolean update(Integer id, String firstName, String lastName, String ssNum, String phone, String gender, String mail, String hireDate, String salary);

    public Boolean delete(Integer id);

}
