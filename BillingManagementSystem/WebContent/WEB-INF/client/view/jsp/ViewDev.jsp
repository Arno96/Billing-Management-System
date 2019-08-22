<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:form action="submitAllocate" modelAttribute="pObj" method="get">
		<f:select path="pcObj.CONFIGURATION_ID">
		 	 <core:forEach items="${projCon}" var="pOb">
				<f:option value="${pOb.CONFIGURATION_ID}">${pOb.projectObj.projectName},${pOb.roleObj.roleName},${pOb.LOCATION}</f:option>
			 </core:forEach>
			 
		</f:select><br>
		
		<f:select path="dObj.developerId">
		 	 <core:forEach items="${devl}" var="dOb">
				<f:option value="${dOb.developerId}">${dOb.developerName}</f:option>
			 </core:forEach>
		</f:select><br>
		
		
		<input type="submit" value="Submit">
	</f:form>
</body>
</html>