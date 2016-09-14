package dy.wechat.message.receive.xml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.math.NumberUtils;
import org.w3c.dom.Element;

import dy.wechat.message.Xml;
import dy.wechat.message.receive.ReceiveMessage;

@XmlRootElement(name = Xml.Element.Root)
@XmlAccessorType(XmlAccessType.NONE)
public class ReceiveXmlMessage implements ReceiveMessage {

	@XmlAnyElement
	private List<Element> elements;

	private Map<String, Element> elementMap;
	private boolean isCache;

	@Override
	public String get(String name) {
		cacheElements();

		Element element = elementMap.get(name);

		return element == null ? null : element.getTextContent();
	}

	@Override
	public boolean hasElement(String name) {
		cacheElements();
		return elementMap.containsKey(name.toString());
	}

	public String getToUserName() {
		return get(Xml.Element.ToUserName);
	}

	public String getFromUserName() {
		return get(Xml.Element.FromUserName);
	}

	public long getCreateTime() {
		return NumberUtils.toLong(get(Xml.Element.CreateTime), 0);
	}

	public String getMsgType() {
		return get(Xml.Element.MsgType);
	}

	private synchronized void cacheElements() {
		if (isCache) {
			return;
		}

		isCache = true;

		if (elementMap == null) {
			elementMap = new HashMap<String, Element>(elements == null ? 0 : elements.size());
		}
		if (elements == null || elements.isEmpty()) {
			return;
		}
		for (Element element : elements) {
			elementMap.put(element.getNodeName(), element);
		}
	}

	@Override
	public String toString() {
		cacheElements();

		StringBuffer buffer = new StringBuffer("ReceiveXmlMessage [");
		for (String key : elementMap.keySet()) {
			buffer.append(key).append('=').append(get(key)).append(',');
		}
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append(']');

		return buffer.toString();
	}
}
