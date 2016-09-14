package dy.wechat.message.request.json.custom.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dy.wechat.message.Json;
import dy.wechat.message.request.json.custom.RequestJsonCustomMessage;

public class CardRequestJsonCustomMessage extends RequestJsonCustomMessage<String> {

	public CardRequestJsonCustomMessage() {
		super(Json.Type.wxcard);
	}
	
	public CardRequestJsonCustomMessage(String kfAccount) {
		super(Json.Type.wxcard, kfAccount);
	}

	@JsonIgnore
	public String getCardId() {
		return get(Json.PropertyName.card_id);
	}

	public void setCardId(String cardId) {
		set(Json.PropertyName.card_id, cardId);
	}

	@JsonIgnore
	public String getCardExtension() {
		return get(Json.PropertyName.card_ext);
	}

	public void setCardExtension(CardExtension cardExtension) throws JsonProcessingException {
		set(Json.PropertyName.card_ext, cardExtension.toJsonString());
	}

	public static class CardExtension {
		/**
		 * code 指定的卡券code码，只能被领一次。use_custom_code字段为true的卡券必须填写，非自定义code不必填写。
		 */
		@JsonProperty("code")
		@JsonInclude(Include.NON_NULL)
		private String code;
		/**
		 * openid 否 指定领取者的openid，只有该用户能领取。bind_openid字段为true的卡券必须填写，
		 * bind_openid字段为false不必填写。
		 */
		@JsonProperty("openid")
		@JsonInclude(Include.NON_NULL)
		private String openId;
		/**
		 * timestamp
		 * 时间戳，商户生成从1970年1月1日00:00:00至今的秒数,即当前的时间,且最终需要转换为字符串形式;由商户生成后传入
		 * ,不同添加请求的时间戳须动态生成，若重复将会导致领取失败！。
		 */
		@JsonProperty("timestamp") 
		private final long timestamp;
		/**
		 * nonce_str
		 * 随机字符串，由开发者设置传入，加强签名的安全性。随机字符串，不长于32位。推荐使用大小写字母和数字，不同添加请求的nonce须动态生成
		 * ，若重复将会导致领取失败！。
		 */
		@JsonProperty("nonce_str") 
		@JsonInclude(Include.NON_NULL)
		private String nonceStr;
		/**
		 * signature
		 * 签名，商户将接口列表中的参数按照指定方式进行签名,签名方式使用SHA1,具体签名方案参见下文;由商户按照规范签名后传入。
		 */
		private @JsonProperty("signature") final String signature;
		/**
		 * outer_id 领取场景值，用于领取渠道的数据统计，默认值为0，字段类型为整型，长度限制为60位数字。
		 * 用户领取卡券后触发的事件推送中会带上此自定义场景值，不参与签名。
		 */
		@JsonProperty("outer_id")
		@JsonInclude(Include.NON_NULL)
		private String outerId;

		public CardExtension(String signature) {
			this(signature, System.currentTimeMillis());
		}

		public CardExtension(String signature, long timestamp) {
			this.signature = signature;
			this.timestamp = timestamp;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getOpenId() {
			return openId;
		}

		public void setOpenId(String openId) {
			this.openId = openId;
		}

		public long getTimestamp() {
			return timestamp;
		}


		public String getNonceStr() {
			return nonceStr;
		}

		public void setNonceStr(String nonceStr) {
			this.nonceStr = nonceStr;
		}

		public String getSignature() {
			return signature;
		}

		public String getOuterId() {
			return outerId;
		}

		public void setOuterId(String outerId) {
			this.outerId = outerId;
		}

		public String toJsonString() throws JsonProcessingException {
			return new ObjectMapper().writeValueAsString(this);
		}
		
	}

}
