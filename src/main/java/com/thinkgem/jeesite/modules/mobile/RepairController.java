package com.thinkgem.jeesite.modules.mobile;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.baoxiu_xinxi.entity.BaoxiuXinxi;
import com.thinkgem.jeesite.modules.baoxiu_xinxi.service.BaoxiuXinxiService;

/**
 * 报修管理
 * @author wang
 *
 */
@Controller
@RequestMapping(value = "${frontPath}/mobile")
public class RepairController extends BaseController {

	@Autowired
	private BaoxiuXinxiService baoxiuXinxiService;
	/**
	 * 报修信息列表
	 * @param response
	 * @param baoxiuXinxi
	 * @return
	 */
	@RequestMapping(value = "GetRepairList")
	public String GetRepairList(HttpServletResponse response,BaoxiuXinxi baoxiuXinxi){
		List<BaoxiuXinxi> baoxiuXinxiList=baoxiuXinxiService.findList(baoxiuXinxi);
		return renderString(response, baoxiuXinxiList);
	}
	/**
	 * 报修信息详情
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "GetRepairById")
	public String GetRepairById(HttpServletResponse response,String id){
		BaoxiuXinxi baoxiuXinxi=baoxiuXinxiService.get(id);
		return renderString(response, baoxiuXinxi);
	}
	
}
