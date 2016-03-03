<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公司信息管理</title>
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
		<li class="active"><a href="${ctx}/wuye_gongsi/sysOffice/">公司信息列表</a></li>
		<shiro:hasPermission name="wuye_gongsi:sysOffice:edit"><li><a href="${ctx}/wuye_gongsi/sysOffice/form">公司信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysOffice" action="${ctx}/wuye_gongsi/sysOffice/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
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
				<th>电话</th>
				<th>负责人</th>
				<th>联系地址</th>
				<th>公司人数</th>
				<th>邮政编码</th>
				<th>传真</th>
				<th>邮箱</th>
				<shiro:hasPermission name="wuye_gongsi:sysOffice:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysOffice">
			<tr>
				<td><a href="${ctx}/wuye_gongsi/sysOffice/form?id=${sysOffice.id}">
					${sysOffice.name}
				</a></td>
				<td>
					${sysOffice.phone}
				</td>
				<td>
					${sysOffice.master}
				</td>
				<td>
					${sysOffice.address}
				</td>
				<td>
					${sysOffice.renshu}
				</td>
				<td>
					${sysOffice.zipCode}
				</td>
				<td>
					${sysOffice.fax}
				</td>
				<td>
					${sysOffice.email}
				</td>
				<shiro:hasPermission name="wuye_gongsi:sysOffice:edit"><td>
    				<a href="${ctx}/wuye_gongsi/sysOffice/form?id=${sysOffice.id}">修改</a>
					<a href="${ctx}/wuye_gongsi/sysOffice/delete?id=${sysOffice.id}" onclick="return confirmx('确认要删除该公司信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>