/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.utils;

/**
 *
 * @author carine
 */
public class Factory {
    
    public static Object instantiates (String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c=Class.forName (className);
        return (c.newInstance());
        
    }
    
}
