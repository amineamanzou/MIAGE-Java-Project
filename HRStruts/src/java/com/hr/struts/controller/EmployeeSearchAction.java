package com.hr.struts.controller;

import com.hr.struts.model.EmployeeManagement;
import java.util.ArrayList;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
//Obsolète (TP 5.1 & 5.2)

public final class EmployeeSearchAction extends SuperAction
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
    String firstName = (String)searchForm.get("firstName");
    String lastName = (String)searchForm.get("lastName");

    String ssNum = (String)searchForm.get("ssNum");
    if (firstName != null && firstName.trim().length() > 0) {
      results = service.searchByFirstName(firstName);
    } else if (lastName != null && lastName.trim().length() > 0) {
      results = service.searchByLastName(lastName);
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
