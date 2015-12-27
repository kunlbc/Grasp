package com.im.request;

import com.ab.request.IhttpRequest;
import com.ab.request.IhttpRestult;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class httpRequest implements IhttpRequest {
	private httpURL requestURL;

	public httpRequest() {
		// TODO Auto-generated constructor stub
		//setRequestURL(http);
		setRequestURL(HttpURLFactory.produceHttpURL());
	}

	@Override
	public IhttpRestult httpGet() {
		// TODO Auto-generated method stub
		try {
			URL url=new URL(getRequestULR().getURL());
			URLConnection connection=url.openConnection();
			connection.connect();
			connection.getContentLength();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public IhttpRestult httpPost() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setRequestURL(httpURL requestURL) {
		this.requestURL=requestURL;
	}
	
	public httpURL getRequestULR() {
		return requestURL;
	}
	/*public String getRequestUrl() {
		return requestUrl;
	}
	
	public String getRequestParam() {
		return requestParam;
	}*/

}
