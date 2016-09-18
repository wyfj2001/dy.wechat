package dy.wechat.message.request.json.command;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;


public abstract class RequestJsonCommand {

	private CloseableHttpClient httpClient;
	
	private String defaultCharset = Consts.UTF_8.displayName();

	protected abstract HttpUriRequest buildHttpUriRequest();
	
	protected abstract HttpContext buildHttpContext();
	
	public String execute() throws ClientProtocolException, IOException {
		return httpClient.execute(buildHttpUriRequest(), new ResponseHandler<String>() {

			@Override
			public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
		        if (status >= 200 && status < 300) {
		            return EntityUtils.toString(response.getEntity(), defaultCharset);
		        } else {
		            throw new ClientProtocolException("Unexpected response status: " + status);
		        }
			}
		}, buildHttpContext());
	}
	
	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public void setDefaultCharset(String defaultCharset) {
		this.defaultCharset = defaultCharset;
	}

}
