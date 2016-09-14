package dy.wechat.message.reply.xml.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import dy.wechat.message.Xml;
import dy.wechat.message.reply.xml.ReplyXmlMessage;

@XmlRootElement(name = Xml.Element.Root)
@XmlAccessorType(XmlAccessType.NONE)
public class TextReplyXmlMessage extends ReplyXmlMessage {

	@XmlElement(name = Xml.Element.Content, defaultValue = "")
	@XmlCDATA
	private String content;

	public TextReplyXmlMessage() {
		super(Xml.Type.text);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("TextReplyXmlMessage [ToUserName=%s, FromUserName=%s, CreateTime=%s, Messaype=%s, Content=%s]", getToUserName(), getFromUserName(),
				getCreateTime(), getMessageType(), getContent());
	}
}
