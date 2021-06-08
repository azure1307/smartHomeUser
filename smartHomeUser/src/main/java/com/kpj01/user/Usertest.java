package com.kpj01.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Usertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://192.168.0.20:3306/smarthome?useSSL=false&useUnicode=true&characterEncoding=euckr";
		String USER_NAME = "smart";
		String PASSWORD = "hi123456";

		Connection conn=null;
		PreparedStatement pstmt;

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
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed...");
			String sql="insert into users(userId, userpw, username,userphone,useraddsi,useraddgu,useradddong,useradddetail,userbirth,usernick) values('test1','test2','test3','test4','test5','test6','test7','test8','test9','test10')";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}


