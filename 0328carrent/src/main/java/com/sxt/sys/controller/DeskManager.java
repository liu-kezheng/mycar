package com.sxt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
*   
*  工作台的控制器
* @author liukz  
* @date 2020年3月31日 下午8:07:48 
*/  
@Controller
@RequestMapping("desk")
public class DeskManager {
	
	/**
	 * 跳转到工作台的页面
	 * @return
	 */
	@RequestMapping("toDeskManager")
	public String toDeskManager() {
		return "system/main/deskManager";
	}
	
}
