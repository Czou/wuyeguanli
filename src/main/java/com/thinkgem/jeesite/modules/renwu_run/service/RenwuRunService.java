/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_run.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.TreeService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.renwu_run.dao.RenwuRunDao;
import com.thinkgem.jeesite.modules.renwu_run.entity.RenwuRun;
import com.thinkgem.jeesite.modules.renwu_run_jilu.entity.RenwuRunJilu;
import com.thinkgem.jeesite.modules.renwu_run_jilu.service.RenwuRunJiluService;

/**
 * 任务执行Service
 * 
 * @author ktzhxm
 * @version 2016-02-09
 */
@Service
@Transactional(readOnly = true)
public class RenwuRunService extends TreeService<RenwuRunDao, RenwuRun> {
	@Autowired
	private RenwuRunJiluService jiluService;

	public RenwuRun get(String id) {
		return super.get(id);
	}

	public List<RenwuRun> findList(RenwuRun renwuRun) {
		if (StringUtils.isNotBlank(renwuRun.getParentIds())) {
			renwuRun.setParentIds(renwuRun.getParentIds());
		}
		dataScopeFilter(renwuRun, "dsf", "id=a.taskDep", "id=a.create_by");
		return super.findList(renwuRun);
	}

	@Transactional(readOnly = false)
	public void save(RenwuRun renwuRun) {
		// 如果是父任务，则子任务一同完成
		renwuRun.setParent(null);
		renwuRun.setParentIds("0," + renwuRun.getId());
		List<RenwuRun> list = findList(renwuRun);
		for (RenwuRun renwu : list) {
			// 忽略掉已经完成的任务
			if ("1".equals(renwu.getTaskstatus()))
				continue;
			
			//任务完成状态
			renwu.setTaskstatus(renwuRun.getTaskstatus());
			super.save(renwu);

			RenwuRunJilu jilu = new RenwuRunJilu();
			jilu.setRenwu(renwu);
			jilu.setRemarks(renwuRun.getRemarks());
			jilu.setWanchengqk(renwuRun.getTaskstatus());
			jiluService.save(jilu);
		}

		// 1更新任务运行状态
		renwuRun.setTaskstatus(renwuRun.getTaskstatus());
		super.save(renwuRun);
		// 2记录任务
		RenwuRunJilu jilu = new RenwuRunJilu();
		jilu.setRenwu(renwuRun);
		jilu.setRemarks(renwuRun.getRemarks());
		jilu.setWanchengqk(renwuRun.getTaskstatus());
		jiluService.save(jilu);
	}

	@Transactional(readOnly = false)
	public void delete(RenwuRun renwuRun) {
		super.delete(renwuRun);
	}

}