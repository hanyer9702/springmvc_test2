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
	public String codeGroupList(CodeVo vo, Model model) throws Exception {

		List<Code> list = service.selectList(vo);
		model.addAttribute("list", list);

		return "code/codeGroupList";
	}
		
	@RequestMapping(value = "/code/codeGroupForm")
	public String codeGroupForm() throws Exception {
		
		return "code/codeGroupForm";
	}
	
	@RequestMapping(value = "/code/codeGroupInst")
	public String codeGroupInst(Code dto) throws Exception {
		
//		입력 실행
		service.insert(dto);
		
		return "redirect:/code/codeGroupList";
	}
	
	@RequestMapping(value = "/code/codeGroupView")
	public String codeGroupView(CodeVo vo, Model model) throws Exception {
		
		// 디비까지 가서 한 건의 데이터 값을 가지고 온다
		Code rt = service.selectOne(vo);
		
		// 가지고 온값을 jsp로 넘겨준다
		model.addAttribute("rt", rt);
		
		return "code/codeGroupView";
	}
	
	@RequestMapping(value = "/code/codeGroupUpdt")
	public String codeGroupUpdt(Code dto, Model model) throws Exception {
		
		service.update(dto);
		
		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq();
	}
	
	@RequestMapping(value = "/code/codeGroupForm2")
	public String codeGroupForm2(CodeVo vo, Model model) throws Exception {
		
		Code rt = service.selectOne(vo);
		
		model.addAttribute("rt", rt);
		
		return "code/codeGroupForm2";
	}
	
	@RequestMapping(value = "/code/codeGroupUpdt2")
	public String codeGroupUpdt2(Code dto) throws Exception {
		
		service.update2(dto);
		
		return "code/codeGroupUpdt2";
	}
	
//	@RequestMapping(value = "/code/codeGroupForm3")
//	public String codeGroupForm3(CodeVo vo, Model model) throws Exception {
//		
//		//데이터 전부 긁어와서 보여주기
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
	public String codeList(Model model) throws Exception {

		List<Code> list = service.selectCodeList();
		model.addAttribute("list", list);

		return "code/codeList";
	}
	
	@RequestMapping(value = "/code/codeView")
	public String codeView(CodeVo vo, Model model) throws Exception {
		
		// 디비까지 가서 한 건의 데이터 값을 가지고 온다
		Code rt = service.selectCodeOne(vo);
		
		// 가지고 온값을 jsp로 넘겨준다
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
		
//		입력 실행
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