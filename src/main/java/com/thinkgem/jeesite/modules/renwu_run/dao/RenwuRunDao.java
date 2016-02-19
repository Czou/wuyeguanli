/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_run.dao;

import com.thinkgem.jeesite.common.persistence.TreeDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.renwu_run.entity.RenwuRun;

/**
 * 任务执行DAO接口
 * @author ktzhxm
 * @version 2016-02-09
 */
@MyBatisDao
public interface RenwuRunDao extends TreeDao<RenwuRun> {
	
}