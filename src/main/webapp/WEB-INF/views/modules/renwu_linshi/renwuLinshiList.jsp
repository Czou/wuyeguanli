<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>临时任务管理</title>
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
		<li class="active"><a href="${ctx}/renwu_linshi/renwuLinshi/">临时任务列表</a></li>
		<shiro:hasPermission name="renwu_linshi:renwuLinshi:edit"><li><a href="${ctx}/renwu_linshi/renwuLinshi/form">临时任务添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="renwuLinshi" action="${ctx}/renwu_linshi/renwuLinshi/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="mingcheng" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>任务责任人</th>
				<th>结束时间</th>
				<th>任务状态</th>
				<shiro:hasPermission name="renwu_linshi:renwuLinshi:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="renwuLinshi">
			<tr>
				<td><a href="${ctx}/renwu_linshi/renwuLinshi/form?id=${renwuLinshi.id}">
					${renwuLinshi.mingcheng}
				</a></td>
				<td>
					${renwuLinshi.taskuser.name}
				</td>
				<td>
					<fmt:formatDate value="${renwuLinshi.jieshusj}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${renwuLinshi.taskstatus==1?'已完成':'未完成'}
				</td>
				<shiro:hasPermission name="renwu_linshi:renwuLinshi:edit"><td>
    				<c:if test="${renwuLinshi.taskstatus==0}">
    				<a href="${ctx}/renwu_linshi/renwuLinshi/form?id=${renwuLinshi.id}">修改</a>
					<a href="${ctx}/renwu_linshi/renwuLinshi/delete?id=${renwuLinshi.id}" onclick="return confirmx('确认要删除该临时任务吗？', this.href)">删除</a>
					<a href="${ctx}/renwu_linshi/renwuLinshi/chuli?id=${renwuLinshi.id}">处理</a>
    				</c:if>
    				<c:if test="${renwuLinshi.taskstatus==1}">
    				<a href="${ctx}/renwu_linshi/renwuLinshi/chuli?id=${renwuLinshi.id}">查看</a>
    				</c:if>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>