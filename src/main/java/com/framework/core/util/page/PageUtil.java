package com.framework.core.util.page;

import java.util.LinkedList;
import java.util.List;


public class PageUtil {
	
	/**
	 * 用封装的分页对象创建分页的方法

	 * 
	 * @param page
	 *            分页对象
	 * @param totalRecords
	 *            总记录数
	 * @return
	 */
	public static final Page createPage(Page page, long totalRecords) {
		return createPage(page.getEveryPage(), page.getCurrentPage(),
				totalRecords);
	}

	/**
	 * 用传入的基本参数创建分页的方法

	 * 
	 * @param everyPage
	 *            分页大小
	 * @param currentPage
	 *            当前页

	 * @param totalRecords
	 *            总记录数
	 * @return page
	 */
	public static Page createPage(int everyPage, int currentPage,
			long totalRecords) {
		/** 分页大小 */
		everyPage = getEveryPage(everyPage);
		/** 当前页 */
		currentPage = getCurrentPage(currentPage);
		
		if(currentPage < 1){
			currentPage = 1;
		}
		/** 记录起始数 */
		int beginIndex = getBeginIndex(everyPage, currentPage);
		/** 总页数 */
		int totalPage = getTotalPage(everyPage, totalRecords);
		
		if(totalPage<1){
			totalPage = 1;
		}
		/**应该是先算出当前页的页数，再算
		 * 
	     */
		if(currentPage > totalPage){
			currentPage=totalPage;
			beginIndex = getBeginIndex(everyPage, currentPage);
		}

		/** 是否有下页 */
		boolean hasNextPage = hasNextPage(currentPage, totalPage);
		/** 是否有上页 */
		boolean hasPrePage = hasPrePage(currentPage);
		/** 上一页 */
		int previousPage = getPreviousPage(currentPage);
		/** 下一页 */
		int nextPage = getNextPage(totalPage, currentPage);
		
		int numLenth = 7;
		/** 显示数字的集合 */
		List<Integer> displayNum = getDisplayNum(currentPage, totalPage,numLenth);
		/** 下一个跳转数 */
		int middle = 0;

		/*if(numLenth/2>displayNum.size() && displayNum.size()>0){
			middle = displayNum.get((displayNum.size())/2);
		}else{
			middle = displayNum.get(numLenth/2);
		}*/
		
		/*try {
			if(numLenth/2>displayNum.size() && displayNum.size()>0){
				
				middle = displayNum.get((displayNum.size())/2);
			}else{
				middle = displayNum.get(numLenth/2);
			}
		} catch (Exception e) {
			middle=1;
			e.printStackTrace();
		}*/
		
		
		int nextDisplayNum = getNextDisplayNum(middle, totalPage,
				numLenth);
		/** 上一个跳转数 */
		int previousDisplayNum = getPreviousDisplayNum(middle,numLenth);
		
		return new Page(hasPrePage, hasNextPage, everyPage, totalPage,
				currentPage, beginIndex, previousPage, nextPage, totalRecords,displayNum,
				nextDisplayNum, previousDisplayNum);
		
	}


	private static int getPreviousDisplayNum(int currentPage, int numLenth) {
		// TODO Auto-generated method stub
		if(currentPage - numLenth > 0){
			return currentPage - numLenth;
		}else if(currentPage - (numLenth+1)/2 > 0 ){
			return 1;
		}
		return 0;
	}

	private static int getNextDisplayNum(int currentPage, int totalPage,
			int numLenth) {
		// TODO Auto-generated method stub
		if(currentPage + numLenth < totalPage){
			return currentPage + numLenth;
		}else if(currentPage + (numLenth+1)/2 < totalPage ){
			return totalPage;
		}
		return 0;
	}

	/**
	 * 取得下页页数
	 * 
	 * @param totalPage
	 *            总页数

	 * @param curpage
	 *            当前页

	 * @return int 下页页数
	 */
	private static int getNextPage(int totalPage, int curpage) {
		if (totalPage == curpage)
			return totalPage;
		else
			return curpage + 1;
	}

	/**
	 * 取得上页页数
	 * 
	 * @param curpage
	 *            当前页

	 * @return int 上页页数
	 */
	private static int getPreviousPage(int curpage) {
		if (curpage == 1)
			return 1;
		else
			return curpage - 1;
	}

	/**
	 * 取得分页大小
	 * 
	 * @param everyPage
	 *            分页大小值,类型为整型

	 * @return int 分页大小,即每页显示多少条记录
	 */
	private static int getEveryPage(int everyPage) {
		// 如果分页为0,则默认为10
		return everyPage == 0 ? 10 : everyPage;
	}

	/**
	 * 取得当前页数
	 * 
	 * @param currentPage
	 *            当前页数
	 * @return int 当前页数
	 */
	private static int getCurrentPage(int currentPage) {
		// 如果当前页为0 ,则默认为1
		return currentPage == 0 ? 1 : currentPage;
	}

	/**
	 * 取得记录起始数

	 * 
	 * @param everyPage
	 *            分页大小
	 * @param currentPage
	 *            当前页

	 * @return int 记录起始数

	 */
	private static int getBeginIndex(int everyPage, int currentPage) {
		return (currentPage - 1) * everyPage;
	}

	/**
	 * 取得总页数

	 * 
	 * @param everyPage
	 *            分页大小
	 * @param totalRecords
	 *            总记录数
	 * @return int 总页数

	 */
	private static int getTotalPage(int everyPage, long totalRecords) {
		return (int) ((totalRecords+everyPage-1) / everyPage);
	}

	/**
	 * 判断是否有上页

	 * 
	 * @param currentPage
	 *            当前页

	 * @return boolean 有上页则返回true,否则false;
	 */
	private static boolean hasPrePage(int currentPage) {
		// 若当前页为1,则没有上页

		return currentPage == 1 ? false : true;
	}

	/**
	 * 判断是否有下页

	 * 
	 * @param currentPage
	 *            当前页

	 * @param totalPage
	 *            总页数

	 * @return boolean 有下页则返回true,否则false;
	 */
	private static boolean hasNextPage(int currentPage, int totalPage) {
		// 若当前页为最后页,则没有下页

		return currentPage == totalPage || totalPage == 0 ? false : true;
	}

	/** 按一定的基数显示数字页码 */
	private static List<Integer> getDisplayNum(int currentPage, int totalPage,
			int baseNum) {
		
		LinkedList<Integer> nums = new LinkedList<Integer>();
		int count = 1;
		int half = (baseNum-1)/2;
		nums.add(currentPage);
		if(currentPage-1 < totalPage-currentPage){
			for(int i=0 ; i<half ;i++){
				int num = currentPage-i-1;
				if(num < 1){
					break;
				}else{
					nums.addFirst(num);
					count++;
				}
			}
			for(int j=0 ; count<baseNum ; j++){
				int num = currentPage + j + 1;
				if(num > totalPage){
					return nums;
				}else{
					nums.addLast(num);
					count++;
				}
			}
		}else{
			for(int j=0 ; j<half ; j++){
				int num = currentPage + j + 1;
				if(num > totalPage){
					break;
				}else{
					nums.addLast(num);
					count++;
				}
			}
			for(int i=0 ;count<baseNum ;i++){
				int num = currentPage-i-1;
				if(num < 1){
					return nums;
				}else{
					nums.addFirst(num);
					count++;
				}
			}
		}
		return nums;
	}
	
}
