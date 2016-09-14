package dy.wechat.message.request.json.custom.impl;

import dy.wechat.message.Json;
import dy.wechat.message.request.json.custom.RequestJsonCustomMessage;

public class TextRequestJsonCustomMessage extends RequestJsonCustomMessage<String> {

	public TextRequestJsonCustomMessage() {
		super(Json.Type.text);
	}
	
	public TextRequestJsonCustomMessage(String kfAccount) {
		super(Json.Type.text, kfAccount);
	}

	public String getContent() {
		return get(Json.PropertyName.content);
	}

	public void setContent(String content) {
		set(Json.PropertyName.content, content);
	}
}
