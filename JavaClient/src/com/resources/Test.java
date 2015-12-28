package com.resources;
import java.util.*;

import com.ab.request.IhttpRestult;
import com.im.request.*;
import com.pm25.model.Pm25Error;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.naming.spi.DirStateFactory.Result;

import org.json.JSONArray;
import org.json.JSONObject;



public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {		
//		try {
//			URL url=new URL("http://www.pm25.in/api/querys/pm2_5.json?avg=true&stations=yes&city=xuzhou&token=5j1znBVAsnSf5xQyNQyq");
//			HttpURLConnection connection;
//			connection = (HttpURLConnection)url.openConnection();
//			//connection.setRequestMethod("GET");
//			connection.setRequestProperty("Accept-Language","en,zh-cn;q=0.5");//表示浏览器所支持的语言，从左向右优先级逐渐降低，q表示权重
//			connection.setRequestProperty("Accept-Charset", "utf-8,gb2312;q=0.7");//表示浏览器所支持的字符集
//			connection.setRequestProperty("Accept", "text/html,text/plain,application/json;q=0.7");//表示浏览器所支持的内容MIME类型
//			//connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  这个指的是以post方式提交的时候请求正文类型
//			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//			connection.setRequestProperty("Connection", "Keep-Alive");
//			connection.connect();
//			//nnection.
//			//result.setCode(connection.getResponseCode());
//			System.out.println(connection.getResponseCode()+"\n");
//			//connection.
//			System.out.println(connection.getContentLength());
//			System.out.println(connection.getContentType());
//			System.out.println(connection.getContentEncoding()+"\n");
//			//System.out.println(connection.));
//			BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			String line;
//			String result="";
//			while ((line=in.readLine())!=null) {
//				
//				result+=new String(line.getBytes(), "utf-8");			
//			}
//			System.out.println(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		Configuration configuration=new Configuration();
//		Properties properties=configuration.getProperties("bin/com/resources/prop.properties");
//		System.out.println(properties.getProperty("pm25.url"));
		try {
			FileInputStream fin=new FileInputStream(new File("bin/com/resources/demo2.txt"));
			int size=fin.available();
			byte[] buffer=new byte[size];
			fin.read(buffer);
			String s=new String(buffer);
			System.out.println(s);
			//JSONObject jObject=new JSONObject(s);
//			JSONArray jArray=new JSONArray(s);
//			for (int i = 0; i < jArray.length(); i++) {
//				JSONObject jObject=jArray.getJSONObject(i);
//				System.out.println(jObject.get("aqi"));
//			}
			//System.out.println(jArray.length());
			if (s.indexOf("error")!=-1) {
				JSONObject jObject=new JSONObject(s);
				Pm25Error pm25Error=new Pm25Error();
				pm25Error.setPm25error(jObject.getString("error"));
				System.out.println(pm25Error.getPm25error());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] arr={1,2,3};
		for (int i : arr) {
			System.out.println(i);
		}


	}

}
