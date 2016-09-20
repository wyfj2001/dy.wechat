package dy.wechat.message.request.command;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;


public abstract class RequestCommand<R> {

	public enum Method {
		GET, POST;
	}

	private CloseableHttpClient httpClient;
	
	private ResponseHandler<? extends R> responseHandler = new ResponseHandler<R>() {

		@Override
		public R handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			int status = response.getStatusLine().getStatusCode();
	        if (status >= 200 && status < 300) {
				return RequestCommand.this.handleResponse(response);
	        } else {
	            throw new ClientProtocolException("Unexpected response status: " + status);
	        }
		}
	};

	protected abstract RequestCommand.Method getMethod();

	protected abstract String getUrl();
	
	protected abstract HttpContext buildHttpContext();

	protected abstract void handleHttpUriRequest(HttpUriRequest request);

	public abstract R handleResponse(HttpResponse response) throws ClientProtocolException, IOException;
	
	private HttpUriRequest buildHttpUriRequest() {
		HttpUriRequest request;
		if (Method.GET.equals(getMethod())) {
			request = new HttpGet(getUrl());
		} else if (Method.POST.equals(getMethod())) {
			request = new HttpPost(getUrl());
		} else {
			throw new UnsupportedOperationException("Unsupported method " + getMethod());
		}
		handleHttpUriRequest(request);
		return request;
	}
	
	public R execute() throws ClientProtocolException, IOException {
		return httpClient.execute(buildHttpUriRequest(), responseHandler, buildHttpContext());
	}
	
	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}

}
