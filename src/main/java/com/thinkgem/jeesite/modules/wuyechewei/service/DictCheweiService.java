/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyechewei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.wuyechewei.dao.DictCheweiDao;
import com.thinkgem.jeesite.modules.wuyechewei.entity.DictChewei;
import com.thinkgem.jeesite.modules.wuyerenyuan.service.DictRenyuanService;

/**
 * 车位信息Service
 * @author ktzhxm
 * @version 2015-12-10
 */
@Service
@Transactional(readOnly = true)
public class DictCheweiService extends CrudService<DictCheweiDao, DictChewei> {
	@Autowired
	private DictRenyuanService renyuanService; 
	@Autowired
	private DictCheweiDao cheweiDao;
	
	public DictChewei get(String id) {
		return super.get(id);
	}
	
	public List<DictChewei> findList(DictChewei dictChewei) {
		return super.findList(dictChewei);
	}
	
	public Page<DictChewei> findPage(Page<DictChewei> page, DictChewei dictChewei) {
		return super.findPage(page, dictChewei);
	}
	
	@Transactional(readOnly = false)
	public void save(DictChewei dictChewei) {
		super.save(dictChewei);
	}
	
	@Transactional(readOnly = false)
	public void delete(DictChewei dictChewei) {
		super.delete(dictChewei);
	}

	/**
	 * 用于人员选择下拉框
	 * @return
	 */
	public List<User> findRenyuanList() {
		User ren=new User();
		ren.setDelFlag("0");
		List<User> list =renyuanService.findList(ren) ;
		for(User r:list){
			r.setName(r.getPath()+"-"+r.getName());
		}
		return list;
	}
	@Transactional(readOnly = false)
	public void chuzu(DictChewei dictChewei) {
		cheweiDao.chuzu(dictChewei);
	}
	@Transactional(readOnly = false)
	public void chushou(DictChewei dictChewei) {
		cheweiDao.chushou(dictChewei);
	}

	public void shifang(String cheweiId) {
		cheweiDao.shifang(cheweiId);
	}
	
}