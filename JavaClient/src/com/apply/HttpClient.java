package com.apply;

import java.util.List;
import java.util.Properties;

import org.json.JSONException;

import com.ab.request.IhttpRequest;
import com.ab.request.IhttpRestult;
import com.im.request.httpRequest;
import com.pm25.model.PM25Object;
import com.pm25.util.JsonConvert;
import com.resources.Configuration;

public class HttpClient {
	private String configPath="bin/com/resources/prop.properties";
	private Properties properties;
	private String requestURL;

	public HttpClient() {
		// TODO Auto-generated constructor stub
		properties=(new Configuration()).getProperties(configPath);
		requestURL=properties.getProperty("pm25.url")+"?city="+properties.getProperty("city")+"&token="+properties.getProperty("token");
	}
	
	public String getRequestURL() {
		return requestURL;
	}
	
	public void ProcessRequest() {
		IhttpRequest request=new httpRequest(getRequestURL());
		IhttpRestult result=request.httpGet();
		if (result.getCode()==200) {
			String bodyString=result.getResponseBody();
			if( bodyString.indexOf("error")!=-1) {
//				try {
//					//@SuppressWarnings("unchecked")
//					//List<PM25Object> pmList=(List<PM25Object>)JsonConvert.PM25ParseJson(bodyString);
//					
//					//下面就是写入数据库的代码
//				} catch (JSONException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
		
	}

}
