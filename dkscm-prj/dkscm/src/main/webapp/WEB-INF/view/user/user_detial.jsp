<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../static/css/bootstrap.min.css">
  		<link rel="stylesheet" href="../static/css/font-awesome.min.css">
  		<link rel="stylesheet" href="../static/css/table.css">
  		<script src="../static/js/jquery-3.4.1.min.js"></script>
		<script src="../static/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			function backIndex() {
				parent.location.reload();
			}
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row" >
				<div class="row" >
					<div class="col-md-12">
						<h1 style="margin-top: 30px">
						<i class='fa fa-telegram'></i>&nbsp;用户个人信息
					</h1>
					</div>
				</div>
				<div class="col-md-12">
					<table class="table">
                		<tbody>
                      		<tr>
                      			<td style="width: 120px;text-align: right;">员工编号:</td>
                      			<td colspan="3">${user.userNo }</td>
                      		</tr>
                      		<tr>
                      			<td style="width: 120px;text-align: right;">员工姓名:</td>
                      			<td colspan="3">${user.username }</td>
                      			
                      		</tr>
                      		<tr>
                      			<td style="width: 120px;text-align: right;">联系电话:</td>
                      			<td colspan="3">${user.cellphone }</td>
                      		</tr>
                      		<tr>
                      			<td style="width: 120px;text-align: right;">员工职位:</td>
                      			<td colspan="3">${user.role.roleName }</td>
                      			
                      		</tr>
                      		<tr>
                      			<td style="width: 120px;text-align: right;">身份证号码:</td>
                      			<td colspan="3">${user.idCard }</td>
                      		</tr>
                      		<tr>
                      			<td style="width: 120px;text-align: right;">电子邮件:</td>
                      			<td colspan="3">${user.email }</td>
                      		</tr>
                      		<tr>
                      			<td style="width: 120px;text-align: right;">员工状态:</td>
                      			<td colspan="3">
                      				<c:choose>
                      					<c:when test="${user.status.statusCode == 'ENABLE' }">在职</c:when>
                      					<c:otherwise>离职</c:otherwise>
                      				</c:choose>
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
				                        <a href="javascript:backIndex();" id="add_btn" type="button" class="btn btn-secondary">返回</a>
				                    </div>
                      			</td>
                      		</tr>
                      	</tbody>
                  	</table>
				</div>
			</div>
		</div>
	</body>
</html>