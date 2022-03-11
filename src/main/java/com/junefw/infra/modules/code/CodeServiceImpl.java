package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService{

	@Autowired
	CodeDao dao;

	@Override
	public List<Code> selectList(CodeVo vo) throws Exception {
		return dao.selectList(vo);
	}

	@Override
	public int insert(Code dto) throws Exception {
		return dao.insert(dto);
	}

	@Override
	public Code selectOne(CodeVo vo) throws Exception {
		
		return dao.selectOne(vo);
	}

	@Override
	public int update(Code dto) throws Exception {
		return dao.update(dto);
	}

	@Override
	public Code selectOne(Code dto) throws Exception {
		return dao.selectOne(dto);
	}

	@Override
	public int update2(Code dto) throws Exception {
		return dao.update2(dto);
	}
	
//	-------------------- code
	
	@Override
	public List<Code> selectCodeList(CodeVo vo) throws Exception {
		return dao.selectCodeList(vo);
	}

	@Override
	public Code selectCodeOne(CodeVo vo) throws Exception {
		return dao.selectCodeOne(vo);
	}

	@Override
	public int insertCode(Code dto) throws Exception {
		return dao.insertCode(dto);
	}

	@Override
	public int updateCode(Code dto) throws Exception {
		return dao.updateCode(dto);
	}
	
	
}