package dy.wechat.message.request.json.custom.impl;

import dy.wechat.message.Json;

public class MPNewsRequestJsonCustomMessage extends MediaRequestJsonCustomMessage {

	public MPNewsRequestJsonCustomMessage() {
		super(Json.Type.mpnews);
	}

	public MPNewsRequestJsonCustomMessage(String kfAccount) {
		super(Json.Type.mpnews, kfAccount);
	}
}
