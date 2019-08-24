<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="kor">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jsgrid-theme.min.css" />
<style>
.externalPager{
	margin: 10px 0;
}
.page-item a{
    position: relative;
    display: block;
    padding: .5rem .75rem;
    margin-left: -1px;
    line-height: 1.25;
    color: #007bff;
    background-color: #fff;
    border: 1px solid #dee2e6;
}
.currentPg{
	color:black;
	background-color: #337ab7;
}
</style>


<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jsgrid.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<title>BOOKS</title>
<script>


//JS그리드
$(function() {	
    $("#jsGrid").jsGrid({
        height: "auto",
        width: "100%",
        
        filtering: true,
        editing: false,
        inserting: false,
        sorting: true,
        autoload: true,
        
      //pageLoading: true,
        paging: true,
        pageSize: 10,
        pageButtonCount: 10,
        pagerContainer: "#externalPager",
        pagerFormat: "{first} {prev} {pages} {next} {last}",
        pagePrevText: "Prev",
        pageNextText: "Next",
        pageFirstText: "First",
        pageLastText: "Last",
        pageNavigatorNextText: "...",
        pageNavigatorPrevText: "...",
        pagerRenderer : null,
        //paging class
        pagerContainerClass: "Page navigation",
        pagerClass: "pagination justify-content-center",
        pagerNavButtonClass: "page-item",
        pageClass: "page-item",
        currentPageClass: "page-link currentPg",

        //modify setting
        rowClick: function(args) {
    		$('#id_modify').val(args.item.id);
    		$('#name_modify').val(args.item.name);
    		$('#writer_modify').val(args.item.writer);
    		$('#price_modify').val(args.item.price);
    		$('#genre_modify').val(args.item.genre);
    		$('#publisher_modify').val(args.item.publisher);
    		$('#cnt_modify').val(args.item.cnt);
    		
    		$('#modal_modify').modal('show');
        },
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
                	}
                });
            }

        },
        fields: [
            { name: "id",        type: "text",   width: "5%", align: "left" },
            { name: "name",      type: "text",   width: "20%"  },
            { name: "writer",    type: "text",   width: "20%"  },
            { name: "price",     type: "number", width: "5%" ,align: "right" },
            { name: "genre",     type: "text",   width: "20%" },
            { name: "publisher", type: "text",   width: "25%" },
            { name: "cnt",       type: "number", width: "5%",align: "right" },
            /*
            { name: "Country", type: "select", items: db.countries, valueField: "Id", textField: "Name" },
            { name: "Married", type: "checkbox", title: "Is Married", sorting: false },
            */
            {   type: "control",
            	modeSwitchButton: false,
            	editButton: false,
            	/*,deleteButton: false*/
				headerTemplate: function() {
				                return "<button type='button' class='btn btn-outline-dark' data-toggle='modal' data-target='#modal_add' >Add</button>";
				            }            	
            }
        ]
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
		
	}
}
</script>
</head>
<body>

<!-- jsGrid -->
<div id="jsGrid"></div>

<!-- paging -->
<div id="externalPager" class="externalPager"></div>

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
				<button type="button" class="btn btn-success" onclick="actionFunction('modify');return false;">수정</button>
			</div>
		</div>
	</div>
</div>

</body>
</html>