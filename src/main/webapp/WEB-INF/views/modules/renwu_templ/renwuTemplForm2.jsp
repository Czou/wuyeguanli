<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>计划管理</title>
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
		<li><a href="${ctx}/renwu_templ/renwuTempl/startTaskList">计划列表</a></li>
		<li class="active"><a href="${ctx}/renwu_templ/renwuTempl/form?id=${renwuTempl.id}&parent.id=${renwuTemplparent.id}">计划<shiro:hasPermission name="renwu_templ:renwuTempl:edit">${not empty renwuTempl.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="renwu_templ:renwuTempl:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="renwuTempl" action="${ctx}/renwu_templ/renwuTempl/saveStartTask" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">名称：</label>
			<div class="controls">
				${renwuTempl.mingcheng }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务周期：</label>
			<div class="controls">
				${renwuTempl.taskcycle } 天
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务部门：</label>
			<div class="controls">
				${renwuTempl.taskdep.name }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">执行员工号：</label>
			<div class="controls">
				${renwuTempl.yuangongcode }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务责任人：</label>
			<div class="controls">
				<sys:treeselect id="taskUser" name="taskUser.id" value="${testData.user.id}" labelName="taskUser.name" labelValue="${renwuTempl.taskUser.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务结束时间：</label>
			<div class="controls">
				<input id="jieshusj" name="jieshusj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${renwuTempl.jieshusj }" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false,readOnly:true,minDate:'%y-%M-\#{%d}'});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="renwu_templ:renwuTempl:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="执 行"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>