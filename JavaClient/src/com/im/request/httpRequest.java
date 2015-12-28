package com.im.request;

import com.ab.request.IhttpRequest;
import com.ab.request.IhttpRestult;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;


public class httpRequest implements IhttpRequest {
	private String requestURL;

//	public httpRequest() {	
//	}
//	
	public httpRequest(String requestURL){		
		this.requestURL=requestURL;
	}

	@Override
	public IhttpRestult httpGet() {	
		return SendRequest();
	}

	@Override
	public IhttpRestult httpPost() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public void setRequestURL(String requestURL) {
//		this.requestURL=requestURL;
//	}
	
	public String getRequestULR() {
		return requestURL;
	}
	
	private IhttpRestult SendRequest() {	
		ResponseResult result=new ResponseResult();
		try {
			URL url=new URL(getRequestULR());
			HttpURLConnection connection;
			connection = (HttpURLConnection)url.openConnection();
			//connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept-Language","en,zh-cn;q=0.5");//表示浏览器所支持的语言，从左向右优先级逐渐降低，q表示权重
			connection.setRequestProperty("Accept-Charset", "utf-8,gb2312;q=0.7");//表示浏览器所支持的字符集
			connection.setRequestProperty("Accept", "text/html,text/plain,application/json;q=0.7");//表示浏览器所支持的内容MIME类型
			//connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  这个指的是以post方式提交的时候请求正文类型
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.connect();
			//nnection.
			result.setCode(connection.getResponseCode());
			if (connection.getResponseCode()==200) {
				InputStream in=connection.getInputStream();
				int size=in.available();
				byte[] buffer=new byte[size];
				in.read(buffer);
				result.setResponseBody(new String(buffer,"utf-8"));
			}
			else {
				result=null;
			}
			//connection.
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		//return null;
	}


}
