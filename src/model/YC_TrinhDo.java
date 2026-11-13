package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class YC_TrinhDo extends AYeuCauTuyenDung {

	private static final String[] THANG = {"Trung cấp", "Cao đẳng", "Đại học", "Thạc sĩ", "Tiến sĩ"};
    /**
     * Default constructor
     */
    public YC_TrinhDo() {
    }

    /**
     * 
     */
    private String trinhDoYeuCau;

    public YC_TrinhDo(String trinhDoYeuCau) {
		super();
		this.trinhDoYeuCau = trinhDoYeuCau;
	}

	public String getTrinhDoYeuCau() {
		return trinhDoYeuCau;
	}

	public void setTrinhDoYeuCau(String trinhDoYeuCau) {
		this.trinhDoYeuCau = trinhDoYeuCau;
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
	
    public boolean kiemTra(HoSoUngVien hs) {
        if(hs == null) {
        	return false;
        }
        
        int bacHs = bac(hs.getTrinhDoHocVan());
        int bacYc = bac(trinhDoYeuCau);
        
        return bacHs >= 0 && bacYc >= 0 && bacHs >= bacYc;
    }

    /**
     * @param hs 
     * @return
     */
    public double chamDiemUngVien(HoSoUngVien hs) {
        return kiemTra(hs) ? 1.0 : 0.0;
    }

}