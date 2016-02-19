<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>巡检点打印</title>
	<meta name="decorator" content="default"/>
	<link href="${ctxStatic }/jquery-plugin/print.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="${ctxStatic }/jquery-plugin/jquery.PrintArea.js"></script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/xunjian_dict/xunjianDict/">巡检点列表</a></li>
		<li class="active"><a href="${ctx}/xunjian_dict/xunjianDict/form?id=${xunjianDict.id}">巡检点打印</a></li>
	</ul><br/>
	<div id="printContent">
		<c:forEach items="${xunjianList }" var="o" >
			<img alt="" src="${pageContext.request.contextPath}/userfiles/${o.id }.jpg" /><br>
			${o.mingcheng }<br/>
		</c:forEach>
	</div>
	<input onclick="javascript:$('#printContent').printArea();" class="btn btn-primary" value="打 印"/>
</body>
</html>