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

    
    public YC_ChuyenNganh(String maYeuCau, int doUuTien, boolean batBuoc, String tenChuyenNghanh) {
		super(maYeuCau, doUuTien, batBuoc);
		this.tenChuyenNghanh = tenChuyenNghanh;
	}

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
    	return hs != null && TienIch.khop(hs.getChuyenNghanh(), tenChuyenNghanh);
    }

    /**
     * @param hs 
     * @return
     */
    public double chamDiemUngVien(HoSoUngVien hs) {
        return kiemTra(hs) ? 1.0 : 0.0;
    }

    
    public String toString() {
    	return "Yeu cau chuyen nganh: " + tenChuyenNghanh + " (" + super.toString() + ")";
    }
}