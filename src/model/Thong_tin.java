package model;

import java.sql.Time;
import java.util.Date;

public class Thong_tin {

	private int sTT;
	private String maHP;
	private String tenHP;
	private int soTin;
	private int soSV;
	private String hinhThuc;
	private String thoiLuong;
	private Date ngay;
	private Time gioThi;
	private String phong;
	private String lop;
	private String nhom;
	
		
	public int getsTT() {
		return sTT;
	}
	public void setsTT(int sTT) {
		this.sTT = sTT;
	}
	public String getMaHP() {
		return maHP;
	}
	public void setMaHP(String maHP) {
		this.maHP = maHP;
	}
	public int getSoTin() {
		return soTin;
	}
	public void setSoTin(int soTin) {
		this.soTin = soTin;
	}
	public String getTenHP() {
		return tenHP;
	}
	public void setTenHP(String tenHP) {
		this.tenHP = tenHP;
	}
	public int getSoSV() {
		return soSV;
	}
	public void setSoSV(int soSV) {
		this.soSV = soSV;
	}
	public String getHinhThuc() {
		return hinhThuc;
	}
	public void setHinhThuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}
	public String getThoiLuong() {
		return thoiLuong;
	}
	public void setThoiLuong(String thoiLuong) {
		this.thoiLuong = thoiLuong;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public Time getGioThi() {
		return gioThi;
	}
	public void setGioThi(Time gioThi) {
		this.gioThi = gioThi;
	}
	public String getPhong() {
		return phong;
	}
	public void setPhong(String phong) {
		this.phong = phong;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getNhom() {
		return nhom;
	}
	public void setNhom(String nhom) {
		this.nhom = nhom;
	}
		
}
