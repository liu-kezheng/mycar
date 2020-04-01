package com.sxt.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxt.sys.domain.Role;

public interface RoleMapper {
	int deleteByPrimaryKey(Integer roleid);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(Integer roleid);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	/**
	 * 查询角色
	 * @param role
	 * @return
	 */
	List<Role> queryAllRole(Role role);
	
	/**
	 * 根据角色id删除sys_role_menu里面的数据
	 * @param roleid
	 */
	void deleteRoleMenuByRid(Integer roleid);
	
	/**
	 * 根据角色id删除sys_role_user里面的数据
	 * @param roleid
	 */
	void deleteRoleUserByRid(Integer roleid);

}