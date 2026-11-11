package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class YC_ChuyenNganh extends AYeuCauTuyenDung {

    /**
     * Default constructor
     */
    public YC_ChuyenNganh() {
    }

    /**
     * 
     */
    private String tenChuyenNghanh;

    
    public YC_ChuyenNganh(String tenChuyenNghanh) {
		super();
		this.tenChuyenNghanh = tenChuyenNghanh;
	}

	public String getTenChuyenNghanh() {
		return tenChuyenNghanh;
	}

	public void setTenChuyenNghanh(String tenChuyenNghanh) {
		this.tenChuyenNghanh = tenChuyenNghanh;
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