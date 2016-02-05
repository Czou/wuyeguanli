/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_templ.dao;

import com.thinkgem.jeesite.common.persistence.TreeDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.renwu_templ.entity.RenwuTempl;

/**
 * 任务计划模板DAO接口
 * @author ktzxm
 * @version 2016-01-15
 */
@MyBatisDao
public interface RenwuTemplDao extends TreeDao<RenwuTempl> {

	/**
	 * 启动一个任务
	 * @param id
	 */
	void startTask(String id);
	void startTask2(String id);
	
	/**
	 * 保存启动任务
	 * @param renwu
	 * @return
	 */
	public int saveStartTask(RenwuTempl renwu);
}