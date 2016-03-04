/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyerenyuan.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;

/**
 * 住户人员信息DAO接口
 * 
 * @author ktzhxm
 * @version 2015-12-14
 */
@MyBatisDao
public interface DictRenyuanDao extends CrudDao<User> {

	/**
	 * 将人从套户内迁出
	 * 
	 */
	void moveOut(String renyuanId);
	/**
	 * 将人设成黑名单
	 * @param flag 
	 */
	void addHeimingd(String renyuanId);
	/**
	 * 删除黑名单
	 * @param renyuanId
	 */
	void delHeimingd(String renyuanId);
	/**
	 * 根据手机号或身份证号，查询人员
	 * @param num
	 * @return
	 */
	DictRenyuan getRenyuanByNum(String num);
	/**
	 * 查询部门与人员
	 * @param companyId
	 * @return
	 */
	public List<User> getRenyuanByCompanyId(String companyId);
}