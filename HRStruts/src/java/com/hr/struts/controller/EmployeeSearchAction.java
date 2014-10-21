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
   
public final class EmployeeSearchAction extends Action
{
  public ActionForward execute(ActionMapping mapping,
     					 ActionForm form,
    					HttpServletRequest request,
    					HttpServletResponse response)
  throws Exception
  {
    EmployeeManagement service = new EmployeeManagement();
    ArrayList results;
   
    DynaActionForm searchForm = (DynaActionForm)form;
    
    // Perform employee search based on the criteria entered.
    String name = (String)searchForm.get("name");
    String ssNum = (String)searchForm.get("ssNum");
    if (name != null && name.trim().length() > 0) {
      results = service.searchByName(name);
    } else if( ssNum != null && ssNum.trim().length() > 0){
      results = service.searchBySsNum(ssNum.trim());
    } else {
      results = service.searchByPhone((String)searchForm.get("phone"));
    }
    
    searchForm.set("results", results);
    // Forward control to this Action's input page.
    return mapping.getInputForward();
  }
}
