<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>巡检管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
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
		<li><a href="${ctx}/xunjian_jilu/xunjianJilu/">巡检列表</a></li>
		<li class="active"><a href="${ctx}/xunjian_jilu/xunjianJilu/form?id=${xunjianJilu.id}">巡检<shiro:hasPermission name="xunjian_jilu:xunjianJilu:edit">${not empty xunjianJilu.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="xunjian_jilu:xunjianJilu:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="xunjianJilu" action="${ctx}/xunjian_jilu/xunjianJilu/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="xunjian.leixing"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">巡检任务名：</label>
			<div class="controls">
				${xunjianJilu.xunjian.leixing}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务责任人：</label>
			<div class="controls">
				<sys:treeselect id="taskuser" name="userId.id" value="${xunjianJilu.userId.id}" labelName="userId.name" labelValue="${xunjianJilu.userId.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务结束时间：</label>
			<div class="controls">
				<input name="jieshusj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${xunjianJilu.jieshusj}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">巡检备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="xunjian_jilu:xunjianJilu:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>