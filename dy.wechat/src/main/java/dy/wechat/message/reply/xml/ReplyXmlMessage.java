package dy.wechat.message.reply.xml;

import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import dy.wechat.message.Xml;
import dy.wechat.message.reply.ReplyMessage;

public abstract class ReplyXmlMessage implements ReplyMessage {

	@XmlElement(name = Xml.Element.ToUserName, defaultValue = "")
	@XmlCDATA
	private String toUserName;

	@XmlElement(name = Xml.Element.FromUserName, defaultValue = "")
	@XmlCDATA
	private String fromUserName;

	@XmlElement(name = Xml.Element.MsgType, defaultValue = "")
	@XmlCDATA
	private String messageType;

	public ReplyXmlMessage(Xml.Type messageType) {
		if (messageType == null) {
			throw new NullPointerException("messageType is null");
		}
		this.messageType = messageType.name();
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	@XmlElement(name = Xml.Element.CreateTime)
	public long getCreateTime() {
		return System.currentTimeMillis();
	}

	public String getMessageType() {
		return messageType;
	}
}
