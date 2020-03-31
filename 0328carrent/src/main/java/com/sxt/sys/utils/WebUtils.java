package com.sxt.sys.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**  
*   
*  Web的工具类
* @author liukz  
* @date 2020年3月31日 下午3:16:40 
*/  
public class WebUtils {
	
	public static ServletRequestAttributes getServletRequestAttributes() {
		return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	}
	
	/**
	 * 获取当前线程的请求对象
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return getServletRequestAttributes().getRequest();
	}
	
	/**
	 * 获取当前线程的响应对象
	 * @return
	 */
	public static HttpServletResponse getHttpServletResponse() {
		return getServletRequestAttributes().getResponse();
	}
	
	/**
	 * 获取session对象
	 * @return
	 */
	public static HttpSession getHttpSession() {
		return getHttpServletRequest().getSession();
	}
	
	/**
	 * 得到servletContext对象
	 * @return
	 */
	public static ServletContext getServletContext() {
		return  ((HttpSession) getHttpServletRequest()).getServletContext();
	}


}
