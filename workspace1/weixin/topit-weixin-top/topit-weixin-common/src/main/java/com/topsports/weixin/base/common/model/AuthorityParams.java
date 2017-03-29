package com.topsports.weixin.base.common.model;

import java.util.List;
import java.util.Map;

/**
 * 用户参数
 * @author zhang.p
 *
 */
public class AuthorityParams {
	
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 权限认证
	 */
	private boolean verification;
	/**
	 * 鍝佺墝缂栫爜
	 */
	private String brandNoVerify;
	/**
	 * 绯荤粺缂栫爜
	 */
	private String systemNoVerify;
	/**
	 * 鍖哄煙绯荤粺缂栫爜
	 */
	private String areaSystemNoVerify;
	/**
	 * 鍝佺墝缂栫爜鍙傛暟鍒楄〃
	 */
	private String[] brandNoList;
	/**
	 * 鐢ㄦ埛鎷ユ湁鍝佺墝鍒楄〃
	 */
	private List<String> hasBrandNoList;
	/**
	 * 鍦板尯
	 */
	private String areaVerify;
	/**
	 * 鍦板尯鍒楄〃
	 */
	private String[] areaList;
	/**
	 * 鐢ㄦ埛鎷ユ湁鍦板尯鍒楄〃
	 */
	private List<String> hasAreaList;
	/**
	 * 鍩庡競涓績
	 */
	private String cityCenterVerify;
	/**
	 * 鍩庡競涓績鍒楄〃
	 */
	private String[] cityCenterList;
	/**
	 * 鐢ㄦ埛鎷ユ湁鐨勫湴鍖哄垪琛�
	 */
	private List<String> hasCityCenterList;
	/**
	 * 浠撳簱
	 */
	private String storeVerify;
	/**
	 * 浠撳簱鍒楄〃
	 */
	private String[] storeList;
	/**
	 * 鐢ㄦ埛鎷ユ湁鐨勪粨搴撳垪琛�
	 */
	private List<String> hasStoreList;
	/**
	 * 闂ㄥ簵
	 */
	private String shopVerify;
	/**
	 * 闂ㄥ簵鍒楄〃
	 */
	private String[] shopList;
	/**
	 * 鐢ㄦ埛鎷ユ湁鐨勯棬搴楀垪琛�
	 */
	private List<String> hasShopList;
	/**
	 * 鏉冮檺鏌ヨ鍙傛暟
	 */
	private Map<String,List<String>> queryParams;
	
	/**
	 * {@linkplain #userId}
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * {@linkplain #userId}
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * {@linkplain #brandNoVerify}
	 * @return
	 */
	public String getBrandNoVerify() {
		return brandNoVerify;
	}

	/**
	 * {@linkplain #brandNoVerify}
	 * @param brandNoVerify
	 */
	public void setBrandNoVerify(String brandNoVerify) {
		this.brandNoVerify = brandNoVerify;
	}

	/**
	 * {@linkplain #areaVerify}
	 * @return
	 */
	public String getAreaVerify() {
		return areaVerify;
	}

	/**
	 * {@linkplain #areaVerify}
	 * @param areaVerify
	 */
	public void setAreaVerify(String areaVerify) {
		this.areaVerify = areaVerify;
	}

	/**
	 * {@linkplain #cityCenterVerify}
	 * @return
	 */
	public String getCityCenterVerify() {
		return cityCenterVerify;
	}

	/**
	 * {@linkplain #cityCenterVerify}
	 * @param cityCenterVerify
	 */
	public void setCityCenterVerify(String cityCenterVerify) {
		this.cityCenterVerify = cityCenterVerify;
	}

	/**
	 * {@linkplain #storeVerify}
	 * @return
	 */
	public String getStoreVerify() {
		return storeVerify;
	}

	/**
	 * 
	 * @param storeVerify {@linkplain #storeVerify}
	 */
	public void setStoreVerify(String storeVerify) {
		this.storeVerify = storeVerify;
	}

	/**
	 * {@linkplain #shopVerify}
	 * @return
	 */
	public String getShopVerify() {
		return shopVerify;
	}

	/**
	 * 
	 * @param shopVerify {@linkplain #shopVerify}
	 */
	public void setShopVerify(String shopVerify) {
		this.shopVerify = shopVerify;
	}

	/**
	 * {@linkplain #brandNoList}
	 * @return
	 */
	public String[] getBrandNoList() {
		return brandNoList;
	}

	/**
	 * {@linkplain #brandNoList}
	 * @param brandNoList
	 */
	public void setBrandNoList(String[] brandNoList) {
		this.brandNoList = brandNoList;
	}

