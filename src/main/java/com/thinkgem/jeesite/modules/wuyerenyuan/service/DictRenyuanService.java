/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyerenyuan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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