
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
    </table>
    
    <html:errors />

    <html:form action="Lookup.do"> 
      <table width="45%" border="0">
        <tr>
          <td><bean:message key="app.symbole" />:</td>
          <td><html:text property="symbole" /></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><html:submit /></td>
        </tr>
      </table>
    </html:form> 

  </body>
</html:html>

