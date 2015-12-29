package com.pm25.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.ab.util.Idao;
import com.resources.Configuration;

public class MysqlDAO implements Idao {
	//private Configuration configuration;
	private String configPath="bin/com/resources/db.properties";
	private Properties properties;

	public MysqlDAO() throws Exception {
		// TODO Auto-generated constructor stub
		properties=(new Configuration()).getProperties(configPath);
		Class.forName(properties.getProperty("dbDriver"));
	}

	@Override
	public Connection openConnection() {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("pwd"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public boolean exeInsertItem(String cmd) {
		// TODO Auto-generated method stub
		Connection conn=openConnection();
		boolean boo=false;
		try {
			Statement state=conn.createStatement();
			state.clearBatch();
			state.addBatch(cmd);
			state.executeBatch();
			boo=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boo;
	}

	@Override
	public ResultSet exeQuery(String cmd) {
		// TODO Auto-generated method stub
		Connection conn=openConnection();
		boolean boo=false;
		ResultSet result=null;
		try {
			Statement state=conn.createStatement();
			result=state.executeQuery(cmd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
