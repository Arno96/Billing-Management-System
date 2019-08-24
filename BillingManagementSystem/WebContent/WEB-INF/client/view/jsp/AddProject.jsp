<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>
    <div class="wrapper">
       	<jsp:include page="sidenav.jsp"/>
        <div id="content">
           <jsp:include page="navbar.jsp"/>   
           
		   <div id="blankspace" >
		   
		   	<f:form action="submitConfig" modelAttribute="pObj" method="get">
				<f:select path="projectObj.projectId">
				 	 <core:forEach items="${proj}" var="pOb">
						<f:option value="${pOb.projectId}">${pOb.projectName}</f:option>
					 </core:forEach>
				</f:select><br>
				<f:select path="roleObj.roleId">
				 	 <core:forEach items="${role}" var="rOb">
						<f:option value="${rOb.roleId}">${rOb.roleName}</f:option>
					 </core:forEach>
				</f:select><br>
				<f:radiobutton path="LOCATION" value="Onsite"/>Onsite
				<f:radiobutton path="LOCATION" value="Offshore"/>Offshore<br>
				<f:input path="PER_HOUR_BILLING"/><br>
				<input type="submit" value="Submit">
			</f:form>
		   
		   </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
