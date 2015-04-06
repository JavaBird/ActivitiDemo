package com.framework.core.util.page;

import java.util.List;
/**
 * EasyUI 分页类
 * @author zhangxh 2015/2/10
 *
 */
public class PageEasyUI<T> {
	private String total;
	private List<T> rows;
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
