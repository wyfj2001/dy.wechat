package dy.wechat.message;

public interface Xml {

	public interface Element {
		String Root = "xml";

		String ToUserName = "ToUserName";
		String FromUserName = "FromUserName";
		String CreateTime = "CreateTime";
		String MsgType = "MsgType";
		String MsgId = "MsgId";
		String Content = "Content";
		String PicUrl = "PicUrl";
		String MediaId = "MediaId";
		String Format = "Format";
		String ThumbMediaId = "ThumbMediaId";
		String Location_X = "Location_X";
		String Location_Y = "Location_Y";
		String Scale = "Scale";
		String Label = "Label";
		String Title = "Title";
		String Description = "Description";
		String Url = "Url";
		String Event = "Event";
		String EventKey = "EventKey";
		String Ticket = "Ticket";
		String Latitude = "Latitude";
		String Longitude = "Longitude";
		String Precision = "Precision";

		String ArticleCount = "ArticleCount";
		String Articles = "Articles";
		String item = "item";

		String Music = "Music";
		String MusicUrl = "MusicUrl";
		String HQMusicUrl = "HQMusicUrl";

		String Video = "Video";
		String Voice = "Voice";
		String Image = "Image";

		String TransInfo = "TransInfo";
		String KfAccount = "KfAccount";

		String OpenID = "OpenID";
		String OpType = "OpType";
		String DeviceID = "DeviceID";
		String DeviceType = "DeviceType";
	}

	public enum Event {
		subscribe, unsubscribe, SCAN, LOCATION, CLICK, VIEW,
	}

	public enum Type {
		/**
		 * 文本消息
		 */
		text,

		/**
		 * 图片消息
		 */
		image,

		/**
		 * 语音消息
		 */
		voice,

		/**
		 * 视频消息
		 */
		video,

		/**
		 * 小视频消息
		 */
		shortvideo,

		/**
		 * 地理位置消息
		 */
		location,

		/**
		 * 链接消息
		 */
		link,

		/**
		 * 事件推送消息
		 */
		event,

		/**
		 * 音乐消息
		 */
		music,

		/**
		 * 图文消息
		 */
		news,

		device_event,

		/**
		 * 将消息转发到多客服
		 */
		transfer_customer_service;
	}

}
