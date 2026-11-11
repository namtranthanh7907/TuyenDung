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
    public double canNangMax;

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