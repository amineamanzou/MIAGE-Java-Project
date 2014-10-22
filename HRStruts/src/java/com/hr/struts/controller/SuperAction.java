/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.controller;

import com.hr.struts.model.Manager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author pierregaillard
 */
public class SuperAction extends Action {
    
    private final Manager manager;
    
    public SuperAction(){
        this.manager = Manager.getInstance();
    }
    
}