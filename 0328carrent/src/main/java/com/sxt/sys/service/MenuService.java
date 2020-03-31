package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.Menu;
import com.sxt.sys.vo.MenuVo;

/**  
*   
* 菜单管理的服务接口 
* @author liukz  
* @date 2020年3月31日 下午9:26:15 
*/  
public interface MenuService {
	
	/**
	 * 查询所有菜单返回
	 * @param menuVo
	 * @return
	 */
	public List<Menu> queryAllMenuForList(MenuVo menuVo);
	
	/**
	 * 根据用户id查询用户的可以菜单
	 * @param menuVo
	 * @param userId
	 * @return
	 */
	public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId);
}
