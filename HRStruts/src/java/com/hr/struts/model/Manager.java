/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.model;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public final class Manager {
 
    private static volatile Manager instance = null;

    private String host;
    private String user;
    private String passwd;
 
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
 
}
