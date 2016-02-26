package com.thinkgem.jeesite.modules.mobile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.jianyi_huifang.entity.JianyiHuifang;
import com.thinkgem.jeesite.modules.jianyi_huifang.service.JianyiHuifangService;
import com.thinkgem.jeesite.modules.jianyi_xinxi.entity.JianyiXinxi;
import com.thinkgem.jeesite.modules.jianyi_xinxi.service.JianyiXinxiService;
import com.thinkgem.jeesite.modules.oa.entity.OaNotify;
import com.thinkgem.jeesite.modules.oa.service.OaNotifyService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
/**
 * 建议信息管理
 * @author wang
 *
 */
@Controller
@RequestMapping(value = "${frontPath}/mobile")
public class SuggestController extends BaseController{
	@Autowired
	private OaNotifyService oaNotifyService;
	@Autowired
	private JianyiXinxiService jianyiXinxiService;
	@Autowired
	private JianyiHuifangService jianyiHuifangService;
	
	/**
	 * 通知列表
	 * @param response
	 * @param oaNotify
	 * @return
	 */
	@RequestMapping(value = "getTongzhilist")
	public String getTongzhilist(HttpServletResponse response,OaNotify oaNotify){
		List<OaNotify> list=oaNotifyService.findList(oaNotify);
		return renderString(response, list);
	}
	/**
	 * 通知详细
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getTongzhiDetail")
	public String getTongzhiDetail(HttpServletResponse response,String id){
		OaNotify oaNotify = oaNotifyService.get(id);
		if(oaNotify!=null){
			return renderString(response, oaNotify);
		}
		return "";
	}
	/**
	 * 建议信息列表
	 * @param jianyiXinxi
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getJianyiList")
	public String getJianyiList(JianyiXinxi jianyiXinxi,HttpServletResponse response) {
		List<JianyiXinxi> list=jianyiXinxiService.findList(jianyiXinxi);
		return renderString(response, list);
	}
	/**
	 * 建议信息详情
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getJianyiDetail")
	public String getJianyiDetail(HttpServletResponse response,String id){
		JianyiXinxi jianyiXinxi = jianyiXinxiService.get(id);
		if(jianyiXinxi!=null){
			return renderString(response, jianyiXinxi);
		}
		return "";
	}
	/**
	 * 保存回访信息
	 * @param response
	 * @param mingcheng
	 * @param xinxiid
	 * @return
	 */
	@RequestMapping(value = "getJianyiHuifangSave")
	public String getJianyiHuifangSave(HttpServletResponse response,Model model,String loginName,String mingcheng,String xinxiid){
		User user= UserUtils.getByLoginName(loginName);
		JianyiHuifang jianyiHuifang=new JianyiHuifang();
		jianyiHuifang.setMingcheng(mingcheng);
		jianyiHuifang.setXinxiid(xinxiid);
		jianyiHuifang.setCreateBy(user.getCreateBy());
		jianyiHuifang.setUpdateBy(user.getUpdateBy());
		jianyiHuifangService.save(jianyiHuifang);
		model.addAttribute("message", "回复成功");
		return renderString(response, model);
	}
	/**
	 * 查看建议信息回回访列表
	 * @param response
	 * @param xinxiid
	 * @return
	 */
	@RequestMapping(value = "getJianyiHuifangByxinxiId")
	public String getJianyiHuifangByxinxiId(HttpServletResponse response,String xinxiid){
		JianyiHuifang jianyiHuifang=new JianyiHuifang();
		jianyiHuifang.setXinxiid(xinxiid);
		List<JianyiHuifang> jianyiHuifangList =jianyiHuifangService.findList( jianyiHuifang);
		return renderString(response, jianyiHuifangList);
		
	}
}
