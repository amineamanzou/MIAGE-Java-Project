package com.hr.struts.plugin;

import com.hr.struts.model.EmployeeManagement;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;

import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.action.ActionServlet;

public class MysqlPlugin implements PlugIn {

    public static final String MODELE = "MODELE";
    private String filePath = null;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String f) {
        filePath = f;
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig applicationConfig)
            throws javax.servlet.ServletException {
        EmployeeManagement e = new EmployeeManagement();
        
        System.out.println("---->Le plug-in démarre<----");
        Properties properties = new Properties(); 

        try {
            FileInputStream fis
                    = new FileInputStream(getFilePath());

            properties.load(fis);
            e.setProperties(properties);
            ServletContext context = servlet.getServletContext();
            context.setAttribute(MODELE, e);

            Properties rProperties = (Properties) context.getAttribute(MODELE);
            System.err.println("---->Database " + rProperties.getProperty("database"));
            System.err.println("---->User " + rProperties.getProperty("user"));
            System.err.println("---->Password " + rProperties.getProperty("password"));
        } catch (FileNotFoundException fnfe) {
            throw new ServletException(fnfe.getMessage());
        } catch (IOException ioe) {
            throw new ServletException(ioe.getMessage());
        }
    }

    public void destroy() {
        System.out.println("---->Le plug-in s'arr�te<----");
    }
}
