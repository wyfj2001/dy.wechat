package dy.wechat.message.request.json.custom.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dy.wechat.message.Json;
import dy.wechat.message.request.json.custom.RequestJsonCustomMessage;

public abstract class MediaRequestJsonCustomMessage extends RequestJsonCustomMessage<String> {

	MediaRequestJsonCustomMessage(Json.Type type) {
		super(type);
	}
	
	MediaRequestJsonCustomMessage(Json.Type type, String kfAccount) {
		super(type, kfAccount);
	}

	@JsonIgnore
	public String getMediaId() {
		return get(Json.PropertyName.media_id);
	}

	public void setMediaId(String mediaId) {
		set(Json.PropertyName.media_id, mediaId);
	}

}