package com.sxt.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxt.sys.service.MenuService;

/**  
*   
* 菜单管理控制器 
* @author liukz  
* @date 2020年3月31日 下午9:39:57 
*/  
@RestController
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	
}
