<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
      <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<jsp:include page="Header.jsp"/>

<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>


<div align="center">


<div class="container"  style="padding-top:70px">
  <h2 style="color:blue">Login Form</h2>
  <f:form action="validate" modelAttribute="dObj" method="post">
    <div class="form-group">
      <label for="userId" style="color:blue">User Id:</label>
      <f:input type="number" class="form-control" id="userId" placeholder="Enter Id"  path="id" style="width:300px"/>
    </div>
    <div class="form-group">
      <label for="pwd" style="color:blue">Password:</label>
      <f:input type="password" class="form-control" id="pwd" placeholder="Enter password" path="password" style="width:300px"/>
    </div>
    
    <button type="submit" class="btn btn-primary">Login</button>
  </f:form>
</div>

</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>