<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>巡检点管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/xunjian_dict/xunjianDict/">巡检点列表</a></li>
		<shiro:hasPermission name="xunjian_dict:xunjianDict:edit"><li><a href="${ctx}/xunjian_dict/xunjianDict/form">巡检点添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="xunjianDict" action="${ctx}/xunjian_dict/xunjianDict/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>巡检任务：</label>
				<form:select id="leixing" path="leixing" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${leixingList}" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>巡检地点：</label>
				<form:input path="mingcheng" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>巡检任务</th>
				<th>巡检地点</th>
				<th>顺序</th>
				<shiro:hasPermission name="xunjian_dict:xunjianDict:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xunjianDict">
			<tr>
				<td>
					<a href="${ctx}/xunjian_jilu/xunjianJilu/form?xunjian.leixing=${xunjianDict.leixing}">${xunjianDict.leixing}</a>
				</td>
				<td><a href="${ctx}/xunjian_dict/xunjianDict/form?id=${xunjianDict.id}">
					${xunjianDict.mingcheng}
				</a></td>
				<td>
					${xunjianDict.shunxu}
				</td>
				<shiro:hasPermission name="xunjian_dict:xunjianDict:edit"><td>
    				<a href="${ctx}/xunjian_dict/xunjianDict/form?id=${xunjianDict.id}">修改</a>
					<a href="${ctx}/xunjian_dict/xunjianDict/delete?id=${xunjianDict.id}" onclick="return confirmx('确认要删除该巡检点吗？', this.href)">删除</a>
					<a href="<c:url value='${fns:getAdminPath()}/xunjian_dict/xunjianDict/form?shunxu=${xunjianDict.shunxu+10}'><c:param name='leixing' value='${xunjianDict.leixing}'/></c:url>">添加地点</a>
					<a href="${ctx}/xunjian_dict/xunjianDict/print?leixing=${xunjianDict.leixing}">打印</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>