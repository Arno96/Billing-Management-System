<%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Projects</title>
</head>
<body>
	<table>
	<f:form Action="addDeveloperAllocation" method="get" modelAttribute="devConfigObj">
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
			
							
							
							<f:select path="projectConfig.configId">
							<f:option value="none">---Select Project configuration----</f:option>
							<c:forEach items="${configList}" var="configObj">
								<f:option value="${configObj.configId}">${configObj.project.projectName},${configObj.role.roleName},${configObj.location}</f:option>
							</c:forEach>
							</f:select>
							
							
							
			
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