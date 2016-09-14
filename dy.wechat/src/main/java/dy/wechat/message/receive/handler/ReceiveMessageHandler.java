package dy.wechat.message.receive.handler;

import java.util.Collection;

import dy.wechat.message.receive.ReceiveMessage;
import dy.wechat.message.receive.trigger.ReceiveMessageTrigger;
import dy.wechat.message.reply.ReplyMessage;

public interface ReceiveMessageHandler {

	ReplyMessage handle(ReceiveMessage message);
	
	Collection<ReceiveMessageTrigger> getTriggers();
}
