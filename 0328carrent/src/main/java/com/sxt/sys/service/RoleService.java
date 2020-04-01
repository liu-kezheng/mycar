package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.Role;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.RoleVo;

/**  
*   
*  角色管理的服务接口 
* @author liukz  
* @date 2020年4月1日 下午9:26:01 
*/  
public interface RoleService {
	
	/**
	 * 查询所有角色返回
	 * @param roleVo
	 * @return
	 */
	public List<Role> queryAllRoleForList(RoleVo roleVo);
	
	/**
	 * 根据用户id查询用户的可用角色
	 * @param roleVo
	 * @param userId
	 * @return
	 */
	public List<Role> queryRoleByUserIdForList(RoleVo roleVo, Integer userId);
	
	/**
	 * 查询所有角色
	 * @param roleVo
	 * @return
	 */
	public DataGridView queryAllRole(RoleVo roleVo);
	
	/**
	 * 添加角色
	 * @param roleVo
	 */
	public void addRole(RoleVo roleVo);
	
	/**
	 * 修改角色
	 * @param roleVo
	 */
	public void updateRole(RoleVo roleVo);
	
	/**
	 * 根据id删除角色
	 * @param roleVo
	 */
	public void deleteRole(Integer roleid);
	
	/**
	 * 批量删除角色
	 * @param roleVo
	 */
	public void deleteBatchRole(Integer[] ids);
}
