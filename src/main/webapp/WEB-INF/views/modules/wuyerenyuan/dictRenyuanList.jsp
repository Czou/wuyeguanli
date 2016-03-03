<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>住户信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
		function formPage(){
			var pids ='${pids}';
			//选了套户
			if(pids.split(',').length==5){
				window.location.href="${ctx}/wuyerenyuan/dictRenyuan/form?taohuIds="+pids;
			}else
				alert("请选择套户");
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/wuyerenyuan/dictRenyuan/">住户信息列表</a></li>
		<shiro:hasPermission name="wuyerenyuan:dictRenyuan:edit">
			<li><a href="javascript:formPage()">住户信息添加</a></li>
		</shiro:hasPermission>
	</ul>
	<input id="path" type="hidden" value="${dictRenyuan.path }" />
	<form:form id="searchForm" modelAttribute="user" action="${ctx}/wuyerenyuan/dictRenyuan/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="12" class="input-medium"/>
			</li>
			<li><label>人员类型：</label>
				<form:radiobuttons path="yezhulx" items="${fns:getDictList('d_zhlx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>随身电话：</label>
				<form:input path="mobile" htmlEscape="false" maxlength="18" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
		<form:hidden path="taohuIds"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="220px">位置</th>
				<th>姓名</th>
				<th>性别</th>
				<th>人员类型</th>
				<th>随身电话</th>
				<shiro:hasPermission name="wuyerenyuan:dictRenyuan:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dictRenyuan">
			<tr>
				<td>
					${dictRenyuan.path}
				</td>
				<td><a href="${ctx}/wuyerenyuan/dictRenyuan/form?id=${dictRenyuan.id}">
					${dictRenyuan.name}
				</a></td>
				<td>
					${fns:getDictLabel(dictRenyuan.sex, 'sex', '')}
				</td>
				<td>
					${fns:getDictLabel(dictRenyuan.yezhulx, 'd_zhlx', '')}
				</td>
				<td>
					${dictRenyuan.mobile}
				</td>
				<shiro:hasPermission name="wuyerenyuan:dictRenyuan:edit"><td>
    				<a href="${ctx}/wuyerenyuan/dictRenyuan/form?id=${dictRenyuan.id}">修改</a>
					<a href="${ctx}/wuyerenyuan/dictRenyuan/delete?id=${dictRenyuan.id}" onclick="return confirmx('确认要删除该住户信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>