/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuye_gongsi.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.wuye_gongsi.entity.SysOffice;
import com.thinkgem.jeesite.modules.wuye_gongsi.service.SysOfficeService;

/**
 * 公司信息管理Controller
 * @author ktzhxm
 * @version 2016-03-01
 */
@Controller
@RequestMapping(value = "${adminPath}/wuye_gongsi/sysOffice")
public class SysOfficeController extends BaseController {

	@Autowired
	private SysOfficeService sysOfficeService;
	
	@ModelAttribute
	public SysOffice get(@RequestParam(required=false) String id) {
		SysOffice entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysOfficeService.get(id);
		}
		if (entity == null){
			entity = new SysOffice();
		}
		return entity;
	}
	
	@RequiresPermissions("wuye_gongsi:sysOffice:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysOffice sysOffice, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysOffice> page = sysOfficeService.findPage(new Page<SysOffice>(request, response), sysOffice); 
		model.addAttribute("page", page);
		return "modules/wuye_gongsi/sysOfficeList";
	}

	@RequiresPermissions("wuye_gongsi:sysOffice:view")
	@RequestMapping(value = "form")
	public String form(SysOffice sysOffice, Model model) {
		model.addAttribute("sysOffice", sysOffice);
		return "modules/wuye_gongsi/sysOfficeForm";
	}

	@RequiresPermissions("wuye_gongsi:sysOffice:edit")
	@RequestMapping(value = "save")
	public String save(SysOffice sysOffice, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysOffice)){
			return form(sysOffice, model);
		}
		sysOfficeService.save(sysOffice);
		addMessage(redirectAttributes, "保存公司信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuye_gongsi/sysOffice/?repage";
	}
	
	@RequiresPermissions("wuye_gongsi:sysOffice:edit")
	@RequestMapping(value = "delete")
	public String delete(SysOffice sysOffice, RedirectAttributes redirectAttributes) {
		sysOfficeService.delete(sysOffice);
		addMessage(redirectAttributes, "删除公司信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuye_gongsi/sysOffice/?repage";
	}

}