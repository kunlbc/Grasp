package com.resources;
import java.util.*;
import com.im.request.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Configuration configuration=new Configuration();
		Properties ps=configuration.getProperties();
		if(ps.get("isHaveParam").equals("true"))
			System.out.println(ps.get("city"));
		else {
			System.out.println(ps.get("requestURL"));
		}*/
		httpURL url=HttpURLFactory.produceHttpURL();
		System.out.println(url.getURL()+"\n");
		URL url1;
		try {
			url1 = new URL(url.getURL());
			URLConnection connection=url1.openConnection();
			connection.connect();
			int le=connection.getContentLength();
			connection.
			System.out.println(le);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
