package com.myapp.struts.plugIn;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;

import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.action.ActionServlet;
import com.myapp.model.Model;
import com.myapp.utils.Factory;

public class Plugin implements PlugIn {

  public static final String MODEL = "modelObject";
  private String modelClassName=null;
  
  public String getModelClassName () {
     return modelClassName;
 }
 public void setModelClassName (String f){
     modelClassName=f;
 }
 
 
  @Override
  public void init(ActionServlet servlet, ModuleConfig applicationConfig)
    throws javax.servlet.ServletException {

    System.out.println("---->Le plug-in demarre<----");
    
    try {

      Model m=(Model)Factory.instantiates(getModelClassName());

      ServletContext context = servlet.getServletContext();
      context.setAttribute(MODEL, m);

      
    }
    catch (ClassNotFoundException | InstantiationException | IllegalAccessException fnfe) {

      throw new ServletException(fnfe.getMessage());
    }
    
  }

  @Override
  public void destroy() {

    System.out.println("---->Le plug-in s'arrete<----");
  }
}
