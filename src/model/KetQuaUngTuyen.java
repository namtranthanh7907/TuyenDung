package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class KetQuaUngTuyen {
	
	
	public static final String TT_CHO = "Cho xet duyet";
	public static final String TT_DAT_HO_SO = "Dat ho so";
	public static final String TT_PHONG_VAN = "Dang phong van";
	public static final String TT_TRUNGTUYEN = "Trung tuyen";
	public static final String TT_LOAI = "Loai";
	public static final String TT_KHONG_TRUNGTUYEN = "Khong trung tuyen";

    /**
     * Default constructor
     */
    public KetQuaUngTuyen() {
    	this.maKetQua = "";
    	this.trangThaiUngTuyen = TT_CHO;
    	this.ngayDanhGia = "";
    }

    /**
     * 
     */
    private String maKetQua;

    /**
     * 
     */
    private HoSoUngVien hoSo;

    /**
     * 
     */
    private String trangThaiUngTuyen;

    /**
     * 
     */
    private String ngayDanhGia;

    /**
     * 
     */
    private ViTriTuyenDung viTri;

    /**
     * 
     */
    private double diemTongKet;
    
    
    private double diemHoSo;
    private double diemPhongVan;




    public KetQuaUngTuyen(String maKetQua, HoSoUngVien hoSo, String trangThaiUngTuyen, String ngayDanhGia,
			ViTriTuyenDung viTri, double diemTongKet) {
		super();
		this.maKetQua = maKetQua;
		this.hoSo = hoSo;
		this.trangThaiUngTuyen = trangThaiUngTuyen;
		this.ngayDanhGia = ngayDanhGia;
		this.viTri = viTri;
		this.diemTongKet = diemTongKet;
	}

    
	public String getMaKetQua() {
		return maKetQua;
	}


	public void setMaKetQua(String maKetQua) {
		this.maKetQua = maKetQua;
	}


	public HoSoUngVien getHoSo() {
		return hoSo;
	}


	public void setHoSo(HoSoUngVien hoSo) {
		this.hoSo = hoSo;
	}


	public String getTrangThaiUngTuyen() {
		return trangThaiUngTuyen;
	}


	public void setTrangThaiUngTuyen(String trangThaiUngTuyen) {
		this.trangThaiUngTuyen = trangThaiUngTuyen;
	}


	public String getNgayDanhGia() {
		return ngayDanhGia;
	}


	public void setNgayDanhGia(String ngayDanhGia) {
		this.ngayDanhGia = ngayDanhGia;
	}


	public ViTriTuyenDung getViTri() {
		return viTri;
	}


	public void setViTri(ViTriTuyenDung viTri) {
		this.viTri = viTri;
	}


	public double getDiemTongKet() {
		return diemTongKet;
	}


	public void setDiemTongKet(double diemTongKet) {
		this.diemTongKet = diemTongKet;
	}

	
	

	public double getDiemHoSo() {
		return diemHoSo;
	}


	public void setDiemHoSo(double diemHoSo) {
		this.diemHoSo = diemHoSo;
	}


	public double getDiemPhongVan() {
		return diemPhongVan;
	}


	public void setDiemPhongVan(double diemPhongVan) {
		this.diemPhongVan = diemPhongVan;
	}


	/**
     * @param trangThaiMoi 
     * @return
     */
	//cap nhat trang thai ung tuyen moi
    public void capNhatTrangThai(String trangThaiMoi) {
        if(trangThaiMoi == null || trangThaiMoi.trim().isEmpty()) {
        	return;
        }
        
        this.trangThaiUngTuyen = trangThaiMoi.trim();
    }

    /**
     * @param diemSan 
     * @return
     */
    
    //kiem tra diem
    public boolean kiemTraDatDiemSan(double diemSan) {
        return diemTongKet >= diemSan;
    }
    
    public String toString() {
    	String ten = (hoSo == null || hoSo.getHoTen() == null) ? "" : hoSo.getHoTen();
    	return (maKetQua == null ? "" : maKetQua) + " | " + ten + " | "
    			+ (trangThaiUngTuyen == null ? "" : trangThaiUngTuyen)
    			+ " | HS=" + String.format(Locale.ROOT, "%.2f", diemHoSo)
    			+ " | PV=" + String.format(Locale.ROOT, "%.2f", diemPhongVan)
    			+ " | TK=" + String.format(Locale.ROOT, "%.2f", diemTongKet);
    }

}