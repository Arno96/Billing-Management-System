<jsp:include page="header.jsp"/>
    <div class="wrapper">
       	<jsp:include page="sidenav.jsp"/>
        <div id="content">
           <jsp:include page="navbar.jsp"/>   
		   <div id="blankspace" >
		   		<div class="table-responsive">
		   			<h3 align="center">
		   				Inline Table Insert Update Delete in Hibernate using JSGRID
		   			</h3>
		   			<div id="jsGrid"></div>
					<script>
    				$("#jsGrid").jsGrid({
	       			 	width: "100%",
	        			height: "400px",
	 					inserting: true,
	        			editing: true,
	        			sorting: true,
	        			paging: true,
	        			filtering: true,
	        			autoload: true,
	        			pageSize: 10,
	        			pageButtonCount: 5,
	        			deleteConfirm: "Do you really want to delete this data?",
	        			//data: db,
	        			controller: {
		                	loadData: function (filter) {
		                		return $.ajax({
		                        type: "GET",
		                        url: "/get",
		                        data: filter,
		                        dataType: "JSON"
		                   		 });
		                	},
		                	insertItem: function(item) {
		                        return $.ajax({
		                            type: "GET",
		                            url: "/insert",
		                            data: item
		                        });
		                    },
		                    
		                    updateItem: function(item) {
		                        return $.ajax({
		                            type: "GET",
		                            url: "/update",
		                            data: item
		                        });
		                    },
		                    
		                    deleteItem: function(item) {
		                        return $.ajax({
		                            type: "GET",
		                            url: "/delete",
		                            data: item
		                        });
		                    },
	        			},
	        			fields: [
	            				{ name: "Name", type: "text", width: 150, validate: "required" },
	            				{ name: "Age", type: "number", width: 50 },
	            				{ name: "Address", type: "text", width: 200 },
	            				{ name: "Married", type: "checkbox", title: "Is Married", sorting: false },
	            				{ type: "control" }
	        			]
   				 	});
				</script>
		   		</div>
		   </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
