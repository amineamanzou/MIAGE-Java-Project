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
        <title> Portal for Employee Management-Add Employee</title>
    </head>
    <body> 
        <font size="+1">
        Portal for Employee Management - Add Employee
        </font><br>
        <hr width="100%" noshade="true">

        <html:errors/>

        <html:form action="/addEmployee">
            <table>
                <tr>
                    <td align="right"><bean:message key="label.search.name"/>:</td>
                    <td><html:text property="name"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>-- or --</td>
                </tr>
                <tr>
                    <td align="right"><bean:message key="label.search.ssNum"/>:</td>
                    <td><html:text property="ssnum"/> (xxx-xx-xxxx)</td>
                </tr>
                <tr>
                    <td></td>
                    <td>-- or --</td>
                </tr>
                <tr>
                    <td align="right"><bean:message key="label.search.phone"/>:</td>
                    <td><html:text property="phone"/> (xxxxxxxxxx)</td>
                </tr>
                <tr>
                    <td></td>
                    <td><html:submit/></td>
                </tr>
            </table>
         </html:form>

    </body>
</html>