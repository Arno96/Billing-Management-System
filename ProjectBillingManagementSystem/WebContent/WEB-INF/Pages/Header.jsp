<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
  <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" /> 
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script>
	
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header" >
      <a class="navbar-brand" href="#">
      	<img src="images/logo.gif" style="width:250px;height:70px"/>
      </a>
    </div>
    
    
    <c:if test="${userObj ne null && userObj.applicationRole eq 'Admin'}">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#" id="getProjectConfiguration">Project Configuration</a></li>
      <li><a href="#">Developer Allocation</a></li>
     <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Billing
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Developer Billing</a></li>
          <li><a href="#">Project Billing</a></li>
          
        </ul>
      </li>
      
    </ul>
    </c:if>
  </div>
  
  <!-- <div id="jsgrid"></div> -->
  
</nav>

<script>
		var myData;
		var myprojects;
		var myroles;
		var locations = [
			{ Name: "Onsite"},
			{ Name: "Offset"},
			
	];
	
		$("a#getProjectConfiguration").click(function(){
			$.ajax({url: "fetchProjectConfigConfiguration", success: function(result){
		    myData=result;
		    
		    $.ajax({url: "fetchProjects", success: function(result){
		    	myprojects=result;
		    
		   $.ajax({url: "fetchRoles", success: function(result){
			   myroles=result;
		    	
		    //func starts
		    $(function() {			
				$("#jsgrid").jsGrid({
		  			 width: "100%",
		   			height: "400px",
				inserting: true,
		   			editing: true,
		   			sorting: true,
		   			paging: true,
		   			data: myData, 
		   			fields: [
							{ name: "project", type: "select", items: myprojects, valueField: "projectid", textField: "projectname" }, 
							{ name: "role", type: "select", items: myroles, valueField: "roleId", textField: "roleName" },
							{ name: "location", type: "select", items: locations, valueField: "Name", textField: "Name" },
		       				/* { name: "location", type: "text", width: 50 }, */
		       				{ name: "perHourBilling", type: "number", width: 200 },
		       				{ type: "control" }
		       				
		   			]
				});
				 
				});//func ends;
		    }});
		    }});  
		  }});
			 $("#div1").hide();
		});
	

		
		
		
</script>