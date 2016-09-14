package dy.wechat.message;

public interface Json {

	public interface PropertyName {
		String touser = "touser"; // 普通用户openid
		String msgtype = "msgtype";// 消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard
		String content= "content";// 文本消息内容
		String media_id= "media_id";// 发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
		String thumb_media_id= "thumb_media_id";// 缩略图的媒体ID
		String title= "title";// 图文消息/视频消息/音乐消息的标题
		String description= "description";// 图文消息/视频消息/音乐消息的描述
		String musicurl= "musicurl";// 音乐链接
		String hqmusicurl= "hqmusicurl";// 高品质音乐链接，wifi环境优先使用该链接播放音乐
		String url= "url";// 图文消息被点击后跳转的链接
		String picurl= "picurl"; // 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
		String articles = "articles";
		
		String card_id = "card_id";
		String card_ext = "card_ext";
		
		String customservice = "customservice";
		String kf_account = "kf_account";
		
		String msg_type = "msg_type";
		String device_id = "device_id";
		String open_id = "open_id";
		String device_type = "device_type";
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
		 * 音乐消息
		 */
		music,
		
		/**
		 * 图文消息
		 */
		news,
		
		/**
		 * 图文消息
		 */
		mpnews,
		
		/**
		 * 卡券
		 */
		wxcard,
		
		unbind,
		
		bind;
	}
}
