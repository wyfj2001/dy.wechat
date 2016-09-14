package dy.wechat.message.receive.executor;

import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dy.wechat.message.receive.ReceiveMessage;
import dy.wechat.message.receive.handler.ReceiveMessageHandler;
import dy.wechat.message.receive.trigger.ReceiveMessageTrigger;
import dy.wechat.message.receive.trigger.factory.ReceiveMessageTriggerFactory;
import dy.wechat.message.reply.ReplyMessage;

public abstract class ReceiveMessageExecutor {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private Map<Collection<ReceiveMessageTrigger>, ReceiveMessageHandler> executors = new HashMap<Collection<ReceiveMessageTrigger>, ReceiveMessageHandler>();
	
	private ReceiveMessageTriggerFactory receiveMessageTriggerFactory;
	
	public void setReceiveMessageHandlers(Collection<ReceiveMessageHandler> receiveMessageHandlers) {
		executors.clear();
		
		for (ReceiveMessageHandler receiveMessageHandler : receiveMessageHandlers) {
			executors.put(receiveMessageHandler.getTriggers(), receiveMessageHandler);
		}
		logger.info("{} has #{}", getClass().getSimpleName(), executors);
	}
	
	public void setReceiveMessageTriggerFactory(ReceiveMessageTriggerFactory receiveMessageTriggerFactory) {
		this.receiveMessageTriggerFactory = receiveMessageTriggerFactory;
		logger.info("{} use #{}", getClass().getSimpleName(), receiveMessageTriggerFactory);
	}
	
	public void execute(Reader reader, Writer writer) {
		try {
			ReplyMessage replyMessage = execute(read(reader));
			write(writer, replyMessage);
		} catch(Exception e) {
			logger.error("Handle message error", e);
		} finally {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(writer);
		}
	}
	
	protected abstract ReceiveMessage read(Reader reader) throws Exception;

	protected abstract void write(Writer writer, ReplyMessage replyMessage) throws Exception;
	
	protected ReplyMessage execute(ReceiveMessage message) {
		logger.info("ReceiveMessage {}", message);
		ReceiveMessageTrigger trigger = receiveMessageTriggerFactory.create(message);
		logger.info("Create {}", trigger);
		ReceiveMessageHandler handler = getReceiveMessageHandler(trigger);
		if (handler == null) {
			logger.warn("Can not get ReceiveMessageHandler by {}", trigger);
			return null;
		}
		logger.info("Get {} by {}", handler, trigger);
		return handler.handle(message);
	}
	
	private ReceiveMessageHandler getReceiveMessageHandler(ReceiveMessageTrigger trigger) {
		for (Collection<ReceiveMessageTrigger> receiveXmlMessageTriggers : executors.keySet()) {
			if (receiveXmlMessageTriggers.contains(trigger)) {
				return executors.get(receiveXmlMessageTriggers);
			}
		}
		return null;
	}
	
}