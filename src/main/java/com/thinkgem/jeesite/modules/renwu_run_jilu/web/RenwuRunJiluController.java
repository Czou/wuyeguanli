/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_run_jilu.web;

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
import com.thinkgem.jeesite.modules.renwu_run_jilu.entity.RenwuRunJilu;
import com.thinkgem.jeesite.modules.renwu_run_jilu.service.RenwuRunJiluService;

/**
 * 任务执行记录Controller
 * @author ktzhxm
 * @version 2016-02-10
 */
@Controller
@RequestMapping(value = "${adminPath}/renwu_run_jilu/renwuRunJilu")
public class RenwuRunJiluController extends BaseController {

	@Autowired
	private RenwuRunJiluService renwuRunJiluService;
	
	@ModelAttribute
	public RenwuRunJilu get(@RequestParam(required=false) String id) {
		RenwuRunJilu entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = renwuRunJiluService.get(id);
		}
		if (entity == null){
			entity = new RenwuRunJilu();
		}
		return entity;
	}
	
	@RequiresPermissions("renwu_run_jilu:renwuRunJilu:view")
	@RequestMapping(value = {"list", ""})
	public String list(RenwuRunJilu renwuRunJilu, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<RenwuRunJilu> page = renwuRunJiluService.findPage(new Page<RenwuRunJilu>(request, response), renwuRunJilu); 
		model.addAttribute("page", page);
		return "modules/renwu_run_jilu/renwuRunJiluList";
	}

	@RequiresPermissions("renwu_run_jilu:renwuRunJilu:view")
	@RequestMapping(value = "form")
	public String form(RenwuRunJilu renwuRunJilu, Model model) {
		model.addAttribute("renwuRunJilu", renwuRunJilu);
		return "modules/renwu_run_jilu/renwuRunJiluForm";
	}

	@RequiresPermissions("renwu_run_jilu:renwuRunJilu:edit")
	@RequestMapping(value = "save")
	public String save(RenwuRunJilu renwuRunJilu, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, renwuRunJilu)){
			return form(renwuRunJilu, model);
		}
		renwuRunJiluService.save(renwuRunJilu);
		addMessage(redirectAttributes, "保存执行情况成功");
		return "redirect:"+Global.getAdminPath()+"/renwu_run_jilu/renwuRunJilu/?repage";
	}
	
	@RequiresPermissions("renwu_run_jilu:renwuRunJilu:edit")
	@RequestMapping(value = "delete")
	public String delete(RenwuRunJilu renwuRunJilu, RedirectAttributes redirectAttributes) {
		renwuRunJiluService.delete(renwuRunJilu);
		addMessage(redirectAttributes, "删除执行情况成功");
		return "redirect:"+Global.getAdminPath()+"/renwu_run_jilu/renwuRunJilu/?repage";
	}

}