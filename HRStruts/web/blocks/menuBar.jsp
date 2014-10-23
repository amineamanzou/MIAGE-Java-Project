<%-- 
    Document   : header
    Created on : 23 oct. 2014, 19:02:47
    Author     : Amine Amanzou <amineamanzou@gmail.com>
--%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container">
    <a class="navbar-brand" href="#"><bean:message key="page.title.menu"/></a>
    <ul class="nav navbar-nav">
        <li>
            <html:link forward="search">Search for Employees</html:link>
        </li>
        <li>
            <html:link forward="showAll">Show all the Employees</html:link>
        </li>
        <li>
            <html:link forward="add">Add an Employees</html:link>
        </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li>
            <html:link page="/Locale.do?method=english">
                <html:img src="img/english.png" alt="English" />
            </html:link>
        </li>
        <li>
            <html:link page="/Locale.do?method=france">
                <html:img src="img/france.png" alt="Français" />
            </html:link>
        </li>
    </ul>
  </div>
</nav>
