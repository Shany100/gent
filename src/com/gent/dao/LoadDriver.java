package com.gent.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoadDriver.load();
	}
	
	public static void load(){
		Connection conn = null;
		Statement stat = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gent?user=root&password=root");
			stat = conn.createStatement();
			result = stat.executeQuery("select name, create_time, flag from event;");
			while(result.next()){
				System.out.println(result.getString("name"));;
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(result != null){
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				result = null;
			}
			if(stat != null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stat = null;
			}
		}
	}

}
