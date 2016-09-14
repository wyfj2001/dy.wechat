package dy.wechat.message.response.json.impl;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import dy.wechat.message.response.json.ResponseJsonMessage;

public class TokenResponseJsonMessage extends ResponseJsonMessage {

	@JsonProperty("access_token") 
	private String accessToken;
	
	@JsonProperty("expires_in")
	private int expires;
	
	private long createTime = System.currentTimeMillis();

	public long getCreateTime() {
		return createTime;
	}
	
	public boolean isExpired() {
		return getCreateTime() + expires * 1000 < System.currentTimeMillis();
	} 

	public String getAccessToken() {
		return accessToken;
	}

	public int getExpires() {
		return expires;
	}

	@Override
	public String toString() {
		return String.format("TokenResponseJsonMessage [accessToken=%s, expires=%s, createTime=%s %s", accessToken, expires, getCreateTime(), StringUtils.removeStart(super.toString(), "["));
	}

	
}
