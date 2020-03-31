package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.sys.domain.Menu;
import com.sxt.sys.mapper.MenuMapper;
import com.sxt.sys.service.MenuService;
import com.sxt.sys.vo.MenuVo;
@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> queryAllMenuForList(MenuVo menuVo) {
		
		return menuMapper.queryAllMenu(menuVo);
	}
	
	/**
	 * 后期权限管理完成后更改
	 */
	@Override
	public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId) {
		
		return menuMapper.queryAllMenu(menuVo);
	}

}
