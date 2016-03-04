/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyerenyuan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.wuyerenyuan.dao.DictRenyuanDao;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;

/**
 * 住户人员信息Service
 * @author ktzhxm
 * @version 2015-12-14
 */
@Service
@Transactional(readOnly = true)
public class DictRenyuanService extends CrudService<DictRenyuanDao, User> {
	
	public User get(String id) {
		return super.get(id);
	}
	
	public List<User> findList(User user) {
		return super.findList(user);
	}
	/*
	 * [{"depName":"维修部",userList:[{"name":"张三","phone":"12345"},{},...]},{}]
	 */
	public List<Map<String, Object>> getRenyuanByCompanyId(String companyId){
		List<Map<String, Object>> result=new ArrayList<Map<String,Object>>();
		
		List<User> list=dao.getRenyuanByCompanyId(companyId);
		
		for(User u:list){
			Map<String, Object> map = Maps.newHashMap();
			String name=u.getOffice().getName();
			Map<String, Object> uObj = Maps.newHashMap();
			uObj.put("id", u.getId());
			uObj.put("name",u.getName());
			uObj.put("phone",u.getPhone());
			//存在这个部门
			if(map.containsKey(name)){
				Map<String, Object> m =(Map<String, Object>) map.get(name);
				List<Map<String, Object>> l=(List<Map<String, Object>>) m.get("userList");
				l.add(uObj);
			}else{
				List<Map<String, Object>> l=new ArrayList<Map<String, Object>>();
				l.add(uObj);
				
				map.put("depName", name);
				map.put("userList", l);
				result.add(map);
			}
		}
		return result;
	}
	
	public Page<User> findPage(Page<User> page, User dictRenyuan) {
		return super.findPage(page, dictRenyuan);
	}
	
	@Transactional(readOnly = false)
	public void save(User dictRenyuan) {
		super.save(dictRenyuan);
	}
	
	@Transactional(readOnly = false)
	public void delete(User dictRenyuan) {
		super.delete(dictRenyuan);
	}
	@Transactional(readOnly = false)
	public void moveOut(String renyuanId) {
		dao.moveOut(renyuanId);
	}
	@Transactional(readOnly = false)
	public void addHeimingd(String renyuanId) {
		dao.addHeimingd(renyuanId);
	}
	@Transactional(readOnly = false)
	public void delHeimingd(String renyuanId) {
		dao.delHeimingd(renyuanId);
	}

	public DictRenyuan getRenyuanByNum(String num) {
		return dao.getRenyuanByNum(num);
	}
	
}