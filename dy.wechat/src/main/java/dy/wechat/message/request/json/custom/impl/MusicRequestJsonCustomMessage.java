package dy.wechat.message.request.json.custom.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dy.wechat.message.Json;
import dy.wechat.message.request.json.custom.RequestJsonCustomMessage;

public class MusicRequestJsonCustomMessage extends RequestJsonCustomMessage<String> {

	public MusicRequestJsonCustomMessage() {
		super(Json.Type.music);
	}
	
	public MusicRequestJsonCustomMessage(String kfAccount) {
		super(Json.Type.music, kfAccount);
	}

	@JsonIgnore
	public String getMusicUrl() {
		return get(Json.PropertyName.musicurl);
	}

	public void setMusicUrl(String musicUrl) {
		set(Json.PropertyName.musicurl, musicUrl);
	}

	@JsonIgnore
	public String getHqMusicUrl() {
		return get(Json.PropertyName.hqmusicurl);
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		set(Json.PropertyName.hqmusicurl, hqMusicUrl);
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
