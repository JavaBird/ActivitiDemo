package com.framework.core.util.page;

import java.util.List;

/**
 * 分页列表类定义
 * 
 * @author renhui
 *
 * @param <T> 泛型
 * @version 1.0
 */
public class PageList<T> {
	
	private Page page;
	
	private List<T> list;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	public PageList()
	{
		
	}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public PageList(Page page, List list) { 
	        this.page = page; 
	        this.list = list; 
	    } 
	/**
	 * 对list手动分页
	 * @param page
	 * @param list
	 * @return PageList
	 */
	public PageList getListsByPage(Page page,List list){
		
		int offset = (page.getCurrentPage() - 1) * page.getEveryPage();
		Integer count = list.size()>=page.getEveryPage()?page.getEveryPage():list.size();
		
		PageList retList = new PageList();
		retList.setPage(page);
		
		if(count.equals(Integer.valueOf(0)))
			retList.setList(list);
		else
		{
		  Integer toIndex =offset+count;
		  if((toIndex)>list.size())
			  toIndex = list.size();
		  
		  retList.setList(list.subList(offset, toIndex));
		}
		return retList;
	}
}

