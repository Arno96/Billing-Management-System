<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="kor">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jsgrid-theme.min.css" />

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jsgrid.min.js"></script>


<title>BOOKS</title>
<script>
$(function() {	
    $("#jsGrid").jsGrid({
        height: "auto",
        width: "100%",
        
        filtering: true,
        editing: true,
        inserting: true,
        sorting: true,
        autoload: true,
        
      //pageLoading: true,
        paging: true,
        pageSize: 10,
        pageButtonCount: 10,
        /*
        rowClick: function(args) {
            console.log(args.item)
        },
        */
        deleteConfirm: function(item) {
            return "\""+item.id+"\""+ "을 삭제 하시겠습니까?";
        },
        controller:  {
            loadData: function(filter) {
                var d = $.Deferred();
                $.ajax({
                	contentType : "application/json; charset=UTF-8",
                	type: "GET",
                	url: "<%=request.getContextPath()%>/api",
                    dataType: "json",
                    data: filter
                }).done(function(response) {
                	if(response.status == "ok") {
                		d.resolve(response.data);	
                	}
                });
                return d.promise();
            }
            ,insertItem: function(item) {
                return $.ajax({
                	contentType : "application/json; charset=UTF-8",
                	type: "POST",
                    url: "<%=request.getContextPath()%>/api",
                    dataType: "json",
                    data: JSON.stringify(item)
                }).done(function(response) {
                	if(response.status == "ok") {
                		alert("등록되었습니다.");
                		location.reload();
                	}
                });
            }
            ,updateItem: function(item) {
                return $.ajax({
                	contentType : "application/json; charset=UTF-8",
                	type: "PUT",
                    url: "<%=request.getContextPath()%>/api/"+item.id,
                    dataType: "json",
                    data: JSON.stringify(item)
                }).done(function(response) {
                	if(response.status == "ok") {
                		alert("수정되었습니다.");
                		location.reload();
                	}
                });
            }
            ,deleteItem: function(item) {
                return $.ajax({
                	contentType : "application/json; charset=UTF-8",
                	type: "DELETE",
                    url: "<%=request.getContextPath()%>/api/"+item.id,
                    dataType: "json",
                    data: item
                }).done(function(response) {
                	if(response.status == "ok") {
                		alert("삭제되었습니다.");
                		location.reload();
                	}
                });
            }

        },
        fields: [
            { name: "id", type: "text", width: 150, readOnly:true},
            { name: "name", type: "text", width: 150  },
            { name: "writer", type: "text", width: 150  },
            { name: "price", type: "number", width: 100 ,align: "right" },
            { name: "genre", type: "text", width: 250 },
            { name: "publisher", type: "text", width: 250 },
            { name: "cnt", type: "number", width: 50,align: "right" },
            /*
            { name: "Country", type: "select", items: db.countries, valueField: "Id", textField: "Name" },
            { name: "Married", type: "checkbox", title: "Is Married", sorting: false },
            */
            {   type: "control"
            	/*,deleteButton: false*/
            }
        ]
    });
});
</script>
</head>
<body>
<div id="jsGrid"></div>
</body>
</html>