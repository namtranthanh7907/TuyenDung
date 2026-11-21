package model;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * 
 */
public class PhongVan {
	
	
	public static final String TT_CHUA = "Chua phong van";
	public static final String TT_DA ="Da phong van";
	public static final String TT_HUY = "Da huy";
	
	
	public static final String KQ_DAT ="Dat";
	public static final String KQ_KHONG_DAT = "Khong dat";
	
	
	

    /**
     * Default constructor
     */
    public PhongVan() {
    	this.trangThaiPhongVan = TT_CHUA;
    	this.nhanXet = "";
    	this.ketQuaVongPhongVan = "";
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
    private String nhanXet;

    /**
     * 
     */
    private String ketQuaVongPhongVan;


    private int vong = 1;

    


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
		this.trangThaiPhongVan = (trangThaiPhongVan == null) ? TT_CHUA : trangThaiPhongVan;
		this.diemPhongVan = diemPhongVan;
		this.nhanXet = (nhanXet == null) ? "" : nhanXet;
		this.ketQuaVongPhongVan = (ketQuaVongPhongVan == null) ? "" : ketQuaVongPhongVan;
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

	
	
	

	public int getVong() {
		return vong;
	}
	
	public void setVong(int vong) {
		if(vong >= 1) {
			this.vong = vong;
		}
	}

	
	


	private static LocalTime chuyenGio(String gio) {
		if(gio == null || gio.trim().isEmpty()) {
			return null;
		}
		try {
			return LocalTime.parse(gio.trim(),
				DateTimeFormatter.ofPattern("H:mm"));
		} catch(DateTimeParseException e) {
			return null;
		}
	}
	
	private static String kiemTraNull(String s) {
		return s == null ? "" : s;
	}
	
	
	
	

    /**
     * @param ngay 
     * @param gio 
     * @return
     */
    public boolean datLich(String ngay, String gio) {
        if(TT_DA.equals(trangThaiPhongVan) || TT_HUY.equals(trangThaiPhongVan)) {
        	return false;
        }
        
        LocalDate ngayPV = TienIch.parseNgay(ngay);
        
        if(ngayPV == null || ngayPV.isBefore(LocalDate.now()) || chuyenGio(gio) == null) {
        	return false;
        }
        
        
        this.ngayPhongVan = ngayPV.format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        this.gioPhongVan = gio.trim();
        this.trangThaiPhongVan = TT_CHUA;
        return true;
    }

    


	/**
     * @param ngayMoi 
     * @param gioMoi 
     * @return
     */
    public boolean doiLich(String ngayMoi, String gioMoi) {
        return datLich(ngayMoi, gioMoi);
    }

    /**
     * @return
     */
    public boolean huyPhongVan() {
    	if(TT_DA.equals(trangThaiPhongVan) || TT_HUY.equals(trangThaiPhongVan)) {
        	return false;
        }
        
        this.trangThaiPhongVan = TT_HUY;
        return true;
    }

    /**
     * @param diem 
     * @param nhanXet 
     * @return
     */
    public boolean  chamDiem(double diem, String nhanXet) {
        if(Double.isNaN(diem) || diem < 0 || diem > 10) {
        	return false;
        }
        
        if (!TT_CHUA.equals(trangThaiPhongVan)) {
            return false;
        }
        
        if (TienIch.parseNgay(ngayPhongVan) == null
                || chuyenGio(gioPhongVan) == null) {
            return false;
        }
        
        this.diemPhongVan = diem;
        this.nhanXet = (nhanXet == null) ? "" : nhanXet;
        this.trangThaiPhongVan = TT_DA;
        
        return true;
    	
    }

    /**
     * @param diemChuan 
     * @return
     */
    public boolean kiemTraDat(double diemChuan) {
    	return TT_DA.equals(trangThaiPhongVan) && diemPhongVan >= diemChuan;
    }

    /**
     * @param ketQua 
     * @return
     */
    public boolean capNhatKetQua(String ketQua) {
    	if(!TT_DA.equals(trangThaiPhongVan)) {
    		return false;
    	}
    	
    	if(!KQ_DAT.equals(ketQua) && !KQ_KHONG_DAT.equals(ketQua)) {
    		return false;
    	}
    	
    	if(ketQuaVongPhongVan != null && !ketQuaVongPhongVan.trim().isEmpty()) {
    		return false;
    	}
    	
        this.ketQuaVongPhongVan = ketQua;
        return true;
    }

    /**
     * @return
     */
    public String layThongTinPhongVan() {
        String ten = (hoSo == null) ? "" : kiemTraNull(hoSo.getHoTen());
        
        return kiemTraNull(idPV) + " | Vong " + vong + " | " + ten
        		+ " | " + kiemTraNull(ngayPhongVan) + " " + kiemTraNull(gioPhongVan)
        		+ " | " + kiemTraNull(hinhThuc) + " - " + kiemTraNull(diaDiem)
        		+ " | Nguoi PV: " + kiemTraNull(nguoiPhongVan)
        		+ " | " + kiemTraNull(trangThaiPhongVan)
        		+ " | Diem: " + String.format(Locale.ROOT, "%.2f", diemPhongVan)
        		+ " | KQ: " + kiemTraNull(ketQuaVongPhongVan);
    }
    
    public String toString() {
    	return layThongTinPhongVan();
    }

}