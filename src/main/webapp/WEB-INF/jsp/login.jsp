
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<body>

<h1>Welcome to the website</h1>
${message}<br/>
  <s:form action="login" commandName="account" method="post">
           <table>
           <tr>
                <td>User Name </td>
                 <td>
                    <s:input type="text" path="username"/>
                 </td>
            </tr>
           <tr>
                <td>Password </td>
                <td><s:input type="password" path="password" /></td>
           </tr>
           <tr></tr>
          <tr><td align="right"><input type="submit" value="Login"/></td></tr>
          </table>
    </s:form>
    </body>
</html>
