/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.xunjian_dict.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.xunjian_dict.entity.XunjianDict;

/**
 * 管理巡检点DAO接口
 * @author ktzhxm
 * @version 2016-02-17
 */
@MyBatisDao
public interface XunjianDictDao extends CrudDao<XunjianDict> {
	public List<String> findLeixingList(XunjianDict dict);

	public List<XunjianDict> findListByLeixing(String leixingStr);
}