/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.xunjian_jilu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.xunjian_dict.entity.XunjianDict;
import com.thinkgem.jeesite.modules.xunjian_dict.service.XunjianDictService;
import com.thinkgem.jeesite.modules.xunjian_jilu.dao.XunjianJiluDao;
import com.thinkgem.jeesite.modules.xunjian_jilu.entity.XunjianJilu;

/**
 * 巡检记录Service
 * @author ktzhxm
 * @version 2016-02-23
 */
@Service
@Transactional(readOnly = true)
public class XunjianJiluService extends CrudService<XunjianJiluDao, XunjianJilu> {
	@Autowired
	private XunjianDictService service;
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
		XunjianDict xunjianDict=new XunjianDict();
		xunjianDict.setLeixing(xunjianJilu.getXunjian().getLeixing());
		List<XunjianDict> list=service.findList(xunjianDict);
		for(XunjianDict d:list){
			XunjianJilu jilu=new XunjianJilu();
			jilu.setXunjian(d);
			jilu.setJieshusj(xunjianJilu.getJieshusj());
			jilu.setUserId(xunjianJilu.getUserId());
			super.save(jilu);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(XunjianJilu xunjianJilu) {
		super.delete(xunjianJilu);
	}
	
}