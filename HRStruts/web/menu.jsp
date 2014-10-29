<%-- 
    Document   : menu
    Created on : 2 oct. 2014, 21:14:02
    Author     : Amine Amanzou <amineamanzou@gmail.com>
--%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html>
    <head>
        <jsp:include page="/blocks/header.jsp" />
    </head>
    <body>
        <jsp:include page="/blocks/menuBar.jsp" />
        <div class="jumbotron">
            <div class="container">
              <h1>Struts project</h1>
              <p>This is a project made for the Sorbonne university in the architecture lessons.</p>
              <p><a class="btn btn-primary btn-lg" role="button">Learn more »</a></p>
            </div>
        </div>
        <div class="container">
            <div class="page-header">
                <h1>Employees <small>Simple CRUD</small></h1>
            </div>
            <div class="well">
                <ul class="nav nav-pills nav-stacked">
                    <li>
                        <html:link forward="create">Create</html:link>
                    </li>
                    <li>
                        <html:link forward="update">Update</html:link>
                    </li>
                    <li>
                        <html:link forward="delete">Delete</html:link>
                    </li>
                </ul>
            </div>
        </div>

       <br>
       <html:errors/> 

    </body>
</html>

