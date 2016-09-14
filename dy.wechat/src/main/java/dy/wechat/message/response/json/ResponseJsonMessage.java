package dy.wechat.message.response.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 错误情况下返回的JSON信息
 * 
 * @author wangyi
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseJsonMessage {

	private @JsonProperty("errcode") int code;
	private @JsonProperty("errmsg") String message;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return String.format("[code=%s, message=%s]", code, message);
	}
	
	public boolean isResponseSuccess() {
		return code == 0;
	}
}
