/*
 * GenericAction.java
 *
 * Created on 28 mars 2007, 13:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.myapp.struts.action;
import org.apache.struts.action.Action;
import com.myapp.model.Model;
import javax.servlet.ServletContext;
/**
 *
 * @author carine
 */
public class GenericAction extends Action {
    
    public static final String MODEL = "modelObject";
  
  public Model getModel () {
      
      ServletContext context = servlet.getServletContext();
      Model m=(Model) context.getAttribute(MODEL);
     return  m;
     
  }
    
}
