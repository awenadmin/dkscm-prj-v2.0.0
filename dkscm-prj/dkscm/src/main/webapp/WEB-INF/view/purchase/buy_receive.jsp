<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../../static/css/bootstrap.min.css">
  		<link rel="stylesheet" href="../../static/css/font-awesome.min.css">
  		<link rel="stylesheet" href="../../static/DataTables/DataTables-1.10.20/css/jquery.dataTables.min.css">
  		<script src="../../static/js/jquery-3.4.1.min.js"></script>
		<script src="../../static/js/bootstrap.min.js"></script>
		<script src="../../static/DataTables/DataTables-1.10.20/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript">
			
		</script>
	</head>
	<body>
		<div class="container" style="margin: 0px;">
			<div class="row" style="padding-top: 10px;">
				<div class="col-md-12">
					<table id="mytable" class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>申请编号</th>
								<th>物资名称</th>
								<th>数量</th>
								<th>预算</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${purchase.purchaseNo }</td>
								<td>${purchase.goodsName }</td>
								<td>${purchase.applyQuantity }</td>
								<td>${purchase.budget }</td>
							</tr>
						</tbody>
					</table> 
				</div>
			</div>
		</div>
	</body>
</html>