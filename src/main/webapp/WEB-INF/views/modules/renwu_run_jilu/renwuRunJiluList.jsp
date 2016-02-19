<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>执行情况管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
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
		<li class="active"><a href="${ctx}/renwu_run_jilu/renwuRunJilu/">执行情况列表</a></li>
		<shiro:hasPermission name="renwu_run_jilu:renwuRunJilu:edit"><li><a href="${ctx}/renwu_run_jilu/renwuRunJilu/form">执行情况添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="renwuRunJilu" action="${ctx}/renwu_run_jilu/renwuRunJilu/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>任务id：</label>
				<form:input path="renwu.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>完成情况：</label>
				<form:radiobuttons path="wanchengqk" items="${fns:getDictList('abc')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>完成情况</th>
				<shiro:hasPermission name="renwu_run_jilu:renwuRunJilu:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="renwuRunJilu">
			<tr>
				<td><a href="${ctx}/renwu_run_jilu/renwuRunJilu/form?id=${renwuRunJilu.id}">
					${renwuRunJilu.renwu.id}
				</a></td>
				<td>
					${fns:getDictLabel(renwuRunJilu.wanchengqk, 'abc', '')}
				</td>
				<shiro:hasPermission name="renwu_run_jilu:renwuRunJilu:edit"><td>
    				<a href="${ctx}/renwu_run_jilu/renwuRunJilu/form?id=${renwuRunJilu.id}">修改</a>
					<a href="${ctx}/renwu_run_jilu/renwuRunJilu/delete?id=${renwuRunJilu.id}" onclick="return confirmx('确认要删除该执行情况吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>