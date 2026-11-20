package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class YC_BangCap extends AYeuCauTuyenDung {

    /**
     * Default constructor
     */
	
	
	
    public YC_BangCap() {
    }

    /**
     * 
     */
    private String tenBangCap;

    /**
     * 
     */
    private String moTaBangCap;

    
    public YC_BangCap(String tenBangCap, String moTaBangCap) {
		super();
		this.tenBangCap = tenBangCap;
		this.moTaBangCap = moTaBangCap;
	}

    
	public YC_BangCap(String maYeuCau, int doUuTien, boolean batBuoc, String tenBangCap, String moTaBangCap) {
		super(maYeuCau, doUuTien, batBuoc);
		this.tenBangCap = tenBangCap;
		this.moTaBangCap = moTaBangCap;
	}


	public String getTenBangCap() {
		return tenBangCap;
	}


	public void setTenBangCap(String tenBangCap) {
		this.tenBangCap = tenBangCap;
	}


	public String getMoTaBangCap() {
		return moTaBangCap;
	}


	public void setMoTaBangCap(String moTaBangCap) {
		this.moTaBangCap = moTaBangCap;
	}


	/**
     * @param hs 
     * @return
     */
    public boolean kiemTra(HoSoUngVien hs) {
    	return hs != null && TienIch.khop(hs.getBangCap(), tenBangCap);
    }

    /**
     * @param hs 
     * @return
     */
    public double chamDiemUngVien(HoSoUngVien hs) {
        return kiemTra(hs) ? 1.0 : 0.0;
    }

    public String toString() {
    	return "Yeu cau bang cap: " + tenBangCap + " (" + super.toString() + ")";
    }
    
}