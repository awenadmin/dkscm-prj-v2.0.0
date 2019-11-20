<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.min.css">
  		<link rel="stylesheet" type="text/css" href="../static/css/font-awesome.min.css">
  		<link rel="stylesheet" type="text/css" href="../static/css/ionicons.min.css">
  		<link rel="stylesheet" type="text/css" href="../static/css/AdminLTE.min.css">
		<script type="text/javascript" src="../static/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
	</head>
	<body class="hold-transition login-page">
		<div class="login-box">
  			<div class="login-logo">
    			<a href="#"><b>DK采购供应链</b></a>
  			</div>
  			<div class="login-box-body">
    			<p class="login-box-msg">请输入您的登录信息进入系统</p>
    			<form action="login" method="post">
      				<div class="form-group has-feedback">
        				<input type="text" name="username" class="form-control" placeholder="请输入您的手机号码">
        				<span class="glyphicon glyphicon-phone form-control-feedback"></span>
      				</div>
      				<div class="form-group has-feedback">
        				<input type="password" name="password" class="form-control" placeholder="请输入您的登录密码">
        				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
      				</div>
      				<div class="row">
        				<div class="col-xs-8"></div>
        				<div class="col-xs-4">
          					<button type="submit" class="btn btn-primary btn-block btn-flat">
          						进入系统
         					</button>
        				</div>
      				</div>
    			</form>
    			<div class="social-auth-links text-center">
      				<p></p>
    			</div>
    			<a href="#">忘记密码</a><br>
  			</div>
		</div>
	</body>
</html>