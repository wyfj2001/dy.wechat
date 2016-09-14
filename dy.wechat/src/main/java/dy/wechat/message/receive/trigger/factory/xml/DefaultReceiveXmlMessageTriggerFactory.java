package dy.wechat.message.receive.trigger.factory.xml;

import org.apache.commons.lang3.StringUtils;

import dy.wechat.message.Xml;
import dy.wechat.message.receive.ReceiveMessage;
import dy.wechat.message.receive.trigger.ReceiveMessageTrigger;
import dy.wechat.message.receive.trigger.factory.ReceiveMessageTriggerFactory;

public class DefaultReceiveXmlMessageTriggerFactory implements ReceiveMessageTriggerFactory {

	@Override
	public ReceiveMessageTrigger create(ReceiveMessage message) {
		ReceiveMessageTrigger trigger = new ReceiveMessageTrigger();
		if (message != null) {
			if (message.hasElement(Xml.Element.MsgType)) {
				trigger.put(Xml.Element.MsgType, message.get(Xml.Element.MsgType));
			}
			if (message.hasElement(Xml.Element.Event)) {
				trigger.put(Xml.Element.Event, message.get(Xml.Element.Event));
			}
			if (message.hasElement(Xml.Element.EventKey) && StringUtils.equals(message.get(Xml.Element.Event), Xml.Event.CLICK.name())) {
				trigger.put(Xml.Element.EventKey, message.get(Xml.Element.EventKey));
			}
		}
		return trigger;
	}

}
