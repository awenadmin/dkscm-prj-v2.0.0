<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../static/css/bootstrap.min.css">
  		<link rel="stylesheet" href="../static/css/font-awesome.min.css">
  		<link rel="stylesheet" href="../static/DataTables/DataTables-1.10.20/css/jquery.dataTables.min.css">
  		<script src="../static/js/jquery-3.4.1.min.js"></script>
		<script src="../static/js/bootstrap.min.js"></script>
		<script src="../static/DataTables/DataTables-1.10.20/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#mytable").DataTable({
					// 关闭本地分页
					paging: false,
					// 关闭搜索框
					searching: false,
					// 关闭排序
					ordering: false,
					// 设定表格的数据是通过异步方式获得
					serverSide: true,
					// 获取表格地址
					ajax: {
						// 请求地址
						url: "list",
						// 请求方式
						type: "post",
						// 设定在请求列表的时候，所需要携带的请求参数
						data: function(d) {
							// 获得对应的设置信息
							var tableSetings = $("#mytable").dataTable().fnSettings();
							// 删除多余请求参数
							for(var key in d) { 
								if(key.indexOf("columns")==0||key.indexOf("order")==0||key.indexOf("search")==0){ 
									//以columns开头的参数删除
									delete d[key]; 
								} 
							}
							// 扩展请求时候的数据，重点在于pageNum和pageSize
							var params = {
									// 获得表格对象后，
									// 系统当前页码_iDisplayStart，默认从0开始
									"pageNum": tableSetings._iDisplayStart + 1,
									// 每页显示数量
									"pageSize": tableSetings._iDisplayLength
							}
							// 将新增的查询数据扩展到请求参数上
							$.extend(d, params); //给d扩展参数
						},
						// 设定回传的数据格式为JSON
						dataType: "json",
						// 过滤数据
						dataFilter: function(data) {
							data = JSON.parse(data);
							var returnData = {};
							returnData.draw = data.draw;
							returnData.recordsTotal = data.totalSize;
							returnData.recordsFiltered = data.totalSize;
							returnData.data = data.list;
							return JSON.stringify(returnData);
						}
					},
					// 为表格的每一个字段设定具体的值
					columnDefs: [{
						targets: 0,
						data: function (row, type, val, meta) {
							// 在序号位置
							var tableSetings = $("#mytable").dataTable().fnSettings();
							var begin = tableSetings._iDisplayStart;
							var size = tableSetings._iDisplayLength;
							return begin * size + begin + meta.row + 1;
						}
					}, {
						targets: 1,
						data: function (row, type, val, meta) {
							// 在序号位置，row就代表JSON中list所对应的一个位置的数据对象
							return row.roleName;
						}
					},{
						targets: 2,
						data: function (row, type, val, meta) {
							var detialBtn = "<a href='javascript:openModel(" + row.roleId + ");' class='btn btn-success btn-xs'><i class=''></i>查看详情</a>&nbsp;";
							var updateBtn = "<a href='javascript:openModel(" + row.roleId + ");' class='btn btn-success btn-xs'><i class=''></i>权限更改</a>&nbsp;";
							return detialBtn + "&nbsp;" + updateBtn;
						}
					}],
					//设置语言
					language: {
				        "sProcessing": "处理中...",
				        "sLengthMenu": "显示 _MENU_ 项结果",
				        "sZeroRecords": "没有匹配结果",
				        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
				        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
				        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
				        "sInfoPostFix": "",
				        "sSearch": "搜索:",
				        "sUrl": "",
				        "sEmptyTable": "表中数据为空",
				        "sLoadingRecords": "载入中...",
				        "sInfoThousands": ",",
				        "oPaginate": {
				            "sFirst": "首页",
				            "sPrevious": "上页",
				            "sNext": "下页",
				            "sLast": "末页"
				        },
				        "oAria": {
				            "sSortAscending": ": 以升序排列此列",
				            "sSortDescending": ": 以降序排列此列"
				        }
				    }
				});
			});
			function openModel(roleId) {
				var url = "role/detial_form/" + roleId;
				var width = "650px";
				var height = "560px";
				var titleHTML = "<i class='fa fa-telegram'></i>&nbsp;申请物资审批";
				parent.showModel(url, width, height, titleHTML);
			}
		</script>
	</head>
	<body style="background: url('../static/images/bg.jpg') repeat-y center 40px;">
		<div class="container">
			<div class="row" >
				<div class="col-md-12">
					<h1>
						<i class="fa fa-shopping-cart"></i>
						职务信息
					</h1>
				</div>	
			</div>
			<div class="row">
				<div class="col-md-12">
					<table id="mytable" style="border-top: 1px solid;" class="table table-striped table-hover">
						<thead>
							<tr>
								<th>序号</th>
								<th>岗位名称</th>
								<th>操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>
	