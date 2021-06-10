package com.kpj01.user;

import java.util.List;


public interface UserDAO { 
	
	public int insert(UserVO vo);

	public int update(UserVO vo);

	public int delete(UserVO vo);

	public UserVO selectOne(UserVO vo);

	public List<UserVO> selectAll();

	public List<UserVO> searchList(String searchKey, String searchWord);

	public String idCheck(UserVO vo);

	public String loginOK(UserVO vo);
	
	public UserVO selectById(UserVO vo);
	
	
	
	
	
	
}
