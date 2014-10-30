<%-- 
    Document   : deleteEmployee
    Created on : 6 oct. 2014, 10:44:49
    Author     : Amine Amanzou
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/blocks/header.jsp" />
    </head>
    <body>
        <jsp:include page="/blocks/menuBar.jsp" />
        <div class="container">
            <div class="page-header">
                <h1>Portal for Employee Management <small>Update </small></h1>
            </div>
            
            <html:errors/>

            <html:form action="/updateEmployee">
                <div class="form-group">
                    <label class="col-sm-2 control-label required" for="form_username">
                        <bean:message key="label.search.name"/>
                    </label>
                    <div class="col-sm-10">
                        <html:text property="firstName"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label required" for="form_username">
                        <bean:message key="label.search.ssNum"/> 
                    </label>
                    <div class="col-sm-10">
                        <html:text property="ssnum"/> (xxx-xx-xxxx)
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
