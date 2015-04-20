<html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<head>

</head>
<body align="center">
    <h1>Transport Management Form</h1>

<h2> Add a new Bus</h2>
   <s:form commandName="newBus" id="newBus" method="post" action="addBus">
        <table border="1" align="center">
             <tr>
                <td>Enter Bus Name</td>
                <td><input type="text" path="name" /></td>
              </tr>
         </table>
         <input type ="submit" value="Add Bus"/>
        </s:form>
</body>

<script>

</script>

</html>