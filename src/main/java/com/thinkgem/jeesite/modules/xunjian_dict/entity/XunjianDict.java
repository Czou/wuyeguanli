/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.xunjian_dict.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 管理巡检点Entity
 * @author ktzhxm
 * @version 2016-02-17
 */
public class XunjianDict extends DataEntity<XunjianDict> {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 名称
	private String leixing;		// 类型
	private Integer shunxu;		// 顺序
	
	public XunjianDict() {
		super();
	}

	public XunjianDict(String id){
		super(id);
	}

	@Length(min=0, max=60, message="名称长度必须介于 0 和 60 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	@Length(min=0, max=255, message="类型长度必须介于 0 和 255 之间")
	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public Integer getShunxu() {
		return shunxu;
	}

	public void setShunxu(Integer shunxu) {
		this.shunxu = shunxu;
	}
}