package com.qq.weixin.qy.pojo.response.message;


/**
 * 
 * @author zhangpeng
 * @version 1.0
 * @date 2014-7-19
 * @usage 微信响应图文消息
 *
 */
public class NewsMessage extends BaseMessage{
	//图文条数，默认第一条为大图。图文数不能超过10，否则将会无响应
	private int ArticleCount;
	//图文
	private Article[] Articles;
	
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public Article[] getArticles() {
		return Articles;
	}
	public void setArticles(Article[] articles) {
		Articles = articles;
	}	



}
