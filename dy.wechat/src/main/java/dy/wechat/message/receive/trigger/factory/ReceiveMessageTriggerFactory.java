package dy.wechat.message.receive.trigger.factory;

import dy.wechat.message.receive.ReceiveMessage;
import dy.wechat.message.receive.trigger.ReceiveMessageTrigger;

public interface ReceiveMessageTriggerFactory {

	ReceiveMessageTrigger create(ReceiveMessage message);
}
