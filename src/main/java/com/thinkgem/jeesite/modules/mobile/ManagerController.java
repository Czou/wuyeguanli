package com.thinkgem.jeesite.modules.mobile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 手机物业管理人员操作
 * @author wang
 *
 */
@Controller
@RequestMapping(value = "${frontPath}/mobile")
public class ManagerController extends BaseController {
	@Autowired
	private SystemService systemService;
	/**
	 * 物业管理登录
	 * @param request
	 * @param response
	 * @param loginName
	 * @return
	 */
	@RequestMapping(value = "getByLoginName")
	public String getByLoginName(HttpServletResponse response,String loginName){
		User user= UserUtils.getByLoginName(loginName);
		if (user!=null) {
			return renderString(response, user);
		}
		return "";
	}
	/**
	 * 修改密码
	 * @param response
	 * @param model
	 * @param loginname
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping(value = "updatePasswordById")
	public String updatePasswordById(HttpServletResponse response,Model model,String loginname,String oldPassword,String newPassword){
		User user = UserUtils.getByLoginName(loginname);
		
		if (SystemService.validatePassword(oldPassword, user.getPassword())){
			systemService.updatePasswordById(user.getId(), user.getLoginName(), newPassword);
			model.addAttribute("message", "修改密码成功");
			return renderString(response, model);
		}else{
			model.addAttribute("message", "修改密码失败，旧密码错误");
			return renderString(response, model);
		}
	}
	/**
	 * 保存用户信息
	 * @param request
	 * @param response
	 * @param loginname
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "updateSaveUserInfo")
	public String updateSaveUserInfo(HttpServletRequest request,HttpServletResponse response,String loginname,Model model){
		String email=request.getParameter("email");
		System.out.println(email+"=====");
		String phone=request.getParameter("phone");
		String mobile=request.getParameter("mobile");
		String remarks=request.getParameter("remarks");
		String photo=request.getParameter("photo");
		
		User currentUser = UserUtils.getByLoginName(loginname);
		if(currentUser!=null){
			currentUser.setEmail(email);
			currentUser.setPhone(phone);
			currentUser.setMobile(mobile);
			currentUser.setRemarks(remarks);
			currentUser.setPhoto(photo);
			systemService.updateUserInfo(currentUser);
		}
		return renderString(response, currentUser);
	}
}
