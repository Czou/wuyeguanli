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
			<li><label>任务名称：</label>
				<form:input path="xunjian.leixing" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li><label>备注：</label>
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
				<th>任务名称</th>
				<th>巡检地点</th>
				<th>巡检人</th>
				<th>巡检时间</th>
				<th>巡检状态</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xunjianJilu">
			<tr>
				<td>
					${xunjianJilu.xunjian.leixing}
				</td>
				<td>
					${xunjianJilu.xunjian.mingcheng}
				</td>
				<td>
					${xunjianJilu.updateBy.name}
				</td>
				<td>
					<fmt:formatDate value="${xunjianJilu.xunjiansj}" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
				<td>
					${xunjianJilu.xunjianstatus==0?'<font color="red">×</font>':'<font color="green">√</font>'}
				</td>
				<td>
					${xunjianJilu.remarks}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>