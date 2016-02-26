package com.thinkgem.jeesite.modules.mobile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.wuye_heimingd.entity.DictHeimingd;
import com.thinkgem.jeesite.modules.wuye_heimingd.service.DictHeimingdService;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;
import com.thinkgem.jeesite.modules.wuyejiben.service.WuyeJibenService;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;
import com.thinkgem.jeesite.modules.wuyerenyuan.service.DictRenyuanService;
import com.thinkgem.jeesite.modules.wuyexiaoqu.entity.WuyeXiaoqu;
import com.thinkgem.jeesite.modules.wuyexiaoqu.service.WuyeXiaoquService;

/**
 * 物业基本信息
 * @author wang
 *
 */
@Controller
@RequestMapping(value = "${frontPath}/mobile")
public class PropertyController extends BaseController {
	@Autowired
	private WuyeJibenService wuyeJibenService;
	@Autowired
	private WuyeXiaoquService wuyeXiaoquService;
	@Autowired
	private DictHeimingdService dictHeimingdService;
	@Autowired
	private DictRenyuanService dictRenyuanService;
	
	/**
	 * 公司基本信息
	 * @param response
	 * @param wuyeJiben
	 * @return
	 */
	@RequestMapping(value = "getGongsilist")
	public String getGongsilist(HttpServletResponse response,WuyeJiben wuyeJiben){
		List<WuyeJiben> list = wuyeJibenService.findList(wuyeJiben);
		return renderString(response, list);
	}
	/**
	 * 小区列表信息
	 * @param response
	 * @param wuyeXiaoqu
	 * @return
	 */
	@RequestMapping(value = "getXiaoqulist")
	public String getXiaoqulist(HttpServletResponse response,WuyeXiaoqu wuyeXiaoqu){
		List<WuyeXiaoqu> list = wuyeXiaoquService.findList(wuyeXiaoqu);
		return renderString(response, list);
	}
	
	/**
	 * 黑名单
	 * @param response
	 * @param dictHeimingd
	 * @return
	 */
	@RequestMapping(value = "getHeimingdanlist")
	public String getHeimingdanlist(HttpServletResponse response,DictHeimingd dictHeimingd) {
		List<DictHeimingd> list = dictHeimingdService.findList(dictHeimingd);
		return renderString(response, list);
	}
	/**
	 * 住户人员列表
	 * @param response
	 * @param dictRenyuan
	 * @return
	 */
	@RequestMapping(value = "getRenyuanlist")
	public String getRenyuanlist(HttpServletResponse response,DictRenyuan dictRenyuan){
		List<DictRenyuan> list= dictRenyuanService.findList(dictRenyuan);
		return renderString(response, list);
	}
	
	
}
