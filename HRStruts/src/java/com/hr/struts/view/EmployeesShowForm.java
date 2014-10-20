package com.hr.struts.view;

/**
 * Deprecated class (pas utilisée) DynaFormAction
 * @author Pierre Gaillard
 */
import java.util.List;   
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
   
public class EmployeesShowForm extends ActionForm
{
  private List results = null;
  
  public void setResults(List results) {
    this.results = results;
  }
   
  public List getResults() {
    return results;
  }
   
  // Reset form fields. 
  public void reset(ActionMapping map, HttpServletRequest req)
  {
    results = null;
  }
}
