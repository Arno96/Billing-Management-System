<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
       <head>
              <title>Login</title>
           <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
       </head>
       <body>
              <div class="container">
                  <h2 align="center" class="text-info">User Form Validation</h2>
                  <hr />
                  <div>&nbsp;</div>

              <form action="validateRole" method="POST">
                      <div align="center" class="form-group">
                            <label>Id:</label><input type="text" size="30" placeholder="Enter Id" name="id"/> <br>                  
                            <label>Password:</label><input type="password" size="30" placeholder="Enter password" name="pwd"/><br>
                            <button type="submit" class="btn btn-primary">Submit</button>
                      </div>
              </form>
           </div>
       </body>
</html>
