package com.thinkgem.jeesite.modules.mobile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.renwu_templ.entity.RenwuTempl;
import com.thinkgem.jeesite.modules.renwu_templ.service.RenwuTemplService;
/**
 * 任务管理
 * @author wang
 *
 */
@Controller
@RequestMapping(value = "${frontPath}/mobile")
public class TaskController extends BaseController{
	@Autowired
	private RenwuTemplService renwuTemplService;
	
	/**
	 * 任务列表
	 * @param response
	 * @param renwuTempl
	 * @return
	 */
	@RequestMapping(value = "getTaskList")
	public String getTaskList(HttpServletResponse response,RenwuTempl renwuTempl){
		List<RenwuTempl> list = renwuTemplService.findList(renwuTempl); 
		return renderString(response, list);
	}
	/**
	 * 任务详情
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getTaskByDetail")
	public String getTaskByDetail(HttpServletResponse response,String id){
		RenwuTempl renwuTempl=renwuTemplService.get(id);
		if(renwuTempl!=null){
			return renderString(response, renwuTempl);
		}
		return "";
		
	}
	
	@RequestMapping(value = "getTaskSave")
	public String getTaskSave(HttpServletResponse response,HttpServletRequest request,String id,RenwuTempl renwuTempl){
		
		String parent=request.getParameter("parent");
		String parentIds=request.getParameter("parentIds");
		String mingcheng=request.getParameter("mingcheng");
		String taskcycle=request.getParameter("taskcycle");
		String taskdep=request.getParameter("taskdep");
		RenwuTempl renwuTempltask=new RenwuTempl();
		if(id==null){
			renwuTempl.setId(id);
		}
		//renwuTempltask.setParent(parent);
		renwuTempltask.setParentIds(parentIds);
		renwuTempltask.setMingcheng(mingcheng);
		//renwuTempltask.setTaskcycle(taskcycle);
		//renwuTempltask.setTaskdep(taskdep);
		renwuTemplService.save(renwuTempltask);
		return renderString(response, renwuTempl);
	}
}
