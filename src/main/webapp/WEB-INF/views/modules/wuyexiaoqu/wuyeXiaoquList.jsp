<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小区信息管理</title>
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
		<li class="active"><a href="${ctx}/wuyexiaoqu/wuyeXiaoqu/">小区信息列表</a></li>
		<shiro:hasPermission name="wuyexiaoqu:wuyeXiaoqu:edit"><li><a href="${ctx}/wuyexiaoqu/wuyeXiaoqu/form">小区信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="wuyeXiaoqu" action="${ctx}/wuyexiaoqu/wuyeXiaoqu/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
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
				<th width="200px">物业公司</th>
				<th>名称</th>
				<th>负责人</th>
				<th>联系人</th>
				<th>值班电话</th>
				<th>户数</th>
				<shiro:hasPermission name="wuyexiaoqu:wuyeXiaoqu:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="wuyeXiaoqu">
			<tr>
				<td>
					${wuyeXiaoqu.wuye.mingcheng}
				</td>
				<td><a href="${ctx}/wuyexiaoqu/wuyeXiaoqu/form?id=${wuyeXiaoqu.id}">
					${wuyeXiaoqu.mingcheng}
				</a></td>
				<td>
					${wuyeXiaoqu.fuzeren}
				</td>
				<td>
					${wuyeXiaoqu.lianxiren}
				</td>
				<td>
					${wuyeXiaoqu.zhibandh}
				</td>
				<td>
					${wuyeXiaoqu.hushu}
				</td>
				<shiro:hasPermission name="wuyexiaoqu:wuyeXiaoqu:edit"><td>
    				<a href="${ctx}/wuyexiaoqu/wuyeXiaoqu/form?id=${wuyeXiaoqu.id}">修改</a>
					<a href="${ctx}/wuyexiaoqu/wuyeXiaoqu/delete?id=${wuyeXiaoqu.id}" onclick="return confirmx('确认要删除该小区信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>