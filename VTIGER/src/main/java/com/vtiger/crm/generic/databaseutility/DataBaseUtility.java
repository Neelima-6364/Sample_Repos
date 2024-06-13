package com.vtiger.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn =null;
	public void getDBConnection() throws SQLException
	{
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn = DriverManager.getConnection("JDBC:mysql://106.51.90.215:3333/projects", "root@%", "root");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public ResultSet executeSelectQuery(String query) throws SQLException
	{
		ResultSet set=null;
		try
		{
		Statement stat = conn.createStatement();
		set = stat.executeQuery(query);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return set;
	}
	public int executeNonSelectQuery(String query) throws SQLException
	{
		int value=0;
		try
		{
		Statement stat = conn.createStatement();
		value=stat.executeUpdate(query);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}
	public void closeDB() throws SQLException
	{
		conn.close();
	}
}
