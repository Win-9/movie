package com.devfun.settingweb;


import java.sql.*;
import org.junit.*;

public class MySqlTest {
	
	private String URL = "jdbc:mysql://127.0.0.1:3307/theater";
	private String USER = "root";
	private String PW = "rkdtmdrn123";


	@Test
	public void test() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("무야요");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println(con);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
