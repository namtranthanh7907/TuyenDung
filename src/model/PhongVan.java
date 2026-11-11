package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class PhongVan {

    /**
     * Default constructor
     */
    public PhongVan() {
    }

    /**
     * 
     */
    private String idPV;

    /**
     * 
     */
    private HoSoUngVien hoSo;

    /**
     * 
     */
    private ViTriTuyenDung viTri;

    /**
     * 
     */
    private String ngayPhongVan;

    /**
     * 
     */
    private String gioPhongVan;

    /**
     * 
     */
    private String hinhThuc;

    /**
     * 
     */
    private String diaDiem;

    /**
     * 
     */
    private String nguoiPhongVan;

    /**
     * 
     */
    private String trangThaiPhongVan;

    /**
     * 
     */
    private double diemPhongVan;

    /**
     * 
     */
    public String nhanXet;

    /**
     * 
     */
    public String ketQuaVongPhongVan;







    public PhongVan(String idPV, HoSoUngVien hoSo, ViTriTuyenDung viTri, String ngayPhongVan, String gioPhongVan,
			String hinhThuc, String diaDiem, String nguoiPhongVan, String trangThaiPhongVan, double diemPhongVan,
			String nhanXet, String ketQuaVongPhongVan) {
		super();
		this.idPV = idPV;
		this.hoSo = hoSo;
		this.viTri = viTri;
		this.ngayPhongVan = ngayPhongVan;
		this.gioPhongVan = gioPhongVan;
		this.hinhThuc = hinhThuc;
		this.diaDiem = diaDiem;
		this.nguoiPhongVan = nguoiPhongVan;
		this.trangThaiPhongVan = trangThaiPhongVan;
		this.diemPhongVan = diemPhongVan;
		this.nhanXet = nhanXet;
		this.ketQuaVongPhongVan = ketQuaVongPhongVan;
	}

    
	public String getIdPV() {
		return idPV;
	}


	public void setIdPV(String idPV) {
		this.idPV = idPV;
	}


	public HoSoUngVien getHoSo() {
		return hoSo;
	}


	public void setHoSo(HoSoUngVien hoSo) {
		this.hoSo = hoSo;
	}


	public ViTriTuyenDung getViTri() {
		return viTri;
	}


	public void setViTri(ViTriTuyenDung viTri) {
		this.viTri = viTri;
	}


	public String getNgayPhongVan() {
		return ngayPhongVan;
	}


	public void setNgayPhongVan(String ngayPhongVan) {
		this.ngayPhongVan = ngayPhongVan;
	}


	public String getGioPhongVan() {
		return gioPhongVan;
	}


	public void setGioPhongVan(String gioPhongVan) {
		this.gioPhongVan = gioPhongVan;
	}


	public String getHinhThuc() {
		return hinhThuc;
	}


	public void setHinhThuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}


	public String getDiaDiem() {
		return diaDiem;
	}


	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}


	public String getNguoiPhongVan() {
		return nguoiPhongVan;
	}


	public void setNguoiPhongVan(String nguoiPhongVan) {
		this.nguoiPhongVan = nguoiPhongVan;
	}


	public String getTrangThaiPhongVan() {
		return trangThaiPhongVan;
	}


	public void setTrangThaiPhongVan(String trangThaiPhongVan) {
		this.trangThaiPhongVan = trangThaiPhongVan;
	}


	public double getDiemPhongVan() {
		return diemPhongVan;
	}


	public void setDiemPhongVan(double diemPhongVan) {
		this.diemPhongVan = diemPhongVan;
	}


	public String getNhanXet() {
		return nhanXet;
	}


	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}


	public String getKetQuaVongPhongVan() {
		return ketQuaVongPhongVan;
	}


	public void setKetQuaVongPhongVan(String ketQuaVongPhongVan) {
		this.ketQuaVongPhongVan = ketQuaVongPhongVan;
	}


	/**
     * 
     */
    public void Operation1() {
        // TODO implement here
    }

    /**
     * @param ngay 
     * @param gio 
     * @return
     */
    public boolean datLich(String ngay, String gio) {
        // TODO implement here
        return false;
    }

    /**
     * @param ngayMoi 
     * @param gioMoi 
     * @return
     */
    public boolean doiLich(String ngayMoi, String gioMoi) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean huyPhongVan() {
        // TODO implement here
        return false;
    }

    /**
     * @param diem 
     * @param nhanXet 
     * @return
     */
    public void chamDiem(double diem, String nhanXet) {
        // TODO implement here
    	
    }

    /**
     * @param diemChuan 
     * @return
     */
    public boolean kiemTraDat(double diemChuan) {
        // TODO implement here
        return false;
    }

    /**
     * @param ketQua 
     * @return
     */
    public void capNhatKetQua(String ketQua) {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public String layThongTinPhongVan() {
        // TODO implement here
        return "";
    }

}