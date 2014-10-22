package com.hr.struts.controller;

import com.hr.struts.model.EmployeeManagement;
import java.util.ArrayList;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
   
public final class EmployeeAddAction extends Action
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
    String name = (String)searchForm.get("name");
    String ssNum = (String)searchForm.get("ssnum");
    String phone = (String)searchForm.get("phone");
    result = Emp.add(name, ssNum, phone);
    
    searchForm.set("res", result);
    // Forward control to this Action's input page.
    return mapping.getInputForward();
  }
}