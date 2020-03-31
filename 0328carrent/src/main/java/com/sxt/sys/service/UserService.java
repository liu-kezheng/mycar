package com.sxt.sys.service;

import com.sxt.sys.domain.User;
import com.sxt.sys.vo.UserVo;

/**  
*   
*  用户服务类接口
* @author liukz  
* @date 2020年3月31日 下午4:16:20 
*/  
public interface UserService {

	User login(UserVo userVo);
}
