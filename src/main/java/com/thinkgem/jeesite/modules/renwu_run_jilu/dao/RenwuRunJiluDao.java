/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_run_jilu.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.renwu_run_jilu.entity.RenwuRunJilu;

/**
 * 任务执行记录DAO接口
 * @author ktzhxm
 * @version 2016-02-10
 */
@MyBatisDao
public interface RenwuRunJiluDao extends CrudDao<RenwuRunJilu> {
	
}