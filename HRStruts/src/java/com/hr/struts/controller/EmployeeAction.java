
import com.hr.struts.controller.SuperAction;

public final class EmployeeAction extends SuperAction {
    //faire une classe pour chq action
    //dans le browser, form action='search?method=search'

    public ActionForward execute(ActionMapping map, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Object method = request.getParameter("method");

        EmployeeSearchService service = new EmployeeSearchService();
        ArrayList results = null;
        DynaActionForm searchForm = (DynaActionForm) form;
        ActionErrors errors = null;
       
        switch (method.toString()) {
            case "searchEmployee":
                SearchEmployee se=new SearchEmployee(service);
                errors = se.searchEmployee(searchForm,request);
                break;

            case "showDepartments":
                results=service.getDepartements();
                searchForm.set("results", results);
                break;
                
            case "addEmployee":                
                AddEmployee add_emp=new AddEmployee(service);
                errors = add_emp.addEmployee(searchForm,request);
                break;

            case "deleteEmployee":
                DeleteEmployee delete_emp=new DeleteEmployee(service);
                errors = delete_emp.deleteEmployee(searchForm,request);
                break;

            case "updateSearchEmployee":
                UpdateEmployee update_emp=new UpdateEmployee(service);
                errors = update_emp.searchEmployee(searchForm,request);
                break;

            case "updateEmployee":
                update_emp=new UpdateEmployee(service);
               errors= update_emp.updateEmploye(searchForm,request);
                break;

            default:
                results = service.getAllEmployee();
                searchForm.set("results", results);     
        }
        saveErrors(request, errors);
        return map.getInputForward();
    }
}
