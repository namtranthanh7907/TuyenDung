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
		if (soNamToiThieu < 0) {
	        throw new IllegalArgumentException(
	            "So nam kinh nghiem khong duoc am"
	        );
	    }
		
		this.linhVucYeuCau = linhVucYeuCau;
		this.soNamToiThieu = soNamToiThieu;
	}

	public String getLinhVucYeuCau() {
		return linhVucYeuCau;
	}
	
	

	public YC_KNghiem(String maYeuCau, int doUuTien, boolean batBuoc, String linhVucYeuCau, int soNamToiThieu) {
		super(maYeuCau, doUuTien, batBuoc);
		if (soNamToiThieu < 0) {
	        throw new IllegalArgumentException(
	            "So nam kinh nghiem khong duoc am"
	        );
	    }
		this.linhVucYeuCau = linhVucYeuCau;
		this.soNamToiThieu = soNamToiThieu;
	}

	public void setLinhVucYeuCau(String linhVucYeuCau) {
		this.linhVucYeuCau = linhVucYeuCau;
	}

	public int getSoNamToiThieu() {
		return soNamToiThieu;
	}

	public void setSoNamToiThieu(int soNamToiThieu) {
		
		if (soNamToiThieu < 0) {
	        throw new IllegalArgumentException(
	            "So nam kinh nghiem khong duoc am"
	        );
	    }
		
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
    
    public String toStirng() {
    	return "Yeu cau linh vuc: linh vuc " + linhVucYeuCau + ", toi thieu "
    			+ soNamToiThieu + " nam (" + super.toString() + ")";
    }

}