/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuye_xiaoqu.web;

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
import com.thinkgem.jeesite.modules.wuye_xiaoqu.entity.SysOfficeXiaoqu;
import com.thinkgem.jeesite.modules.wuye_xiaoqu.service.SysOfficeXiaoquService;

/**
 * 小区信息管理Controller
 * @author ktzhxm
 * @version 2016-03-02
 */
@Controller
@RequestMapping(value = "${adminPath}/wuye_xiaoqu/sysOfficeXiaoqu")
public class SysOfficeXiaoquController extends BaseController {

	@Autowired
	private SysOfficeXiaoquService sysOfficeXiaoquService;
	
	@ModelAttribute
	public SysOfficeXiaoqu get(@RequestParam(required=false) String id) {
		SysOfficeXiaoqu entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysOfficeXiaoquService.get(id);
		}
		if (entity == null){
			entity = new SysOfficeXiaoqu();
		}
		return entity;
	}
	
	@RequiresPermissions("wuye_xiaoqu:sysOfficeXiaoqu:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysOfficeXiaoqu sysOfficeXiaoqu, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysOfficeXiaoqu> page = sysOfficeXiaoquService.findPage(new Page<SysOfficeXiaoqu>(request, response), sysOfficeXiaoqu); 
		model.addAttribute("page", page);
		return "modules/wuye_xiaoqu/sysOfficeXiaoquList";
	}

	@RequiresPermissions("wuye_xiaoqu:sysOfficeXiaoqu:view")
	@RequestMapping(value = "form")
	public String form(SysOfficeXiaoqu sysOfficeXiaoqu, Model model) {
		model.addAttribute("parList",sysOfficeXiaoquService.findParList());
		model.addAttribute("sysOfficeXiaoqu", sysOfficeXiaoqu);
		return "modules/wuye_xiaoqu/sysOfficeXiaoquForm";
	}

	@RequiresPermissions("wuye_xiaoqu:sysOfficeXiaoqu:edit")
	@RequestMapping(value = "save")
	public String save(SysOfficeXiaoqu sysOfficeXiaoqu, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysOfficeXiaoqu)){
			return form(sysOfficeXiaoqu, model);
		}
		sysOfficeXiaoquService.save(sysOfficeXiaoqu);
		addMessage(redirectAttributes, "保存小区信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuye_xiaoqu/sysOfficeXiaoqu/?repage";
	}
	
	@RequiresPermissions("wuye_xiaoqu:sysOfficeXiaoqu:edit")
	@RequestMapping(value = "delete")
	public String delete(SysOfficeXiaoqu sysOfficeXiaoqu, RedirectAttributes redirectAttributes) {
		sysOfficeXiaoquService.delete(sysOfficeXiaoqu);
		addMessage(redirectAttributes, "删除小区信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuye_xiaoqu/sysOfficeXiaoqu/?repage";
	}

}