package com.kpj01.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAOimpl implements UserDAO {
	
	// DB name : smarthome
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://192.168.0.17:3306/smarthome?useSSL=false&useUnicode=true&characterEncoding=euckr";
	String USER_NAME = "smart";
	String PASSWORD = "hi123456";
	
	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet rs;
	

	
	public UserDAOimpl() {
		// DB 연결
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("Connect Successed!");
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
	public int insert(UserVO vo) {
		System.out.println(" ===== UserDAOimpl의 insert() =====");
		System.out.println(vo);
		
		int flag = 0;
		
		try {  /*private double decibel;
				private int userState;*/
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" ~ connect successed! ~ ");
			String sql="insert into users(userId, userpw, username, userphone, useraddsi,"
					+ "useraddgu, useradddong, useradddetail, userbirth, usernick, userage) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getUserPhone());
			pstmt.setString(5, vo.getUserAddSi());
			pstmt.setString(6, vo.getUserAddGu());
			pstmt.setString(7, vo.getUserAddDong());
			pstmt.setString(8, vo.getUserAddDetail());
			pstmt.setString(9, vo.getUserBirth());
			pstmt.setString(10, vo.getUserNick());
			pstmt.setInt(11, vo.getUserAge());
			//pstmt.executeUpdate();
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return flag;
	}

	
	@Override
	public int update(UserVO vo) {
		
		System.out.println(" ===== UserDAOimpl의 update() =====");
		System.out.println("vo : " + vo);
		
		int flag = 0;
		
		try {  
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" ~ connect successed! ~ ");
			/*private double decibel;
			private int userState;*/
			String sql="update users set userId=?, userPw=?, userName=?, "
					+ "userPhone=?, userAddSi=?, userAddGu=?, userAddDong=?, "
					+ "userAddDetail=?, userBirth=?, usernick=?, userage=? where userNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getUserPhone());
			pstmt.setString(5, vo.getUserAddSi());
			pstmt.setString(6, vo.getUserAddGu());
			pstmt.setString(7, vo.getUserAddDong());
			pstmt.setString(8, vo.getUserAddDetail());
			pstmt.setString(9, vo.getUserBirth());
			pstmt.setString(10, vo.getUserNick());
			pstmt.setInt(11, vo.getUserAge());
			pstmt.setInt(12, vo.getUserNum());
			//pstmt.executeUpdate();
			flag = pstmt.executeUpdate();
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
		return flag;
	}

	
	@Override
	public int delete(UserVO vo) {
		System.out.println(" ===== UserDAOimpl의 delete() =====");
		
		int flag = 0;
		
		try {  
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" ~ connect successed! ~ ");
			
			String sql="update users set userstate=1 where userNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getUserNum());
			//pstmt.executeUpdate();
			flag = pstmt.executeUpdate();
			
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
		return flag;
	}

	
	@Override
	public UserVO selectOne(UserVO vo) {
		System.out.println(" ===== UserDAOimpl의 selectOne() =====");
		System.out.println("vo : " + vo);
		
		UserVO vo1 = new UserVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" ~ connect successed! ~ ");
			
			String sql = "select * from users where userNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getUserNum());
			rs = pstmt.executeQuery(); 
			/*private double decibel;
			private int userState;*/
			while(rs.next()) {
				vo1.setUserNum(rs.getInt("userNum"));
				vo1.setUserId(rs.getString("userId"));
				vo1.setUserPw(rs.getString("userPw"));
				vo1.setUserName(rs.getString("userName"));
				vo1.setUserPhone(rs.getString("userPhone"));
				vo1.setUserAddSi(rs.getString("userAddSi"));
				vo1.setUserAddGu(rs.getString("userAddGu"));
				vo1.setUserAddDong(rs.getString("userAddDong"));
				vo1.setUserAddDetail(rs.getString("userAddDetail"));
				vo1.setUserBirth(rs.getString("userBirth"));
				vo1.setUserAge(rs.getInt("userAge"));
				vo1.setUserNick(rs.getString("userNick"));
				vo1.setDecibel(rs.getDouble("decibel"));
				vo1.setUserState(rs.getInt("userState"));
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
		return vo1;
	}

	
	@Override
	public List<UserVO> selectAll() {
		System.out.println(" ===== UserDAOimpl의 selectAll() =====");
		List<UserVO> list = new ArrayList<UserVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" ~ connect successed! ~ ");
			
			String sql = "select * from users order by userNum asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			
			while(rs.next()) {
				/*private double decibel;
				private int userState;*/
				UserVO vo = new UserVO();
				vo.setUserNum(rs.getInt("userNum"));
				vo.setUserId(rs.getString("userId"));
				vo.setUserPw(rs.getString("userPw"));
				vo.setUserName(rs.getString("userName"));
				vo.setUserPhone(rs.getString("userPhone"));
				vo.setUserAddSi(rs.getString("userAddSi"));
				vo.setUserAddGu(rs.getString("userAddGu"));
				vo.setUserAddDong(rs.getString("userAddDong"));
				vo.setUserAddDetail(rs.getString("userAddDetail"));
				vo.setUserBirth(rs.getString("userBirth"));
				vo.setUserAge(rs.getInt("userAge"));
				vo.setUserNick(rs.getString("userNick"));
				vo.setDecibel(rs.getDouble("decibel"));
				vo.setUserState(rs.getInt("userState"));
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
	public List<UserVO> searchList(String searchKey, String searchWord) {
		System.out.println(" ===== UserDAOimpl의 searchList() =====");
		System.out.println("searchKey : " + searchKey);
		System.out.println("searchWord : " + searchWord);
		
		List<UserVO> list = new ArrayList<UserVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" ~ connection successed! ~ ");
			
			String sql = "select * from users where " + searchKey + " like ? order by userNum asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserVO vo = new UserVO();
				vo.setUserNum(rs.getInt("userNum"));
				vo.setUserId(rs.getString("userId"));
				vo.setUserPw(rs.getString("userPw"));
				vo.setUserName(rs.getString("userName"));
				vo.setUserPhone(rs.getString("userPhone"));
				vo.setUserAddSi(rs.getString("userAddSi"));
				vo.setUserAddGu(rs.getString("userAddGu"));
				vo.setUserAddDong(rs.getString("userAddDong"));
				vo.setUserAddDetail(rs.getString("userAddDetail"));
				vo.setUserBirth(rs.getString("userBirth"));
				vo.setUserAge(rs.getInt("userAge"));
				vo.setUserNick(rs.getString("userNick"));
				vo.setDecibel(rs.getDouble("decibel"));
				vo.setUserState(rs.getInt("userState"));
				list.add(vo);
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

	
	//해당 id가 있는지 확인 - successed / failed 체크해주는 메소드
	@Override
	public String idCheck(UserVO vo) {
		System.out.println(" ===== UserDAOimpl의 idCheck() =====");
		System.out.println("vo : " + vo);
		
		String result = "OK";
		
		//id 없으면 "Not OK"
		if(vo.getUserId().trim().length()==0)
			return "Not OK";
		
		// id 있으면
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" ~ connection successed! ~ ");

			String sql = "select * from users where userId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				result = "Not OK";
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
		return result;
	}

	
	@Override
	public String loginOK(UserVO vo) {
		System.out.println(" ===== UserDAOimpl의 loginOK() =====");
		System.out.println("vo : " + vo);

		String result = "failed";

		// id, pw의 공백 없는 길이가 0이면 실패!
		if (vo.getUserId().trim().length() == 0 || vo.getUserPw().trim().length() == 0)
			return "failed";

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" connection successed! ");
			// private String memberId;
			// private String memberPw;
			String sql = "select * from users where userId=? and userPw=? and userstate=0";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			
			rs = pstmt.executeQuery(); 
			// 로그인 성공할 경우 - while문이 돌아간다 => id,pw 존재한다.
			while (rs.next()) { 
				result = "successed";
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
		return result;
	}
	
	@Override
	public UserVO selectById(UserVO vo) {
		System.out.println(" ===== UserDAOimpl의 selectById() =====");
		System.out.println("vo : " + vo);
		
		UserVO vo2 = new UserVO();
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(" ~ connect successed! ~ ");
			
			String sql = "select * from users where userID=? and userState=0";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			rs = pstmt.executeQuery(); 
			
			while(rs.next()) {
				vo2.setUserNum(rs.getInt("userNum"));
				vo2.setUserId(rs.getString("userId"));
				vo2.setUserPw(rs.getString("userPw"));
				vo2.setUserName(rs.getString("userName"));
				vo2.setUserPhone(rs.getString("userPhone"));
				vo2.setUserAddSi(rs.getString("userAddSi"));
				vo2.setUserAddGu(rs.getString("userAddGu"));
				vo2.setUserAddDong(rs.getString("userAddDong"));
				vo2.setUserAddDetail(rs.getString("userAddDetail"));
				vo2.setUserBirth(rs.getString("userBirth"));
				vo2.setUserAge(rs.getInt("userAge"));
				vo2.setUserNick(rs.getString("userNick"));
				vo2.setDecibel(rs.getDouble("decibel"));
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
		System.out.println("vo : " + vo2);
		return vo2;
	}
	
}//end class