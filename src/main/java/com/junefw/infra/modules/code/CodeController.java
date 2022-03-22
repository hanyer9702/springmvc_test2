package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@Autowired
	CodeServiceImpl service;
	
	@RequestMapping(value = "/code/codeGroupList")
	public String codeGroupList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		// count �����ð�
		
		int count = service.selectOneCount(vo);
		
		
		vo.setParamsPaging(count);
		
		// count�� 0�� �ƴϸ� list �������� �κ� ���� �� model ��ü�� ���
		if(count != 0) {
			List<Code> list = service.selectList(vo);
			model.addAttribute("list", list);
		} else {
			// by pass
		}
		
		return "code/codeGroupList";
	}
		
	@RequestMapping(value = "/code/codeGroupForm")
	public String codeGroupForm(@ModelAttribute("vo") CodeVo vo) throws Exception {
		
		return "code/codeGroupForm";
	}
	
	@RequestMapping(value = "/code/codeGroupInst")
	public String codeGroupInst(@ModelAttribute("vo") CodeVo vo, Code dto) throws Exception {
		
//		�Է� ����
		service.insert(dto);
		
//		return "redirect:/code/codeGroupList";
		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + "&thisPage=" + vo.getThisPage() + "&shOption=" + vo.getShOption() + "&shValue=" + vo.getShValue();
	}
	
	@RequestMapping(value = "/code/codeGroupView")
	public String codeGroupView(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		// ������ ���� �� ���� ������ ���� ������ �´�
		Code rt = service.selectOne(vo);
		
		// ������ �°��� jsp�� �Ѱ��ش�
		model.addAttribute("rt", rt);
		
		return "code/codeGroupView";
	}
	
	@RequestMapping(value = "/code/codeGroupUpdt")
	public String codeGroupUpdt(@ModelAttribute("vo") CodeVo vo, Code dto, Model model) throws Exception {
		
		service.update(dto);
		
		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + "&shOption=" + vo.getShOption() + "&shValue=" + vo.getShValue();
	}
	
	@RequestMapping(value = "/code/codeGroupForm2")
	public String codeGroupForm2(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		Code rt = service.selectOne(vo);
		
		model.addAttribute("rt", rt);
		
		return "code/codeGroupForm2";
	}
	
	@RequestMapping(value = "/code/codeGroupUpdt2")
	public String codeGroupUpdt2(@ModelAttribute("vo") CodeVo vo, Code dto) throws Exception {
		
		service.update2(dto);
		
		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + "&thisPage=" + vo.getThisPage() + "&shOption=" + vo.getShOption() + "&shValue=" + vo.getShValue();
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
	
//	-----------------------
//	code
	
	@RequestMapping(value = "/code/codeList")
	public String codeList(CodeVo vo, Model model) throws Exception {

		List<Code> list = service.selectCodeList(vo);
		model.addAttribute("list", list);
		
		List<Code> list2 = service.selectList(vo);
		model.addAttribute("list2", list2);

		return "code/codeList";
	}
	
	@RequestMapping(value = "/code/codeView")
	public String codeView(CodeVo vo, Model model) throws Exception {
		
		// ������ ���� �� ���� ������ ���� ������ �´�
		Code rt = service.selectCodeOne(vo);
		
		// ������ �°��� jsp�� �Ѱ��ش�
		model.addAttribute("rt", rt);
		
		return "code/codeView";
	}
	@RequestMapping(value = "/code/codeForm")
	public String codeForm(CodeVo vo, Model model) throws Exception {
		
		List<Code> list = service.selectList(vo);
		model.addAttribute("list", list);
		
		return "code/codeForm";
	}
	
	@RequestMapping(value = "/code/codeInst")
	public String codeInst(Code dto) throws Exception {
		
//		�Է� ����
		service.insertCode(dto);
		
		return "";
	}
	@RequestMapping(value = "/code/codeForm2")
	public String codeForm2(CodeVo vo, Model model) throws Exception {
		
		Code rt = service.selectCodeOne(vo);
		
		model.addAttribute("rt", rt);
		
		return "code/codeForm2";
	}
	
	@RequestMapping(value = "/code/codeUpdt")
	public String codeUpdt(Code dto) throws Exception {
		
		service.updateCode(dto);
		
		return "code/codeUpdt";
	}
}