<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>任务管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")){
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
		<li><a href="${ctx}/renwu_run/renwuRun/">任务列表</a></li>
		<li class="active"><a href="${ctx}/renwu_run/renwuRun/form?id=${renwuRun.id}&parent.id=${renwuRunparent.id}">任务<shiro:hasPermission name="renwu_run:renwuRun:edit">${not empty renwuRun.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="renwu_run:renwuRun:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="renwuRun" action="${ctx}/renwu_run/renwuRun/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">上级任务:</label>
			<div class="controls">
				${renwuRun.parent.mingcheng }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">名称：</label>
			<div class="controls">
				${renwuRun.mingcheng }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务周期：</label>
			<div class="controls">
				${renwuRun.taskcycle }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务部门：</label>
			<div class="controls">
				${renwuRun.office.name }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">执行员工号：</label>
			<div class="controls">
				${renwuRun.yuangongcode }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">预定完成时间：</label>
			<div class="controls">
				<fmt:formatDate value="${renwuRun.jieshusj}" pattern="yyyy-MM-dd"/>
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
			<shiro:hasPermission name="renwu_run:renwuRun:edit">
				<c:if test="${renwuRun.taskstatus==0 }">
					<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
				</c:if>
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>