package com.kpj01.user;
import java.sql.Connection;
import java.sql.DriverManager;


public class Usertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://192.168.0.9:3306/smarthome?useSSL=false&useUnicode=true&characterEncoding=euckr";
		String USER_NAME = "smart";
		String PASSWORD = "hi123456";

		Connection conn=null;


		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("find successed");
		} catch (Exception e) {
			System.out.println("Connect Failed!");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}


