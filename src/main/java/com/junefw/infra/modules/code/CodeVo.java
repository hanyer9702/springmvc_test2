package com.junefw.infra.modules.code;

public class CodeVo {
	
	//VO

	private String ifcgSeq;
	
	// search
	private String shIfcgName;
	private String shIfcgDelNy;
	
//	code
	
	private String ifcdSeq;
	
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
}
