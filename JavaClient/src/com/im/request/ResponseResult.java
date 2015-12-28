package com.im.request;

import java.util.Map;

import com.ab.request.IhttpRestult;

public class ResponseResult implements IhttpRestult {

	//private Map<String, String> responseHead;
	private int code;
	private String body;
	public ResponseResult() {		// TODO Auto-generated constructor stub
		
	}
	public ResponseResult(int code) {
		// TODO Auto-generated constructor stub
		setCode(code);
	}

	@Override
	public int getCode() {
		// TODO Auto-generated method stub
		return code;
	}
public void setCode(int code) {
	this.code=code;
}
	@Override
	public String getResponseBody() {
		// TODO Auto-generated method stub
		return body;
	}
	
	public void setResponseBody(String body) {
		this.body=body;
	}

}
