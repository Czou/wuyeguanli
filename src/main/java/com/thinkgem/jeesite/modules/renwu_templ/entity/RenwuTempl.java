/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_templ.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.thinkgem.jeesite.common.persistence.TreeEntity;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 任务计划模板Entity
 * @author ktzxm
 * @version 2016-01-15
 */
public class RenwuTempl extends TreeEntity<RenwuTempl> {
	
	private static final long serialVersionUID = 1L;
	private RenwuTempl parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String mingcheng;		// 名称
	private String taskcycle;		// 任务周期
	private Date jieshusj;	//任务结束时间
	private Office taskdep;		// 任务部门
	private User taskUser;		//任务责任人
	private String yuangongcode;		// 执行员工号
	private String taskStatus;	//任务状态，0未执行，1执行中
	private String taskStatusText;	//启动or查看
	
	public RenwuTempl() {
		super();
	}

	public RenwuTempl(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public RenwuTempl getParent() {
		return parent;
	}

	public void setParent(RenwuTempl parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=2000, message="所有父级编号长度必须介于 1 和 2000 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	public String getTaskcycle() {
		return taskcycle;
	}

	public void setTaskcycle(String taskcycle) {
		this.taskcycle = taskcycle;
	}
	
	public Office getTaskdep() {
		return taskdep;
	}

	public void setTaskdep(Office taskdep) {
		this.taskdep = taskdep;
	}
	
	@Length(min=0, max=64, message="执行员工号长度必须介于 0 和 64 之间")
	public String getYuangongcode() {
		return yuangongcode;
	}

	public void setYuangongcode(String yuangongcode) {
		this.yuangongcode = yuangongcode;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskStatusText() {
		return taskStatusText;
	}

	public void setTaskStatusText(String taskStatusText) {
		this.taskStatusText = taskStatusText;
	}

	public Date getJieshusj() {
		return jieshusj;
	}

	public void setJieshusj(Date jieshusj) {
		this.jieshusj = jieshusj;
	}

	public User getTaskUser() {
		return taskUser;
	}

	public void setTaskUser(User taskUser) {
		this.taskUser = taskUser;
	}

}