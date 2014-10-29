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
        </div>
    </body>
</html>