package com.pm25.util;
import java.awt.List;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.*;

import com.pm25.model.*;

public class JsonConvert {

	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public JsonConvert() {
		// TODO Auto-generated constructor stub
	}
	//专门为pm25的数据格式转换的
	public static Object PM25ParseJson(String jsonString) throws JSONException, ParseException {
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
			pm25.setQuality(jObject.getString("quality"));
			pm25.setStation_code(jObject.getString("station_code"));
			String temp=jObject.getString("time_point").replace("T", " ");
			
			pm25.setTime_point(new Date(sdf.parse(temp.substring(0,temp.length()-1)).getTime()));//StringToTime(jObject.getString("time_point")));
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
  
	private static Date StringToTime(String stime)  {		
		String part1=stime.replace("T", " ");	
		Date dresult=null;
		try {
			String part2=part1.substring(0, part1.length()-1);
			dresult=new Date(sdf.parse(part2).getTime());//Date(sdf.parse(part2).getTime());
			//return 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return dresult;
	}
}
