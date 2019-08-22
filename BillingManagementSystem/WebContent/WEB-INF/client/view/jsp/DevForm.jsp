<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<form action="Bill" method="get">
		<select>
		 	 <core:forEach items="${devL}" var="pOb">
				<option value="${pOb}" name="dev" >${pOb.developerName}</option>
			 </core:forEach>
		</select><br>
		<label>Month :</label>
		<input type="text" name="x"/><br>
		<input type="submit" value="submit">
	</form>
	</div>
</body>
</html>