package com.kpj01.CS;

import java.util.List;


public interface CSDAO {

	public List<CSVO> selectOne(String csQuestion);
	public List<CSVO> selectAll();
	
}
