package com.sxt.sys.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**  
*   
* 文件上传下载工具类 
* @author liukz  
* @date 2020年3月31日 下午2:44:05 
*/  
public class AppFileUtils {
	
	/**
	 * 得到文件上传的路径
	 */
	public static String PATH = "G:/upload/";
	static {
		InputStream stream = AppFileUtils.class.getClassLoader().getResourceAsStream("file.properties");
		Properties properties = new Properties();
		try {
			properties.load(stream);
			PATH = properties.getProperty("path");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件下载
	 * @param response
	 * @param path
	 * @param oldName
	 * @return
	 */
	public static ResponseEntity<Object> downloadFile(HttpServletResponse response, String path, String oldName){
		//使用绝对路径+相对路径去找到文件对象
		File file = new File(AppFileUtils.PATH, path);
		//判断文件是否存在
		if(file.exists()) {
			try {
				oldName = URLEncoder.encode(oldName,  "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			//把file转为一个bytes
			try {
				byte[] bytes = FileUtils.readFileToByteArray(file);
				HttpHeaders header = new HttpHeaders();
				//封装响应内容类型（APPLICATION_OCTET_STREAM 响应内容不限定）
				header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				//设置下载的文件的名称
				header.setContentDispositionFormData("attachment", oldName);
				//创建ResponseEntity对象
				ResponseEntity<Object> entity = new ResponseEntity<Object>(bytes, header, HttpStatus.ACCEPTED);
				return entity;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}else {
			PrintWriter out;
			try {
				out = response.getWriter();
				out.write("文件不存在");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
			return null;
		}
	}
	
	/**
	 * 根据相对路径删除影片上文件
	 * @param path
	 */
	public static void deleteFileUsePath(String path) {
		String realpath = PATH+path;
		//根据文件
		File file = new File(realpath);
		if(file.exists()) {
			file.delete();
		}
	}
	
}
