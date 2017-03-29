package com.qq.weixin.qy.pojo.push.message;

/**
 * 推送MP图文消息
 * @author zhang.p
 *
 */
public class MPNewsMessage extends BaseMessage{
	private MPnews mpnews;
	
	
	public MPnews getMpnews() {
		return mpnews;
	}

	public void setMpnews(MPArticle[] articles) {
		MPnews mpnews=new MPnews();
		mpnews.setArticles(articles);
		this.mpnews = mpnews;
	}


	public class MPnews{
		private MPArticle[] articles;

		public MPArticle[] getArticles() {
			return articles;
		}

		public void setArticles(MPArticle[] articles) {
			this.articles = articles;
		}
		
	}
}
