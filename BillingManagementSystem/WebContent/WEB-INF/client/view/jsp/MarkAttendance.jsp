<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script >
$(function() {
	 
    $("#jsGrid").jsGrid({
        height: "70%",
        width: "100%",
        editing: true,
        autoload: true,
        paging: true,
        deleteConfirm: function(item) {
            return "The client \"" + item.Name + "\" will be removed. Are you sure?";
        },
        rowClick: function(args) {
            showDetailsDialog("Edit", args.item);
        },
        controller: db,
        fields: [
            { name: "Name", type: "text", width: 150 },
            { name: "Age", type: "number", width: 50 },
            { name: "Address", type: "text", width: 200 },
            { name: "Country", type: "select", items: db.countries, valueField: "Id", textField: "Name" },
            { name: "Married", type: "checkbox", title: "Is Married", sorting: false },
            {
                type: "control",
                modeSwitchButton: false,
                editButton: false,
                headerTemplate: function() {
                    return $("<button>").attr("type", "button").text("Add")
                            .on("click", function () {
                                showDetailsDialog("Add", {});
                            });
                }
            }
        ]
    });
 
    $("#detailsDialog").dialog({
        autoOpen: false,
        width: 400,
        close: function() {
            $("#detailsForm").validate().resetForm();
            $("#detailsForm").find(".error").removeClass("error");
        }
    });
 
    $("#detailsForm").validate({
        rules: {
            name: "required",
            age: { required: true, range: [18, 150] },
            address: { required: true, minlength: 10 },
            country: "required"
        },
        messages: {
            name: "Please enter name",
            age: "Please enter valid age",
            address: "Please enter address (more than 10 chars)",
            country: "Please select country"
        },
        submitHandler: function() {
            formSubmitHandler();
        }
    });
 
    var formSubmitHandler = $.noop;
 
    var showDetailsDialog = function(dialogType, client) {
        $("#name").val(client.Name);
        $("#age").val(client.Age);
        $("#address").val(client.Address);
        $("#country").val(client.Country);
        $("#married").prop("checked", client.Married);
 
        formSubmitHandler = function() {
            saveClient(client, dialogType === "Add");
        };
 
        $("#detailsDialog").dialog("option", "title", dialogType + " Client")
                .dialog("open");
    };
 
    var saveClient = function(client, isNew) {
        $.extend(client, {
            Name: $("#name").val(),
            Age: parseInt($("#age").val(), 10),
            Address: $("#address").val(),
            Country: parseInt($("#country").val(), 10),
            Married: $("#married").is(":checked")
        });
 
        $("#jsGrid").jsGrid(isNew ? "insertItem" : "updateItem", client);
 
        $("#detailsDialog").dialog("close");
    };
 
});
</script>
</head>
<body>
	<div align="center">
	<h1>welcome Data entry operator</h1>
	<hr>
		<f:form action="submitData" modelAttribute="dataObj" method="get">
			<label>Developer Name :</label>
			<f:select path="devObj.developerId">
		 	 <core:forEach items="${devObj}" var="dOb">
				<f:option value="${dOb.developerId}">${dOb.developerName}</f:option>
			 </core:forEach>
		</f:select><br>
		<label>Month :</label>
			<f:select path="month">
				<f:option value="january">january</f:option>
				<f:option value="february">february</f:option>
				<f:option value="march">march</f:option>
				<f:option value="april">april</f:option>
				<f:option value="may">may</f:option>
				<f:option value="june">june</f:option>
				<f:option value="july">july</f:option>
				<f:option value="august">august</f:option>
				<f:option value="september">september</f:option>
				<f:option value="october">october</f:option>
				<f:option value="november">november</f:option>
				<f:option value="december">december</f:option>
			</f:select>
			<br>
			<label>year :</label>
			<f:select path="year" id="year">
				<f:option value="">Select year</f:option>
			</f:select>
			<script type="text/javascript">
				for(y=2015;y<2029;y++)
				{
					var optn = document.createElement("OPTION");
					optn.text=y;
					optn.value=y;
					
					if(y==2019)
					{
						optn.selected=true;
					}
					document.getElementById('year').options.add(optn);
				}
			</script>
			<label>Half day:</label>
			<f:input path="halfDay" /><br>
			<label>Full day:</label>
			<f:input path="fullDay"/><br>
			<input type="submit" value="submit">
		</f:form>
	</div>
</body>
</html>