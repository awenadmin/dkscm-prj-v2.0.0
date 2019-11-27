<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../static/css/bootstrap.min.css">
  		<link rel="stylesheet" href="../static/css/font-awesome.min.css">
  		<script src="../static/js/jquery-3.4.1.min.js"></script>
		<script src="../static/js/bootstrap.min.js"></script>
		<script src="../static/js/jquery.validate.min.js"></script>
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
							url: "apply",
							type: "post",
							data: formdata,
							dataType: "json",
							success: function(data) {
								// 对于data得到的就是true、false
								if (data) {
									alert("申请提交成功，请等待后续流程！");
									// 关闭窗口，重定向到列表页面
									parent.closeModal();
									location.href="APPLY/index";
								} else {
									alert("申请提交失败，请稍后再试！");
									parent.closeModal();
								}
							}
						});
					},
					// 校验规则
					rules: {
						goodsName: {
							required: true
						},
						applyQuantity: {
							required: true,
							number: true,
							min: 0.01
						}
					},
					// 报错信息
					messages: {
						goodsName: {
							required: "请填写物资名称"
						},
						applyQuantity: {
							required: "请填写采购数量",
							number: "请正确填写采购数量",
							min: "采购数量至少为0.01"
						}
					}
				});
			});
		</script>
	</head>
	<body>
			<div class="row">
				<div class="col-md-12" style="margin: 30px auto;">
					<form id="myForm" role="form">
						<table style="border-collapse: separate; border-spacing: 5px; margin: 0 auto;">
							<tr>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-gift"></i>
									<label>物资名称：</label>
								</td>
								<td colspan="3" style="padding: 0px 5px;">
									<input type="text" id="goodsName" name="goodsName" class="form-control" style="width: 300px;"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3">
									<label for="goodsName" class="error" style="color: red;"></label>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-shopping-bag"></i>
									<label>品牌：</label>
								</td>
								<td colspan="3" style="padding: 0px 5px;">
									<input type="text" id="goodsBand" name="goodsBand" class="form-control" style="width: 300px;"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3">
									<label for="goodsBand" class="error" style="color: red;"></label>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-shopping-basket"></i>
									<label>型号：</label>
								</td>
								<td colspan="3" style="padding: 0px 5px;">
									<input type="text" id="goodsType" name="goodsType" class="form-control" style="width: 300px;"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3">
									<label for="goodsType" class="error" style="color: red;"></label>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-cart-plus"></i>
									<label>购买数量：</label>
								</td>
								<td style="padding: 0px 5px;">
									<input type="text" id="applyQuantity" name="applyQuantity" class="form-control" style="width: 100px;"/>
								</td>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-balance-scale"></i>
									<label>计量单位：</label>
								</td>
								<td style="padding: 0px 5px;">
									<input type="text" id="goodsUnit" name="goodsUnit" class="form-control" style="width: 70px;"/>
								</td>
							</tr>
							<tr>
								<td colspan="2" style="text-align: right;">
									<label for="applyQuantity" class="error" style="color: red;"></label>
								</td>
								<td colspan="2" style="text-align: right;">
									<label for="goodsUnit" class="error" style="color: red;"></label>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-jpy"></i>
									<label>总费用：</label>
								</td>
								<td colspan="3" style="padding: 0px 5px;">
									<div class="input-group">
										<input type="text" id="budget" name="budget" class="form-control" style="width: 250px;"/>
	            						<span class="input-group-addon">&nbsp;元</span>
            						</div>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3">
									<label for="budget" class="error" style="color: red;"></label>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">
									<span style="color: red;">*</span>
									<i class="fa fa-file-text-o"></i>
									<label>购买说明：</label>
								</td>
								<td colspan="3" style="padding: 0px 5px;">
									<input type="text" id="applyRemark" name="applyRemark" class="form-control" style="width: 300px;"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3">
									<label for="applyRemark" class="error" style="color: red;"></label>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align: right;">
									<button id="submitBtn" type="submit" class="btn btn-success">
										<i class="fa fa-cart-arrow-down"></i>
										申请购买
									</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12" style="text-align: center;">
					<h3 id="result"></h3>
				</div>
			</div>	
	</body>
</html>
