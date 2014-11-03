/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import java.util.ArrayList;

/**
 *
 * @author pierregaillard
 */
public interface IEmployeeDAO {
    
    // Search for employees by firstname.
    public ArrayList searchByFirstName(String name);
    
    // Search for employees by lastname.
    public ArrayList searchByLastName(String name);
   
    // Search for employee by social security number.
    public ArrayList searchBySsNum(String ssNum);
        
    // Search for employee by phone number.
    public ArrayList searchByPhone(String phone);
    
    // Search for employee by mail adress.
    public ArrayList searchByMail(String mail);
    
    public Employee searchById(Integer id);

    public boolean delete(Employee get);

    public ArrayList findAll();
    
    public boolean add(Integer id, String firstName, String lastName, String ssNum, String phone);

    public boolean update(Integer id, String firstName, String lastName, String ssNum, String phone);

}
