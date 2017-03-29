package com.topsports.weixin.base.common.utils;

/**
 * 分页接口
 * @author zhang.p
 *
 */
public interface Pageable {
	/**
	 * 鎬昏褰曟暟
	 * 
	 * @return
	 */
	public int getTotalCount();

	/**
	 * 鎬婚〉鏁�
	 * 
	 * @return
	 */
	public int getTotalPage();

	/**
	 * 姣忛〉璁板綍鏁�
	 * 
	 * @return
	 */
	public int getPageSize();

	/**
	 * 褰撳墠椤靛彿
	 * 
	 * @return
	 */
	public int getPageNo();

	/**
	 * 鏄惁绗竴椤�
	 * 
	 * @return
	 */
	public boolean isFirstPage();

	/**
	 * 鏄惁鏈�鍚庝竴椤�
	 * 
	 * @return
	 */
	public boolean isLastPage();

	/**
	 * 杩斿洖涓嬮〉鐨勯〉鍙�
	 */
	public int getNextPage();

	/**
	 * 杩斿洖涓婇〉鐨勯〉鍙�
	 */
	public int getPrePage();
}
