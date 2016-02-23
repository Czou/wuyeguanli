/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.xunjian_jilu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.xunjian_jilu.entity.XunjianJilu;
import com.thinkgem.jeesite.modules.xunjian_jilu.dao.XunjianJiluDao;

/**
 * 巡检记录Service
 * @author ktzhxm
 * @version 2016-02-23
 */
@Service
@Transactional(readOnly = true)
public class XunjianJiluService extends CrudService<XunjianJiluDao, XunjianJilu> {

	public XunjianJilu get(String id) {
		return super.get(id);
	}
	
	public List<XunjianJilu> findList(XunjianJilu xunjianJilu) {
		return super.findList(xunjianJilu);
	}
	
	public Page<XunjianJilu> findPage(Page<XunjianJilu> page, XunjianJilu xunjianJilu) {
		return super.findPage(page, xunjianJilu);
	}
	
	@Transactional(readOnly = false)
	public void save(XunjianJilu xunjianJilu) {
		super.save(xunjianJilu);
	}
	
	@Transactional(readOnly = false)
	public void delete(XunjianJilu xunjianJilu) {
		super.delete(xunjianJilu);
	}
	
}