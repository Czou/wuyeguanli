/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_run_jilu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.renwu_run_jilu.entity.RenwuRunJilu;
import com.thinkgem.jeesite.modules.renwu_run_jilu.dao.RenwuRunJiluDao;

/**
 * 任务执行记录Service
 * @author ktzhxm
 * @version 2016-02-10
 */
@Service
@Transactional(readOnly = true)
public class RenwuRunJiluService extends CrudService<RenwuRunJiluDao, RenwuRunJilu> {

	public RenwuRunJilu get(String id) {
		return super.get(id);
	}
	
	public List<RenwuRunJilu> findList(RenwuRunJilu renwuRunJilu) {
		return super.findList(renwuRunJilu);
	}
	
	public Page<RenwuRunJilu> findPage(Page<RenwuRunJilu> page, RenwuRunJilu renwuRunJilu) {
		return super.findPage(page, renwuRunJilu);
	}
	
	@Transactional(readOnly = false)
	public void save(RenwuRunJilu renwuRunJilu) {
		super.save(renwuRunJilu);
	}
	
	@Transactional(readOnly = false)
	public void delete(RenwuRunJilu renwuRunJilu) {
		super.delete(renwuRunJilu);
	}
	
}