/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_linshi.web;

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
import com.thinkgem.jeesite.modules.renwu_linshi.entity.RenwuLinshi;
import com.thinkgem.jeesite.modules.renwu_linshi.service.RenwuLinshiService;

/**
 * 临时任务Controller
 * @author ktzhxm
 * @version 2016-02-22
 */
@Controller
@RequestMapping(value = "${adminPath}/renwu_linshi/renwuLinshi")
public class RenwuLinshiController extends BaseController {

	@Autowired
	private RenwuLinshiService renwuLinshiService;
	
	@ModelAttribute
	public RenwuLinshi get(@RequestParam(required=false) String id) {
		RenwuLinshi entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = renwuLinshiService.get(id);
		}
		if (entity == null){
			entity = new RenwuLinshi();
		}
		return entity;
	}
	
	@RequiresPermissions("renwu_linshi:renwuLinshi:view")
	@RequestMapping(value = {"list", ""})
	public String list(RenwuLinshi renwuLinshi, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<RenwuLinshi> page = renwuLinshiService.findPage(new Page<RenwuLinshi>(request, response), renwuLinshi); 
		model.addAttribute("page", page);
		return "modules/renwu_linshi/renwuLinshiList";
	}

	@RequiresPermissions("renwu_linshi:renwuLinshi:view")
	@RequestMapping(value = "form")
	public String form(RenwuLinshi renwuLinshi, Model model) {
		model.addAttribute("renwuLinshi", renwuLinshi);
		return "modules/renwu_linshi/renwuLinshiForm";
	}

	@RequiresPermissions("renwu_linshi:renwuLinshi:edit")
	@RequestMapping(value = "save")
	public String save(RenwuLinshi renwuLinshi, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, renwuLinshi)){
			return form(renwuLinshi, model);
		}
		renwuLinshiService.save(renwuLinshi);
		addMessage(redirectAttributes, "保存临时任务成功");
		return "redirect:"+Global.getAdminPath()+"/renwu_linshi/renwuLinshi/?repage";
	}
	
	@RequiresPermissions("renwu_linshi:renwuLinshi:edit")
	@RequestMapping(value = "delete")
	public String delete(RenwuLinshi renwuLinshi, RedirectAttributes redirectAttributes) {
		renwuLinshiService.delete(renwuLinshi);
		addMessage(redirectAttributes, "删除临时任务成功");
		return "redirect:"+Global.getAdminPath()+"/renwu_linshi/renwuLinshi/?repage";
	}
	//处理任务
	@RequiresPermissions("renwu_linshi:renwuLinshi:view")
	@RequestMapping(value = "chuli")
	public String chuli(RenwuLinshi renwuLinshi, Model model) {
		model.addAttribute("renwuLinshi", renwuLinshi);
		return "modules/renwu_linshi/renwuLinshiChuli";
	}
	@RequiresPermissions("renwu_linshi:renwuLinshi:edit")
	@RequestMapping(value = "saveChuli")
	public String saveChuli(RenwuLinshi renwuLinshi, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, renwuLinshi)){
			return form(renwuLinshi, model);
		}
		renwuLinshiService.saveChuli(renwuLinshi);
		addMessage(redirectAttributes, "处理临时任务成功");
		return "redirect:"+Global.getAdminPath()+"/renwu_linshi/renwuLinshi/?repage";
	}
}