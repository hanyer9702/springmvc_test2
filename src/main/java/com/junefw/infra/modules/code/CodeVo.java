package com.junefw.infra.modules.code;

public class CodeVo {
	
	//codegroup VO

	private String ifcgSeq;
	
	//codegroup search
	private String shIfcgName;
	private String shIfcgDelNy;
	
//	code
	
	private String ifcdSeq;
	
//	code search
	
	private String shIfcdName;
	private String shIfcdDelNy;
	private String shIfcgSeq;
	
	//--------------------------

	public String getIfcgSeq() {
		return ifcgSeq;
	}

	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}

	public String getShIfcgName() {
		return shIfcgName;
	}

	public void setShIfcgName(String shIfcgName) {
		this.shIfcgName = shIfcgName;
	}
	
	public String getShIfcgDelNy() {
		return shIfcgDelNy;
	}

	public void setShIfcgDelNy(String shIfcgDelNy) {
		this.shIfcgDelNy = shIfcgDelNy;
	}

	//	-----------------------
	public String getIfcdSeq() {
		return ifcdSeq;
	}

	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}

	public String getShIfcdName() {
		return shIfcdName;
	}

	public void setShIfcdName(String shIfcdName) {
		this.shIfcdName = shIfcdName;
	}

	public String getShIfcdDelNy() {
		return shIfcdDelNy;
	}

	public void setShIfcdDelNy(String shIfcdDelNy) {
		this.shIfcdDelNy = shIfcdDelNy;
	}

	public String getShIfcgSeq() {
		return shIfcgSeq;
	}

	public void setShIfcgSeq(String shIfcgSeq) {
		this.shIfcgSeq = shIfcgSeq;
	}
}
