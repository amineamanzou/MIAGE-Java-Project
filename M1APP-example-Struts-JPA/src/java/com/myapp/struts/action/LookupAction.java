package com.myapp.struts.action;

import com.myapp.struts.formbean.LookupForm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;


import com.myapp.model.Model;
import com.myapp.model.ModelException;



public class LookupAction extends GenericAction {
    
  
  
  @Override
  public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
        

    Double cours = null;

    // Cible par d�faut
    String cible = "succes";
    String symbole = null;

    if ( form != null ) {

      // Utilisation de LookupForm pour obtenir les param�tres de la requ�te
      LookupForm lookupForm = (LookupForm)form;

      symbole = lookupForm.getSymbole();

      System.out.println("Symbole : " +symbole);
      try {
      Model m=getModel();
      cours = m.getCotation(symbole);

    }
      catch (ModelException e) {
          System.out.println ("erreur Model : " + e.getMessage());
    }
    System.out.println("cours : " +cours);
    }
    // Cible en cas d'echec
    if ( cours == null ) {

      cible = "echec";
      ActionMessages erreurs = new ActionMessages();
      erreurs.add(ActionMessages.GLOBAL_MESSAGE,
        new ActionMessage("erreurs.recherche.symbole.inconnu", symbole));

      // Signalement des erreurs � la page d'origine
      if (!erreurs.isEmpty()) {

        saveErrors(request, erreurs);
      }

    }
    else {
      
      request.setAttribute("COURS", cours);
    }
    // Transmission a la vue appropriee
    return (mapping.findForward(cible));
  }
}
