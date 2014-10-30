<%-- 
    Document   : header
    Created on : 23 oct. 2014, 19:02:47
    Author     : Amine Amanzou <amineamanzou@gmail.com>
--%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <b><a class="navbar-brand" href="/HRStruts/">
            <bean:message key="page.title.menu"/>
        </a></b>
        <ul class="nav navbar-nav">
            <li>
                <html:link forward="search"><bean:message key="page.title.search" /></html:link>
            </li>
            <li>
                <html:link forward="showAll"><bean:message key="page.title.show" /></html:link>
            </li>
            <li>
                <a href="/HRStruts"><bean:message key="page.title.crud" /></a>
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
<br>
<br>
            