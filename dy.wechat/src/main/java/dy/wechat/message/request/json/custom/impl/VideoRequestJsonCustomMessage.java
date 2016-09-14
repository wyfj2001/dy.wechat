package dy.wechat.message.request.json.custom.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dy.wechat.message.Json;

public class VideoRequestJsonCustomMessage extends MediaRequestJsonCustomMessage {

	public VideoRequestJsonCustomMessage() {
		super(Json.Type.voice);
	}
	
	public VideoRequestJsonCustomMessage(String kfAccount) {
		super(Json.Type.voice, kfAccount);
	}

	@JsonIgnore
	public String getThumbMediaId() {
		return get(Json.PropertyName.thumb_media_id);
	}

	public void setThumbMediaId(String thumbMediaId) {
		set(Json.PropertyName.thumb_media_id, thumbMediaId);
	}

	@JsonIgnore
	public String getTitle() {
		return get(Json.PropertyName.title);
	}

	public void setTitle(String title) {
		set(Json.PropertyName.title, title);
	}

	@JsonIgnore
	public String getDescription() {
		return get(Json.PropertyName.description);
	}

	public void setDescription(String description) {
		set(Json.PropertyName.description, description);
	}
}
