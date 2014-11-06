/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.controller;

import com.hr.struts.model.EmployeeManagement;
import com.hr.struts.model.IEmployeeManagement;
import com.hr.struts.model.Manager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import org.apache.struts.actions.MappingDispatchAction;

/**
 *
 * @author pierregaillard
 */
public class SuperAction extends MappingDispatchAction {
        
    public Manager getManager(){
        try {
            return Manager.getInstance();
        } catch (NamingException ex) {
            Logger.getLogger(SuperAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public IEmployeeManagement getEmployeeManagement(){
        return EmployeeManagement.getInstance();
    }
    
}