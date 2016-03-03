/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuye_xiaoqu.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.wuye_xiaoqu.entity.SysOfficeXiaoqu;

/**
 * 小区信息管理DAO接口
 * @author ktzhxm
 * @version 2016-03-02
 */
@MyBatisDao
public interface SysOfficeXiaoquDao extends CrudDao<SysOfficeXiaoqu> {
	public List<Office> findParList();
}