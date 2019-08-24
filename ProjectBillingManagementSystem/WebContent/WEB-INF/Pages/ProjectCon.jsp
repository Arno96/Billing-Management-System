<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
    
<%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Projects</title>
</head>
<body>
	<table>
	<f:form Action="addProjectConfig" method="get" modelAttribute="configObj">
	<tr>
		<td>
							<f:select path="project.projectId">
							<f:option value="none">---Select Project----</f:option>
							<c:forEach items="${pList}" var="pObj">
								<f:option value="${pObj.projectId}">${pObj.projectName}</f:option>
							</c:forEach>
							</f:select>
							
							
							
							
			
		</td>
		</tr>
		<tr>	
			<td>
			
							
							
							<f:select path="role.roleId">
							<f:option value="none">---Select Role----</f:option>
							<c:forEach items="${rList}" var="rObj">
								<f:option value="${rObj.roleId}">${rObj.roleName}</f:option>
							</c:forEach>
							</f:select>
							
							
							
			
			</td>
			</tr>
			
				<tr>
		<td>
							<f:radiobutton path="location" value="Onsite" name="o"/>Onsite
							<br/>
							<f:radiobutton path="location" value="Offsite" name="o"/>Offshore
							
							
							
							
							
							
							
			
		</td>
		</tr>
		
			<tr>
		<td>
							<f:input type="text" path="billingPerHour"/>
							
							
							
							
							
							
			
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