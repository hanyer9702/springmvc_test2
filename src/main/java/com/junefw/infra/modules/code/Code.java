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
	private MultipartFile[] file0;
	private MultipartFile[] file1;
	private String ifcdOriginalFileName;
	private String ifcdUuidFileName;
	
	private String tableName;
	
	private String seq;
	private Integer type;
	private Integer defaultNy;
	private Integer sort;
	private String originalName;
	private String uuidName;
	private String ext;
	private long size;
	private Integer delNy;
	private String pseq;
	
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
	public MultipartFile[] getFile0() {
		return file0;
	}
	public void setFile0(MultipartFile[] file0) {
		this.file0 = file0;
	}
	public MultipartFile[] getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile[] file1) {
		this.file1 = file1;
	}
	
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long l) {
		this.size = l;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getDefaultNy() {
		return defaultNy;
	}
	public void setDefaultNy(Integer defaultNy) {
		this.defaultNy = defaultNy;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getUuidName() {
		return uuidName;
	}
	public void setUuidName(String uuidName) {
		this.uuidName = uuidName;
	}
	public Integer getDelNy() {
		return delNy;
	}
	public void setDelNy(Integer delNy) {
		this.delNy = delNy;
	}
	public String getPseq() {
		return pseq;
	}
	public void setPseq(String pseq) {
		this.pseq = pseq;
	}
	
	
}