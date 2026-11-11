package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class KetQuaUngTuyen {

    /**
     * Default constructor
     */
    public KetQuaUngTuyen() {
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


	/**
     * @param trangThaiMoi 
     * @return
     */
    public void capNhatTrangThai(String trangThaiMoi) {
        this.trangThaiUngTuyen = trangThaiMoi;
    }

    /**
     * @param diemSan 
     * @return
     */
    public boolean kiemTraDatDiemSan(double diemSan) {
        return diemTongKet >= diemSan;
    }

}