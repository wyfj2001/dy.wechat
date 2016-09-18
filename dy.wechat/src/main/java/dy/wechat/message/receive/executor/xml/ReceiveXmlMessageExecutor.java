package dy.wechat.message.receive.executor.xml;

import java.io.Reader;
import java.io.Writer;

import dy.wechat.message.receive.ReceiveMessage;
import dy.wechat.message.receive.executor.ReceiveMessageExecutor;
import dy.wechat.message.receive.executor.xml.converter.XmlConverter;
import dy.wechat.message.receive.xml.ReceiveXmlMessage;
import dy.wechat.message.reply.ReplyMessage;

public class ReceiveXmlMessageExecutor extends ReceiveMessageExecutor {

	private XmlConverter xmlConverter = new XmlConverter();
	
	public void setXmlConverter(XmlConverter xmlConverter) {
		this.xmlConverter = xmlConverter;
	}

	@Override
	protected ReceiveMessage read(Reader reader) throws Exception {
		return (ReceiveMessage) xmlConverter.unmarshal(reader, ReceiveXmlMessage.class);
	}

	@Override
	protected void write(Writer writer, ReplyMessage replyMessage) throws Exception {
		if (replyMessage == null) {
			writer.write("");
		} else {
			xmlConverter.marshal(replyMessage, writer);
		}
	}
	

}
