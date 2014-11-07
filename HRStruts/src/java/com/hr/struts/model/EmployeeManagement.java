package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class EmployeeManagement implements IEmployeeManagement {

    Properties properties = new Properties();

    private static volatile EmployeeManagement instance = null;

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

    @Override
    public Connection getConnection() throws SQLException {

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        String bdd = properties.getProperty("database");
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");
        Connection cn = DriverManager.getConnection(bdd, user, pwd);
        return cn;

    }

    // Search for employees by firstname.
    @Override
    public ArrayList searchByFirstName(String name) throws SQLException{
        Connection cn = null;
        ArrayList resultat = new ArrayList();

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYES WHERE name LIKE \\'%\" + name + \"%\\'");
            while (rs.next()) {
                String firstName = rs.getString("name");
                String ssNum = rs.getString("ssNum");
                String phone = rs.getString("phone");
                Employee tmp = new Employee(firstName,ssNum,phone);
           resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cn != null) {
                cn.close();
            }
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
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYES WHERE LASTNAME LIKE \\'%\" + name + \"%\\'");
            while (rs.next()) {
                String firstName = rs.getString("name");
                String ssNum = rs.getString("ssNum");
                String phone = rs.getString("phone");
                Employee tmp = new Employee(firstName,ssNum,phone);
           resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYES WHERE SSNUM LIKE \\'%\" + ssNum + \"%\\'");
            while (rs.next()) {
                String firstName = rs.getString("name");
                String sNum = rs.getString("ssNum");
                String phone = rs.getString("phone");
                Employee tmp = new Employee(firstName,sNum,phone);
           resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYES WHERE PHONE LIKE \\'%\" + phone + \"%\\'");
            while (rs.next()) {
                String firstName = rs.getString("name");
                String ssNum = rs.getString("ssNum");
                String tel = rs.getString("phone");
                Employee tmp = new Employee(firstName,ssNum,tel);
           resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYES WHERE MAIL LIKE \\'%\" + mail + \"%\\'");
            while (rs.next()) {
                String firstName = rs.getString("name");
                String ssNum = rs.getString("ssNum");
                String phone = rs.getString("phone");
                Employee tmp = new Employee(firstName,ssNum,phone);
           resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYES");
            while (rs.next()) {
                String firstName = rs.getString("name");
                String ssNum = rs.getString("ssNum");
                String phone = rs.getString("phone");
                Employee tmp = new Employee(firstName,ssNum,phone);
           resultat.add(tmp);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return resultat;    }

    @Override
    public boolean add(Integer id, String firstName, String lastName, String ssNum, String phone) {
         Connection cn = null;
         Boolean resultat = null;

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            //à completer
            ResultSet rs = state.executeQuery("INSERT INTO EMPLOYES VALUES (\\'%\" + name + \"%\\')");
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return resultat;
    }

    @Override
    public boolean update(Integer id, String firstName, String lastName, String ssNum, String phone) {
                Connection cn = null;
         Boolean resultat = null;

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            //à completer
            ResultSet rs = state.executeQuery("INSERT INTO EMPLOYES VALUES (\\'%\" + name + \"%\\')");
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
            ResultSet rs = state.executeQuery("DELETE FROM EMPLOYES WHERE ID LIKE \\'%\" + id + \"%\\'");
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return resultat;    }
}
