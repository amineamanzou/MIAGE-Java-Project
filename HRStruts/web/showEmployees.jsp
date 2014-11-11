<%-- 
    Document   : showEmployee
    Created on : 6 oct. 2014, 10:43:32
    Author     : pierregaillard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/blocks/header.jsp" />
    </head>
    <body>
        <jsp:include page="/blocks/menuBar.jsp" />
        <div class="container">
            <div class="page-header">
                <h1>Show All the Employees</h1>
            </div>
        
       
            <html:form action="/showEmployees"> 
                <button type="submit" class="btn btn-success">Afficher</button>
            </html:form>

            <logic:present name="showEmployees" property="results">

             <hr width="100%" size="1" noshade="true"/>
             <bean:size id="size" name="showEmployees" property="results"/> 
             <logic:equal name="size" value="0">
                <center>
                    <font color="red"> <b>No employees Found</b>  </font>
                </center> 
             </logic:equal>

            <logic:greaterThan name="size" value="0">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th><bean:message key="label.employee.firstName"/></th>
                            <th><bean:message key="label.employee.lastName"/></th>
                            <th><bean:message key="label.employee.ssNum"/></th>
                            <th><bean:message key="label.employee.phone"/></th>
                            <th><bean:message key="label.employee.mail"/></th>
                            <th><bean:message key="label.employee.gender"/></th>
                            <th><bean:message key="label.employee.hireDate"/></th>
                            <th><bean:message key="label.employee.salary"/></th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <logic:iterate id="result" name="showEmployees" property="results">
                        <tr>
                            <td><bean:write name="result" property="id"/></td>
                            <td><bean:write name="result" property="firstName"/></td>
                            <td><bean:write name="result" property="lastName"/></td>
                            <td><bean:write name="result" property="ssNum"/></td>
                            <td><bean:write name="result" property="phone"/></td>
                            <td><bean:write name="result" property="mail"/></td>
                            <td><bean:write name="result" property="gender"/></td>
                            <td><bean:write name="result" property="hiredate"/></td>
                            <td><bean:write name="result" property="salary"/></td>
                            <td>
                                <a class="btn btn-info btn-xs" href=""><bean:message key="button.update"/></a>
                                <a class="btn btn-danger btn-xs" href=""><bean:message key="button.delete"/></a>
                            </td>
                        </tr>
                    </logic:iterate>
                    </tbody>
                </table>
            </logic:greaterThan>

            </logic:present>
        </div>
    </body>
</html>

