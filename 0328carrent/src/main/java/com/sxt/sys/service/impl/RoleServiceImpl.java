package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.Role;
import com.sxt.sys.mapper.RoleMapper;
import com.sxt.sys.service.RoleService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.RoleVo;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> queryAllRoleForList(RoleVo roleVo) {
		
		return roleMapper.queryAllRole(roleVo);
	}
	
	/**
	 * 后期权限管理完成后更改
	 */
	@Override
	public List<Role> queryRoleByUserIdForList(RoleVo roleVo, Integer userId) {
		
		return roleMapper.queryAllRole(roleVo);
	}

	@Override
	public DataGridView queryAllRole(RoleVo roleVo) {
		Page<Object> page = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
		List<Role> data = this.roleMapper.queryAllRole(roleVo);
		
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addRole(RoleVo roleVo) {
		
		this.roleMapper.insertSelective(roleVo);
	}

	@Override
	public void updateRole(RoleVo roleVo) {
		
		this.roleMapper.updateByPrimaryKeySelective(roleVo);
	}


	@Override
	public void deleteRole(Integer roleid) {
		//删除角色表的数据
		this.roleMapper.deleteByPrimaryKey(roleid);
		//根据角色id删除sys_role_menu里面的数据
		this.roleMapper.deleteRoleMenuByRid(roleid);	
		//根据角色id删除sys_role_user里面的数据
		this.roleMapper.deleteRoleUserByRid(roleid);
	}

	@Override
	public void deleteBatchRole(Integer[] ids) {
		
		
	}

}
