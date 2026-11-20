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
		
    	if (minTuoi < 0 || maxTuoi < minTuoi) {
            throw new IllegalArgumentException(
                "Khoang tuoi khong hop le"
            );
        }
    	
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
        if(hs == null || minTuoi < 0 || maxTuoi < minTuoi){
        	return false;
        }
        
        int tuoi = hs.tinhTuoi();
        return tuoi >= minTuoi && tuoi <= maxTuoi;
    }

    /**
     * @param hs 
     * @return
     */
    public double chamDiemUngVien(HoSoUngVien hs) {
    	return kiemTra(hs) ? 1.0 : 0;
    }

}