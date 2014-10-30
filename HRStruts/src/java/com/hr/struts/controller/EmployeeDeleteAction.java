package com.hr.struts.controller;

import com.hr.struts.model.EmployeeManagement;
import com.hr.struts.model.entities.Employee;
import java.sql.SQLException;
import java.util.ArrayList;  
import javax.sql.DataSource;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
   
public final class EmployeeDeleteAction extends SuperAction
{
  @Override
  public ActionForward execute(ActionMapping mapping,
     					 ActionForm form,
    					HttpServletRequest request,
    					HttpServletResponse response)
  throws Exception
  {
    EmployeeManagement Emp = new EmployeeManagement();
    Boolean result;
    
    DynaActionForm searchForm = (DynaActionForm)form;
   
    // Perform employee search based on the criteria entered.
    Integer id = (Integer)searchForm.get("id");
    if (id != null)
        result = Emp.delete(Emp.searchById(id));
    else
        result = false;
    
    searchForm.set("results", result);
    // Forward control to this Action's input page.
    return mapping.getInputForward();
  }
}