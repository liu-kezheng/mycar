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
	
}
