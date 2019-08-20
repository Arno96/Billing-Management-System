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
	<f:form action="submitConfig" modelAttribute="paObj" method="get">
		<f:select path="pcObj.CONFIGURATION_ID">
		 	 <core:forEach items="${proj}" var="pOb">
				<f:option value="${pOb.projectId}">${pOb.projectName}</f:option>
			 </core:forEach>
		</f:select><br>
	</f:form>
</body>
</html>