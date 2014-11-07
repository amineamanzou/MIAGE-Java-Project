/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.controller;

import com.hr.struts.model.IEmployeeManagement;
import org.apache.struts.actions.MappingDispatchAction;

/**
 *
 * @author pierregaillard
 */
public class SuperAction extends MappingDispatchAction {
    
    public IEmployeeManagement getEmployeeManagement(){
        return (IEmployeeManagement)this.getServlet().getServletContext().getAttribute("modelEmployee");
    }
    
    
    
}