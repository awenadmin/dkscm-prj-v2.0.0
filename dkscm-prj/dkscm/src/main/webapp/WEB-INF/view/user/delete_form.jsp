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
  		<script src="../../static/js/jquery-3.4.1.min.js"></script>
		<script src="../../static/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			function review(statusCode) {
				$.ajax({
					url: "",
					type: "post",
					data: {
						"statusCode": statusCode
					},
					dataType: "json",
					success: function(data) {
						if (data) {
							alert("信息更改成功！");
						} else {
							alert("信息更改失败！");
						}
						// 关闭模态框
						parent.closeModal();
						// 页面重定向
						parent.location.reload();
					}
				});
			};
			function backIndex() {
				parent.closeModal();
			}
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row" >
				<div class="col-md-12">
					确定要辞去
						<label style="font-weight: bold; font-size: 18px">${user.username}</label>&nbsp;
					吗？
				</div>
				<div class="col-md-12">
					<div class="modal-footer" style="border: none;">
						<a href="javascript:backIndex();" type="button" class="btn btn-secondary" data-dismiss="modal">返回</a>
					    <a href="javascript:review('DISABLE');" id="add_btn" type="button" class="btn btn-secondary">确认</a>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>