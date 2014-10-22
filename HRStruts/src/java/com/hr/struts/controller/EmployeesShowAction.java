package com.hr.struts.controller;

import com.hr.struts.model.EmployeeManagement;
import java.util.ArrayList;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public final class EmployeesShowAction extends SuperAction
{
  public ActionForward execute(ActionMapping mapping,
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
