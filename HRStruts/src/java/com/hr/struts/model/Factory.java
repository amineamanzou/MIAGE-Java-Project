/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.model;

/**
 *
 * @author pierregaillard
 */
public class Factory {

    public static Object instantiate (String NomModelClass){ 
        try {
            Class cls = Class.forName(NomModelClass);
            Object obj = cls.newInstance();
		  return obj;
        }
        catch(Exception e){
            return null;
        }
    }   
}
