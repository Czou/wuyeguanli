/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.xunjian_dict.web;

import java.util.List;

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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.xunjian_dict.entity.XunjianDict;
import com.thinkgem.jeesite.modules.xunjian_dict.service.XunjianDictService;

/**
 * 管理巡检点Controller
 * @author ktzhxm
 * @version 2016-02-17
 */
@Controller
@RequestMapping(value = "${adminPath}/xunjian_dict/xunjianDict")
public class XunjianDictController extends BaseController {

	@Autowired
	private XunjianDictService xunjianDictService;
	
	@ModelAttribute
	public XunjianDict get(@RequestParam(required=false) String id) {
		XunjianDict entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = xunjianDictService.get(id);
		}
		if (entity == null){
			entity = new XunjianDict();
		}
		return entity;
	}
	
	@RequiresPermissions("xunjian_dict:xunjianDict:view")
	@RequestMapping(value = {"list", ""})
	public String list(XunjianDict xunjianDict, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<String> leixingList = xunjianDictService.findLeixingList();
		model.addAttribute("leixingList", leixingList);
		
		Page<XunjianDict> page = xunjianDictService.findPage(new Page<XunjianDict>(request, response), xunjianDict); 
		model.addAttribute("page", page);
		return "modules/xunjian_dict/xunjianDictList";
	}

	@RequiresPermissions("xunjian_dict:xunjianDict:view")
	@RequestMapping(value = "form")
	public String form(XunjianDict xunjianDict, Model model) {
		model.addAttribute("xunjianDict", xunjianDict);
		return "modules/xunjian_dict/xunjianDictForm";
	}

	@RequiresPermissions("xunjian_dict:xunjianDict:edit")
	@RequestMapping(value = "save")
	public String save(XunjianDict xunjianDict, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, xunjianDict)){
			return form(xunjianDict, model);
		}
		xunjianDictService.save(xunjianDict);
		addMessage(redirectAttributes, "保存巡检点成功");
		return "redirect:"+Global.getAdminPath()+"/xunjian_dict/xunjianDict/?repage&leixing="+xunjianDict.getLeixing();
	}
	
	@RequiresPermissions("xunjian_dict:xunjianDict:edit")
	@RequestMapping(value = "delete")
	public String delete(XunjianDict xunjianDict, RedirectAttributes redirectAttributes) {
		xunjianDictService.delete(xunjianDict);
		addMessage(redirectAttributes, "删除巡检点成功");
		return "redirect:"+Global.getAdminPath()+"/xunjian_dict/xunjianDict/?repage";
	}
	
	//巡检点打印页面
	@RequiresPermissions("xunjian_dict:xunjianDict:view")
	@RequestMapping(value = "print")
	public String print(XunjianDict xunjianDict, Model model,HttpServletRequest request) {
		String leixingStr=request.getParameter("leixing");
		List<XunjianDict> list = xunjianDictService.findListByLeixing(leixingStr);
		model.addAttribute("xunjianList", list);
		return "modules/xunjian_dict/xunjianDictPrint";
	}
}