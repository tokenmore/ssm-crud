<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工信息显示</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/jquery-3.1.1.min.js"></script>
</head>
<body>
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
				<button class="btn btn-primary">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				新增</button>
				<button class="btn btn-danger">
				<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
				删除</button>
			</div>
		</div>
		<!--显示表格数据  -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					 <tr>
					 	<th>员工ID</th>
					 	<th>姓名</th>
					 	<th>性别</th>
					 	<th>邮箱</th>
					 	<th>部门</th>
					 	<th>操作</th>
					 </tr>
					 <c:forEach items="${pageinfo.list}" var="emp">
					 	<tr>
					 	<th>${emp.empId }</th>
					 	<th>${emp.empName }</th>
					 	<th>${emp.gender }</th>
					 	<th>${emp.email }</th>
					 	<th>${emp.dept.deptName }</th>
					 	<th>
					 		<button class="btn btn-primary btn-sm">
					 		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					 		编辑</button>
					 		<button class="btn btn-danger btn-sm">
					 		<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
						 		删除</button>
					 	</th>
					 </tr>
					 </c:forEach>
				</table>
			</div>
		</div>
		<!--  显示分页信息-->
		<div class="row">
			<!-- 分页文本信息 -->
			<div class="col-md-6">
				当前页：${pageinfo.pageNum}页，共有${pageinfo.pages}页，共有${pageinfo.total}条记录
			</div>
			<!-- 分页条 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				<ul class="pagination">
				<li><a href="${APP_PATH}/emps?pn=1">首页</a></li>
					<c:if test="${pageinfo.hasPreviousPage}">
						<li><a href="${APP_PATH }/emps?pn=${pageinfo.pageNum-1 }" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					</c:if>
					
					<c:forEach items="${pageinfo.navigatepageNums}" var="page_Num">
						<c:if test="${page_Num ==pageinfo.pageNum}">
							<li class="active"><a href="#">${page_Num }</a></li>
						</c:if>
						<c:if test="${page_Num !=pageinfo.pageNum}">
							<li><a href="${APP_PATH}/emps?pn=${page_Num}">${page_Num }</a></li>
						</c:if>
						
					</c:forEach>
					
					<c:if test="${pageinfo.hasNextPage}">
						<li><a href="${APP_PATH}/emps?pn=${pageinfo.pageNum+1}" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
					</c:if>
					
					<li><a href="${APP_PATH}/emps?pn=${pageinfo.pages}">尾页</a></li>
				</ul>
				</nav>
				
			</div>
		</div>
	</div>
</body>
</html>