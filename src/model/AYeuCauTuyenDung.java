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
    }

    /**
     * 
     */
    private String maYeuCau;

    /**
     * 
     */
    private String doUuTien;

    /**
     * 
     */
    private boolean batBuoc;



    /**
     * @param hs 
     * @return
     */
    public abstract boolean kiemTra(HoSoUngVien hs);

    public AYeuCauTuyenDung(String maYeuCau, String doUuTien, boolean batBuoc) {
		super();
		this.maYeuCau = maYeuCau;
		this.doUuTien = doUuTien;
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

	public void setDoUuTien(String doUuTien) {
		this.doUuTien = doUuTien;
	}

	/**
     * @return
     */
    public int getDoUuTien() {
        // TODO implement here
        return 0;
    }

    /**
     * @param hs 
     * @return
     */
    public abstract double chamDiemUngVien(HoSoUngVien hs);

}