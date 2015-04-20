<html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<head>

</head>
<body align="center">
    <h1>Transport Management Form</h1>

        <s:form commandName="stop" id="stopForm" method="post" action="busList">
        <table border="1" align="center">
             <tr>
             <td>Select Route</td>
                <td>
                    <s:select path="stop_id" id="stop">
                    <option value="Select Route" >Select Route</option>
                     <c:forEach items="${stopsList}" var="stop">
                    <c:set var="stopName"  value="${stop.name}"/>
                     <c:if test="${SelectedStop != stopName}">
                        <option value=${stop.stop_id} >${stopName}</option>
                     </c:if>
                     <c:if test="${SelectedStop == stopName}" >
                        <option value=${stop.stop_id} selected="true">${stopName}</option>
                     </c:if>
                    </c:forEach>
                    </s:select>
                </td>
            </tr>
         </table>
        </s:form>
    <div id="busForm">
        <s:form commandName="bus" method="post"  action="addEmployee">
                <table border="1" align="center">
                     <tr>
                     <td>Select Bus</td>
                        <td>
                            <s:select id="busId" path="bus_id">
                             <option value="Select Bus" >Select Bus</option>
                             <c:forEach items="${busesList}" var="bus">
                              <option value=${bus.bus_id}>${bus.name}</option>
                            </c:forEach>
                            </s:select>
                        </td>
                    </tr>
                     <tr class="alwaysHide">
                        <td><input type="text" name="stop_id" value=${selectedStopId} /></td>
                     </tr>

                        <tr class="employeeForm">
                            <td>Employee Name</td>
                            <td><input type="text" name="employeeName" /></td>
                        </tr>
                        <tr class="employeeForm">
                            <td>Employee Id</td>
                            <td><input type="text" name="employeeId" /></td>
                        </tr>

                    <tr>
                 </table>
                 <br/>
                 <input class="employeeForm" type="submit" name="action" value="Add" />
        </s:form>
    <br/>

</body>

<script>
$("#stop").change(function(){$("#stopForm").submit();})
$(".employeeForm").hide();
$(".alwaysHide").hide();
$("#busId").change(function(){$(".employeeForm").show()})
</script>

</html>