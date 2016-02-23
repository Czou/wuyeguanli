/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_templ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.TreeService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.renwu_run.dao.RenwuRunDao;
import com.thinkgem.jeesite.modules.renwu_run.entity.RenwuRun;
import com.thinkgem.jeesite.modules.renwu_templ.dao.RenwuTemplDao;
import com.thinkgem.jeesite.modules.renwu_templ.entity.RenwuTempl;

/**
 * 任务计划模板Service
 * 
 * @author ktzxm
 * @version 2016-01-15
 */
@Service
@Transactional(readOnly = true)
public class RenwuTemplService extends TreeService<RenwuTemplDao, RenwuTempl> {

	@Autowired
	private RenwuRunDao runDao;

	public RenwuTempl get(String id) {
		return super.get(id);
	}

	public List<RenwuTempl> findList(RenwuTempl renwuTempl) {
		if (StringUtils.isNotBlank(renwuTempl.getParentIds())) {
			renwuTempl.setParentIds("," + renwuTempl.getParentIds() + ",");
		}
		dataScopeFilter(renwuTempl, "dsf", "id=o.id", "id=a.create_by");
		return super.findList(renwuTempl);
	}

	@Transactional(readOnly = false)
	public void save(RenwuTempl renwuTempl) {
		super.save(renwuTempl);
	}

	@Transactional(readOnly = false)
	public void delete(RenwuTempl renwuTempl) {
		super.delete(renwuTempl);
	}

	@Transactional(readOnly = false)
	public void saveStartTask(RenwuTempl templ) {
		RenwuRun run = new RenwuRun();
		run.setParent(new RenwuRun(templ.getParentId()));
		run.setParentIds(templ.getParentIds());
		run.setMingcheng(templ.getMingcheng());
		run.setTaskcycle(templ.getTaskcycle());
		run.setOffice(templ.getTaskdep());
		run.setYuangongcode(templ.getYuangongcode());
		run.setUser(templ.getTaskUser());
		run.setJieshusj(templ.getJieshusj());
		run.preInsert();
		runDao.insert(run);

		// 当前任务及任务明细一同启动
		RenwuTempl r = new RenwuTempl();
		r.setParentIds(templ.getId());
		List<RenwuTempl> list = findList(r);
		for (RenwuTempl rl : list) {
			RenwuRun run1 = new RenwuRun();
			run1.setParent(new RenwuRun(run.getId()));
			run1.setMingcheng(rl.getMingcheng());
			run1.setTaskcycle(rl.getTaskcycle());
			run1.setOffice(rl.getTaskdep());
			run1.setYuangongcode(rl.getYuangongcode());
			run1.setUser(templ.getTaskUser());
			run1.setJieshusj(templ.getJieshusj());
			run1.setParentIds("0,"+run.getId());

			// 添加记录
			run1.preInsert();
			runDao.insert(run1);
		}
	}
}