/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_linshi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.renwu_linshi.dao.RenwuLinshiDao;
import com.thinkgem.jeesite.modules.renwu_linshi.entity.RenwuLinshi;
import com.thinkgem.jeesite.modules.renwu_run.entity.RenwuRun;
import com.thinkgem.jeesite.modules.renwu_run_jilu.entity.RenwuRunJilu;
import com.thinkgem.jeesite.modules.renwu_run_jilu.service.RenwuRunJiluService;

/**
 * 临时任务Service
 * @author ktzhxm
 * @version 2016-02-22
 */
@Service
@Transactional(readOnly = true)
public class RenwuLinshiService extends CrudService<RenwuLinshiDao, RenwuLinshi> {
	@Autowired
	private RenwuRunJiluService jiluService;
	
	public RenwuLinshi get(String id) {
		return super.get(id);
	}
	
	public List<RenwuLinshi> findList(RenwuLinshi renwuLinshi) {
		return super.findList(renwuLinshi);
	}
	
	public Page<RenwuLinshi> findPage(Page<RenwuLinshi> page, RenwuLinshi renwuLinshi) {
		return super.findPage(page, renwuLinshi);
	}
	
	@Transactional(readOnly = false)
	public void save(RenwuLinshi renwuLinshi) {
		renwuLinshi.setParent_id("0");
		renwuLinshi.setParentIds("0,");
		super.save(renwuLinshi);
	}
	
	@Transactional(readOnly = false)
	public void delete(RenwuLinshi renwuLinshi) {
		super.delete(renwuLinshi);
	}
	@Transactional(readOnly = false)
	public void saveChuli(RenwuLinshi renwuLinshi) {
		super.save(renwuLinshi);
		
		RenwuRunJilu jilu = new RenwuRunJilu();
		RenwuRun renwu=new RenwuRun();
		renwu.setId(renwuLinshi.getId());
		jilu.setRenwu(renwu);
		jilu.setRemarks(renwuLinshi.getRemarks());
		jilu.setWanchengqk(renwuLinshi.getTaskstatus());
		 jiluService.save(jilu);
		
	}
	
}