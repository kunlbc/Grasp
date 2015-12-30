package com.apply;

import java.util.Timer;
import java.util.TimerTask;

public class PM25Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final HttpClient pm25Client=new HttpClient();
		Timer timer=new Timer();
		TimerTask task=new TimerTask() {
			public void run() {
				try {
					pm25Client.ProcessRequest();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
		};
		java.util.Date t=new java.util.Date(); 
		timer.schedule(task,t,30*60*1000);
	}

}
