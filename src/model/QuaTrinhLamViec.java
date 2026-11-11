package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class QuaTrinhLamViec {

    /**
     * Default constructor
     */
    public QuaTrinhLamViec() {
    }

    /**
     * 
     */
    private String tgianBD;

    /**
     * 
     */
    private String tgKetThuc;

    /**
     * 
     */
    private String viTri;

    /**
     * 
     */
    private String tenCongTy;

    /**
     * 
     */
    private String sdt_nguoiLH;

    /**
     * 
     */
    private String moTaCongViec;

    /**
     * 
     */
    private String thanhTich;


    public QuaTrinhLamViec(String tgianBD, String tgKetThuc, String viTri, String tenCongTy, String sdt_nguoiLH,
			String moTaCongViec, String thanhTich) {
		super();
		this.tgianBD = tgianBD;
		this.tgKetThuc = tgKetThuc;
		this.viTri = viTri;
		this.tenCongTy = tenCongTy;
		this.sdt_nguoiLH = sdt_nguoiLH;
		this.moTaCongViec = moTaCongViec;
		this.thanhTich = thanhTich;
	}

    
	public String getTgianBD() {
		return tgianBD;
	}


	public void setTgianBD(String tgianBD) {
		this.tgianBD = tgianBD;
	}


	public String getTgKetThuc() {
		return tgKetThuc;
	}


	public void setTgKetThuc(String tgKetThuc) {
		this.tgKetThuc = tgKetThuc;
	}


	public String getViTri() {
		return viTri;
	}


	public void setViTri(String viTri) {
		this.viTri = viTri;
	}


	public String getTenCongTy() {
		return tenCongTy;
	}


	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}


	public String getSdt_nguoiLH() {
		return sdt_nguoiLH;
	}


	public void setSdt_nguoiLH(String sdt_nguoiLH) {
		this.sdt_nguoiLH = sdt_nguoiLH;
	}


	public String getMoTaCongViec() {
		return moTaCongViec;
	}


	public void setMoTaCongViec(String moTaCongViec) {
		this.moTaCongViec = moTaCongViec;
	}


	public String getThanhTich() {
		return thanhTich;
	}


	public void setThanhTich(String thanhTich) {
		this.thanhTich = thanhTich;
	}


	/**
     * @return
     */
    public int tinhSoThangLamViec() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public boolean tinhTrangLamViec() {
        // TODO implement here
        return false;
    }

    /**
     * @param vitri 
     * @return
     */
    public void capNhatQuaTrinhLamViec(String vitri) {
        // TODO implement here
        
    }

}