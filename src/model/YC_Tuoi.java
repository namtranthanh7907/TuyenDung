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