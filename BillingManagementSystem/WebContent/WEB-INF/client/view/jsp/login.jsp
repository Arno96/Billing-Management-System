<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login Page</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<style type="text/css">
		body {
    		font-family: "Lato", sans-serif;
		}
		.main-head{
		    height: 150px;
		    background: #FFF;
		   
		}
		.sidenav {
		    height: 100%;
		    background-color: #000;
		    overflow-x: hidden;
		    padding-top: 20px;
		}
		
		.main {
		    padding: 0px 10px;
		}
		@media screen and (max-height: 450px) {
		    .sidenav {padding-top: 15px;}
		}
		@media screen and (max-width: 450px) {
		    .login-form{
		        margin-top: 10%;
		    }
		
		    .register-form{
		        margin-top: 10%;
		    }
		}
		@media screen and (min-width: 768px){
		    .main{
		        margin-left: 40%; 
		    }
			.sidenav{
		        width: 40%;
		        position: fixed;
		        z-index: 1;
		        top: 0;
		        left: 0;
		    }
			.login-form{
		        margin-top: 80%;
			}
			.register-form{
		        margin-top: 20%;
		    }
		}
		.login-main-text{
		    margin-top: 20%;
		    padding: 60px;
		    color: #fff;
		}
		
		.login-main-text h2{
		    font-weight: 300;
		}
		.btn-black{
		    background-color: #000 !important;
		    color: #fff;
		}
	</style>
</head>
<body>
	<div class="sidenav">
         <div class="login-main-text">
            <h2>Application<br> Login Page</h2>
            <p>Login or register from here to access.</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form action="validateRole" method="POST">
                  <div class="form-group">
                     <label>User Name</label>
                     <input type="number" class="form-control" placeholder="User Name" name="id">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" placeholder="Password" name="pwd">
                  </div>
                  <button type="submit" class="btn btn-black">Login</button>
               </form>
            </div>
         </div>
      </div>
</body>
</html>