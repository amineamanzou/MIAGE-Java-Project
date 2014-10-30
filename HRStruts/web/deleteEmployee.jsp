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
                <h1>Portal for Employee Management <small>Delete </small></h1>
            </div>
            <div class="alert alert-danger">
                Cette action irréversible va également supprimer l'ensemble des informations associées !
            </div>
            <html:form action="/deleteEmployee">
                <div class="form-group">
                    <label class="col-sm-2 control-label required" for="form_username">
                        Id
                    </label>
                    <div class="col-sm-10">
                        <html:text property="id"/>
                    </div>
                </div>
               <button type="submit" class="btn btn-danger">Confirmer la suppression</button>
               <a href="#" class="btn btn-default">Annuler</a> 
            </html:form>
        </div>
    </body>
</html>
