<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工信息显示</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${APP_PATH}/static/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!--员工添加模态框  -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">员工添加</h4>
      </div>
      <div class="modal-body">
      
        <form class="form-horizontal" id="form">
        	<!-- 输入姓名 -->
        	<div class="form-group">
		    <label for="inputName" class="col-sm-2 control-label">姓名</label>
		    <div class="col-sm-10">
		      <input type="text" name="empName" class="form-control" id="empName_add" placeholder="name">
		      <span class="help-block"></span>
		    </div>
		  	</div>
        	<!-- 邮箱 -->
        	<div class="form-group">
		    <label for="email" class="col-sm-2 control-label">邮箱</label>
		    <div class="col-sm-10">
		      <input type="email"name="email" class="form-control" id="email_add" placeholder="email">
		      		      <span class="help-block"></span>
		    </div>
 		 	</div>
 		 <!-- 性别 -->
		  <div class="form-group">
		    <label for="empGender" class="col-sm-2 control-label">性别</label>
		    <div class="col-sm-10">
		    <label class="radio-inline">
			  <input type="radio" name="gender" id="gender1_add" value="男"> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" name="gender" id="gender2_add" value="女" checked="checked"> 女
			</label>
		    
		    </div>
		  </div>
		  <!-- 部门 -->
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">部门</label>
		    <div class="col-sm-4">
				<select class="form-control" name="dId" id="dept_add">
				</select>
		    </div>
 		 </div>
		  
		</form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="emp_save">保存</button>
      </div>
    </div>
  </div>
</div>


<!-- 员工修改模态框 -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">员工修改</h4>
      </div>
      <div class="modal-body">
      
        <form class="form-horizontal" id="form">
        	<!-- 输入姓名 -->
        	<div class="form-group">
		    <label for="inputName" class="col-sm-2 control-label">姓名</label>
		    <div class="col-sm-10">
		      <p class="form-control-static" id="static-empName"></p>
		    </div>
		  	</div>
        	<!-- 邮箱 -->
        	<div class="form-group">
		    <label for="email" class="col-sm-2 control-label">邮箱</label>
		    <div class="col-sm-10">
		      <input type="email"name="email" class="form-control" id="email_update" placeholder="email">
		      		      <span class="help-block"></span>
		    </div>
 		 	</div>
 		 <!-- 性别 -->
		  <div class="form-group">
		    <label for="empGender" class="col-sm-2 control-label">性别</label>
		    <div class="col-sm-10">
		    <label class="radio-inline">
			  <input type="radio" name="gender" id="gender1_update" value="男"> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" name="gender" id="gender2_update" value="女" checked="checked"> 女
			</label>
		    
		    </div>
		  </div>
		  <!-- 部门 -->
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">部门</label>
		    <div class="col-sm-4">
				<select class="form-control" name="dId" id="dept_update">
				</select>
		    </div>
 		 </div>
		  
		</form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="emp_update">更新</button>
      </div>
    </div>
  </div>
</div>

	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<!-- 两个按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
				<button class="btn btn-danger" id="emp_delete_all">删除</button>
			</div>
		</div>
		<!--显示表格数据  -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					 <thead>
					 	<tr>
					 	<th><input type="checkbox" id="check_all"/></th>
					 	<th>员工ID</th>
					 	<th>姓名</th>
					 	<th>性别</th>
					 	<th>邮箱</th>
					 	<th>部门</th>
					 	<th>操作</th>
					 </tr>
					 </thead>
					 
					 <tbody>
					 	
					 </tbody>
				</table>
			</div>
		</div>
		
		
		<!--  显示分页信息-->
		<div class="row">
			<!-- 分页文本信息 -->
			<div class="col-md-6" id="page_info_area">
				
			</div>
			<!-- 分页条 -->
			<div class="col-md-6" id="page_nav_area">
				
			</div>
		</div>
	</div>
	
