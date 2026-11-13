package model;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;

/**
 * 
 */
public class HoSoUngVien {

    /**
     * Default constructor
     */
    public HoSoUngVien() {
    	this("", "", "", "", "", "", "", "", "", "", 0.0, 0.0);
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
		this.linhVuc_KNghiem = (linhVuc_KNghiem == null) ? new HashMap<String, Integer>() : linhVuc_KNghiem;
		this.quaTrinhLamViec = (quaTrinhLamViec == null) ? new Stack<QuaTrinhLamViec>() : quaTrinhLamViec;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.bangCap = bangCap;
		this.chuyenNghanh = chuyenNghanh;
		this.chieuCao = chieuCao;
		this.dsNgoaiNgu = (dsNgoaiNgu == null) ? new HashMap<String, String>() : dsNgoaiNgu;
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
		this.linhVuc_KNghiem = (linhVuc_KNghiem == null) ? new HashMap<>() : linhVuc_KNghiem;
	}



	public Stack<QuaTrinhLamViec> getQuaTrinhLamViec() {
		return quaTrinhLamViec;
	}



	public void setQuaTrinhLamViec(Stack<QuaTrinhLamViec> quaTrinhLamViec) {
		this.quaTrinhLamViec = (quaTrinhLamViec == null) ? new Stack<>() : quaTrinhLamViec;
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
		this.dsNgoaiNgu = (dsNgoaiNgu == null) ? new HashMap<>() : dsNgoaiNgu;
	}



	public double getCanNang() {
		return canNang;
	}



	public void setCanNang(double canNang) {
		this.canNang = canNang;
	}



	/**
     * @return
    
     *
     */
	
	
    public int tinhTuoi() {
    	LocalDate sinh = TienIch.parseNgay(ngaySinh);
    	if(sinh == null || sinh.isAfter(LocalDate.now())) {
    		return -1;
    	}
    	
    	return Period.between(sinh, LocalDate.now()).getYears();
    }

    /**
     * @param linhvuc 
     * @param soNam 
     * @return
     */
    
    

    public String timKhoa(HashMap<String, ?> ds, String ten) {
    	if(ds == null || ten == null || ten.trim().isEmpty()) {
    		return null;
    	}
    	
    	for(String key : ds.keySet()) {
    		if(TienIch.khop(key, ten)) {
    			return key;
    		}
    	}
    	
    	return null;
    }
    public void themKinhNghiem(String linhVuc, int soNam) {
        if(linhVuc == null || linhVuc.trim().isEmpty() || soNam < 0) {
        	return;
        }
        
        if(linhVuc_KNghiem == null) {
        	linhVuc_KNghiem = new HashMap<String, Integer>();
        }
        
        String khoa = timKhoa(linhVuc_KNghiem, linhVuc);
        
        if(khoa == null) {
        	khoa = linhVuc.trim();
        }
        
        linhVuc_KNghiem.put(khoa, soNam);
        
    }
    
    /**
     * @param linhvuc 
     * @return
     */
    public int laySoNamKinhNghiem(String linhVuc) {
        if(linhVuc == null || linhVuc.trim().isEmpty() || linhVuc_KNghiem == null) {
        	return 0;
        }
        
        String khoa = timKhoa(linhVuc_KNghiem, linhVuc);
        if(khoa == null) {
        	return 0;
        }
        
        Integer soNam = linhVuc_KNghiem.get(khoa);
        
        return soNam == null || soNam < 0 ? 0 : soNam;
    }

    /**
     * @param ten 
     * @param trinhDo 
     * @return
     */
    public void themNgoaiNgu(String ten, String trinhDo) {
        if(ten == null || trinhDo == null || ten.trim().isEmpty() || trinhDo.trim().isEmpty()) {
        	return;
        }
        
        if(dsNgoaiNgu == null) {
        	dsNgoaiNgu = new HashMap<String, String>();
        }
        
        String khoa = timKhoa(dsNgoaiNgu, ten);
        if(khoa == null) {
        	khoa = ten.trim();
        }
        dsNgoaiNgu.put(khoa, trinhDo.trim());
        
    }
    
    public String layTrinhDoNgoaiNgu(String ten) {
    	if(ten == null || ten.trim().isEmpty() || dsNgoaiNgu == null) {
    		return null;
    	}
    	
    	String khoa = timKhoa(dsNgoaiNgu, ten);
    	
    	return khoa == null ? null : dsNgoaiNgu.get(khoa);
    }

    /**
     * @param qt 
     * @return
     */
    public void themQuaTrinhLamViec(QuaTrinhLamViec qt) {
        if(qt == null) {
        	return;
        }
        
        if(quaTrinhLamViec == null) {
        	quaTrinhLamViec = new Stack<QuaTrinhLamViec>();
        }
       
       quaTrinhLamViec.push(qt);
        
    }

