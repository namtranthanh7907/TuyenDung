package model;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class HoSoUngVien {

    /**
     * Default constructor
     */
    public HoSoUngVien() {
    }

    /**
     * 
     */
    private String maHS;

    /**
     * 
     */
    private String hoTen;

    /**
     * 
     */
    private String ngaySinh;

    /**
     * 
     */
    private String diaChiThuongTru;

    /**
     * 
     */
    private String gioiTinh;

    /**
     * 
     */
    private String trinhDoHocVan;

    /**
     * 
     */
    private HashMap<String, Integer> linhVuc_KNghiem;

    /**
     * 
     */
    private Stack<QuaTrinhLamViec> quaTrinhLamViec;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String soDienThoai;

    /**
     * 
     */
    private String bangCap;

    /**
     * 
     */
    private String chuyenNghanh;

    /**
     * 
     */
    private double chieuCao;

    /**
     * 
     */
    private HashMap<String, String> dsNgoaiNgu;

    /**
     * 
     */
    private double canNang;





    public HoSoUngVien(String maHS, String hoTen, String ngaySinh, String diaChiThuongTru, String gioiTinh,
			String trinhDoHocVan, HashMap<String, Integer> linhVuc_KNghiem, Stack<QuaTrinhLamViec> quaTrinhLamViec,
			String email, String soDienThoai, String bangCap, String chuyenNghanh, double chieuCao,
			HashMap<String, String> dsNgoaiNgu, double canNang) {
		super();
		this.maHS = maHS;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChiThuongTru = diaChiThuongTru;
		this.gioiTinh = gioiTinh;
		this.trinhDoHocVan = trinhDoHocVan;
		this.linhVuc_KNghiem = linhVuc_KNghiem;
		this.quaTrinhLamViec = quaTrinhLamViec;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.bangCap = bangCap;
		this.chuyenNghanh = chuyenNghanh;
		this.chieuCao = chieuCao;
		this.dsNgoaiNgu = dsNgoaiNgu;
		this.canNang = canNang;
	}

    
    
	public HoSoUngVien(String maHS, String hoTen, String ngaySinh, String diaChiThuongTru, String gioiTinh,
			String trinhDoHocVan, String email, String soDienThoai, String bangCap
			, String chuyenNghanh, double chieuCao, double canNang) {
		super();
		this.maHS = maHS;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChiThuongTru = diaChiThuongTru;
		this.gioiTinh = gioiTinh;
		this.trinhDoHocVan = trinhDoHocVan;
		this.linhVuc_KNghiem = new HashMap<String, Integer>();
		this.quaTrinhLamViec = new Stack<QuaTrinhLamViec>();
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.bangCap = bangCap;
		this.chuyenNghanh = chuyenNghanh;
		this.chieuCao = chieuCao;
		this.dsNgoaiNgu = new HashMap<String, String>();
		this.canNang = canNang;
	}



	public String getMaHS() {
		return maHS;
	}



	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}



	public String getHoTen() {
		return hoTen;
	}



	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}



	public String getNgaySinh() {
		return ngaySinh;
	}



	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}



	public String getDiaChiThuongTru() {
		return diaChiThuongTru;
	}



	public void setDiaChiThuongTru(String diaChiThuongTru) {
		this.diaChiThuongTru = diaChiThuongTru;
	}



	public String getGioiTinh() {
		return gioiTinh;
	}



	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}



	public String getTrinhDoHocVan() {
		return trinhDoHocVan;
	}



	public void setTrinhDoHocVan(String trinhDoHocVan) {
		this.trinhDoHocVan = trinhDoHocVan;
	}



	public HashMap<String, Integer> getLinhVuc_KNghiem() {
		return linhVuc_KNghiem;
	}



	public void setLinhVuc_KNghiem(HashMap<String, Integer> linhVuc_KNghiem) {
		this.linhVuc_KNghiem = linhVuc_KNghiem;
	}



	public Stack<QuaTrinhLamViec> getQuaTrinhLamViec() {
		return quaTrinhLamViec;
	}



	public void setQuaTrinhLamViec(Stack<QuaTrinhLamViec> quaTrinhLamViec) {
		this.quaTrinhLamViec = quaTrinhLamViec;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSoDienThoai() {
		return soDienThoai;
	}



	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}



	public String getBangCap() {
		return bangCap;
	}



	public void setBangCap(String bangCap) {
		this.bangCap = bangCap;
	}



	public String getChuyenNghanh() {
		return chuyenNghanh;
	}



	public void setChuyenNghanh(String chuyenNghanh) {
		this.chuyenNghanh = chuyenNghanh;
	}



	public double getChieuCao() {
		return chieuCao;
	}



	public void setChieuCao(double chieuCao) {
		this.chieuCao = chieuCao;
	}



	public HashMap<String, String> getDsNgoaiNgu() {
		return dsNgoaiNgu;
	}



	public void setDsNgoaiNgu(HashMap<String, String> dsNgoaiNgu) {
		this.dsNgoaiNgu = dsNgoaiNgu;
	}



	public double getCanNang() {
		return canNang;
	}



	public void setCanNang(double canNang) {
		this.canNang = canNang;
	}



	/**
     * @return
     */
    public int tinhTuoi() {
    	int namSinh = Integer.parseInt(ngaySinh.substring(ngaySinh.length() - 4));
    	int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
       return namHienTai - namSinh;
    }

    /**
     * @param linhvuc 
     * @param soNam 
     * @return
     */
    public void themKinhNghiem(String linhVuc, int soNam) {
        if(linhVuc == null || soNam < 0) {
        	return;
        }
        
        linhVuc_KNghiem.put(linhVuc, soNam);
        
    }

    /**
     * @param linhvuc 
     * @return
     */
    public int laySoNamKinhNghiem(String linhVuc) {
        if(linhVuc == null) {
        	return 0;
        }
        
        Integer soNam = linhVuc_KNghiem.get(linhVuc);
        
        if(soNam == null) {
        	return 0;
        } else {
        	return soNam;
        }
    }

    /**
     * @param ten 
     * @param trinhDo 
     * @return
     */
    public void themNgoaiNgu(String ten, String trinhDo) {
        if(ten == null || trinhDo == null) {
        	return;
        }
        dsNgoaiNgu.put(ten, trinhDo);
        
    }

    /**
     * @param qt 
     * @return
     */
    public void themQuaTrinhLamViec(QuaTrinhLamViec qt) {
        if(qt == null) {
        	return;
        }
       
       quaTrinhLamViec.push(qt);
        
    }

    /**
     * @return
     */
    public QuaTrinhLamViec layQuaTrinhLamViec() {
        if(quaTrinhLamViec.isEmpty()) {
        	return null;
        }
        
        return quaTrinhLamViec.peek();
    }

    /**
     * @param yc 
     * @return
     */
    public boolean kiemTraYeuCau(AYeuCauTuyenDung yc) {
        if(yc == null) {
        	return false;
        }
        
        return yc.kiemTra(this);
    }

    /**
     * @param obj 
     * @return
     */
    @Override
    public boolean equals(Object obj) {
    	if(this == obj) {
    		return true;
    	}
    	
    	if(obj == null || getClass() != obj.getClass()) {
    		return false;
    	}
    	
    	HoSoUngVien hs = (HoSoUngVien) obj;
    
        return maHS != null && maHS.equals(hs.getMaHS());
    }
    

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return maHS == null ? 0 : maHS.hashCode();
    }

    /**
     * @param diaChi 
     * @return
     */
    public void capNhatDiaChi(String diaChi) {
        if(diaChi == null) {
        	return;
        }
        
        this.diaChiThuongTru = diaChi;
        
    }
    
    public static void main(String[] args) {
		
	}

}