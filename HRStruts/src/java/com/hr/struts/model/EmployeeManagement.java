package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class EmployeeManagement
{
    /* Hard-coded sample data. Normally this would come from a real data source: database    */
    private static List<Employee> employees = new ArrayList<Employee>(Arrays.asList(
        new Employee(1,"Bob","Davidson", "123-45-6789", "01244324254", "male", "mail@test.com", "06/12/2006", "30023"),
        new Employee(2,"Mary","Williams", "987-65-4321", "01244324254", "male", "mail@test.com", "06/12/2006", "30023"),
        new Employee(3,"Jim","Smith", "111-11-1111", "01244324254", "male", "mail@test.com", "06/12/2006", "30023"),
        new Employee(4,"Beverly","Harris", "222-22-2222", "01244324254", "male", "mail@test.com", "06/12/2006", "30023"),
        new Employee(5,"Thomas","Frank", "333-33-3333", "01244324254", "male", "mail@test.com", "06/12/2006", "30023"),
        new Employee(6,"Jim","Davidson", "444-44-4444", "44444444444", "male", "mail@test.com", "06/12/2006", "30023")
    ));
   
    // Search for employees by firstname.
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
    public ArrayList searchByMail(String mail) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
            if (employee.getMail().equals(mail)) {
                resultList.add(employee);
            }
        }
        return resultList;
    }
    
        public Employee searchById(Integer id) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public boolean delete(Employee get) {
        employees.remove(get);
        return true;
    }

    public ArrayList findAll() {
        return (ArrayList) employees;
    }

    public boolean add(Integer id, String firstName, String lastName, String ssNum, String phone) {
        employees.add(new Employee(id, firstName, lastName, ssNum, phone, null, null, null, null));
        return true;
    }

    public boolean update(Integer id, String firstName, String lastName, String ssNum, String phone) {
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).getId().equals(id)){
                employees.get(i).setFirstName(firstName);
                employees.get(i).setLastName(lastName);
                employees.get(i).setSsNum(ssNum);
                employees.get(i).setPhone(phone);
            }
        }
        return true;
    }
}
