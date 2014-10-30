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
                <table>
                    <tr>
                        <td align="right"><bean:message key="label.search.firstName"/>:</td>
                        <td><html:text property="firstName"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>-- or --</td>
                    </tr>
                    <tr>
                        <td align="right"><bean:message key="label.search.lastName"/>:</td>
                        <td><html:text property="lastName"/> </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>-- or --</td>
                    </tr>
                    <tr>
                        <td align="right"><bean:message key="label.search.ssNum"/>:</td>
                        <td><html:text property="ssNum"/> (xxx-xx-xxxx)</td>
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

            <logic:present name="searchEmployee" property="results">

                <hr width="100%" size="1" noshade="true">

                <bean:size id="size" name="searchEmployee" property="results"/>

                <logic:equal name="size" value="0">
                    <center>
                    <font color="red"><b>No Employees Found</b></font>
                    </center>
                </logic:equal>
                <logic:greaterThan name="size" value="0">
                    <table border="1">
                        <tr>
                            <th>Id</th>
                            <th>FirstName</th>
                            <th>LastName</th>
                            <th>Social Security Number</th>
                            <th>Phone Number</th>
                            <th>Mail</th>
                            <th>Gender</th>
                            <th>Hire Date</th>
                            <th>Salary</th>
                        </tr>
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
                    </table>
                </logic:greaterThan>
            </logic:present>
        </div>
    </body>
</html>