package dy.wechat.message.request.json.custom.impl;

import dy.wechat.message.Json;

public class VoiceRequestJsonCustomMessage extends MediaRequestJsonCustomMessage {

	public VoiceRequestJsonCustomMessage() {
		super(Json.Type.voice);
	}
	
	public VoiceRequestJsonCustomMessage(String kfAccount) {
		super(Json.Type.voice, kfAccount);
	}
}
