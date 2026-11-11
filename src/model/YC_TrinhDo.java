package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class YC_TrinhDo extends AYeuCauTuyenDung {

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