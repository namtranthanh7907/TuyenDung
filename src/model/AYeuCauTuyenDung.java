package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class AYeuCauTuyenDung{

    /**
     * Default constructor
     */
    public AYeuCauTuyenDung() {
    	this("", 1, false);
    }

    /**
     * 
     */
    private String maYeuCau;

    /**
     * 
     */
    private int doUuTien;

    /**
     * 
     */
    private boolean batBuoc;



    /**
     * @param hs 
     * @return
     */
    public abstract boolean kiemTra(HoSoUngVien hs);

    public AYeuCauTuyenDung(String maYeuCau, int doUuTien, boolean batBuoc) {
		super();
		this.maYeuCau = maYeuCau == null ? "" : maYeuCau;
		this.doUuTien = Math.max(1, Math.min(5, doUuTien));
		this.batBuoc = batBuoc;
	}

	public String getMaYeuCau() {
		return maYeuCau;
	}

	public void setMaYeuCau(String maYeuCau) {
		this.maYeuCau = maYeuCau;
	}

	public boolean isBatBuoc() {
		return batBuoc;
	}

	public void setBatBuoc(boolean batBuoc) {
		this.batBuoc = batBuoc;
	}

	

	public void setDoUuTien(int doUuTien) {
		this.doUuTien = Math.max(1, Math.min(5, doUuTien));
	}

	/**
     * @return
     */
    
	public int getDoUuTien() {
		return doUuTien;
	}
    /**
     * @param hs 
     * @return
     */
    public abstract double chamDiemUngVien(HoSoUngVien hs);

	public String toString() {
		return "Ma yeu cau: " + maYeuCau + ", Do uu tien: " + doUuTien + ", Bat buoc: " + batBuoc;
	}

}