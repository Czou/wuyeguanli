/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_run_jilu.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.renwu_run.entity.RenwuRun;

/**
 * 任务执行记录Entity
 * @author ktzhxm
 * @version 2016-02-10
 */
public class RenwuRunJilu extends DataEntity<RenwuRunJilu> {
	
	private static final long serialVersionUID = 1L;
	private RenwuRun renwu;		// 任务id
	private String wanchengqk;		// 完成情况
	
	public RenwuRunJilu() {
		super();
	}

	public RenwuRunJilu(String id){
		super(id);
	}

	public RenwuRun getRenwu() {
		return renwu;
	}

	public void setRenwu(RenwuRun renwu) {
		this.renwu = renwu;
	}
	
	@Length(min=0, max=1, message="完成情况长度必须介于 0 和 1 之间")
	public String getWanchengqk() {
		return wanchengqk;
	}

	public void setWanchengqk(String wanchengqk) {
		this.wanchengqk = wanchengqk;
	}
	
}