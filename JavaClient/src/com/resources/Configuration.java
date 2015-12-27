package com.resources;
import java.io.*;
import java.util.*;
public class Configuration {
	Properties ps;

	public Configuration() {
		// TODO Auto-generated constructor stub
		ps=new Properties();
	}
	
	public Properties getProperties(String path) {
		if (ps.isEmpty()) {
			try {
				InputStream in=new BufferedInputStream(new FileInputStream(path));//程序在此抛出异常的时候就不会再向下执行
				//java project的文件相对路径是工程的根目录，classpath则是bin目录
				ps.load(in);
				in.close();				
			} catch (Exception e) {
				// TODO: handle exception
				//主要输出一些错误信息			
				System.out.println(e.getMessage());	
				
				return null;
			}
		}else {
			return ps;
		}
		return ps;
		
	}

}
