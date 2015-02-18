
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>




<html:html>
  <head>
    <title>Application Struts-Spring </title>
  </head>
  <body>

    <table width="500" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr> 
        <td> 
          <div align="left">
            <img src="images/logo_paris1.png">
          </div>
        </td>
        
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>
          <bean:message key="app.cours" /> :
          <%= request.getAttribute("COURS") %>
        </td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
  </body>
</html:html>
