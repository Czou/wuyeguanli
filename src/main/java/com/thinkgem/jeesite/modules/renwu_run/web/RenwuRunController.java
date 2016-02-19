/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_run.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.renwu_run.entity.RenwuRun;
import com.thinkgem.jeesite.modules.renwu_run.service.RenwuRunService;

/**
 * 任务执行Controller
 * @author ktzhxm
 * @version 2016-02-09
 */
@Controller
@RequestMapping(value = "${adminPath}/renwu_run/renwuRun")
public class RenwuRunController extends BaseController {

	@Autowired
	private RenwuRunService renwuRunService;
	
	@ModelAttribute
	public RenwuRun get(@RequestParam(required=false) String id) {
		RenwuRun entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = renwuRunService.get(id);
		}
		if (entity == null){
			entity = new RenwuRun();
		}
		return entity;
	}
	
	@RequiresPermissions("renwu_run:renwuRun:view")
	@RequestMapping(value = {"list", ""})
	public String list(RenwuRun renwuRun, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<RenwuRun> list = renwuRunService.findList(renwuRun); 
		for(RenwuRun run:list){
			if("0".equals(run.getTaskstatus())){
				run.setTaskText("处理");
				run.setTaskstatus("未处理");
			}else{
				run.setTaskText("查看");
				run.setTaskstatus("处理完毕");
			}
		}
		model.addAttribute("list", list);
		return "modules/renwu_run/renwuRunList";
	}

	@RequiresPermissions("renwu_run:renwuRun:view")
	@RequestMapping(value = "form")
	public String form(RenwuRun renwuRun, Model model) {
		if (renwuRun.getParent()!=null && StringUtils.isNotBlank(renwuRun.getParent().getId())){
			renwuRun.setParent(renwuRunService.get(renwuRun.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(renwuRun.getId())){
				RenwuRun renwuRunChild = new RenwuRun();
				renwuRunChild.setParent(new RenwuRun(renwuRun.getParent().getId()));
				List<RenwuRun> list = renwuRunService.findList(renwuRun); 
				if (list.size() > 0){
					renwuRun.setSort(list.get(list.size()-1).getSort());
					if (renwuRun.getSort() != null){
						renwuRun.setSort(renwuRun.getSort() + 30);
					}
				}
			}
		}
		if (renwuRun.getSort() == null){
			renwuRun.setSort(30);
		}
		model.addAttribute("renwuRun", renwuRun);
		return "modules/renwu_run/renwuRunForm";
	}

	@RequiresPermissions("renwu_run:renwuRun:edit")
	@RequestMapping(value = "save")
	public String save(RenwuRun renwuRun, Model model, RedirectAttributes redirectAttributes) {
		renwuRunService.save(renwuRun);
		addMessage(redirectAttributes, "保存任务成功");
		return "redirect:"+Global.getAdminPath()+"/renwu_run/renwuRun/?repage";
	}
	
	@RequiresPermissions("renwu_run:renwuRun:edit")
	@RequestMapping(value = "delete")
	public String delete(RenwuRun renwuRun, RedirectAttributes redirectAttributes) {
		renwuRunService.delete(renwuRun);
		addMessage(redirectAttributes, "删除任务成功");
		return "redirect:"+Global.getAdminPath()+"/renwu_run/renwuRun/?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<RenwuRun> list = renwuRunService.findList(new RenwuRun());
		for (int i=0; i<list.size(); i++){
			RenwuRun e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
}