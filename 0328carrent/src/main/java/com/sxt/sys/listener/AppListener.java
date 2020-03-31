package com.sxt.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 取到ServletContext
		ServletContext context = sce.getServletContext();
		context.setAttribute("ctx", context.getContextPath());
		System.out.println("---------Servlet容器创建成功 ctx被放到ServletContext作用域-------");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
}