<script type="text/javascript">
	var totalRecord,currentPage;
	$(function(){
		to_page(1);
	});
	
	//抽取Ajax方法
	function to_page(pn){
		$.ajax({
			url:"${APP_PATH}/emps",
			data:"pn="+pn,
			type:"get",
			success:function(result){
				//1.解析员工数据
				build_emps_table(result);
				//2.解析显示分页信息
				build_page_info(result);
				//3.显示分页条
				build_page_nav(result);
			}
		});
	}
	
	function build_emps_table(result){
		$("#emps_table tbody").empty();
		
		var emps = result.extend.pageinfo.list;
		$.each(emps,function(index,item){
			var chooseId=$("<td><input type='checkbox' class='check_btn'/></td>");
			var empId = $("<td></td>").append(item.empId);
			var empName = $("<td></tdr>").append(item.empName);
			var gender = $("<td></td>").append(item.gender);
			var email = $("<td></td>").append(item.email);
			var dept = $("<td></td>").append(item.dept.deptName);
			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
			.append("<span></sapn>").addClass("glyphicon glyphicon-pencil").append("编辑");
			editBtn.attr("edit-id",item.empId);
			var deleteBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
			.append("<span></sapn>").addClass("glyphicon glyphicon-trash").append("删除");
			deleteBtn.attr("delete-id",item.empId);
			var oper = $("<td></td>").append(editBtn).append(" ").append(deleteBtn);
			
			$("<tr></tr>").append(chooseId).append(empId).append(empName).append(gender).
			append(email).append(dept).append(oper).appendTo("#emps_table tbody");			
		});
	}
	//显示分页信息
	function build_page_info(result){
		$("#page_info_area").empty();
		
		$("#page_info_area").append("当前页："+result.extend.pageinfo.pageNum+
		"页，共有"+result.extend.pageinfo.pages+"页，共有"+result.extend.pageinfo.total+"条记录");
		totalRecord = result.extend.pageinfo.total;
		currentPage = result.extend.pageinfo.pageNum;
	}
	//显示分页条
	function build_page_nav(result){
		$("#page_nav_area").empty();
		
		var ul = $("<ul></ul>").addClass("pagination");
		//首页
		var firstPageLi = $("<li></li>").
		append($("<a></a>").append("首页").attr("href","#"));
		//前一页
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if(result.extend.pageinfo.hasPreviousPage == false){
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		}else{
			firstPageLi.click(function(){
				to_page(1);
			});
			prePageLi.click(function(){
				to_page(result.extend.pageinfo.pageNum-1);
			});
		}
		//后一页
		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		//尾页
		var lastPageLi = $("<li></li>").
		append($("<a></a>").append("尾页").attr("href","#"));
		if(result.extend.pageinfo.hasNextPage == false){
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		}else{
			lastPageLi.click(function(){
				to_page(result.extend.pageinfo.pages);
			}); 
			nextPageLi.click(function(){
				to_page(result.extend.pageinfo.pageNum+1);
			});
		}
		ul.append(firstPageLi).append(prePageLi);
		$.each(result.extend.pageinfo.navigatepageNums,function(index,item){
			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if(result.extend.pageinfo.pageNum == item){
				$(numLi).addClass("active");
			}
			numLi.click(function(){
				to_page(item);
			});
			ul.append(numLi);
		});
		ul.append(nextPageLi).append(lastPageLi);
		var navle = $("<nav></nav>").append(ul);
		navle.appendTo("#page_nav_area");
	}
	
	//加载模态框
	$("#emp_add_modal_btn").click(function(){
		//在弹出模态框之前应该提交ajax请求，获取部门信息
		form_reset("#empAddModal form");
		getDepts("#dept_add");
		
		$("#empAddModal").modal({
			backdrop:"static"
		});
	});
	
	function getDepts(ele){
		$(ele).empty();
		$.ajax({
			url:"${APP_PATH}/depts",
			type:"GET",
			success:function(result){
				//遍历得到的部门信息
				$.each(result.extend.depts,function(){
					var optionEl = $("<option></option>").append(this.deptName).attr("value",this.deptId);
					optionEl.appendTo(ele);
				});
			}
		});
	}

//输入内容校验
function validate_form_input(){
	//1.校验用户名是否合法
	var empName = $("#empName_add").val();
	var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
	if(!regName.test(empName)){
		//alert("用户名必须为2-5位中文或者6-16位英文");
		show_validate_msg("#empName_add","error","用户名必须为2-5位中文或者6-16位英文");
		return false;
	}else{
		show_validate_msg("#empName_add","success","");
	}
	

	
	//2.校验邮箱格式是否正确
	var email = $("#email_add").val();
	var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
	if(!regEmail.test(email)){
		//alert("邮箱格式不合法!");
		show_validate_msg("#email_add","error","邮箱格式不合法!");
		return false;
	}else{
		show_validate_msg("#email_add","success","");
	}
	return true;
}

//校验输入数据方法
function show_validate_msg(ele,status,msg){
	$(ele).parent().removeClass("has-success has-error");
	$(ele).next("span").text("");
	if("success"==status){
		$(ele).parent().addClass("has-success");
		$(ele).next("span").text(msg);
	}else if("error==status"){
		$(ele).parent().addClass("has-error");
		$(ele).next("span").text(msg);
	}
}

