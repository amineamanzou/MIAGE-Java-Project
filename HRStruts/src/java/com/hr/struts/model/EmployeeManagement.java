package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import com.hr.struts.plugin.MysqlPlugin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.struts.action.ActionServlet;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class EmployeeManagement implements IEmployeeManagement
{
    private static volatile EmployeeManagement instance = null;
    /* Hard-coded sample data. Normally this would come from a real data source: database    */
    private static List<Employee> employees = new ArrayList<>(Arrays.asList(
        new Employee(1,"Bob","Davidson", "123-45-6789", "01244324254", "male", "mail@test.com", "06/12/2006", "30023"),
        new Employee(2,"Mary","Williams", "987-65-4321", "01244324254", "male", "mail@test.com", "06/12/2006", "30023"),
        new Employee(3,"Jim","Smith", "111-11-1111", "01244324254", "male", "mail@test.com", "06/12/2006", "30023"),
        new Employee(4,"Beverly","Harris", "222-22-2222", "01244324254", "male", "mail@test.com", "06/12/2006", "30023"),
        new Employee(5,"Thomas","Frank", "333-33-3333", "01244324254", "male", "mail@test.com", "06/12/2006", "30023"),
        new Employee(6,"Jim","Davidson", "444-44-4444", "44444444444", "male", "mail@test.com", "06/12/2006", "30023")
    ));
    
    public final static EmployeeManagement getInstance() {
        if (EmployeeManagement.instance == null) {
           synchronized(EmployeeManagement.class) {
             if (EmployeeManagement.instance == null) {
               EmployeeManagement.instance = new EmployeeManagement();
             }
           }
        }
        return EmployeeManagement.instance;
    }
       
    @Override
    public Connection getConnection(ActionServlet servlet){
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Properties bddProperties = (Properties) servlet.getServletContext().getAttribute(MysqlPlugin.PROPERTIES);
            String bdd = bddProperties.getProperty("database");
            String user = bddProperties.getProperty("user");
            String pwd = bddProperties.getProperty("password");
            Connection cn = DriverManager.getConnection(bdd, user, pwd);
            Statement selectAllState = cn.createStatement();
            ResultSet result = selectAllState.executeQuery("SELECT * FROM employee");
            while (result.next()) {
                String nom = result.getString("last_name");
                System.out.println(nom);
            }
            return cn;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    // Search for employees by firstname.
    @Override
    public ArrayList searchByFirstName(String name) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
           if (employee.getFirstName().toUpperCase().contains(name.toUpperCase())) {
                resultList.add(employee);
           }
        }
        return resultList;
    }
    
    // Search for employees by lastname.
    @Override
    public ArrayList searchByLastName(String name) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
           if (employee.getLastName().toUpperCase().contains(name.toUpperCase())) {
                resultList.add(employee);
           }
        }
        return resultList;
    }
   
    // Search for employee by social security number.
    @Override
    public ArrayList searchBySsNum(String ssNum) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
            if (employee.getSsNum().equals(ssNum)) {
                resultList.add(employee);
            }
        }
        return resultList;
    }
        
    // Search for employee by phone number.
    @Override
    public ArrayList searchByPhone(String phone) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
            if (employee.getPhone().equals(phone)) {
                resultList.add(employee);
            }
        }
        return resultList;
    }
    
    
    // Search for employee by mail adress.
    @Override
    public ArrayList searchByMail(String mail) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
            if (employee.getMail().equals(mail)) {
                resultList.add(employee);
            }
        }
        return resultList;
    }
    
    @Override
    public Employee searchById(Integer id) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Employee get) {
        employees.remove(get);
        return true;
    }

    @Override
    public ArrayList findAll() {
        return (ArrayList) employees;
    }

    @Override
    public boolean add(Integer id, String firstName, String lastName, String ssNum, String phone) {
        employees.add(new Employee(id, firstName, lastName, ssNum, phone, null, null, null, null));
        return true;
    }

    @Override
    public boolean update(Integer id, String firstName, String lastName, String ssNum, String phone) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setSsNum(ssNum);
                employee.setPhone(phone);
            }
        }
        return true;
    }
}
