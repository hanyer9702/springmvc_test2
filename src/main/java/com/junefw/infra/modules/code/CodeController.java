package com.junefw.infra.modules.code;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {

	@Autowired
	CodeServiceImpl service;
	
	@RequestMapping(value = "/code/codeGroupList")
	public String codeGroupList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		// count 가져올것
		
		int count = service.selectOneCount(vo);
		
		
		vo.setParamsPaging(count);
		
		// count가 0이 아니면 list 가져오는 부분 수행 후 model 개체에 담기
		if(count != 0) {
			List<Code> list = service.selectList(vo);
			model.addAttribute("list", list);
		} else {
			// by pass
		}
		
		return "code/codeGroupList";
	}
	
	public String makeQueryString(CodeVo vo) {
		String tmp =  "&thisPage=" + vo.getThisPage() 
					+ "&shOption=" + vo.getShOption() 
					+ "&shValue=" + vo.getShValue();
		return tmp;
	}
		
	@RequestMapping(value = "/code/codeGroupForm")
	public String codeGroupForm(@ModelAttribute("vo") CodeVo vo) throws Exception {
		
		return "code/codeGroupForm";
	}
	
	@RequestMapping(value = "/code/codeGroupInst")
	public String codeGroupInst(@ModelAttribute("vo") CodeVo vo, Code dto, RedirectAttributes redirectAttributes) throws Exception {
		
//		입력 실행
		service.insert(dto);
		
		redirectAttributes.addAttribute("ifcgSeq", dto.getIfcdSeq());	//get
		redirectAttributes.addAttribute("thisPage", vo.getThisPage());	//get
		redirectAttributes.addAttribute("shOption", vo.getShOption());	//get
		redirectAttributes.addAttribute("shValue", vo.getShValue());	//get
		
		return "redirect:/code/codeGroupList";
//		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + makeQueryString(vo);
	}
	
	@RequestMapping(value = "/code/codeGroupView")
	public String codeGroupView(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		// 디비까지 가서 한 건의 데이터 값을 가지고 온다
		Code rt = service.selectOne(vo);
		
		// 가지고 온값을 jsp로 넘겨준다
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
		
		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + makeQueryString(vo);
	}
	
	@RequestMapping(value = "/code/codeGroupDelY")
	public String codeGroupDelY(@ModelAttribute("vo") CodeVo vo, Code dto, RedirectAttributes redirectAttributes) throws Exception {
		
//		입력 실행
		service.delete(vo);
		
		redirectAttributes.addAttribute("ifcgSeq", dto.getIfcdSeq());	//get
		redirectAttributes.addAttribute("thisPage", vo.getThisPage());	//get
		redirectAttributes.addAttribute("shOption", vo.getShOption());	//get
		redirectAttributes.addAttribute("shValue", vo.getShValue());	//get
		
		return "redirect:/code/codeGroupList";
//		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + makeQueryString(vo);
	}
	
	@RequestMapping(value = "/code/codeGroupDelN")
	public String codeGroupDelN(@ModelAttribute("vo") CodeVo vo, Code dto, RedirectAttributes redirectAttributes) throws Exception {
		
//		입력 실행
		service.updateDelete(vo);
		
		redirectAttributes.addAttribute("ifcgSeq", dto.getIfcdSeq());	//get
		redirectAttributes.addAttribute("thisPage", vo.getThisPage());	//get
		redirectAttributes.addAttribute("shOption", vo.getShOption());	//get
		redirectAttributes.addAttribute("shValue", vo.getShValue());	//get
		
		return "redirect:/code/codeGroupList";
//		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + makeQueryString(vo);
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
	
//	@RequestMapping(value = "/code/codeList", method = {RequestMethod.POST, RequestMethod.GET}) 
	@RequestMapping(value = "/code/codeList") 
	public String codeList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		List<Code> list2 = service.selectAllList(vo);
		model.addAttribute("list2", list2);
		
		int count = service.selectCodeOneCount(vo);
		
		vo.setParamsPaging(count);
		
		// count가 0이 아니면 list 가져오는 부분 수행 후 model 개체에 담기
		if(count != 0) {
			List<Code> list = service.selectCodeList(vo);
			model.addAttribute("list", list);
		} else {
			// by pass
		}

		return "/code/codeList";
	}
	
	@RequestMapping(value = "/code/codeView")
	public String codeView(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		System.out.println("*********************************");
		System.out.println(vo.getShIfcdDelNy());
		System.out.println(vo.getShIfcdName());
		System.out.println(vo.getThisPage());
		System.out.println(vo.getIfcdSeq());
		System.out.println("*********************************");
		
		
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
		
//		 MultipartFile multipartFile = dto.getFile(); 
		
//		String fileName = multipartFile.getOriginalFilename();
//		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
//		String uuid = UUID.randomUUID().toString();
//		String uuidFileName = uuid + "." + ext;
//		
//		dto.setIfcdOriginalFileName(fileName);
//		dto.setIfcdUuidFileName(uuidFileName);
//		
//		
//		multipartFile.transferTo(new File("C:/factory/ws_sts_0413/springmvc_test2/src/main/webapp/resources/uploaded/" + uuidFileName));
		
		
		
//		System.out.println("multipartFile:" + multipartFile.getOriginalFilename());
		
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