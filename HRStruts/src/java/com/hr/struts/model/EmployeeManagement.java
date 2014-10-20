package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
   
public class EmployeeManagement
{
  /* Hard-coded sample data. Normally this would come from a real data source: database    */
private static List<Employee> employees = new ArrayList<Employee>(Arrays.asList(
    new Employee("Bob Davidson", "123-45-6789", "01244324254"),
    new Employee("Mary Williams", "987-65-4321", "01244324254"),
    new Employee("Jim Smith", "111-11-1111", "01244324254"),
    new Employee("Beverly Harris", "222-22-2222", "01244324254"),
    new Employee("Thomas Frank", "333-33-3333", "01244324254"),
    new Employee("Jim Davidson", "444-44-4444", "44444444444")
  ));
   
  // Search for employees by name.
	public ArrayList searchByName(String name) {
		ArrayList resultList = new ArrayList();
		for (Employee employee : employees) {
		   if (employee.getName().toUpperCase().indexOf(name.toUpperCase()) != -1) {
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

	public boolean delete(Employee get) {
		employees.remove(get);
		return true;
	}

	public ArrayList findAll() {
		return (ArrayList) employees;
	}

	public boolean add(String name, String ssNum, String phone) {
		employees.add(new Employee(name, ssNum, phone));
		return true;
	}

	public boolean update(Employee e, String name, String ssNum, String phone) {
		for(int i = 0; i < employees.size(); i++){
			if(employees.get(i).equals(e)){
				employees.get(i).setName(name);
				employees.get(i).setSsNum(ssNum);
                                employees.get(i).setPhone(phone);
			}
		}
		return true;
	}
}
