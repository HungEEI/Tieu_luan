package model;

import java.util.ArrayList;

public class thongTinModel {
	
	private ArrayList<Thong_tin> dsThong_tin;
	private String luachon;
	private String tenFile;
	
	public thongTinModel() {
		this.dsThong_tin = new ArrayList<Thong_tin>();
		this.luachon = "";
		this.tenFile = "";
	}

	public ArrayList<Thong_tin> getDsThong_tin() {
		return dsThong_tin;
	}

	public void setDsThong_tin(ArrayList<Thong_tin> dsThong_tin) {
		this.dsThong_tin = dsThong_tin;
	}

	public String getLuachon() {
		return luachon;
	}

	public void setLuachon(String luachon) {
		this.luachon = luachon;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
	
}
