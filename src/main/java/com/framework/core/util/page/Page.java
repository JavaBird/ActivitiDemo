package com.framework.core.util.page;

import java.util.List;

/**
 * 功能：对分页属性的封装
 * 
 * @author Administrator
 * 
 */
public class Page {

	/** 是否有上一页 */
	private boolean hasPrePage;
	

	/** 是否有下一页 */
	private boolean hasNextPage;

	/** 分页大小 */
	private int everyPage;

	/** 总页数 */
	private int totalPage;

	/** 当前页 */
	private int currentPage;

	/** 记录起始数 */
	private int beginIndex;

	/** 下一页 */
	private int nextPage;

	/** 上一页 */
	private int previousPage;

	/** 总记录数 */
	private long totalCount;

	/** 基于数字显示的数组 */
	@SuppressWarnings("rawtypes")
	private List displayNum;

	/** 跳转到下一个显示的数组 */
	private int nextDisplayNum;

	/** 跳转到上一个显示的数组 */
	private int previousDisplayNum;


	public int getNextDisplayNum() {
		return nextDisplayNum;
	}

	public void setNextDisplayNum(int nextDisplayNum) {
		this.nextDisplayNum = nextDisplayNum;
	}

	@SuppressWarnings("rawtypes")
	public List getDisplayNum() {
		return displayNum;
	}

	@SuppressWarnings("rawtypes")
	public void setDisplayNum(List displayNum) {
		this.displayNum = displayNum;
	}

	/**
	 * 默认的构造函数

	 * 
	 */
	public Page() {

	}

	/**
	 * 用分页大小构造分页对象

	 * 
	 * @param everyPage
	 *            分页大小
	 */
	public Page(int everyPage) {
		this.everyPage = everyPage;
	}

	/**
	 * 完整的构造分页对象的方法
	 * 
	 * @param hasPrePage
	 *            是否有上页

	 * @param hasNextPage
	 *            是否有下页

	 * @param everyPage
	 *            分页大小
	 * @param totalPage
	 *            总页数

	 * @param currentPage
	 *            当前页

	 * @param beginIndex
	 *            记录起始数

	 * @param previousPage
	 *            上页页数
	 * @param nextPage
	 *            下页页数
	 * @param totalCount
	 *            总记录数
	 */

	@SuppressWarnings("rawtypes")
	public Page(boolean hasPrePage, boolean hasNextPage, int everyPage,
			int totalPage, int currentPage, int beginIndex, int previousPage,
			int nextPage, long totalCount, List displayNum,
			int nextDisplayNum, int previousDisplayNum) {
		this.totalCount = totalCount;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
		this.everyPage = everyPage;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.beginIndex = beginIndex;
		this.previousPage = previousPage;
		this.nextPage = nextPage;
		this.displayNum = displayNum;
		this.nextDisplayNum = nextDisplayNum;
		this.previousDisplayNum = previousDisplayNum;
	}

	/**
	 * @return 记录起始数.
	 */
	public int getBeginIndex() {
		return beginIndex;
	}

	/**
	 * @param beginIndex
	 *            设置记录起始位置.
	 */
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	/**
	 * @return 当前页数.
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            设置当前页页数.
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return 分页大小,即每页显示多少条记录.
	 */
	public int getEveryPage() {
		return everyPage;
	}

	/**
	 * @param everyPage
	 *            设置分页大小.
	 */
	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	/**
	 * @return 是否有下页.
	 */
	public boolean getHasNextPage() {
		return hasNextPage;
	}

	/**
	 * @param hasNextPage
	 *            设置是否有下页.
	 */
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	/**
	 * @return 是否有上页.
	 */
	public boolean getHasPrePage() {
		return hasPrePage;
	}

	/**
	 * @param hasPrePage
	 *            设置是否有上页.
	 */
	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	/**
	 * @return 总页数.
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage
	 *            设置总页数.
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return 总记录数
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * 
	 * @param totalCount
	 *            设置总记录数.
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 
	 * @return 下页页数
	 */
	public int getNextPage() {
		return nextPage;
	}

	/**
	 * @param nextPage
	 *            设置下页页数.
	 */
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	/**
	 * 
	 * @return 上页页数
	 */
	public int getPreviousPage() {
		return previousPage;
	}

	/**
	 * 
	 * @param previousPage
	 *            设置上页页数.
	 */
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getPreviousDisplayNum() {
		return previousDisplayNum;
	}

	public void setPreviousDisplayNum(int previousDisplayNum) {
		this.previousDisplayNum = previousDisplayNum;
	}

}
