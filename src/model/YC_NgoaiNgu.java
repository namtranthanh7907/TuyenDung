package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class YC_NgoaiNgu extends AYeuCauTuyenDung {

	private static final String[] THANG = {"A1", "A2", "B1", "B2", "C1", "C2"};
    /**
     * Default constructor
     */
    public YC_NgoaiNgu() {
    }

    /**
     * 
     */
    private String tenNgoaiNgu;

    /**
     * 
     */
    private String trinhDoToiThieu;

    public YC_NgoaiNgu(String tenNgoaiNgu, String trinhDoToiThieu) {
		super();
		this.tenNgoaiNgu = tenNgoaiNgu;
		this.trinhDoToiThieu = trinhDoToiThieu;
	}

    
    
	public YC_NgoaiNgu(String maYeuCau, int doUuTien, boolean batBuoc, String tenNgoaiNgu, String trinhDoToiThieu) {
		super(maYeuCau, doUuTien, batBuoc);
		this.tenNgoaiNgu = tenNgoaiNgu;
		this.trinhDoToiThieu = trinhDoToiThieu;
	}



	public String getTenNgoaiNgu() {
		return tenNgoaiNgu;
	}

	public void setTenNgoaiNgu(String tenNgoaiNgu) {
		this.tenNgoaiNgu = tenNgoaiNgu;
	}

	public String getTrinhDoToiThieu() {
		return trinhDoToiThieu;
	}

	public void setTrinhDoToiThieu(String trinhDoToiThieu) {
		this.trinhDoToiThieu = trinhDoToiThieu;
	}

	/**
     * @param hs 
     * @return
     */
	
	private static int bac(String td) {
		for(int i = 0; i < THANG.length; i++) {
			if(TienIch.khop(THANG[i], td)) {
				return i;
			}
		}
		
		return -1;
	}
	
	private int bacUngVien(HoSoUngVien hs) {
		if(hs == null) {
			return -1;
		}
		
		return bac(hs.layTrinhDoNgoaiNgu(tenNgoaiNgu));
	}
	
	
	
    public boolean kiemTra(HoSoUngVien hs) {
        int yc = bac(trinhDoToiThieu);
        return yc >= 0 && bacUngVien(hs) >= yc;
    }

    /**
     * @param hs 
     * @return
     */
    public double chamDiemUngVien(HoSoUngVien hs) {
        int yc = bac(trinhDoToiThieu);
        int uv = bacUngVien(hs);
        
        if(yc < 0 || uv < 0) {
        	return 0.0;
        }
        
        if(uv > yc) {
        	return 1.0;
        }
        return (uv + 1.0) / (yc + 1.0);
    }
    
    public String toString() {
    	return "Yeu cau ngoai ngu: " + tenNgoaiNgu + " tu " + trinhDoToiThieu
    				+ " tro len (" + super.toString() + ")";
    }

}