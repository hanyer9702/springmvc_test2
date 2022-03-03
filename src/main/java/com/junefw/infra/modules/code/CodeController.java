package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@Autowired
	CodeServiceImpl service;
	
	@RequestMapping(value = "/code/codeGroupList")
	public String codeGroupList(Model model) throws Exception {

		List<Code> list = service.selectList();
		model.addAttribute("list", list);

		return "code/codeGroupList";
	}
		
	@RequestMapping(value = "/code/codeGroupForm")
	public String codeGroupForm() throws Exception {
		
		return "code/codeGroupForm";
	}
	
	@RequestMapping(value = "/code/codeGroupInst")
	public String codeGroupInst(Code dto) throws Exception {
		
//		�Է� ����
		service.insert(dto);
		
		return "";
	}
	
	@RequestMapping(value = "/code/codeGroupView")
	public String codeGroupView(CodeVo vo, Model model) throws Exception {
		
		// ������ ���� �� ���� ������ ���� ������ �´�
		Code rt = service.selectOne(vo);
		
		// ������ �°��� jsp�� �Ѱ��ش�
		model.addAttribute("rt", rt);
		
		return "code/codeGroupView";
	}
	
	@RequestMapping(value = "/code/codeGroupUpdt")
	public String codeGroupUpdt(Code dto, Model model) throws Exception {
		
		service.update(dto);
		
		Code rt = service.selectOne(dto);
		model.addAttribute("rt", rt);
		
		return "code/codeGroupUpdt";
	}
	
//	@RequestMapping(value = "/code/codeGroupForm3")
//	public String codeGroupForm3(CodeVo vo, Model model) throws Exception {
//		
//		//������ ���� �ܾ�ͼ� �����ֱ�
//		List<Code> list = service.selectList();
//		model.addAttribute("list", list);
//		service.update(vo);
//				
//		return "code/codeGroupForm3";
//	}
//	
//	@RequestMapping(value = "/code/codeGroupUpdt2")
//	public String codeGroupUpdt2(Code dto, Model model) throws Exception {
//		
////		Code rt = service.selectOne(dto);
////		model.addAttribute("rt", rt);
//		
//		return "code/codeGroupUpdt2";
//	}
}