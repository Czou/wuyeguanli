<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>建议管理</title>
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
		<li><a href="${ctx}/jianyi_xinxi/jianyiXinxi/">建议列表</a></li>
		<li class="active"><a href="${ctx}/jianyi_xinxi/jianyiXinxi/form?id=${jianyiXinxi.id}">建议<shiro:hasPermission name="jianyi_xinxi:jianyiXinxi:edit">${not empty jianyiXinxi.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="jianyi_xinxi:jianyiXinxi:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="jianyiXinxi" action="${ctx}/jianyi_xinxi/jianyiXinxi/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">建议内容：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建议分类：</label>
			<div class="controls">
				<form:select path="fenlei" items="${fns:getDictList('d_jyfl')}" itemLabel="label" itemValue="value"/>
			</div>
		</div>
		<div class="control-group" style="display:none;">
			<label class="control-label">处理结果：</label>
			<div class="controls">
				<form:input path="jieguo" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="jianyi_xinxi:jianyiXinxi:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>