/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_linshi.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 临时任务Entity
 * @author ktzhxm
 * @version 2016-02-22
 */
public class RenwuLinshi extends DataEntity<RenwuLinshi> {
	
	private static final long serialVersionUID = 1L;
	private String parent_id;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String mingcheng;		// 名称
	private String taskcycle;		// 任务周期
	private String taskdep;		// 任务部门
	private User taskuser;		// 任务责任人
	private Integer taskType;	//任务类型
	private String yuangongcode;		// 执行员工号
	private String taskstatus="0";		// taskstatus
	private Date jieshusj;		// 结束时间
	
	public RenwuLinshi() {
		super();
	}

	public RenwuLinshi(String id){
		super(id);
	}

	@Length(min=1, max=64, message="父级编号长度必须介于 1 和 64 之间")
	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
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
	
	@Length(min=0, max=5, message="任务周期长度必须介于 0 和 5 之间")
	public String getTaskcycle() {
		return taskcycle;
	}

	public void setTaskcycle(String taskcycle) {
		this.taskcycle = taskcycle;
	}
	
	@Length(min=0, max=64, message="任务部门长度必须介于 0 和 64 之间")
	public String getTaskdep() {
		return taskdep;
	}

	public void setTaskdep(String taskdep) {
		this.taskdep = taskdep;
	}
	
	public User getTaskuser() {
		return taskuser;
	}

	public void setTaskuser(User taskuser) {
		this.taskuser = taskuser;
	}
	
	@Length(min=0, max=64, message="执行员工号长度必须介于 0 和 64 之间")
	public String getYuangongcode() {
		return yuangongcode;
	}

	public void setYuangongcode(String yuangongcode) {
		this.yuangongcode = yuangongcode;
	}
	
	@Length(min=0, max=1, message="taskstatus长度必须介于 0 和 1 之间")
	public String getTaskstatus() {
		return taskstatus;
	}

	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJieshusj() {
		return jieshusj;
	}

	public void setJieshusj(Date jieshusj) {
		this.jieshusj = jieshusj;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}
	
}