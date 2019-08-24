<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance</title>
</head>
<body>
<table>
	<f:form Action="addAttendance" method="get" modelAttribute="dataEntry">
	<tr>
		<td>
							<f:select path="developer.developerId">
							<f:option value="none">---Select Developer----</f:option>
							<c:forEach items="${dList}" var="dObj">
								<c:if test="${dObj.role=='Developer'}">
								<f:option value="${dObj.developerId}">${dObj.developerName}</f:option>
								</c:if>
							</c:forEach>
							</f:select>
							
							
							
							
			
		</td>
		</tr>
		
		
		
		
		<tr>
		<td>
						
							
								
								<f:input path="month" type="month" />
								
						
							
							
							
			
		</td>
		</tr>
		
		<tr>
		<td>
							
							
								
								<f:input path="totalNoOfHoursPresent"/>
								
							
							
							
							
							
			
		</td>
		</tr>
		
		
		
				
		<tr>
			<td>
				<input type="submit">
		
			</td>
		</tr>
			
			</f:form>
		</table>
		
</body>
</html>