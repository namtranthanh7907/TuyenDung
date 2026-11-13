package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class YC_KNghiem extends AYeuCauTuyenDung {

    /**
     * Default constructor
     */
    public YC_KNghiem() {
    }

    /**
     * 
     */
    private String linhVucYeuCau;

    /**
     * 
     */
    private int soNamToiThieu;

    public YC_KNghiem(String linhVucYeuCau, int soNamToiThieu) {
		super();
		this.linhVucYeuCau = linhVucYeuCau;
		this.soNamToiThieu = soNamToiThieu;
	}

	public String getLinhVucYeuCau() {
		return linhVucYeuCau;
	}

	public void setLinhVucYeuCau(String linhVucYeuCau) {
		this.linhVucYeuCau = linhVucYeuCau;
	}

	public int getSoNamToiThieu() {
		return soNamToiThieu;
	}

	public void setSoNamToiThieu(int soNamToiThieu) {
		this.soNamToiThieu = soNamToiThieu;
	}

	/**
     * @param hs 
     * @return
     */
    public boolean kiemTra(HoSoUngVien hs) {
        return hs != null && hs.laySoNamKinhNghiemTongHop(linhVucYeuCau) >= soNamToiThieu;
    }

    /**
     * @param hs 
     * @return
     */
    public double chamDiemUngVien(HoSoUngVien hs) {
        if(hs == null) {
        	return 0.0;
        }
        if(soNamToiThieu <= 0) {
        	return 1.0;
        }
        
        return Math.min(1.0, (double) hs.laySoNamKinhNghiemTongHop(linhVucYeuCau) / soNamToiThieu);
    }

}