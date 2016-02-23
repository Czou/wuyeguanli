<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>巡检管理</title>
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
		<li class="active"><a href="${ctx}/xunjian_jilu/xunjianJilu/">巡检列表</a></li>
		<shiro:hasPermission name="xunjian_jilu:xunjianJilu:edit">
		<!--li><a href="${ctx}/xunjian_jilu/xunjianJilu/form">巡检添加</a></li-->
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="xunjianJilu" action="${ctx}/xunjian_jilu/xunjianJilu/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>任务id：</label>
				<form:input path="xunjianid" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li><label>巡检备注：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>任务id</th>
				<th>巡检状态</th>
				<th>更新者</th>
				<th>update_date</th>
				<th>巡检备注</th>
				<shiro:hasPermission name="xunjian_jilu:xunjianJilu:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xunjianJilu">
			<tr>
				<td>
					${xunjianJilu.xunjianid}
				</td>
				<td>
					${xunjianJilu.xunjianstatus}
				</td>
				<td>
					${xunjianJilu.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${xunjianJilu.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${xunjianJilu.remarks}
				</td>
				<shiro:hasPermission name="xunjian_jilu:xunjianJilu:edit"><td>
    				<a href="${ctx}/xunjian_jilu/xunjianJilu/form?id=${xunjianJilu.id}">修改</a>
					<a href="${ctx}/xunjian_jilu/xunjianJilu/delete?id=${xunjianJilu.id}" onclick="return confirmx('确认要删除该巡检吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>