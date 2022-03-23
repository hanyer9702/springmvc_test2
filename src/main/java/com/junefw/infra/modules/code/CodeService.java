package com.junefw.infra.modules.code;

import java.util.List;

public interface CodeService {
	
	public int selectOneCount(CodeVo vo) throws Exception;
	
	public List<Code> selectList(CodeVo vo) throws Exception; 
	public int insert(Code dto) throws Exception;
	public Code selectOne(CodeVo vo) throws Exception;
	public Code selectOne(Code dto) throws Exception;
	public int update(Code dto) throws Exception;
	public int update2(Code dto) throws Exception;
	public int updateDelete(CodeVo vo) throws Exception;
	public int delete(CodeVo vo) throws Exception;
	
//	code------------------
	
	public List<Code> selectCodeList(CodeVo vo) throws Exception; 
	public Code selectCodeOne(CodeVo vo) throws Exception;
	public int insertCode(Code dto) throws Exception;
	public int updateCode(Code dto) throws Exception;
}