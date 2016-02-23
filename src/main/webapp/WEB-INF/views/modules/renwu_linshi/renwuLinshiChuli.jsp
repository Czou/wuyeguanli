<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>临时任务管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/renwu_linshi/renwuLinshi/">临时任务列表</a></li>
		<li class="active"><a href="${ctx}/renwu_linshi/renwuLinshi/form?id=${renwuLinshi.id}">临时任务<shiro:hasPermission name="renwu_linshi:renwuLinshi:edit">${renwuLinshi.taskstatus==0?'处理':'查看'}</shiro:hasPermission><shiro:lacksPermission name="renwu_linshi:renwuLinshi:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="renwuLinshi" action="${ctx}/renwu_linshi/renwuLinshi/saveChuli" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">任务描述：</label>
			<div class="controls">
				${renwuLinshi.mingcheng}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务责任人：</label>
			<div class="controls">
				${renwuLinshi.taskuser.name}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结束时间：</label>
			<div class="controls">
				<fmt:formatDate value="${renwuLinshi.jieshusj}" pattern="yyyy-MM-dd"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务结果：</label>
			<div class="controls">
				<form:radiobuttons path="taskstatus" items="${fns:getDictList('dict_renwuResult')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">完成情况：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="renwu_linshi:renwuLinshi:edit">
			<c:if test="${renwuLinshi.taskstatus==0 }">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</c:if>
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>