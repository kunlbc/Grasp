package com.im.request;

//import com.ab.request.IhttpURLFactory;
import java.io.*;
import java.util.*;

import com.resources.*;

public class HttpURLFactory {

	private static Configuration pm25Configuration=new Configuration();
	private static Configuration pm25ParamConfiguration=new Configuration();
	private static String pm25ParamPath="bin/com/resources/pm25Param.properties";
	private static String pm25Path="bin/com/resources/pm25.properties";
	public HttpURLFactory() {
		// TODO Auto-generated constructor stub
	}

	//@Override
	public static httpURL produceHttpURL() {
		// TODO Auto-generated method stub
		Properties pm25ps=pm25Configuration.getProperties(pm25Path);		
		if(pm25ps.get("isHaveParam").equals("true")){
			Properties pm25Paramps=pm25ParamConfiguration.getProperties(pm25ParamPath);
			Map<String, String> param=new HashMap<String,String>(pm25Paramps.size());
			Iterator<String> iterator=pm25Paramps.stringPropertyNames().iterator();
			//当然这边参数可以随意添加
			while (iterator.hasNext()) {
				String key=iterator.next();
				param.put(key, pm25Paramps.getProperty(key));
			}
			return new httpURL(pm25ps.getProperty("requestURL"), param);
		}
		return new httpURL();
	}
   
	//@Override
	/*public static httpURL httpParamURLFactory() {
		// TODO Auto-generated method stub
		//这个可以从配置文件的一些地方读取httpURL所需的参数
		return null;
	}*/
	
	/*public static Configuration getConfiguration() {
		return configuration;
	}*/

}
