/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuye_xiaoqu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.wuye_xiaoqu.dao.SysOfficeXiaoquDao;
import com.thinkgem.jeesite.modules.wuye_xiaoqu.entity.SysOfficeXiaoqu;

/**
 * 小区信息管理Service
 * @author ktzhxm
 * @version 2016-03-02
 */
@Service
@Transactional(readOnly = true)
public class SysOfficeXiaoquService extends CrudService<SysOfficeXiaoquDao, SysOfficeXiaoqu> {

	public SysOfficeXiaoqu get(String id) {
		return super.get(id);
	}
	
	public List<SysOfficeXiaoqu> findList(SysOfficeXiaoqu sysOfficeXiaoqu) {
		return super.findList(sysOfficeXiaoqu);
	}
	
	public Page<SysOfficeXiaoqu> findPage(Page<SysOfficeXiaoqu> page, SysOfficeXiaoqu sysOfficeXiaoqu) {
		return super.findPage(page, sysOfficeXiaoqu);
	}
	
	@Transactional(readOnly = false)
	public void save(SysOfficeXiaoqu sysOfficeXiaoqu) {
		super.save(sysOfficeXiaoqu);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysOfficeXiaoqu sysOfficeXiaoqu) {
		super.delete(sysOfficeXiaoqu);
	}

	public List<Office> findParList() {
		return dao.findParList();
	}
	
}