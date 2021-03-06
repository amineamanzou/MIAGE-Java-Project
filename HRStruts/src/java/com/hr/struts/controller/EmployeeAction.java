package com.hr.struts.controller;

import com.hr.struts.model.IEmployeeManagement;
import java.util.ArrayList;  
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
        IEmployeeManagement employeeManagement = super.getEmployeeManagement();
        List results;

        DynaActionForm searchForm = (DynaActionForm) form;

        String firstName = searchForm.getString("firstName");
        String ssNum = searchForm.getString("ssNum");
        String lastName = searchForm.getString("lastName");
        String phone = searchForm.getString("phone");
        String mail = searchForm.getString("mail");
        try {
            if (firstName != null && firstName.trim().length() > 0) {
                results = employeeManagement.findBy("firstName",firstName);
            } 
            else if (lastName != null && lastName.trim().length() > 0) {
                results = employeeManagement.findBy("lastName",lastName);
            }
            else if (ssNum != null && ssNum.trim().length() > 0) {
                results = (List) employeeManagement.findBy("ssNum",ssNum);
            }
            else if (phone != null && phone.trim().length() > 0){
                results = (List) employeeManagement.findBy("phone",phone);
            }
            else if (mail != null && mail.trim().length() > 0){
                results = (List) employeeManagement.findBy("mail",mail);
            }
            else {
                errors.add(null, new ActionMessage("Veuillez remplir au moins un champs"));
                results = new ArrayList();
            }
        } catch (Exception e) {
                errors.add(null, new ActionMessage(e.getMessage()));
                results = new ArrayList();
        } finally {
            this.saveErrors(request, errors);
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
    IEmployeeManagement employeeManagement = super.getEmployeeManagement();
    ArrayList results;
   
    DynaActionForm showForm = (DynaActionForm) form;
   
    // Perform the show all the employees function.
    results = employeeManagement.findAll();
    
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
    IEmployeeManagement Emp = super.getEmployeeManagement();
    Boolean result;
   
    DynaActionForm searchForm = (DynaActionForm)form;
   
    // Perform employee search based on the criteria entered.
    String firstName = (String)searchForm.get("firstName");
    String lastName = (String)searchForm.get("lastName");
    String ssNum = (String)searchForm.get("ssNum");
    String phone = (String)searchForm.get("phone");
    String gender = (String)searchForm.get("gender");
    String hireDate = (String)searchForm.get("hireDate");
    String mail = (String)searchForm.get("mail");
    String salary = (String)searchForm.get("salary");
    if (lastName != null && lastName.trim().length() > 0 &&
            firstName != null && lastName.trim().length() > 0 &&
                    ssNum != null && ssNum.trim().length() > 0)
            result = Emp.add(firstName, lastName, ssNum, phone, gender, mail, hireDate, salary);
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
    IEmployeeManagement Emp = super.getEmployeeManagement();
    Boolean result;
    
    DynaActionForm searchForm = (DynaActionForm)form;
   
    // Perform employee search based on the criteria entered.
    Integer id = (Integer)searchForm.get("id");
    if (id != null)
        result = Emp.delete(id);
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
    IEmployeeManagement Emp = super.getEmployeeManagement();
    Boolean result;
   
    DynaActionForm searchForm = (DynaActionForm)form;
   
    // Perform employee search based on the criteria entered.
    Integer id = 1;
    String firstName = (String)searchForm.get("firstName");
    String lastName = (String)searchForm.get("lastName");
    String ssNum = (String)searchForm.get("ssNum");
    String phone = (String)searchForm.get("phone");
    String gender = (String)searchForm.get("gender");
    String hireDate = (String)searchForm.get("hireDate");
    String mail = (String)searchForm.get("mail");
    String salary = (String)searchForm.get("salary");
    if (lastName != null && lastName.trim().length() > 0 &&
            firstName != null && lastName.trim().length() > 0 &&
                    ssNum != null && ssNum.trim().length() > 0)
            result = Emp.update(id, firstName, lastName, ssNum, phone, gender, mail, hireDate, salary);
    else
        result = false;
    
    searchForm.set("results", result);
    // Forward control to this Action's input page.
    return mapping.getInputForward();
  }
} 
