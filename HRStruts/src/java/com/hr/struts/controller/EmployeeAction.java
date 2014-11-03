package com.hr.struts.controller;

import com.hr.struts.model.EmployeeManagement;
import com.hr.struts.model.IEmployeeManagement;
import com.hr.struts.view.EmployeesShowForm;
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
import org.apache.struts.actions.MappingDispatchAction;

//Class qui regroupe toutes les actions. TP 6
public final class EmployeeAction extends SuperAction {

    public ActionForward search(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionErrors errors = new ActionErrors();
        IEmployeeManagement employeeManagement = super.getEmployeeManagement();
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
    					HttpServletResponse response)
  throws Exception
  {
    EmployeeManagement service = new EmployeeManagement();
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
} 
