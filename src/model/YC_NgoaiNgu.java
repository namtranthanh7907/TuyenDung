package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class YC_NgoaiNgu extends AYeuCauTuyenDung {

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