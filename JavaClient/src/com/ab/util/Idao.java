package com.ab.util;

import java.sql.Connection;
import java.sql.ResultSet;

public interface Idao {
	public Connection openConnection();
	public boolean exeInsertItem(String cmd);
	public ResultSet exeQuery(String cmd);
	
}
