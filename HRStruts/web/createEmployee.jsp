<%-- 
    Document   : addEmployee
    Created on : 2 oct. 2014, 21:16:06
    Author     : Pierre Gaillard
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
                <h1>Portal for Employee Management <small>Create </small></h1>
            </div>
            
            <html:errors/>

            <html:form action="/createEmployee">
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
                    <label class="col-sm-3 control-label" >
                        <bean:message key="label.employee.mail"/>
                    </label>
                    <div class="col-sm-9">
                        <html:text property="mail"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label" >
                        <bean:message key="label.employee.gender"/>
                    </label>
                    <div class="col-sm-9">
                        <html:text property="gender"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label" >
                        <bean:message key="label.employee.hireDate"/> 
                    </label>
                    <div class="col-sm-9">
                        <html:text property="hireDate"/> (xx/xx/xxxx)
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label" >
                        <bean:message key="label.employee.salary"/>
                    </label>
                    <div class="col-sm-9">
                         <html:text property="salary"/>
                    </div>
                </div>
                <div class="form-group">
                    <hr width="100%" size="1" noshade="false">
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success">Enregistrer</button>
                        <a href="#" class="btn btn-default">Annuler</a>
                    </div>
                </div>
             </html:form>
        </div>
    </body>
</html>