<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../../static/css/bootstrap.min.css">
  		<link rel="stylesheet" href="../../static/css/font-awesome.min.css">
  		<link rel="stylesheet" href="../../static/css/table.css">
  		<link rel="stylesheet" href="../../static/css/font-awesome.min.css">
  		<script src="../../static/js/jquery-3.4.1.min.js"></script>
		<script src="../../static/js/bootstrap.min.js"></script>
		<script src="../../static/js/jquery.validate.min.js"></script>
		<script type="text/javascript">
		$(function() {
			$("#myform").validate({
				submitHandler: function(form) {
					var formData = $("#myform").serialize();
					$.ajax({
						url: "",
						type: "post",
						data: formData,
						dataType: "json",
						success: function(data) {
							if (data) {
								alert("职务变更成功！");
							} else {
								alert("职务变更成功！");
							}
							// 关闭模态框
							parent.closeModel();
							// 页面重定向
							parent.openContent("user/index");
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
					<form id="myform" role="form">
						<table class="table">
	                		<tbody>
	                      		<tr>
	                      			<td style="width: 120px;text-align: right;">员工编号:</td>
	                      			<td colspan="3">
	                      				<input name="userNo" value="${user.userNo }" readonly="readonly" class="form-control">
	                      			</td>
	                      		</tr>
	                      		<tr>
	                      			<td style="width: 120px;text-align: right;">员工姓名:</td>
	                      			<td colspan="3">
	                      				<input name="username" value="${user.username }" readonly="readonly" class="form-control">
	                      			</td>
	                      			
	                      		</tr>
	                      		<tr>
	                      			<td style="width: 120px;text-align: right;">当前职位:</td>
	                      			<td colspan="2">
										<select name="roleId" class="form-control">
									    	<option>${user.role.roleName }</option>
									      	<option id="roleId" value="2">物资员</option>
									      	<option id="roleId" value="3">采购科</option>
									      	<option id="roleId" value="4">仓库科</option>
									    </select>
									</td>
	                      			
	                      		</tr>
	                      		<tr>
	                      			<td style="width: 120px;text-align: right;">入职时间:</td>
	                      			<td colspan="3">
										<fmt:formatDate value="${user.createTime }" pattern="yyyy年MM月dd日" />
									</td>
	                      		</tr>
	                      		<tr>
	                      			<td colspan="4" align="right">
		                      			<div class="modal-footer" >
					                        <button id="add_btn" type="submit" class="btn btn-secondary">职务变更</button>
					                    </div>
	                      			</td>
	                      		</tr>
	                      	</tbody>
	                  	</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>