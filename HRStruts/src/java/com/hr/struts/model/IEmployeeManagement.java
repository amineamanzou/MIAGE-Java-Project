/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.struts.action.ActionServlet;

/**
 *
 * @author pierregaillard
 */
public interface IEmployeeManagement {
    
    public void setProperties (Properties p);
    
    public Connection getConnection() throws SQLException;
    
    // Search for employees by firstname.
    public ArrayList searchByFirstName(String name) throws SQLException;
    
    // Search for employees by lastname.
    public ArrayList searchByLastName(String name);
   
    // Search for employee by social security number.
    public ArrayList searchBySsNum(String ssNum);
        
    // Search for employee by phone number.
    public ArrayList searchByPhone(String phone);
    
    // Search for employee by mail adress.
    public ArrayList searchByMail(String mail);
    
    public ArrayList findAll();
    
    public boolean add(Integer id, String firstName, String lastName, String ssNum, String phone);

    public boolean update(Integer id, String firstName, String lastName, String ssNum, String phone);

    public Boolean delete(Integer id);

}
