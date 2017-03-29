package com.qq.weixin.qy.pojo.push.message;

/**
 * 推送图文消息
 * @author zhang.p
 *
 */
public class NewsMessage extends BaseMessage{
	private News news;
	
	public News getNews() {
		return news;
	}


	public void setNews(Article[] articles) {
		News news=new News();
		news.setArticles(articles);
		this.news = news;
	}


	public class News{
		private Article[] articles;

		public Article[] getArticles() {
			return articles;
		}

		public void setArticles(Article[] articles) {
			this.articles = articles;
		} 
		
	}
}
