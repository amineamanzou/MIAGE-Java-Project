<%-- 
    Document   : searchEmployee
    Created on : 2 oct. 2014, 21:16:06
    Author     : Amine Amanzou <amineamanzou@gmail.com>
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
    <head>
        <jsp:include page="/blocks/header.jsp" />
    </head>
    <body> 
        <jsp:include page="/blocks/menuBar.jsp" />
        
        <div class="container">
            <div class="page-header">
                <h1>Portal for Employee Management <small>Search </small></h1>
            </div>

            <html:errors/>

            <html:form action="/searchEmployee">
                <div class="form-group">
                    <label class="col-sm-3 control-label required" >
                        <bean:message key="label.employee.firstName"/>
                    </label>
                    <div class="col-sm-9">
                        <html:text property="firstName"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label required" >
                        <bean:message key="label.employee.lastName"/>
                    </label>
                    <div class="col-sm-9">
                        <html:text property="lastName"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label required" >
                        <bean:message key="label.employee.ssNum"/> 
                    </label>
                    <div class="col-sm-9">
                        <html:text property="ssNum"/> (xxx-xx-xxxx)
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label required" >
                        <bean:message key="label.employee.phone"/>
                    </label>
                    <div class="col-sm-9">
                         <html:text property="phone"/> (xxxxxxxxxx)
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label required" >
                        <bean:message key="label.employee.mail"/>
                    </label>
                    <div class="col-sm-9">
                         <html:text property="mail"/> (xxxxxxxxxx)
                    </div>
                </div>
                <div class="form-group">
                    <hr width="100%" size="1" noshade="false">
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-info">Search</button>
                    </div>
                </div>
             </html:form>

            <logic:present name="searchEmployee" property="results">

                <hr width="100%" size="1" noshade="true">

                <bean:size id="size" name="searchEmployee" property="results"/>

                <logic:equal name="size" value="0">
                    <center>
                    <font color="red"><b>No Employees Found</b></font>
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
                            </tr>
                        </thead>
                        <tbody>
                        <logic:iterate id="result" name="searchEmployee" property="results">
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
                            </tr>
                        </logic:iterate>
                        </tbody>
                    </table>
                </logic:greaterThan>
            </logic:present>
        </div>
    </body>
</html>