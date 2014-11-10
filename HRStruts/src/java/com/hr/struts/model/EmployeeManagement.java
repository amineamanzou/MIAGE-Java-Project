package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class EmployeeManagement implements IEmployeeManagement {

    private Properties properties = new Properties();

    /*private static volatile EmployeeManagement instance = null;*/

   /* 
    public final static EmployeeManagement getInstance() {
        if (EmployeeManagement.instance == null) {
            synchronized (EmployeeManagement.class) {
                if (EmployeeManagement.instance == null) {
                    EmployeeManagement.instance = new EmployeeManagement();
                }
            }
        }
        return EmployeeManagement.instance;
    } 
    */

    @Override
    public Connection getConnection(){
        
        try {
            Context initContext = new InitialContext();
            DataSource data = (DataSource) initContext.lookup(properties.getProperty("datasource"));
            return data.getConnection();

        } catch (NamingException | SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Search for employees by firstname.
    @Override
    public ArrayList searchByFirstName(String name){
        Connection cn = null;
        ArrayList resultat = new ArrayList();
        
        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM db_hr.EMPLOYEE WHERE firstName LIKE \'" + name + "\'");
            while (rs.next()) {
                Employee tmp = this.rowToEmployee(rs);
                resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection(cn);
        }
        
        return resultat;
    }

    // Search for employees by lastname.
    @Override
    public ArrayList searchByLastName(String name) {
        Connection cn = null;
        ArrayList resultat = new ArrayList();

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            String request = "SELECT * FROM db_hr.EMPLOYEE WHERE lastName LIKE \'" + name + "\'";
            ResultSet rs = state.executeQuery(request);
            System.out.println(request);
            System.out.println(rs);
            while (rs.next()) {
                Employee tmp = this.rowToEmployee(rs);
                resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection(cn);
        }
        
        return resultat;
    }

    // Search for employee by social security number.
    @Override
    public ArrayList searchBySsNum(String ssNum) {
        Connection cn = null;
        ArrayList resultat = new ArrayList();

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM db_hr.EMPLOYEE WHERE ssNum LIKE \'" + ssNum + "\'");
            while (rs.next()) {
                Employee tmp = this.rowToEmployee(rs);
                resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection(cn);
        }
        
        return resultat;
    }

    // Search for employee by phone number.
    @Override
    public ArrayList searchByPhone(String phone) {
         Connection cn = null;
        ArrayList resultat = new ArrayList();

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM db_hr.EMPLOYEE WHERE phone LIKE \'" + phone + "\'");
            while (rs.next()) {
                Employee tmp = this.rowToEmployee(rs);
                resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection(cn);
        }
        
        return resultat;
    }

    // Search for employee by mail adress.
    @Override
    public ArrayList searchByMail(String mail) {
        Connection cn = null;
        ArrayList resultat = new ArrayList();

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM db_hr.EMPLOYEE WHERE mail LIKE \'" + mail + "\'");
            while (rs.next()) {
                Employee tmp = this.rowToEmployee(rs);
                resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection(cn);
        }
        
        return resultat;
    }

    @Override
    public ArrayList findAll() {
        Connection cn = null;
        ArrayList resultat = new ArrayList();

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM "+properties.getProperty("databaseName")+".EMPLOYEE");
            while (rs.next()) {
                Employee tmp = this.rowToEmployee(rs);
                resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection(cn);
        }
        
        return resultat;    }

    @Override
    public boolean add(String firstName, String lastName, String ssNum, String phone, String gender, String mail, String hireDate, String salary) {
        Connection cn = null;
        Boolean resultat = null;

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            //à completer
            ResultSet rs = state.executeQuery("INSERT INTO `employee` (`id`, `ssNum`, `firstName`, `lastName`, `gender`, `phone`, `mail`, `hireDate`, `salary`, `department_id`) VALUES " +
                                                "(NULL, "+ ssNum + ", "+ firstName + ", "+ lastName + ", "+ gender + ", "+ phone + ", "+ mail + ", "+ hireDate + ", "+ salary + ", NULL);");
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection(cn);
        }
        
        return resultat;
    }

    @Override
    public boolean update(Integer id, String firstName, String lastName, String ssNum, String phone, String gender, String mail, String hireDate, String salary) {
        Connection cn = null;
        Boolean resultat = null;

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            //à completer
            ResultSet rs = state.executeQuery("INSERT INTO `employee` (`id`, `ssNum`, `firstName`, `lastName`, `gender`, `phone`, `mail`, `hireDate`, `salary`, `department_id`) VALUES " +
                                                "(NULL, "+ ssNum + ", "+ firstName + ", "+ lastName + ", "+ gender + ", "+ phone + ", "+ mail + ", "+ hireDate + ", "+ salary + ", NULL);");
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection(cn);
        }
        
        return resultat;
    }

    @Override
    public void setProperties(Properties p) {
        this.properties = p;
    }

    @Override
    public Boolean delete(Integer id) {
     Connection cn = null;
     Boolean resultat = null;
        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            ResultSet rs = state.executeQuery("DELETE FROM db_hr.EMPLOYEE WHERE ID LIKE \\'%\" + id + \"%\\'");
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection(cn);
        }
        
        return resultat;    
    }
    
    private void closeConnection(Connection cn){
        if(cn != null) {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Employee rowToEmployee(ResultSet rs) throws SQLException{
        Integer id = rs.getInt("id");
        String ssNum = rs.getString("ssNum");
        Employee e = new Employee(id, ssNum);
        e.setFirstName(rs.getString("firstName"));
        e.setLastName(rs.getString("lastName"));
        e.setMail(rs.getString("mail"));
        e.setPhone(rs.getString("phone"));
        e.setGender(rs.getString("gender"));
        e.setHiredate(rs.getString("hireDate"));
        e.setSalary(rs.getString("salary"));
        return e;
    }
}
