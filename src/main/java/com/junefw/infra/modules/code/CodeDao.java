package com.junefw.infra.modules.code;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDao {
	
	@Inject
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	private static String namespace = "com.junefw.infra.modules.code.CodeMpp";

	public List<Code> selectList(CodeVo vo) {
		return sqlSession.selectList(namespace + ".selectList", vo);
	}
	
	public int insert(Code dto) {
		return sqlSession.insert(namespace + ".insert", dto);
	}
	
	public Code selectOne(CodeVo vo) {
		return sqlSession.selectOne(namespace + ".selectOne", vo);
	}
	
	public Code selectOne(Code dto) {
		return sqlSession.selectOne(namespace + ".selectOne", dto);
	}
	
	public int update(Code dto) {
		return sqlSession.update(namespace + ".update", dto);
	}
	
	public int update2(Code dto) {
		return sqlSession.update(namespace + ".update2", dto);
	}
	
//	---------------------code
	
	public List<Code> selectCodeList(CodeVo vo) {
		return sqlSession.selectList(namespace + ".selectCodeList", vo);
	}
	public Code selectCodeOne(CodeVo vo) {
		return sqlSession.selectOne(namespace + ".selectCodeOne", vo);
	}
	public int insertCode(Code dto) {
		return sqlSession.insert(namespace + ".insertCode", dto);
	}
	public int updateCode(Code dto) {
		return sqlSession.update(namespace + ".updateCode", dto);
	}
}