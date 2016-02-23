/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.xunjian_jilu.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.xunjian_jilu.entity.XunjianJilu;

/**
 * 巡检记录DAO接口
 * @author ktzhxm
 * @version 2016-02-23
 */
@MyBatisDao
public interface XunjianJiluDao extends CrudDao<XunjianJilu> {
	
}