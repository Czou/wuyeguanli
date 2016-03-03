/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuye_gongsi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wuye_gongsi.entity.SysOffice;
import com.thinkgem.jeesite.modules.wuye_gongsi.dao.SysOfficeDao;

/**
 * 公司信息管理Service
 * @author ktzhxm
 * @version 2016-03-01
 */
@Service
@Transactional(readOnly = true)
public class SysOfficeService extends CrudService<SysOfficeDao, SysOffice> {

	public SysOffice get(String id) {
		return super.get(id);
	}
	
	public List<SysOffice> findList(SysOffice sysOffice) {
		return super.findList(sysOffice);
	}
	
	public Page<SysOffice> findPage(Page<SysOffice> page, SysOffice sysOffice) {
		return super.findPage(page, sysOffice);
	}
	
	@Transactional(readOnly = false)
	public void save(SysOffice sysOffice) {
		super.save(sysOffice);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysOffice sysOffice) {
		super.delete(sysOffice);
	}
	
}