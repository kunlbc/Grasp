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
				InputStream in=new BufferedInputStream(new FileInputStream(path));//�����ڴ��׳��쳣��ʱ��Ͳ���������ִ��
				//java project���ļ����·���ǹ��̵ĸ�Ŀ¼��classpath����binĿ¼
				ps.load(in);
				in.close();				
			} catch (Exception e) {
				// TODO: handle exception
				//��Ҫ���һЩ������Ϣ			
				System.out.println(e.getMessage());	
				
				return null;
			}
		}else {
			return ps;
		}
		return ps;
		
	}

}
