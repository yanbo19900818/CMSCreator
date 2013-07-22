<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>欢迎页	</title>
     <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="<%=request.getContextPath() %>/js/jquery-1.7.min.js"></script>
    <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body>
<jsp:include page="header.jsp"/>
	<div class="row-fluid">
		<div class="span4">
			<ul class="nav nav-list">
				<li class="active">
					<a href="#">首页</a>
				</li>
				<li>
					<a href="#">库</a>
				</li>
				<li>
					<a href="#">应用</a>
				</li>
				<li class="nav-header">
					功能列表
				</li>
				<li>
					<a href="#">资料</a>
				</li>
				<li>
					<a href="#">设置</a>
				</li>
				<li class="divider">
				</li>
				<li>
					<a href="#">帮助</a>
				</li>
			</ul>
		</div>
		<div class="span8">
		</div>
	</div>
</div>
  </body>
</html>
