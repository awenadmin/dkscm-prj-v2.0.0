    
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../../static/css/bootstrap.min.css">
  		<link rel="stylesheet" href="../../static/css/font-awesome.min.css">
  		<script src="../../static/js/jquery-3.4.1.min.js"></script>
		<script src="../../static/js/bootstrap.min.js"></script>
		<script src="../../static/js/jquery.validate.min.js"></script>
		<title></title>
		<script type="text/javascript">
			$(function() {
				$("#myForm").validate({
					// 如果jQuery.Validation框架全部校验成功，则会同步提交数据，
					// 为了能够阻止同步提交，则需要更改submit动作
					submitHandler: function(form) {
						// 该属性将会阻止数据的提交，而是转向调用本函数，因此可以在该函数中进行异步提交
						// 使用jQuery的serialize函数将表单数据进行格式化
						var formdata = $("#myForm").serialize();
						// 获得所有数据之后，就可以进行异步提交
						$.ajax({
							url: "../buy",
							type: "post",
							data: formdata,
							dataType: "json",
							success: function(data) {
								if (data) {
									alert("购买成功！");
								} else {
									alert("购买失败！");
								}
								// 关闭模态框
								parent.closeModal();
								// 页面重定向
								parent.openFrame("purchase/REVIEW/index", "fa fa-cart-plus", "物资采购", "物资购买");
							}
						});
					},
					// 校验规则
					rules: {
						
					},
					// 报错信息
					messages: {
						
					}
				});
			});
		</script>
	</head>
	<body>
		<div class="container" style="margin: 5px;">
			<div class="row">
				<div class="col-md-12">
					<form id="myForm" role="form">
						<table style="border-collapse: separate; border-spacing: 5px;">
							<tr>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-copyright"></i>
									<label>购买品牌：</label>
								</td>
								<td colspan="3" style="padding: 0px 5px;">
									<input type="text" id="purchaseBand" name="purchaseBand" class="form-control" style="width: 300px;"/>
									<input type="hidden" name="purchaseId" value="${purchaseId }">
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3">
									<label for="purchaseBand" class="error" style="color: red;"></label>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-tags"></i>
									<label>购买型号：</label>
								</td>
								<td colspan="3" style="padding: 0px 5px;">
									<input type="text" id="purchaseType" name="purchaseType" class="form-control" style="width: 300px;"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3">
									<label for="purchaseType" class="error" style="color: red;"></label>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-cubes"></i>
									<label>购买数量：</label>
								</td>
								<td colspan="3" style="padding: 0px 5px;">
									<input type="text" id="purchaseQuantity" name="purchaseQuantity" class="form-control" style="width: 100px;"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3" style="text-align: right;">
									<label for="purchaseQuantity" class="error" style="color: red;"></label>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-money"></i>
									<label>总费用：</label>
								</td>
								<td colspan="3" style="padding: 0px 5px;">
									<div class="input-group">
										<input type="text" id="purchaseAmount" name="purchaseAmount" class="form-control" style="width: 250px;"/>
	            						<span class="input-group-addon">&nbsp;元</span>
            						</div>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3">
									<label for="purchaseAmount" class="error" style="color: red;"></label>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-align-justify"></i>
									<label>采购备注：</label>
								</td>
								<td colspan="3" style="padding: 0px 5px;">
									<input type="text" id="purchaseRemark" name="purchaseRemark" class="form-control" style="width: 300px;"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3">
									<label for="purchaseRemark" class="error" style="color: red;"></label>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align: right;">
									<button id="submitBtn" type="submit" class="btn btn-success">
										<i class="fa fa-plus"></i>
										采购完成
									</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>		
		</div>
	</body>
</html>