	/**
	 * {@linkplain #hasBrandNoList}
	 * @return
	 */
	public List<String> getHasBrandNoList() {
		return hasBrandNoList;
	}

	/**
	 * {@linkplain #hasBrandNoList}
	 * @param hasBrandNoList
	 */
	public void setHasBrandNoList(List<String> hasBrandNoList) {
		this.hasBrandNoList = hasBrandNoList;
	}

	/**
	 * {@linkplain #areaList}
	 * @return
	 */
	public String[] getAreaList() {
		return areaList;
	}

	/**
	 * {@linkplain #areaList}
	 * @param areaList
	 */
	public void setAreaList(String[] areaList) {
		this.areaList = areaList;
	}

	/**
	 * {@linkplain #shopList}
	 * @return
	 */
	public String[] getCityCenterList() {
		return cityCenterList;
	}

	/**
	 * {@linkplain #shopList}
	 * @param cityCenterList
	 */
	public void setCityCenterList(String[] cityCenterList) {
		this.cityCenterList = cityCenterList;
	}

	/**
	 * {@linkplain #hasAreaList}
	 * @return
	 */
	public List<String> getHasAreaList() {
		return hasAreaList;
	}

	/**
	 * {@linkplain #hasAreaList}
	 * @param hasAreaList
	 */
	public void setHasAreaList(List<String> hasAreaList) {
		this.hasAreaList = hasAreaList;
	}


	/**
	 * {@linkplain #hasCityCenterList}
	 * @return
	 */
	public List<String> getHasCityCenterList() {
		return hasCityCenterList;
	}

	/**
	 * {@linkplain #hasCityCenterList}
	 * @param hasCityCenterList
	 */
	public void setHasCityCenterList(List<String> hasCityCenterList) {
		this.hasCityCenterList = hasCityCenterList;
	}


	/**
	 * {@linkplain #shopList}
	 * @return
	 */
	public String[] getStoreList() {
		return storeList;
	}

	/**
	 * {@linkplain #shopList}
	 * @param storeList
	 */
	public void setStoreList(String[] storeList) {
		this.storeList = storeList;
	}

	/**
	 * {@linkplain #hasStoreList}
	 * @return
	 */
	public List<String> getHasStoreList() {
		return hasStoreList;
	}

	/**
	 * {@linkplain #hasStoreList}
	 * @param hasStoreList
	 */
	public void setHasStoreList(List<String> hasStoreList) {
		this.hasStoreList = hasStoreList;
	}

	/**
	 * {@linkplain #shopList}
	 * @return
	 */
	public String[] getShopList() {
		return shopList;
	}

	/**
	 * {@linkplain #shopList}
	 * @param shop
	 */
	public void setShopList(String[] shopList) {
		this.shopList = shopList;
	}

	/**
	 * {@linkplain #hasShopList}
	 * @return
	 */
	public List<String> getHasShopList() {
		return hasShopList;
	}

	/**
	 * {@linkplain #hasShopList}
	 * @param hasShopList
	 */
	public void setHasShopList(List<String> hasShopList) {
		this.hasShopList = hasShopList;
	}

	/**
	 * {@linkplain #verification}
	 * @return
	 */
	public boolean isVerification() {
		return verification;
	}

	/**
	 * {@linkplain #verification}
	 * @param verification
	 */
	public void setVerification(boolean verification) {
		this.verification = verification;
	}

	/**
	 * {@linkplain #queryParams}
	 * @return
	 */
	public Map<String, List<String>> getQueryParams() {
		return queryParams;
	}

	/**
	 * {@linkplain #queryParams}
	 * @param queryParams
	 */
	public void setQueryParams(Map<String, List<String>> queryParams) {
		this.queryParams = queryParams;
	}

	/**
	 * {@link #systemNoVerify}
	 * @return
	 */
	public String getSystemNoVerify() {
		return systemNoVerify;
	}

	/**
	 * {@link #systemNoVerify}
	 * @param systemNoVerify
	 */
	public void setSystemNoVerify(String systemNoVerify) {
		this.systemNoVerify = systemNoVerify;
	}

	/**
	 * {@link #areaSystemNoVerify}
	 * @return
	 */
	public String getAreaSystemNoVerify() {
		return areaSystemNoVerify;
	}

	/**
	 * {@link #areaSystemNoVerify}
	 * @param areaSystemNoVerify
	 */
	public void setAreaSystemNoVerify(String areaSystemNoVerify) {
		this.areaSystemNoVerify = areaSystemNoVerify;
	}
}
