/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.xunjian_jilu.web;

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
import com.thinkgem.jeesite.modules.xunjian_jilu.entity.XunjianJilu;
import com.thinkgem.jeesite.modules.xunjian_jilu.service.XunjianJiluService;

/**
 * 巡检记录Controller
 * @author ktzhxm
 * @version 2016-02-23
 */
@Controller
@RequestMapping(value = "${adminPath}/xunjian_jilu/xunjianJilu")
public class XunjianJiluController extends BaseController {

	@Autowired
	private XunjianJiluService xunjianJiluService;
	
	@ModelAttribute
	public XunjianJilu get(@RequestParam(required=false) String id) {
		XunjianJilu entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = xunjianJiluService.get(id);
		}
		if (entity == null){
			entity = new XunjianJilu();
		}
		return entity;
	}
	
	@RequiresPermissions("xunjian_jilu:xunjianJilu:view")
	@RequestMapping(value = {"list", ""})
	public String list(XunjianJilu xunjianJilu, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<XunjianJilu> page = xunjianJiluService.findPage(new Page<XunjianJilu>(request, response), xunjianJilu); 
		model.addAttribute("page", page);
		return "modules/xunjian_jilu/xunjianJiluList";
	}

	@RequiresPermissions("xunjian_jilu:xunjianJilu:view")
	@RequestMapping(value = "form")
	public String form(XunjianJilu xunjianJilu, Model model) {
		model.addAttribute("xunjianJilu", xunjianJilu);
		return "modules/xunjian_jilu/xunjianJiluForm";
	}

	@RequiresPermissions("xunjian_jilu:xunjianJilu:edit")
	@RequestMapping(value = "save")
	public String save(XunjianJilu xunjianJilu, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, xunjianJilu)){
			return form(xunjianJilu, model);
		}
		xunjianJiluService.save(xunjianJilu);
		addMessage(redirectAttributes, "保存巡检成功");
		return "redirect:"+Global.getAdminPath()+"/xunjian_jilu/xunjianJilu/?repage";
	}
	
	@RequiresPermissions("xunjian_jilu:xunjianJilu:edit")
	@RequestMapping(value = "delete")
	public String delete(XunjianJilu xunjianJilu, RedirectAttributes redirectAttributes) {
		xunjianJiluService.delete(xunjianJilu);
		addMessage(redirectAttributes, "删除巡检成功");
		return "redirect:"+Global.getAdminPath()+"/xunjian_jilu/xunjianJilu/?repage";
	}

}