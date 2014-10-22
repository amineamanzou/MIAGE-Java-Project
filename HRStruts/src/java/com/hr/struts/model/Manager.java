/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public final class Manager {
 
    private static volatile Manager instance = null;

    private String host = "localhost:3306";
    private String database = "employees";
    private String user = "root";
    private String passwd = "root";
 
    /**
     * Constructor
     */
    private Manager() {
        super();
    }
 
    /**
     * Method that return the instance of the singleton
     * @return the instance of manager.
     */
    public final static Manager getInstance() {
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
	Connection connection = null;
 
	try {
		connection = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.database, this.user, this.passwd);
 
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}
 
	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
    }
    
}
