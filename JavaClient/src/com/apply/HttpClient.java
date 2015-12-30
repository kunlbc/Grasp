package com.apply;

import java.text.ParseException;
import java.util.List;
import java.util.Properties;

import org.json.JSONException;

import com.ab.request.IhttpRequest;
import com.ab.request.IhttpRestult;
import com.ab.util.Idao;
import com.im.request.httpRequest;
import com.pm25.model.PM25Object;
import com.pm25.model.Pm25Error;
import com.pm25.util.JsonConvert;
import com.pm25.util.MysqlDAO;
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
	
	public void ProcessRequest() throws Exception {
		IhttpRequest request=new httpRequest(getRequestURL());
		IhttpRestult result=request.httpGet();
		if (result.getCode()==200) {
			String bodyString=result.getResponseBody();
			if( bodyString.indexOf("error")==-1) {
				Idao dao=new MysqlDAO();
				int index=0;
				@SuppressWarnings("unchecked")
				List<PM25Object> pmList=(List<PM25Object>)JsonConvert.PM25ParseJson(bodyString);
				for (PM25Object pm25Object : pmList) {
					String sqlString="insert ignore into pmdata(id,aqi,pmarea,pm25,pm25_24h,pmposition,pmquality"
							+ ",stationcode,time_point) values ('Õ¾µã"+index+"',"+pm25Object.getAqi()+",'"+pm25Object.getArea()+"',"
							+pm25Object.getPm2_5()+","+pm25Object.getPm2_5_24h()+",'"+pm25Object.getPosition_name()
							+"','"+pm25Object.getQuality()+"','"+pm25Object.getStation_code()+"','"+pm25Object.getTime_point()+"')";
					dao.exeInsertItem(sqlString);
					index++;
				}
			}else {
				Pm25Error pmerror=(Pm25Error)JsonConvert.PM25ErrorJson(bodyString);
				System.out.println(pmerror.getPm25error());
				}
		}
		
	}

}
