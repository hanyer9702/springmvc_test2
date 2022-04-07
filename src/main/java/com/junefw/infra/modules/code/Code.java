package com.junefw.infra.modules.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Code {
	
//	DTO codegroup
	private String ifcgSeq;
	private String ifcgName;
	private String ifcgNameEng;
	private Integer ifcgDelNy;
	
//	code
	private String ifcdSeq;
	private String ifcdName;
	private String ifcdUseNy;
	private String ifcdDelNy;
	private String ifcdOrder;
	
//	for cache
	public static List<Code> cachedCodeArrayList = new ArrayList<Code>(); 
	
//	uploaded
	public MultipartFile file;
	public MultipartFile file1;
	public String ifcdOriginalFileName;
	public String ifcdUuidFileName;
	
//------------
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public Integer getIfcgDelNy() {
		return ifcgDelNy;
	}
	public void setIfcgDelNy(Integer ifcgDelNy) {
		this.ifcgDelNy = ifcgDelNy;
	}
//	---------------------
	public String getIfcdSeq() {
		return ifcdSeq;
	}
	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}
	public String getIfcdName() {
		return ifcdName;
	}
	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}
	public String getIfcdDelNy() {
		return ifcdDelNy;
	}
	public void setIfcdDelNy(String ifcdDelNy) {
		this.ifcdDelNy = ifcdDelNy;
	}
	public String getIfcgNameEng() {
		return ifcgNameEng;
	}
	public void setIfcgNameEng(String ifcgNameEng) {
		this.ifcgNameEng = ifcgNameEng;
	}
	public String getIfcdUseNy() {
		return ifcdUseNy;
	}
	public void setIfcdUseNy(String ifcdUseNy) {
		this.ifcdUseNy = ifcdUseNy;
	}
	public String getIfcdOrder() {
		return ifcdOrder;
	}
	public void setIfcdOrder(String ifcdOrder) {
		this.ifcdOrder = ifcdOrder;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public String getIfcdOriginalFileName() {
		return ifcdOriginalFileName;
	}
	public void setIfcdOriginalFileName(String ifcdOriginalFileName) {
		this.ifcdOriginalFileName = ifcdOriginalFileName;
	}
	public String getIfcdUuidFileName() {
		return ifcdUuidFileName;
	}
	public void setIfcdUuidFileName(String ifcdUuidFileName) {
		this.ifcdUuidFileName = ifcdUuidFileName;
	}
	
	
}