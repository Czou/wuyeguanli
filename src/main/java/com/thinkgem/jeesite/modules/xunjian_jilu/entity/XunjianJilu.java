/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.xunjian_jilu.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.xunjian_dict.entity.XunjianDict;

/**
 * 巡检记录Entity
 * @author ktzhxm
 * @version 2016-02-23
 */
public class XunjianJilu extends DataEntity<XunjianJilu> {
	
	private static final long serialVersionUID = 1L;
	private XunjianDict xunjian;		// 巡检任务
	private Date jieshusj;	//结束时间
	private User userId;	//巡检人
	private Date xunjiansj;	//巡检时间
	private Integer shunxu;	//顺序
	private int xunjianstatus=0;		// 巡检状态
	
	public XunjianJilu() {
		super();
	}

	public XunjianJilu(String id){
		super(id);
	}

	@Length(min=0, max=255, message="巡检状态长度必须介于 0 和 255 之间")
	public int getXunjianstatus() {
		return xunjianstatus;
	}

	public void setXunjianstatus(int xunjianstatus) {
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

	public Integer getShunxu() {
		return shunxu;
	}

	public void setShunxu(Integer shunxu) {
		this.shunxu = shunxu;
	}

	public XunjianDict getXunjian() {
		return xunjian;
	}

	public void setXunjian(XunjianDict xunjian) {
		this.xunjian = xunjian;
	}

	public Date getXunjiansj() {
		return xunjiansj;
	}

	public void setXunjiansj(Date xunjiansj) {
		this.xunjiansj = xunjiansj;
	}
	
}