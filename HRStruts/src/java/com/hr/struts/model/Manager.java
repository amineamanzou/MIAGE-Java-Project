/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public final class Manager {
 
    private static volatile Manager instance = null;
 
    /**
     * Constructor
     */
    private Manager() {
        super();
    }
 
    /**
     * Method that return the instance of the singleton
     * @return the instance of manager.
     * @throws javax.naming.NamingException
     */
    public final static Manager getInstance() throws NamingException {
        if (Manager.instance == null) {
           synchronized(Manager.class) {
             if (Manager.instance == null) {
               Manager.instance = new Manager();
             }
           }
        }
        return Manager.instance;
    }
 
    public void getConnection(){
        try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	}
	System.out.println("MySQL JDBC Driver Registered!");
        
        /* TODO */
        
    }
}
