package com.hr.struts.controller;

import com.hr.struts.model.EmployeeDAO;
import com.hr.struts.model.IEmployeeDAO;
import java.util.ArrayList;  
import static java.util.Collections.list;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
   
public final class EmployeeAction extends SuperAction {

  public ActionForward search(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionErrors errors = new ActionErrors();
        IEmployeeDAO employeeManagement = super.getEmployeeManagement();
        List results;

        DynaActionForm searchForm = (DynaActionForm) form;

        String name = searchForm.getString("firstName");
        String ssnum = searchForm.getString("ssNum");
        if (name != null && name.trim().length() > 0) {
            results = employeeManagement.searchByFirstName(name);
        } else if (ssnum != null && ssnum.trim().length() > 0) {
            try {
                results = (List) employeeManagement.searchBySsNum(ssnum);
            } catch (Exception e) {
                errors.add(null, new ActionMessage(e.getMessage()));
                results = new ArrayList();
            } finally {
                this.saveErrors(request, errors);
            }
        } else {
            errors.add(null, new ActionMessage("Veuillez remplir au moins un champs"));
            results = new ArrayList();
        }
        searchForm.getMap().clear();
        searchForm.set("results", results);

        return mapping.getInputForward();
    }
    
  public ActionForward show(ActionMapping mapping,
     					 ActionForm form,
    					HttpServletRequest request,
    					HttpServletResponse response) throws Exception
  {
    EmployeeDAO service = new EmployeeDAO();
    ArrayList results;
   
    DynaActionForm showForm = (DynaActionForm) form;
   
    // Perform the show all the employees function.
    results = service.findAll();
    
    // Cible par defaut
    String cible = new String("succes");

    // Cible en cas d'echec
    if (results == null ) {
      cible = new String("echec");
      ActionMessages errors = new ActionMessages();
      errors.add(null, new ActionMessage("error.show.employees.notfound"));
      // Signalement des erreurs a la page d'origine
      if (!errors.isEmpty()) {
        saveErrors(request, errors);
      }
    }

    // Transmission a la vue appropriee
    showForm.set("results", results);
    return (mapping.findForward(cible));
  }

public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
    IEmployeeDAO Emp = super.getEmployeeManagement();
    Boolean result;
   
    DynaActionForm searchForm = (DynaActionForm)form;
   
    // Perform employee search based on the criteria entered.
    Integer id = (Integer)searchForm.get("id");
    String firstName = (String)searchForm.get("firstName");
    String lastName = (String)searchForm.get("lastName");
    String ssNum = (String)searchForm.get("ssNum");
    String phone = (String)searchForm.get("phone");
    if (lastName != null && lastName.trim().length() > 0 &&
            firstName != null && lastName.trim().length() > 0 &&
                    ssNum != null && ssNum.trim().length() > 0)
            result = Emp.add(id, firstName, lastName, ssNum, phone);
    else
        result = false;
    
    // Forward control to this Action's input page.
    return mapping.getInputForward();
  }

public ActionForward delete(ActionMapping mapping,
     					 ActionForm form,
    					HttpServletRequest request,
    					HttpServletResponse response) throws Exception
  {
    IEmployeeDAO Emp = super.getEmployeeManagement();
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

public ActionForward update(ActionMapping mapping,
     					 ActionForm form,
    					HttpServletRequest request,
    					HttpServletResponse response) throws Exception
  {
    IEmployeeDAO Emp = super.getEmployeeManagement();
    Boolean result;
   
    DynaActionForm searchForm = (DynaActionForm)form;
   
    // Perform employee search based on the criteria entered.
    Integer id = (Integer)searchForm.get("id");
    String firstName = (String)searchForm.get("firstName");
    String lastName = (String)searchForm.get("lastName");
    String ssNum = (String)searchForm.get("ssNum");
    String phone = (String)searchForm.get("phone");
    if (lastName != null && lastName.trim().length() > 0 &&
            firstName != null && lastName.trim().length() > 0 &&
                    ssNum != null && ssNum.trim().length() > 0)
            result = Emp.update(id, firstName, lastName, ssNum, phone);
    else
        result = false;
    
    searchForm.set("results", result);
    // Forward control to this Action's input page.
    return mapping.getInputForward();
  }
} 
