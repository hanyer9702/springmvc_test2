package com.junefw.infra.modules.code;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.junefw.infra.modules.common.util.UtilUpload;

@Service
public class CodeServiceImpl implements CodeService{
	
	//insert, update, delete

	@Autowired
	CodeDao dao;
	
	@Override
	public int selectOneCount(CodeVo vo) throws Exception {
		return dao.selectOneCount(vo);
	}

	@Override
	public List<Code> selectList(CodeVo vo) throws Exception {
		return dao.selectList(vo);
	}
	
	@Override
	public List<Code> selectAllList(CodeVo vo) throws Exception {
		return dao.selectAllList(vo);
	}

	@Override
	public int insert(Code dto) throws Exception {
		
		dao.insert(dto);			//ifcgName, ifcdName
		dao.insertCode(dto);		// ifcgName, ifcdName, ifcdSeq
		
		return 1;
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
	
	@Override
	public int updateDelete(CodeVo vo) throws Exception {
		return dao.updateDelete(vo);
	}
	
	@Override
	public int delete(CodeVo vo) throws Exception {
		return dao.delete(vo);
	}
	
//	-------------------- code
	
	@Override
	public int selectCodeOneCount(CodeVo vo) throws Exception {
		return dao.selectCodeOneCount(vo);
	}
	
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
		
		dao.insertCode(dto);
		
		int j = 0;
		
		for(MultipartFile multipartFile : dto.getFile0()) {
			String pathModule = this.getClass().getSimpleName().toString().toLowerCase().replace("serviceimpl", "");
			UtilUpload.upload(multipartFile, pathModule, dto);
			
			dto.setTableName("infrMemberUploaded");
			dto.setType(0);
			dto.setDefaultNy(0);
			dto.setSort(j);
			dto.setDefaultNy(0);
			dto.setPseq(dto.getIfcdSeq()); 
			
			dao.insertUploaded(dto);
			j++;
		}
		
		return 1;
	}

	@Override
	public int updateCode(Code dto) throws Exception {
		return dao.updateCode(dto);
	}

	@PostConstruct
	public void selectListForCache() throws Exception{
		List<Code> codeListFromDb = (ArrayList<Code>) dao.selectListForCache();
		
		Code.cachedCodeArrayList.clear();
		Code.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + Code.cachedCodeArrayList.size() + " Checked!");		
	}
	
	public static List<Code> selectListCachedCode(String ifcgSeq) throws Exception {
		List<Code> rt = new ArrayList<Code>();
		for(Code codeRow : Code.cachedCodeArrayList) {
			if(codeRow.getIfcgSeq().equals(ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		
		return rt;
	}
}