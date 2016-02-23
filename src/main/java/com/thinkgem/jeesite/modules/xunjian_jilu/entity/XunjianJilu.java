/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.xunjian_jilu.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 巡检记录Entity
 * @author ktzhxm
 * @version 2016-02-23
 */
public class XunjianJilu extends DataEntity<XunjianJilu> {
	
	private static final long serialVersionUID = 1L;
	private String xunjianid;		// 任务id
	private Date jieshusj;	//结束时间
	private User userId;	//巡检人
	private String xunjianstatus;		// 巡检状态
	
	public XunjianJilu() {
		super();
	}

	public XunjianJilu(String id){
		super(id);
	}

	@Length(min=0, max=60, message="任务id长度必须介于 0 和 60 之间")
	public String getXunjianid() {
		return xunjianid;
	}

	public void setXunjianid(String xunjianid) {
		this.xunjianid = xunjianid;
	}
	
	@Length(min=0, max=255, message="巡检状态长度必须介于 0 和 255 之间")
	public String getXunjianstatus() {
		return xunjianstatus;
	}

	public void setXunjianstatus(String xunjianstatus) {
		this.xunjianstatus = xunjianstatus;
	}

	public Date getJieshusj() {
		return jieshusj;
	}

	public void setJieshusj(Date jieshusj) {
		this.jieshusj = jieshusj;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	
}