//重置表单样式和内容
function form_reset(ele){
	$(ele)[0].reset();
	$(ele).find("*").removeClass("has-error has-success");
	$(ele).find(".help-block").text("");
}
//给员工姓名输入框绑定事件，当文本框内容发生变化是给服务端发送ajax请求
$("#empName_add").change(function(){
	//发送ajax请求查询用户名是否可用
	$.ajax({
		url:"${APP_PATH}/checkUser",
		data:"empName="+this.value,
		type:"POST",
		success:function(result){
			if(result.code ==100){
				show_validate_msg("#empName_add","success","用户名可用");
				$("#emp_save").attr("ajax-judge","success");
			}else{
				show_validate_msg("#empName_add","error",result.extend.va_msg);
				$("#emp_save").attr("ajax-judge","error");
			}
		}
		
	});
});
	
$("#emp_save").click(function(){
	//先进行校验几条数据是否合法，如果合法则进行插入操作，否则返回false
	 if(!validate_form_input()){
		return false;
	}  
	
	//对前一步的ajax校验结果进行判断
	if($(this).attr("ajax-judge")=="error"){
		return false;
	}
	
	$.ajax({
		url:"${APP_PATH}/emp",
		type:"POST",
		data:$("#form").serialize(),
		success:function(result){
			if(result.code ==100){
				$("#empAddModal").modal('hide');
				
				to_page(totalRecord);
			}else{
				if(undefined != result.extend.errorFiled.email){
					show_validate_msg("#email_add","error",result.extend.errorFiled.email);
				}
				if(undefined != result.extend.errorFiled.empName){
					show_validate_msg("#empName_add","error",result.extend.errorFiled.empName);
				}
			}
			
			
		}
	});
}); 

//定义方法得到员工信息
function getEmp(id){
	$.ajax({
		url:"${APP_PATH}/emp/"+id,
		type:"GET",
		success:function(result){
			var empdata = result.extend.emp;
			$("#static-empName").text(empdata.empName);
			$("#email_update").val(empdata.email);
			$("#empUpdateModal input[name=gender]").val([empdata.gender])
			$("#empUpdateModal select").val([empdata.dId]);
		}
	});
}
$(document).on("click",".edit_btn",function(){
	//点击编辑按钮之后，显示模态框，加载部门信息。和员工信息
	getDepts("#dept_update");
	//查处员工信息
	getEmp($(this).attr("edit-id"));
	//将员工ID值传送给更新按钮
	$("#emp_update").attr("edit-id",$(this).attr("edit-id"));
	//加载模态框
	$("#empUpdateModal").modal({
		backdrop:"static"
	});
	//
});

$("#emp_update").click(function(){
	var email = $("#email_update").val();
	var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
	if(!regEmail.test(email)){
		show_validate_msg("#email_update","error","邮箱格式不合法!");
		return false;
	}else{
		show_validate_msg("#email_update","success","");
	}
	//发送ajax请求
	$.ajax({
		url:"${APP_PATH}/emp/"+$(this).attr("edit-id"),
		type:"POST",
		//data:$("#empUpdateModal form").serialize(),
		data:$("#empUpdateModal form").serialize()+"&_method=put",
		success:function(result){
			//1.关闭模态框
			$("#empUpdateModal").modal("hide");
			//2.跳转至当前修改数据所在页
			to_page(currentPage);
		}
	});
});

//给删除按钮绑定事件
$(document).on("click",".delete_btn",function(){
	var empName = $(this).parents("tr").find("td:eq(2)").text();
	if(confirm("确认删除【"+empName+"】吗？")){
		$.ajax({
			url:"${APP_PATH}/emp/"+$(this).attr("delete-id"),
			type:"DELETE",
			success:function(result){
				alert(result.msg);
				to_page(currentPage);
			}
		});
	}
});

//当期全选按钮被点击时，当前页面的选择框呈现被选中状态
$("#check_all").click(function(){
	$(".check_btn").prop("checked",$(this).prop("checked"));
});
//当当前页的所有单选按钮被选中后，全选按钮也被选中
$(document).on("click",".check_btn",function(){
	var l = $(".check_btn:checked").length == $(".check_btn").length;
	$("#check_all").prop("checked",l);
});
//点击删除按钮，可以删除当前选中的员工信息
$("#emp_delete_all").click(function(){
	var empNames="";
	var del_idstr="";
	$.each($(".check_btn:checked"),function(){
		empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
		//删除多余的一个逗号
		del_idstr +=$(this).parents("tr").find("td:eq(1)").text()+"-";
	});
	 empNames = empNames.substring(0,empNames.length-1); 
	 del_idstr =del_idstr.substring(0,del_idstr.length-1);
	if(confirm("确认删除【"+empNames+"】吗？")){
		//点击确认之后，发送ajax请求
		$.ajax({
			url:"${APP_PATH}/emp/"+del_idstr,
			type:"DELETE",
			success:function(result){
				alert(result.msg);
				to_page(currentPage);
			}
		});
	} 
});
</script>
</body>
</html>