<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>菜单管理</title>
</head>
	<!-- 如果使用frameset的包含页面  主页面不能有body -->
	<frameset cols="250,*" border="1">
		<frame src="${ctx }/sys/toMenuLeft.action" name="left">
		<frame src="${ctx }/sys/toMenuRight.action" name="right">
	</frameset>
</html>