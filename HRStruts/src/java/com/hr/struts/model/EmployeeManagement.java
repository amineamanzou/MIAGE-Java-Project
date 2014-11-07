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

    private Properties properties = new Properties();

    private static volatile EmployeeManagement instance = null;

   /* public final static EmployeeManagement getInstance() {
        if (EmployeeManagement.instance == null) {
            synchronized (EmployeeManagement.class) {
                if (EmployeeManagement.instance == null) {
                    EmployeeManagement.instance = new EmployeeManagement();
                }
            }
        }
        return EmployeeManagement.instance;
    } */

    @Override
    public Connection getConnection(){

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        String bdd = properties.getProperty("database");
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(bdd, user, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;

    }

    // Search for employees by firstname.
    @Override
    public ArrayList searchByFirstName(String name){
        Connection cn = null;
        ArrayList resultat = new ArrayList();

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYEE WHERE first_name LIKE \\'%\" + name + \"%\\'");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String ssNum = rs.getString("ssNum");
                Employee tmp = new Employee(id, ssNum);
                tmp.setFirstName(rs.getString("firstName"));
                tmp.setLastName(rs.getString("lastName"));
                tmp.setMail(rs.getString("mail"));
                tmp.setPhone(rs.getString("phone"));
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

    // Search for employees by lastname.
    @Override
    public ArrayList searchByLastName(String name) {
         Connection cn = null;
        ArrayList resultat = new ArrayList();

        try {
            cn = this.getConnection();
            Statement state = cn.createStatement();
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYEE WHERE first_name LIKE \\'%\" + name + \"%\\'");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String ssNum = rs.getString("ssNum");
                Employee tmp = new Employee(id, ssNum);
                tmp.setFirstName(rs.getString("firstName"));
                tmp.setLastName(rs.getString("lastName"));
                tmp.setMail(rs.getString("mail"));
                tmp.setPhone(rs.getString("phone"));
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
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYEE WHERE SSNUM LIKE \\'%\" + ssNum + \"%\\'");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Employee tmp = new Employee(id, rs.getString("ssNum"));
                tmp.setFirstName(rs.getString("firstName"));
                tmp.setLastName(rs.getString("lastName"));
                tmp.setMail(rs.getString("mail"));
                tmp.setPhone(rs.getString("phone"));
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
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYEE WHERE PHONE LIKE \\'%\" + phone + \"%\\'");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String ssNum = rs.getString("ssNum");
                Employee tmp = new Employee(id, ssNum);
                tmp.setFirstName(rs.getString("firstName"));
                tmp.setLastName(rs.getString("lastName"));
                tmp.setMail(rs.getString("mail"));
                tmp.setPhone(rs.getString("phone"));
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
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYEE WHERE MAIL LIKE \\'%\" + mail + \"%\\'");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String ssNum = rs.getString("ssNum");
                Employee tmp = new Employee(id, ssNum);
                tmp.setFirstName(rs.getString("firstName"));
                tmp.setLastName(rs.getString("lastName"));
                tmp.setMail(rs.getString("mail"));
                tmp.setPhone(rs.getString("phone"));
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
            ResultSet rs = state.executeQuery("SELECT DISTINCT * FROM EMPLOYEE");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String ssNum = rs.getString("ssNum");
                Employee tmp = new Employee(id, ssNum);
                tmp.setFirstName(rs.getString("firstName"));
                tmp.setLastName(rs.getString("lastName"));
                tmp.setMail(rs.getString("mail"));
                tmp.setPhone(rs.getString("phone"));
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
            ResultSet rs = state.executeQuery("INSERT INTO EMPLOYEE VALUES (\\'%\" + name + \"%\\')");
          
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
            ResultSet rs = state.executeQuery("INSERT INTO EMPLOYEE VALUES (\\'%\" + name + \"%\\')");
          
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
            ResultSet rs = state.executeQuery("DELETE FROM EMPLOYEE WHERE ID LIKE \\'%\" + id + \"%\\'");
          
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
