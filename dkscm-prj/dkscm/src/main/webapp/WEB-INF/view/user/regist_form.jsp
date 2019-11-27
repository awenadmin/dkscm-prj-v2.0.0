<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../static/css/bootstrap.min.css">
		<link rel="stylesheet" href="../static/css/table.css">
  		<link rel="stylesheet" href="../static/css/font-awesome.min.css">
  		<script src="../static/js/jquery-3.4.1.min.js"></script>
		<script src="../static/js/bootstrap.min.js"></script>
		<script src="../static/js/jquery.validate.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#myform").validate({
					submitHandler: function(form) {
						var formData = $("#myform").serialize();
						$.ajax({
							url: "regist_form",
							type: "post",
							data: formData,
							dataType: "json",
							success: function(data) {
								if (data) {
									alert("采购订单申请成功！");
									location.href = "index";
								} else {
									alert("采购订单申请失败！");
								}
							}
						});
					},
					rules:{
						
						
					},
					messages:{
						
					}
				});
			});
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row" >
				<div class="col-md-12">
					<h1>
						<i class="fa fa-shopping-cart"></i>
						新增员工信息
					</h1>
				</div>
			</div>
			<div class="row" >
				<div class="col-md-12">
					<form id="myform" role="form">
						<table class="table">
							<tr>
								<td>员工编号：</td>
								<td>
									<input type="text" name="userNo" id="userNo" class="form-control" value="${userNo }" readonly="readonly">
								</td>
							</tr>
							<tr>
								<td>员工姓名</td>
								<td>
									<input type="text" name="username" id="username" class="form-control" placeholder="请输入员工姓名">
								</td>
							</tr>
							<tr>
								<td>手机号码</td>
								<td>
									<input type="text" name="cellphone" id="cellphone" class="form-control" placeholder="请输入员工手机号码">
								</td>
							</tr>
							<tr>
								<td>初始密码</td>
								<td>
									<input type="password" name="password" id="password" value="admin" readonly="readonly" class="form-control">
								</td>
							</tr>
							<tr>
								<td>员工职务</td>
								<td>
								    <select name="roleId" class="form-control">
								    	<option id="roleId" value="0">——请选择职务——</option>
								      	<option id="roleId" value="2">物资员</option>
								      	<option id="roleId" value="4">采购科</option>
								      	<option id="roleId" value="5">仓库科</option>
								    </select>
								</td>
							</tr>
							<tr>
								<td>
									<button type="submit" class="btn btn-primary">确认</button>
								</td>
							</tr>
						</table>
					</form>
				</div>		
			</div>
		</div>
	</body>
</html>