package com.pm25.model;

public class PM25Object {
	public PM25Object() {
		// TODO Auto-generated constructor stub
	}	
	public int getAqi() {
		return aqi;
	}
	public void setAqi(int aqi) {
		this.aqi = aqi;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPm2_5() {
		return pm2_5;
	}
	public void setPm2_5(int pm2_5) {
		this.pm2_5 = pm2_5;
	}
	public int getPm2_5_24h() {
		return pm2_5_24h;
	}
	public void setPm2_5_24h(int pm2_5_24h) {
		this.pm2_5_24h = pm2_5_24h;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getTime_point() {
		return time_point;
	}
	public void setTime_point(String time_point) {
		this.time_point = time_point;
	}
	
	private int aqi;
	private String area;
	private int pm2_5;
	private int pm2_5_24h;
	private String position_name;
	private String time_point;
}
