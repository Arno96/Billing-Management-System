<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="kor">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>

<title>BOOKS</title>
<script>
$(document).ready(function() {
    $('#example').DataTable( {
    	pageLength: 10,
    	bPaginate: true,
    	bLengthChange: true,
    	lengthMenu : [5, 10, 20, 30, 50],
    	pagingType: "full_numbers",
    	processing: true,
    	ordering: true,
    	searching: true,
    	serverSide: false,
        ajax : {
            "url":"<%=request.getContextPath()%>/api",
            "type":"GET",
            "data": function (d) {
                d.userStatCd = "NR";
            }
        },    
        columns: [
            { "data": "id" },
            { "data": "name" },
            { "data": "writer" },
            { "data": "price" },
            { "data": "genre" },
            { "data": "publisher" },
            { "data": "cnt" }
        ]
    } );
} );


</script>
</head>
<body>
<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>WRITER</th>
                <th>PRICE</th>
                <th>GENRE</th>
                <th>PUBLISHER</th>
                <th>CNT</th>
            </tr>
        </thead>
    </table>
</body>
</html>