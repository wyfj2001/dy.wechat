package dy.wechat.message.request.json.custom.impl;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dy.wechat.message.Json;
import dy.wechat.message.request.json.custom.RequestJsonCustomMessage;

public class NewsRequestJsonCustomMessage extends RequestJsonCustomMessage<List<NewsRequestJsonCustomMessage.Article>> {

	public NewsRequestJsonCustomMessage() {
		super(Json.Type.news);
	}
	
	public NewsRequestJsonCustomMessage(String kfAccount) {
		super(Json.Type.news, kfAccount);
	}

	@JsonIgnore
	public List<NewsRequestJsonCustomMessage.Article> getArticles() {
		return get(Json.PropertyName.articles);
	}
	
	public void setArticles(List<NewsRequestJsonCustomMessage.Article> articles) {
		set(Json.PropertyName.articles, articles);
	}
	
	public void addArticle(String title, String description, String picUrl, String url) {
		if (getArticles() == null) {
			setArticles(new ArrayList<NewsRequestJsonCustomMessage.Article>());
		}
		
		getArticles().add(new Article(title, description, picUrl, url));
	}
	
	static class Article {
		String title;
		
		String description;
		
		String picurl;
		
		String url;

		Article() {
		}
		
		public Article(String title, String description, String picurl, String url) {
			this.title = title;
			this.description = description;
			this.picurl = picurl;
			this.url = url;
		}

		public String getTitle() {
			return title;
		}

		public String getDescription() {
			return description;
		}

		public String getPicurl() {
			return picurl;
		}

		public String getUrl() {
			return url;
		}
	}
}
