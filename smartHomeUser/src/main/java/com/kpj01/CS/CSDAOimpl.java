package com.kpj01.CS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CSDAOimpl implements CSDAO {
	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://192.168.0.20:3306/smarthome?useSSL=false&useUnicode=true&characterEncoding=euckr";
	private final String USER_NAME = "smart";
	private final String PASSWORD = "hi123456";

	private Connection conn=null;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CSDAOimpl() {
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
	@Override
	public List<CSVO> selectOne(String csQuestion) {
		System.out.println("selectOne()...");
		System.out.println("csQuestion:"+csQuestion);
		List<CSVO> list = new ArrayList<CSVO>();

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");

			String sql = "select * from cs where csquestion like ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+csQuestion+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CSVO vo2 = new CSVO();
				vo2.setCSNum(rs.getInt("CSNum"));
				vo2.setCsQuestion(rs.getString("csQuestion"));
				vo2.setCsAnswer(rs.getString("csAnswer"));
				list.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
		
	}

	@Override
	public List<CSVO> selectAll() {
		System.out.println("selectAll()...");
		List<CSVO> list = new ArrayList<CSVO>();

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");

			String sql = "select * from cs order by csnum asc";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				CSVO vo2 = new CSVO();
				vo2.setCSNum(rs.getInt("CSNum"));
				vo2.setCsQuestion(rs.getString("csQuestion"));
				vo2.setCsAnswer(rs.getString("csAnswer"));
				list.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}

}
=======
package com.kpj01.CS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CSDAOimpl implements CSDAO {
	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://192.168.0.20:3306/smarthome?useSSL=false&useUnicode=true&characterEncoding=euckr";
	private final String USER_NAME = "smart";
	private final String PASSWORD = "hi123456";

	private Connection conn=null;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CSDAOimpl() {
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
	@Override
	public List<CSVO> selectOne(String csQuestion) {
		System.out.println("selectOne()...");
		System.out.println("csQuestion:"+csQuestion);
		List<CSVO> list = new ArrayList<CSVO>();

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");

			String sql = "select * from cs where csquestion like ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+csQuestion+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CSVO vo2 = new CSVO();
				vo2.setCSNum(rs.getInt("CSNum"));
				vo2.setCsQuestion(rs.getString("csQuestion"));
				vo2.setCsAnswer(rs.getString("csAnswer"));
				list.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
		
	}

	@Override
	public List<CSVO> selectAll() {
		System.out.println("selectAll()...");
		List<CSVO> list = new ArrayList<CSVO>();

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");

			String sql = "select * from cs order by csnum asc";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				CSVO vo2 = new CSVO();
				vo2.setCSNum(rs.getInt("CSNum"));
				vo2.setCsQuestion(rs.getString("csQuestion"));
				vo2.setCsAnswer(rs.getString("csAnswer"));
				list.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}

}
