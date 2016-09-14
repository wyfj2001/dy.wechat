package dy.wechat.message.reply.xml.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import dy.wechat.message.Xml;
import dy.wechat.message.reply.xml.ReplyXmlMessage;

@XmlRootElement(name = Xml.Element.Root)
@XmlAccessorType(XmlAccessType.NONE)
public class NewsReplyXmlMessage extends ReplyXmlMessage {

	@XmlElement(name = Xml.Element.Articles)
	private Articles articles = new Articles();

	public NewsReplyXmlMessage() {
		super(Xml.Type.news);
	}

	@XmlElement(name = Xml.Element.ArticleCount)
	public int getArticleCount() {
		return articles.size();
	}

	public List<Item> getItems() {
		return articles.items;
	}

	public void addItem(String title, String description, String picUrl, String url) {
		if (articles.items == null) {
			articles.items = new ArrayList<Item>();
		}
		articles.items.add(new Item(title, description, picUrl, url));
	}

	@Override
	public String toString() {
		return String.format("NewsReplyXmlMessage [articleCount=%s, ToUserName=%s, FromUserName=%s, CreateTime=%s, Articles=%s]", getArticleCount(),
				getToUserName(), getFromUserName(), getCreateTime(), articles);
	}

	@XmlAccessorType(XmlAccessType.NONE)
	static class Articles {
		@XmlElement(name = Xml.Element.item)
		List<Item> items;

		int size() {
			return items == null ? 0 : items.size();
		}

		@Override
		public String toString() {
			return items == null ? "" : items.toString();
		}
	}

	@XmlAccessorType(XmlAccessType.NONE)
	static class Item {

		@XmlElement(name = Xml.Element.Title, defaultValue = "")
		@XmlCDATA
		private String title;

		@XmlElement(name = Xml.Element.Description, defaultValue = "")
		@XmlCDATA
		private String description;

		@XmlElement(name = Xml.Element.PicUrl, defaultValue = "")
		@XmlCDATA
		private String picUrl;

		@XmlElement(name = Xml.Element.Url, defaultValue = "")
		@XmlCDATA
		private String url;

		Item() {
		}

		Item(String title, String description, String picUrl, String url) {
			super();
			this.title = title;
			this.description = description;
			this.picUrl = picUrl;
			this.url = url;
		}

		@Override
		public String toString() {
			return String.format("Item [title=%s, description=%s, picUrl=%s, url=%s]", title, description, picUrl, url);
		}
	}
}
