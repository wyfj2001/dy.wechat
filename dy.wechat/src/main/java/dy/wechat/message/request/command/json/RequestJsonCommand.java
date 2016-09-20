package dy.wechat.message.request.command.json;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import dy.wechat.common.JsonMapper;
import dy.wechat.message.request.command.RequestCommand;

public abstract class RequestJsonCommand<R> extends RequestCommand<R> {

	protected abstract Class<R> getValueType();
	
	@Override
	public R handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		return JsonMapper.instance.readValue(response.getEntity().getContent(), getValueType());
	}

}
