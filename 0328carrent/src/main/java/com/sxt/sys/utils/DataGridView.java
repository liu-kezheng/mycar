package com.sxt.sys.utils;

/**  
*   
*  封装layui数据表格的数据对象
* @author liukz  
* @date 2020年4月1日 上午11:54:20 
*/  
public class DataGridView {
	
	private Integer code = 0;
	private String msg = "";
	private Long count;
	private Object data;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public DataGridView(Object data) {
		super();
		this.data = data;
	}
	public DataGridView() {
		// TODO Auto-generated constructor stub
	}
}
