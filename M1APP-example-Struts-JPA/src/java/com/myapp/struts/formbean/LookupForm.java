package com.myapp.struts.formbean;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;

public class LookupForm extends ActionForm {

  private String symbole = null;

  public String getSymbole() {

    return (symbole);
  }

  public void setSymbole(String symbole) {

    this.symbole = symbole;
  }

  @Override
  public void reset(ActionMapping mapping,
    HttpServletRequest request) {

    this.symbole = null;
  }

  @Override
  public ActionErrors validate(ActionMapping mapping,
    HttpServletRequest request) {

    ActionErrors erreurs = new ActionErrors();

    if ( (symbole == null ) || (symbole.length() == 0) ) {

      erreurs.add("symbole", new ActionMessage("erreurs.recherche.symbole.requis"));
    }
    return erreurs;
  }
}
