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
        <title><bean:message key="page.title.menu"/></title>
    </head>
    <body>

        <font size="+1">
            <bean:message key="page.title.menu"/>
        </font>
        <br>
        <hr width="100%" noshade="true">
        <html:link page="/Locale.do?method=english">English</html:link>
        <html:link page="/Locale.do?method=france">Français</html:link>
        <br>
        <hr width="100%" noshade="true">

       &#149; <html:link forward="search">Search for Employees</html:link><br>
       &#149; <html:link forward="showAll">Show all the Employees</html:link><br>
       &#149; <html:link forward="add">Add an Employees</html:link><br>

       <br>
       <html:errors/> 

    </body>
</html>

