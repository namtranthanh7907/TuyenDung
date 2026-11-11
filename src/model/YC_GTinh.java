package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class YC_GTinh extends AYeuCauTuyenDung {

    /**
     * Default constructor
     */
    public YC_GTinh() {
    }

    /**
     * 
     */
    private String gioiTinh;

    public YC_GTinh(String gioiTinh) {
		super();
		this.gioiTinh = gioiTinh;
	}
    

	public String getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
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