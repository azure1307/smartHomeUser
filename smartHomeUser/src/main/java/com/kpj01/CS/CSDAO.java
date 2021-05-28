package com.kpj01.CS;

import java.util.List;


public interface CSDAO {

	public CSVO selectOne(CSVO vo);
	public List<CSVO> selectAll();
	
}
