package com.hr.struts.plugin;

import com.hr.struts.model.Factory;
import com.hr.struts.model.IEmployeeManagement;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;

import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.action.ActionServlet;

public class MysqlPlugin implements PlugIn {

    private String filePath = null;
    private String modelEmployee;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String f) {
        filePath = f;
    }

    public String getModelEmployee() {
        return modelEmployee;
    }

    public void setModelEmployee(String modelEmployee) {
        this.modelEmployee = modelEmployee;
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig applicationConfig)
            throws javax.servlet.ServletException {

        System.out.println("---->Le plug-in démarre<----");
        Properties properties = new Properties();

        try {
            //Cherche le fichier en dynamique
            Factory f = new Factory();
            IEmployeeManagement employeeModel = (IEmployeeManagement) f.instantiate(modelEmployee);
            InputStream fis = servlet.getServletContext().getResourceAsStream(getFilePath());

            properties.load(fis);
            employeeModel.setProperties(properties);
            servlet.getServletContext().setAttribute("modelEmployee", employeeModel);

        } catch (FileNotFoundException fnfe) {
            throw new ServletException(fnfe.getMessage());
        } catch (IOException ioe) {
            throw new ServletException(ioe.getMessage());
        }
    }

    public void destroy() {
        System.out.println("---->Le plug-in s'arrete<----");
    }
}
