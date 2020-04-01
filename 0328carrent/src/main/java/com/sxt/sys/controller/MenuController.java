package com.sxt.sys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxt.sys.costast.SysConstast;
import com.sxt.sys.domain.Menu;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.MenuService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.ResultObj;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.utils.TreeNodeBuilder;
import com.sxt.sys.utils.WebUtils;
import com.sxt.sys.vo.MenuVo;

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
	
	@RequestMapping("loadIndexLeftMenuJson")
	public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo){
		//得到当前登录的用户对象
		User user = (User) WebUtils.getHttpSession().getAttribute("user");
		
		List<Menu> list = null;
		menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);//只查询可用的
		if(user.getType()==SysConstast.USER_TYPE_SUPER) {
			list = this.menuService.queryAllMenuForList(menuVo);
		}else {
			list = this.menuService.queryMenuByUserIdForList(menuVo, user.getUserid());
		}
		
		List<TreeNode> nodes = new ArrayList<>();
		//把list里面的数据放到nodes
		for (Menu menu : list) {
			Integer id = menu.getId();
			Integer pid = menu.getPid();
			String title = menu.getTitle();
			String icon = menu.getIcon();
			String href = menu.getHref();
			Boolean spread = menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
			String target = menu.getTarget();
			nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
		}
		return TreeNodeBuilder.builder(nodes, 1);
	}

	@RequestMapping("loadMenuManagerLeftTreeJson")
	public DataGridView loadMenuManagerLeftTreeJson(MenuVo menuVo){
		menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);//只查询可用的
		List<Menu> list = this.menuService.queryAllMenuForList(menuVo);
		List<TreeNode> nodes = new ArrayList<>();
		//把list里面的数据放到nodes
		for (Menu menu : list) {
			Integer id = menu.getId();
			Integer pid = menu.getPid();
			String title = menu.getTitle();
			String icon = menu.getIcon();
			String href = menu.getHref();
			Boolean spread = menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
			String target = menu.getTarget();
			nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
		}
		return new DataGridView(nodes);
	}
		
	/**
	 * 加载菜单列表返回DataGridView
	 * @param menuVo
	 * @return
	 */
	@RequestMapping("loadAllMenu")
	public DataGridView loadAllMenu(MenuVo menuVo) {
		return this.menuService.queryAllMenu(menuVo);
	}
	
	/**
	 * 添加菜单
	 * @param menuVo
	 * @return
	 */
	@RequestMapping("addMenu")
	public ResultObj addMenu(MenuVo menuVo) {
		try {
			this.menuService.addMenu(menuVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultObj.ADD_ERROR;
	}
	
	/**
	 * 修改菜单
	 * @param menuVo
	 * @return
	 */
	@RequestMapping("updateMenu")
	public ResultObj updateMenu(MenuVo menuVo) {
		try {
			this.menuService.updateMenu(menuVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultObj.UPDATE_ERROR;
	}
	
	/**
	 * 根据id判断当前菜单有没有子节点
	 * 有返回code>=0
	 * 没有返回 code<0
	 * @param menuVo
	 * @return
	 */
	@RequestMapping("checkMenuHasChildren")
	public ResultObj checkMenuHasChildren(MenuVo menuVo){
		//根据pid查询菜单数量
		Integer count = this.menuService.queryMenuByPid(menuVo.getId());
		if(count>0) {
			return ResultObj.STATUS_TRUE;
		}else {
			return ResultObj.STATUS_FALSE;
		}
	}
	
	/**
	 * 删除菜单
	 * @param menuVo
	 * @return
	 */
	@RequestMapping("deleteMenu")
	public ResultObj deleteMenu(MenuVo menuVo) {
		try {
			this.menuService.deleteMenu(menuVo);
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultObj.DELETE_ERROR;
	}
}
