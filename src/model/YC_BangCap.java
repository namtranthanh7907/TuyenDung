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
        // TODO implement here
        return false;
    }

    /**
     * @param hs 
     * @return
     */
    public double chamDiemUngVien(HoSoUngVien hs) {
        // TODO implement here
        return 0.0d;
    }

}