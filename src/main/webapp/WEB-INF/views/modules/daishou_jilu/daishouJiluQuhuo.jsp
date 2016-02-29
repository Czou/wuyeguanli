<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>信息管理</title>
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
		<li><a href="${ctx}/daishou_jilu/daishouJilu/">信息列表</a></li>
		<li class="active"><a href="${ctx}/daishou_jilu/daishouJilu/form?id=${daishouJilu.id}">信息<shiro:hasPermission name="daishou_jilu:daishouJilu:edit">${not empty daishouJilu.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="daishou_jilu:daishouJilu:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="daishouJilu" action="${ctx}/daishou_jilu/daishouJilu/saveQuhuo" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">货物名称：</label>
			<div class="controls">
				${daishouJilu.mingcheng}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">收货人电话：</label>
			<div class="controls">
				${daishouJilu.shouhuodh}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">收货人姓名：</label>
			<div class="controls">
				${daishouJilu.shouhuoxm}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">收货人地址：</label>
			<div class="controls">
				${daishouJilu.shouhuodz}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">存放时间：</label>
			<div class="controls">
				<fmt:formatDate value="${daishouJilu.cunfangsj }" pattern="yyyy-MM-dd"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">物流公司：</label>
			<div class="controls">
				${daishouJilu.wuliugs.mingcheng}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">货柜：</label>
			<div class="controls">
				${daishouJilu.huogui.mingcheng}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否本人取货：</label>
			<div class="controls">
				<input type="radio" name="shifoubr" value="1" checked="checked">是&nbsp;&nbsp;
				<input type="radio" name="shifoubr" value="0">否
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">取货人电话：</label>
			<div class="controls">
				<form:input path="quhuodh" htmlEscape="false" maxlength="15" class="input-xlarge"/>
				<span class="help-inline"><font color="green">本人取货不必填写</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">取货人姓名：</label>
			<div class="controls">
				<form:input path="quhuoxm" htmlEscape="false" maxlength="10" class="input-xlarge"/>
				<span class="help-inline"><font color="green">本人取货不必填写</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="daishou_jilu:daishouJilu:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>