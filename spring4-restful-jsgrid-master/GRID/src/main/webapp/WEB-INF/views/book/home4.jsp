<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="kor">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<style>
	.table{
		line-height:1.0;
	}
</style>


<title>BOOKS</title>
<script>
var table;
$(document).ready(function() {
    table = $('#example').DataTable( {
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
    });
    
    $('#example tbody').on( 'click', 'tr', function () {
        var data = table.row($(this)).data();
		$('#id_modify').val(data.id);
		$('#name_modify').val(data.name);
		$('#writer_modify').val(data.writer);
		$('#price_modify').val(data.price);
		$('#genre_modify').val(data.genre);
		$('#publisher_modify').val(data.publisher);
		$('#cnt_modify').val(data.cnt);
		
		$('#modal_modify').modal('show');
    });
 
    
    
});

//Action(add,modify)
function actionFunction(action) {
	if(action == "add") {
		
		//validation
		if($('#name').val()      == "") { alert("이름을 입력해주세요.");$('#name').focus();return false; }
		if($('#writer').val()    == "") { alert("작가를 입력해주세요");$('#writer').focus();return false; }
		if($('#price').val()     == "") { alert("가격을 입력해주세요.");$('#price').focus();return false; }
		if($('#genre').val()     == "") { alert("장르를 입력해주세요");$('#genre').focus();return false; }
		if($('#publisher').val() == "") { alert("출판사를 입력해주세요.");$('#publisher').focus();return false; }
		if($('#cnt').val()       == "") { alert("수량을 입력해주세요.");$('#cnt').focus();return false; }
		
		//data
		var data = {};
		data.name      = $('#name').val();
		data.writer    = $('#writer').val();
		data.price     = $('#price').val();
		data.genre     = $('#genre').val();
		data.publisher = $('#publisher').val();
		data.cnt       = $('#cnt').val();

		//등록
		$.ajax({
        	contentType : "application/json; charset=UTF-8",
        	type: "POST",
            url: "<%=request.getContextPath()%>/api",
            dataType: "json",
            data: JSON.stringify(data)
        }).done(function(response) {
        	if(response.status == "ok") {
        		alert("등록되었습니다.");
        		location.reload();
        	}
        });
		
	} else if (action == "modify") {
		
		//validation
		if($('#name_modify').val()      == "") { alert("이름을 입력해주세요.");$('#name_modify').focus();return false; }
		if($('#writer_modify').val()    == "") { alert("작가를 입력해주세요");$('#writer_modify').focus();return false; }
		if($('#price_modify').val()     == "") { alert("가격을 입력해주세요.");$('#price_modify').focus();return false; }
		if($('#genre_modify').val()     == "") { alert("장르를 입력해주세요");$('#genre_modify').focus();return false; }
		if($('#publisher_modify').val() == "") { alert("출판사를 입력해주세요.");$('#publisher_modify').focus();return false; }
		if($('#cnt_modify').val()       == "") { alert("수량을 입력해주세요.");$('#cnt_modify').focus();return false; }
		
		//data
		var data = {};
		data.id        = $('#id_modify').val();
		data.name      = $('#name_modify').val();
		data.writer    = $('#writer_modify').val();
		data.price     = $('#price_modify').val();
		data.genre     = $('#genre_modify').val();
		data.publisher = $('#publisher_modify').val();
		data.cnt       = $('#cnt_modify').val();
	
		//수정
		$.ajax({
        	contentType : "application/json; charset=UTF-8",
        	type: "PUT",
            url: "<%=request.getContextPath()%>/api/"+data.id,
            dataType: "json",
            data: JSON.stringify(data)
        }).done(function(response) {
        	if(response.status == "ok") {
        		alert("수정되었습니다.");
        		location.reload();
        	}
        });		
		
	} else if (action == "del") {
		//data
		var data = {};
		data.id  = $('#id_modify').val();	
		
		if(confirm("삭제하시겠습니까?")){
			$.ajax({
	        	contentType : "application/json; charset=UTF-8",
	        	type: "DELETE",
	            url: "<%=request.getContextPath()%>/api/"+data.id,
	            dataType: "json",
	            data: data
	        }).done(function(response) {
	        	if(response.status == "ok") {
	        		alert("삭제되었습니다.");
	        		location.reload();
	        	}
	        });
		}
	}
}

</script>
</head>
<body>

<button type='button' class='btn btn btn-primary' data-toggle='modal' data-target='#modal_add' >Add</button>

<br/><br/>

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

<!-- add modal -->
<div class="modal fade" id="modal_add" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Book</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
        		</button>
			</div>
			<div class="modal-body">
				<fieldset>
					<div class="form-group">
						<label class="control-label col-lg-3" for="name">name</label>
						<input type="text" class="form-control" name="name" id="name" value="" />
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3" for="writer">writer</label>
						<input type="text" class="form-control" name="writer" id="writer" value="" />
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3" for="price">price</label>
						<input type="number" class="form-control" name="price" id="price" value="" />
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3" for="genre">genre</label>
						<input type="text" class="form-control" name="genre" id="genre" value="" />
					</div>

					<div class="form-group">
						<label class="control-label col-lg-3" for="publisher">publisher</label>
						<input type="text" class="form-control" name="publisher" id="publisher" value="" />
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3" for="cnt">cnt</label>
						<input type="number" class="form-control" name="cnt" id="cnt" value="" />
					</div>
				</fieldset>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" onclick="actionFunction('add');return false;">등록</button>
			</div>
		</div>
	</div>
</div>


<!-- modify modal -->
<div class="modal fade" id="modal_modify" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Book</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
        		</button>
			</div>
			<div class="modal-body">
				<fieldset>
					<div class="form-group">
						<label class="control-label col-lg-3" for="id_modify">ID</label>
						<input type="text" class="form-control" name="id_modify" id="id_modify" value=""  readonly />
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3" for="name_modify">name</label>
						<input type="text" class="form-control" name="name_modify" id="name_modify" value="" />
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3" for="writer_modify">writer</label>
						<input type="text" class="form-control" name="writer_modify" id="writer_modify" value="" />
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3" for="price_modify">price</label>
						<input type="number" class="form-control" name="price_modify" id="price_modify" value="" />
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3" for="genre_modify">genre</label>
						<input type="text" class="form-control" name="genre_modify" id="genre_modify" value="" />
					</div>

					<div class="form-group">
						<label class="control-label col-lg-3" for="publisher_modify">publisher</label>
						<input type="text" class="form-control" name="publisher_modify" id="publisher_modify" value="" />
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3" for="cnt_modify">cnt</label>
						<input type="number" class="form-control" name="cnt_modify" id="cnt_modify" value="" />
					</div>
				</fieldset>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" onclick="actionFunction('del');return false;">삭제</button>
				<button type="button" class="btn btn-success" onclick="actionFunction('modify');return false;">수정</button>
			</div>
		</div>
	</div>
</div>


</html>