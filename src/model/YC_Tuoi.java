package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class YC_Tuoi extends AYeuCauTuyenDung {

    /**
     * Default constructor
     */
    public YC_Tuoi() {
    }

    /**
     * 
     */
    private int minTuoi;

    /**
     * 
     */
    private int maxTuoi;

    public YC_Tuoi(int minTuoi, int maxTuoi) {
		super();
		this.minTuoi = minTuoi;
		this.maxTuoi = maxTuoi;
	}

	public int getMinTuoi() {
		return minTuoi;
	}

	public void setMinTuoi(int minTuoi) {
		this.minTuoi = minTuoi;
	}

	public int getMaxTuoi() {
		return maxTuoi;
	}

	public void setMaxTuoi(int maxTuoi) {
		this.maxTuoi = maxTuoi;
	}

	/**
     * @param hs 
     * @return
     */
    public boolean kiemTra(HoSoUngVien hs) {
        if(hs == null){
        	return false;
        }
        
        int tuoi = hs.tinhTuoi();
        return tuoi >= 0 && tuoi >= minTuoi && tuoi <= maxTuoi;
    }

    /**
     * @param hs 
     * @return
     */
    public double chamDiemUngVien(HoSoUngVien hs) {
    	return kiemTra(hs) ? 1.0 : 0;
    }

}