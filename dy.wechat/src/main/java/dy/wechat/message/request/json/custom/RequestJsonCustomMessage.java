package dy.wechat.message.request.json.custom;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import dy.wechat.message.Json;

public abstract class RequestJsonCustomMessage<T> {
	
	@JsonProperty(Json.PropertyName.touser)
	private String toUser;
	@JsonProperty(Json.PropertyName.msgtype)
	private final String messageType;

	@JsonIgnore
	private Map<String, Map<String, T>> messageBody;
	
	@JsonProperty(Json.PropertyName.customservice)
	@JsonInclude(Include.NON_NULL)
	private CustomService customService;
	
	public RequestJsonCustomMessage(Json.Type type) {
		this(type, null);
	}
	
	public RequestJsonCustomMessage(Json.Type type, String kfAccount) {
		messageType = type.name();
		messageBody = new HashMap<String, Map<String,T>>(1);
		messageBody.put(this.messageType, new HashMap<String, T>(1));
		if (StringUtils.isNotBlank(kfAccount)) {
			this.customService = new CustomService(kfAccount);
		}
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getMessageType() {
		return messageType;
	}
	
	@JsonAnyGetter
	Map<String, Map<String, T>> getMessageBody() {
		return messageBody;
	}
	
	public void set(String propertyName, T value) {
		messageBody.get(messageType).put(propertyName, value);
	}
	
	public T get(String propertyName) {
		return messageBody.get(messageType).get(propertyName);
	}

	@Override
	public String toString() {
		return String.format("%s [toUser=%s, messageType=%s]", getClass().getSimpleName(), toUser, messageType);
	}
	
	static class CustomService {
		@JsonProperty(Json.PropertyName.kf_account)
		private String kfAccount;
		
		public CustomService(String kfAccount) {
			this.kfAccount = kfAccount;
		}

		public String getKfAccount() {
			return kfAccount;
		}
	}
}
