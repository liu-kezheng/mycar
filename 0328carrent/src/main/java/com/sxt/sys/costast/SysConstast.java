package com.sxt.sys.costast;

/**  
*   
*  常量配置接口
* @author liukz  
* @date 2020年3月31日 下午4:32:37 
*/  
public interface SysConstast {
	
	String USER_LOGIN_ERROR_MSG = "用户名或密码不正确";
	
	/**
	 * 可用状态
	 */
	Integer AVAILABLE_TRUE = 1;
	Integer AVAILABLE_FALSE = 0;
	
	/**
	 * 用户类型
	 */
	Integer USER_TYPE_SUPER = 1;
	Integer USER_TYPE_NORMAL = 1;
	
	/**
	 * 是否展开
	 */
	Integer SPREAD_TRUE = 1;
	Integer SPREAD_FALSE = 0;
	
	/**
	 * 操作状态
	 */
	String ADD_SUCCESS = "添加成功";
	String ADD_ERROR = "添加失败";
	
	String UPDATE_SUCCESS = "更新成功";
	String UPDATE_ERROR = "更新失败";
	
	String DELETE_SUCCESS = "删除成功";
	String DELETE_ERROR = "删除失败";
	
	String RESET_SUCCESS = "重置成功";
	String RESET_ERROR = "重置失败";
	
	String DISPATCH_SUCCESS = "分配成功";
	String DISPATCH_ERROR = "分配失败";
	
	Integer CODE_SUCCESS = 0; //操作成功
	Integer CODE_ERROR = -1; //操作失败
}