    /**
     * @return
     */
    public QuaTrinhLamViec layQuaTrinhLamViec() {
        if(quaTrinhLamViec == null || quaTrinhLamViec.isEmpty()) {
        	return null;
        }
        
        return quaTrinhLamViec.peek();
    }

    /**
     * @param yc 
     * @return
     */
    public boolean kiemTraYeuCau(AYeuCauTuyenDung yc) {
        return yc != null && yc.kiemTra(this);
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
    
    public int tinhSoThangLamViec(String linhVuc) {
    	return ThongKeKinhNghiem.tinhSoThang(this, linhVuc);
    }
    
    public int laySoNamKinhNghiemTongHop(String linhVuc) {
    	return Math.max(laySoNamKinhNghiem(linhVuc), tinhSoThangLamViec(linhVuc) / 12);
    }
    
    public String tomTatKinhNghiem(String linhVuc) {
    	int thang = tinhSoThangLamViec(linhVuc);
        if(thang == 0) {
            return hoTen + ": chưa có kinh nghiệm trong lĩnh vực " + linhVuc;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(hoTen).append(": ");
        if(thang >= 12) {
            sb.append(thang / 12).append(" năm ");
        }
        if(thang % 12 > 0) {
            sb.append(thang % 12).append(" tháng ");
        }
        sb.append("trong lĩnh vực ").append(linhVuc).append(". Chức vụ: ");
        String dau = "";
        for(QuaTrinhLamViec qt : ThongKeKinhNghiem.layQuaTrinhTheoLinhVuc(this, linhVuc)) {
            sb.append(dau).append(qt.getViTri());
            dau = ", ";
        }
        return sb.toString();
    }
    
    public String tomTatLinhVuc() {
    	if(quaTrinhLamViec == null || quaTrinhLamViec.isEmpty()) {
    		return "Chua co kinh nghiem";
    	}
    	
    	LinkedHashMap<String, String> dsLinhVuc = new LinkedHashMap<>();
    	
    	for(QuaTrinhLamViec qt : quaTrinhLamViec) {
    		if(qt == null) {
    			continue;
    		}
    		
    		String lv = qt.getLinhVuc();
    		
    		if(lv == null || lv.trim().isEmpty()) {
    			continue;
    		}
    		
    		lv = lv.trim();
    		
    		String khoa = TienIch.chuanHoa(lv);
    		
    		if(!khoa.isEmpty()) {
    			dsLinhVuc.putIfAbsent(khoa, lv);
    		}
    	}
    	
    	if(dsLinhVuc.isEmpty()) {
    		return "Chua co linh vuc kinh nghiem hop le";
    	}
    	
    	return String.join(", ", dsLinhVuc.values());
    }
    
    public String toString() {
    	return maHS + ", " + hoTen + ", " + ngaySinh + ", " + gioiTinh + ", "
    			+ trinhDoHocVan + ", " + bangCap + ", " + chuyenNghanh;
    }
    
    public static void main(String[] args) {
        HoSoUngVien a = new HoSoUngVien("HS01", "Trần Thành Nam", "7/9/1995", "Hà Nội", "Nam",
                "Đại học", "nam@gmail.com", "0987654321", "Cử nhân", "Marketing", 1.75, 68.0);

        a.themQuaTrinhLamViec(new QuaTrinhLamViec("1/1/2020", "31/12/2021", "Nhân viên MKT", "ABC", "0900000000", "", "", "Marketing"));
        a.themQuaTrinhLamViec(new QuaTrinhLamViec("1/1/2022", "1/7/2023", "Trưởng nhóm MKT", "ABC", "0900000000", "", "", "Marketing"));
        a.themQuaTrinhLamViec(new QuaTrinhLamViec("1/1/2023", "31/12/2023", "Lập trình viên", "XYZ", "0900000000", "", "", "IT"));
        a.themNgoaiNgu("Tiếng Anh", "B2");

        System.out.println(a.tomTatKinhNghiem("marketing"));
        System.out.println("Số tháng Marketing: " + a.tinhSoThangLamViec("Marketing"));
        System.out.println("Số năm tổng hợp: " + a.laySoNamKinhNghiemTongHop("Marketing"));
        System.out.println("Các lĩnh vực: " + a.tomTatLinhVuc());
        System.out.println("Công việc gần nhất: " + a.layQuaTrinhLamViec());
        System.out.println("Tổng tháng mọi lĩnh vực: " + ThongKeKinhNghiem.tinhTongSoThang(a));
        System.out.println("Đạt yêu cầu 3 năm Marketing: " + a.kiemTraYeuCau(new YC_KNghiem("Marketing", 3)));
        System.out.println("Đạt yêu cầu tiếng Anh C1: " + a.kiemTraYeuCau(new YC_NgoaiNgu("Tiếng Anh", "C1")));
        System.out.println("Đạt yêu cầu null: " + a.kiemTraYeuCau(null));
    }

}