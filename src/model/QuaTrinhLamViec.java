package model;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
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
    
    private String linhVuc;



    
	public QuaTrinhLamViec(String tgianBD, String tgKetThuc, String viTri, String tenCongTy, String sdt_nguoiLH,
			String moTaCongViec, String thanhTich, String linhVuc) {
		super();
		this.tgianBD = tgianBD;
		this.tgKetThuc = tgKetThuc;
		this.viTri = viTri;
		this.tenCongTy = tenCongTy;
		this.sdt_nguoiLH = sdt_nguoiLH;
		this.moTaCongViec = moTaCongViec;
		this.thanhTich = thanhTich;
		this.linhVuc = linhVuc;
	}
	
	

	public String getLinhVuc() {
		return linhVuc;
	}



	public void setLinhVuc(String linhVuc) {
		this.linhVuc = linhVuc;
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
	
	public LocalDate layNgayBatDau() {
		return TienIch.parseNgay(tgianBD);
	}
	
	public LocalDate layNgayKetThuc() {
		if(tinhTrangLamViec()) {
			return LocalDate.now();
		}
		return TienIch.parseNgay(tgKetThuc);
	}

	/**
     * @return
     */

    /**
     * @return
     */
    public boolean tinhTrangLamViec() {
    	if (tgKetThuc == null || tgKetThuc.trim().isEmpty()) {
            return true;
        }
        String ketThuc = TienIch.chuanHoa(tgKetThuc);
        
        return "nay".equals(ketThuc);
    }
    
    public boolean hopLe() {
    	LocalDate batDau = layNgayBatDau();
    	LocalDate ketThuc = layNgayKetThuc();
    	
    	return batDau != null && ketThuc != null && !ketThuc.isBefore(batDau);
    }

    public int tinhSoThangLamViec() {
    	if(!hopLe()) {
    		return 0;
    	}
    	
    	LocalDate batDat = layNgayBatDau();
    	LocalDate ketThuc = layNgayKetThuc();
    	long soThang = ChronoUnit.MONTHS.between(batDat, ketThuc.plusDays(1));
    	
    	if(soThang <= 0) {
    		return 0;
    	}
    	
    	return soThang > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) soThang;
    }
    
    /**
     * @param vitri
     * @return
     */
    
    
    
    public void capNhatQuaTrinhLamViec(String vitriMoi) {
        if(vitriMoi == null || vitriMoi.trim().isEmpty()) {
        	return;
        }
        this.viTri = vitriMoi.trim();
    }
    
    public String toString() {
    	return viTri + " tai " + tenCongTy + " (" + tgianBD + " - " + (tinhTrangLamViec() ? "nay" : tgKetThuc)
    			+ "), linh vuc: " + linhVuc;
    }
}