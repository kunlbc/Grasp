package com.im.request;
import java.util.*;

public class httpURL {
	private String url;
	private Map<String, String> param;
	private boolean haveParam;

	public httpURL() {
		// TODO Auto-generated constructor stub
		//httpURL("",);		
		setHaveParam(false);
	}
	public  httpURL(String url, Map<String, String>param) {
		if(url!="")
			setURL(url);
		if (param!=null)
			setParam(param);	
		setHaveParam(true);
	}
	public void setURL(String url){
		this.url=url;//这边不太好的地方就是没有及时判断是否带有参数的url
	}
	
	public String getURL(){
		if (IsHaveParam()) {
			return getParamURL();
		}
		return url;
	}
	
	
	private String getParamURL() {
		StringBuilder paramBuilder=new StringBuilder();
		paramBuilder.append(url+"?");
		for(String key : param.keySet()){
			paramBuilder.append(key+"="+param.get(key)+"&");
		}
		try {
			paramBuilder.delete(paramBuilder.lastIndexOf("&"), paramBuilder.length());
		} catch (StringIndexOutOfBoundsException e) {
			// TODO: handle exception
			//输出错误；
		}
		return paramBuilder.toString();
	}
	
	public void setHaveParam(boolean haveParam) {
		this.haveParam=haveParam;
	}
	
	public boolean IsHaveParam() {
		return haveParam;
	}
	public void setParam(Map<String, String>param) {
		//if(getURL().indexOf("?")!=-1)
		this.param=param;
		setHaveParam(true);
	}
	
	public Map<String, String> getParam() {	
		if(IsHaveParam())
			return param;
		else
			return null;
	}

}
