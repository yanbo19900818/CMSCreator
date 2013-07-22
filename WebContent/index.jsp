<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>欢迎页</title>
<link
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="screen" />
<script src="<%=request.getContextPath()%>/js/jquery-1.7.min.js"></script>
<script
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<link href="<%=request.getContextPath()%>/css/right.css"
	rel="stylesheet" media="screen" />
</head>

<body>
	<div class="container-fluid">
		<jsp:include page="header.jsp" />
		<div class="row-fluid">
			<jsp:include page="right.jsp" />
			<div class="span9"></div>
		</div>
	</div>
</body>
</html>
