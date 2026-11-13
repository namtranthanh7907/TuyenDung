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
        return hs != null && TienIch.khop(hs.getGioiTinh(), gioiTinh);
    }

    /**
     * @param hs 
     * @return
     */
    public double chamDiemUngVien(HoSoUngVien hs) {
        return kiemTra(hs) ? 1.0 : 0.0;
    }

}