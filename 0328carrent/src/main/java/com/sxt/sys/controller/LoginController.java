package com.sxt.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxt.sys.costast.SysConstast;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.WebUtils;
import com.sxt.sys.vo.UserVo;

/**  
*   
* 用户登录控制器  
* @author liukz  
* @date 2020年3月31日 下午4:19:38 
*/  
@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "system/main/login";
	}
	
	/**
	 * 登录方法
	 * @param userVo
	 * @return
	 */
	@RequestMapping("login")
	public String login(UserVo userVo, Model model) {
		User user = this.userService.login(userVo);
		if(null!=user) {
			//放入session
			WebUtils.getHttpSession().setAttribute("user", user);
			
			//记录登录日志 向sys_login_log里面插入数据
			
			return "system/main/index";
		}else {
			model.addAttribute("error", SysConstast.USER_LOGIN_ERROR_MSG);
			return "system/main/login";
		}
	}
}
