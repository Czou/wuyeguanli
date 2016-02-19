/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_run.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.TreeEntity;
import com.thinkgem.jeesite.modules.sys.entity.Office;

/**
 * 任务执行Entity
 * @author ktzhxm
 * @version 2016-02-09
 */
public class RenwuRun extends TreeEntity<RenwuRun> {
	
	private static final long serialVersionUID = 1L;
	private RenwuRun parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String mingcheng;		// 名称
	private String taskcycle;		// 任务周期
	private Office office;		// 任务部门
	private String yuangongcode;		// 执行员工号
	private String taskstatus;		// taskstatus
	private Date jieshusj;		// jieshusj
	private String taskText;	//任务链接文本
	
	public RenwuRun() {
		super();
	}

	public RenwuRun(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public RenwuRun getParent() {
		return parent;
	}

	public void setParent(RenwuRun parent) {
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
	
	@Length(min=0, max=5, message="任务周期长度必须介于 0 和 5 之间")
	public String getTaskcycle() {
		return taskcycle;
	}

	public void setTaskcycle(String taskcycle) {
		this.taskcycle = taskcycle;
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
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJieshusj() {
		return jieshusj;
	}

	public void setJieshusj(Date jieshusj) {
		this.jieshusj = jieshusj;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public String getTaskText() {
		return taskText;
	}

	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}
}