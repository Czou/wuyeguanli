/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuye_gongsi.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wuye_gongsi.entity.SysOffice;

/**
 * 公司信息管理DAO接口
 * @author ktzhxm
 * @version 2016-03-01
 */
@MyBatisDao
public interface SysOfficeDao extends CrudDao<SysOffice> {
	
}