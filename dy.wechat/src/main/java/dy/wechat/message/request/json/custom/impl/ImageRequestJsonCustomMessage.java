package dy.wechat.message.request.json.custom.impl;

import dy.wechat.message.Json;

public class ImageRequestJsonCustomMessage extends MediaRequestJsonCustomMessage {

	public ImageRequestJsonCustomMessage() {
		super(Json.Type.image);
	}
	
	public ImageRequestJsonCustomMessage(String kfAccount) {
		super(Json.Type.image, kfAccount);
	}
}
