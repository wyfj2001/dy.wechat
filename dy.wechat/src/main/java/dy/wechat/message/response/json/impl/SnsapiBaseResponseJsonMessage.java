package dy.wechat.message.response.json.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SnsapiBaseResponseJsonMessage extends TokenResponseJsonMessage {

	@JsonProperty("refresh_token")
	private String refreshToken;

	@JsonProperty("openid")
	private String openId;

	private String scope;

	@JsonProperty("unionid")
	private String unionId;

	public String getRefreshToken() {
		return refreshToken;
	}

	public String getOpenId() {
		return openId;
	}

	public String getScope() {
		return scope;
	}

	public String getUnionId() {
		return unionId;
	}

	@Override
	public String toString() {
		return String.format("SnsapiBaseResponseJsonMessage [refreshToken=%s, openId=%s, scope=%s, unionId=%s, toString()=%s]", refreshToken, openId, scope, unionId, super.toString());
	}
}
