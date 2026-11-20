package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class YC_NgoaiHinh extends AYeuCauTuyenDung {

    /**
     * Default constructor
     */
    public YC_NgoaiHinh() {
    }

    /**
     * 
     */
    private double chieuCaoMin;

    /**
     * 
     */
    private double chieuCaoMax;

    /**
     * 
     */
    private double canNangMin;

    /**
     * 
     */
    private double canNangMax;

    public YC_NgoaiHinh(double chieuCaoMin, double chieuCaoMax, double canNangMin, double canNangMax) {
		super();
		this.chieuCaoMin = chieuCaoMin;
		this.chieuCaoMax = chieuCaoMax;
		this.canNangMin = canNangMin;
		this.canNangMax = canNangMax;
	}

	public double getChieuCaoMin() {
		return chieuCaoMin;
	}

	public void setChieuCaoMin(double chieuCaoMin) {
		this.chieuCaoMin = chieuCaoMin;
	}

	public double getChieuCaoMax() {
		return chieuCaoMax;
	}

	public void setChieuCaoMax(double chieuCaoMax) {
		this.chieuCaoMax = chieuCaoMax;
	}

	public double getCanNangMin() {
		return canNangMin;
	}

	public void setCanNangMin(double canNangMin) {
		this.canNangMin = canNangMin;
	}

	public double getCanNangMax() {
		return canNangMax;
	}

	public void setCanNangMax(double canNangMax) {
		this.canNangMax = canNangMax;
	}

	/**
     * @param hs 
     * @return
     */
    public boolean kiemTra(HoSoUngVien hs) {
        if(hs == null) {
        	return false;
        }
        
        if(chieuCaoMin < 0 || chieuCaoMax < chieuCaoMin || canNangMin < 0 || canNangMax < canNangMin) {
        	return false;
        }
        
        double cao = hs.getChieuCao();
        double canNang = hs.getCanNang();
        return cao > 0 && canNang > 0
        		&& cao >= chieuCaoMin && cao <= chieuCaoMax
        		&& canNang >= canNangMin && canNang <= canNangMax;
    }

    /**
     * @param hs 
     * @return
     */
    public double chamDiemUngVien(HoSoUngVien hs) {
        return kiemTra(hs) ? 1.0 : 0.0;
    }

}