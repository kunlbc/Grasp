package com.pm25.util;
import java.awt.List;
import java.util.ArrayList;

import org.json.*;

import com.pm25.model.*;

public class JsonConvert {

	public JsonConvert() {
		// TODO Auto-generated constructor stub
	}
	//专门为pm25的数据格式转换的
	public static Object PM25ParseJson(String jsonString) throws JSONException {
		JSONArray jArray=new JSONArray(jsonString);
		java.util.List<PM25Object> pmList=new ArrayList<PM25Object>();
		for (int i = 0; i < jArray.length(); i++) {
			JSONObject jObject=jArray.getJSONObject(i);
			PM25Object pm25=new PM25Object();
			pm25.setAqi(jObject.getInt("aqi"));
			pm25.setArea(jObject.getString("area"));
			pm25.setPm2_5(jObject.getInt("pm2_5"));
			pm25.setPm2_5_24h(jObject.getInt("pm2_5_24h"));
			pm25.setPosition_name(jObject.getString("position_name"));
			pm25.setTime_point(jObject.getString("time_point"));
			pmList.add(pm25);
		}		
		return pmList;
	}
	
	public static Object PM25ErrorJson(String jsonString)throws JSONException {
		JSONObject jObject=new JSONObject(jsonString);
		Pm25Error pm25Error=new Pm25Error();
		pm25Error.setPm25error(jObject.getString("error"));
		return pm25Error;
	}
 
}
