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
                    <label class="col-sm-2 control-label required" for="form_username">
                        Id
                    </label>
                    <div class="col-sm-10">
                        <html:text property="id"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label required" for="form_username">
                        <bean:message key="label.search.firstName"/>
                    </label>
                    <div class="col-sm-10">
                        <html:text property="firstName"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label required" for="form_username">
                        <bean:message key="label.search.lastName"/>
                    </label>
                    <div class="col-sm-10">
                        <html:text property="lastName"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label required" for="form_username">
                        <bean:message key="label.search.ssNum"/> 
                    </label>
                    <div class="col-sm-10">
                        <html:text property="ssNum"/> (xxx-xx-xxxx)
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label required" for="form_username">
                        <bean:message key="label.search.phone"/>
                    </label>
                    <div class="col-sm-10">
                         <html:text property="phone"/> (xxxxxxxxxx)
                    </div>
                </div>
                <br><br><br><br><br>
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