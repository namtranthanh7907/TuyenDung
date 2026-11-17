package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class ViTriTuyenDung {

    /**
     * Default constructor
     */
    public ViTriTuyenDung() {
    }

    /**
     * 
     */
    private String tenViTri;

    /**
     * 
     */
    private String noiLamViec;

    /**
     * 
     */
    private int soLuong;

    /**
     * 
     */
    private int maxLuong;

    /**
     * 
     */
    private int minLuong;

    /**
     * 
     */
    private HashSet<HoSoUngVien> dsHoSoUngVien;

    /**
     * 
     */
    private PriorityQueue<AYeuCauTuyenDung> dsYeuCauTuyenDung;

    /**
     * 
     */
    private String maViTri;

    /**
     * 
     */
    private String moTaCongViec;

    /**
     * 
     */
    private ArrayList<KetQuaUngTuyen> dsKetQua;

    /**
     * 
     */
    private ArrayList<PhongVan> dsPhongVan;










    public ViTriTuyenDung(String tenViTri, String noiLamViec, int soLuong, int maxLuong, int minLuong,
			HashSet<HoSoUngVien> dsHoSoUngVien, PriorityQueue<AYeuCauTuyenDung> dsYeuCauTuyenDung, String maViTri,
			String moTaCongViec, ArrayList<KetQuaUngTuyen> dsKetQua, ArrayList<PhongVan> dsPhongVan) {
		super();
		this.tenViTri = tenViTri;
		this.noiLamViec = noiLamViec;
		this.soLuong = soLuong;
		this.maxLuong = maxLuong;
		this.minLuong = minLuong;
		this.dsHoSoUngVien = (dsHoSoUngVien == null) ? new HashSet<>() : dsHoSoUngVien;
		this.dsYeuCauTuyenDung = new PriorityQueue<>(new Comparator<AYeuCauTuyenDung>() {
		    @Override
		    public int compare(AYeuCauTuyenDung o1, AYeuCauTuyenDung o2) {
		        return Integer.compare(o2.getDoUuTien(), o1.getDoUuTien());
		    }
		});
		if(dsYeuCauTuyenDung != null) {
		    this.dsYeuCauTuyenDung.addAll(dsYeuCauTuyenDung);
		}
		
		this.maViTri = maViTri;
		this.moTaCongViec = moTaCongViec;
		this.dsKetQua = (dsKetQua == null) ? new ArrayList<>() : dsKetQua;
		this.dsPhongVan = (dsPhongVan == null) ? new ArrayList<>() : dsPhongVan;
	}
    
    

    
	public ViTriTuyenDung(String tenViTri, String noiLamViec, int soLuong, int maxLuong, int minLuong
			, String maViTri, String moTaCongViec) {
		super();
		this.tenViTri = tenViTri;
		this.noiLamViec = noiLamViec;
		this.soLuong = soLuong;
		this.maxLuong = maxLuong;
		this.minLuong = minLuong;
		this.dsHoSoUngVien = new HashSet<>();
		this.dsYeuCauTuyenDung = new PriorityQueue<>(new Comparator<AYeuCauTuyenDung>() {
		    @Override
		    public int compare(AYeuCauTuyenDung o1, AYeuCauTuyenDung o2) {
		        return Integer.compare(o2.getDoUuTien(), o1.getDoUuTien());
		    }
		});
		this.maViTri = maViTri;
		this.moTaCongViec = moTaCongViec;
		this.dsKetQua = new ArrayList<>();
		this.dsPhongVan = new ArrayList<>();
	}




	public String getTenViTri() {
		return tenViTri;
	}


	public void setTenViTri(String tenViTri) {
		this.tenViTri = tenViTri;
	}


	public String getNoiLamViec() {
		return noiLamViec;
	}


	public void setNoiLamViec(String noiLamViec) {
		this.noiLamViec = noiLamViec;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public int getMaxLuong() {
		return maxLuong;
	}


	public void setMaxLuong(int maxLuong) {
		this.maxLuong = maxLuong;
	}


	public int getMinLuong() {
		return minLuong;
	}


	public void setMinLuong(int minLuong) {
		this.minLuong = minLuong;
	}


	public HashSet<HoSoUngVien> getDsHoSoUngVien() {
		return dsHoSoUngVien;
	}


	public void setDsHoSoUngVien(HashSet<HoSoUngVien> dsHoSoUngVien) {
		this.dsHoSoUngVien = dsHoSoUngVien;
	}


	public PriorityQueue<AYeuCauTuyenDung> getDsYeuCauTuyenDung() {
		return dsYeuCauTuyenDung;
	}


	public void setDsYeuCauTuyenDung(PriorityQueue<AYeuCauTuyenDung> dsYeuCauTuyenDung) {
		this.dsYeuCauTuyenDung = dsYeuCauTuyenDung;
	}


	public String getMaViTri() {
		return maViTri;
	}


	public void setMaViTri(String maViTri) {
		this.maViTri = maViTri;
	}


	public String getMoTaCongViec() {
		return moTaCongViec;
	}


	public void setMoTaCongViec(String moTaCongViec) {
		this.moTaCongViec = moTaCongViec;
	}


	public ArrayList<KetQuaUngTuyen> getDsKetQua() {
		return dsKetQua;
	}


	public void setDsKetQua(ArrayList<KetQuaUngTuyen> dsKetQua) {
		this.dsKetQua = dsKetQua;
	}


	public ArrayList<PhongVan> getDsPhongVan() {
		return dsPhongVan;
	}


	public void setDsPhongVan(ArrayList<PhongVan> dsPhongVan) {
		this.dsPhongVan = dsPhongVan;
	}


	/**
     * @param yc 
     * @return
     */
    public boolean themYeuCau(AYeuCauTuyenDung yc) {
        if(yc == null) {
        	return false;
        }
        
        dsYeuCauTuyenDung.offer(yc);
        return true;
    }

    /**
     * @param yc 
     * @return
     */
    public boolean xoaYeuCau(AYeuCauTuyenDung yc) {
        if(yc == null) {
        	return false;
        }
        
        return dsYeuCauTuyenDung.remove(yc);
    }

    /**
     * @param hs 
     * @return
     */
    public boolean nopHoSo(HoSoUngVien hs) {
        if(hs == null) {
        	return false;
        }
        
        
        if(timHoSo(hs.getMaHS()) != null) {
        	return false;
        }
        
        if(!kiemTraYeuCau(hs)) {
        	return false;
        }
        
        return dsHoSoUngVien.add(hs);
    }

    /**
     * @param maHoSo 
     * @return
     */
    public boolean xoaHoSo(String maHoSo) {
        if(maHoSo == null) {
        	return false;
        }
        
        HoSoUngVien hs = timHoSo(maHoSo);
        return dsHoSoUngVien.remove(hs);
        
        
    }

    /**
     * @param maHoSo 
     * @return
     */
    public HoSoUngVien timHoSo(String maHoSo) {
        if(maHoSo == null) {
        	return null;
        }
        
        for(HoSoUngVien hs : dsHoSoUngVien) {
        	if(hs.getMaHS().equals(maHoSo)) {
        		return hs;
        	}
        }
        return null;
    }

    /**
     * @param hs 
     * @return
     */
    public boolean kiemTraYeuCau(HoSoUngVien hs) {
        if(hs == null) {
        	return false;
        }
        
        for(AYeuCauTuyenDung yc : dsYeuCauTuyenDung) {
        	if(yc.isBatBuoc() && !yc.kiemTra(hs)) {
        		return false;
        	}
        }
        
        return true;
    }

    /**
     * @return
     */
    public ArrayList<HoSoUngVien> locHoSoPhuHop() {
        ArrayList<HoSoUngVien> res = new ArrayList<>();
        
        for(HoSoUngVien hs : dsHoSoUngVien) {
        	if(kiemTraYeuCau(hs)) {
        		res.add(hs);
        	}
        }
        return res;
    }

    /**
     * @return
     */
    public int demSoLuongUngVien() {
        return dsHoSoUngVien.size();
    }

    /**
     * @return
     */
    public boolean kiemTraConChiTieu() {
    	return demSoTrungTuyen() < soLuong;
    }

    /**
     * @param hs 
     * @return
     */
    public double tinhTongDiem(HoSoUngVien hs) {
        if(hs == null) {
        	return 0;
        }
        
        double res = 0;
        
        for(AYeuCauTuyenDung yc : dsYeuCauTuyenDung) {
        	res += yc.chamDiemUngVien(hs) * yc.getDoUuTien();
        }
        
        return res;
    }

    /**
     * @param pv 
     * @return
     */
    public boolean themPhongVan(PhongVan pv) {
        if(pv == null) {
        	return false;
        }
        
        if(timPhongVan(pv.getIdPV()) != null) {
        	return false;
        }
        
        return dsPhongVan.add(pv);
    }

    /**
     * @param maPV 
     * @return
     */
    public boolean xoaPhongVan(String maPV) {
        if(maPV == null) {
        	return false;
        }
        
        for(int i = 0; i < dsPhongVan.size(); i++) {
        	PhongVan pv = dsPhongVan.get(i);
        	if(pv != null && pv.getIdPV().equals(maPV)) {
        		dsPhongVan.remove(i);
        		return true;
        	}
        }
        return false;
    }

    /**
     * @param maPV 
     * @return
     */
    public PhongVan timPhongVan(String maPV) {
        if(maPV == null) {
        	return null;
        }
        
        for(PhongVan pv : dsPhongVan) {
        	if(maPV.equals(pv.getIdPV())) {
        		return pv;
        	}
        }
        return null;
    }

    /**
     * @return
     */
    public ArrayList<PhongVan> layDanhSachPhongVan() {
        return new ArrayList<>(dsPhongVan);
    }

    
    public String toString() {
    	String res = "";
    	
    	res += "Ten vi tri: " + tenViTri + ", Noi lam viec: " + noiLamViec
    			+ ", So luong: " + soLuong + ", Max luong: " + maxLuong + ", Min luong: " + minLuong
    			+ ", Ma vi tri: " + maViTri + ", Mo ta cong viec: " + moTaCongViec
    			+ "\nDanh sach ho so ung vien:\n";
    	
    	if(dsHoSoUngVien == null || dsHoSoUngVien.isEmpty()) {
    		res += " Chua co Ho so ung vien!\n";
    	} else {
    		for(HoSoUngVien hs : dsHoSoUngVien) {
    			if(hs != null) {
    				res += " " + hs.toString() + "\n";
    			}
    		}
    	}
    	
    	res += "Danh sach yeu cau tuyen dung:\n";
    	
    	if(dsYeuCauTuyenDung == null || dsYeuCauTuyenDung.isEmpty()) {
    		res += " Chua co yeu cau tuyen dung!\n";
    	} else {
    		for(AYeuCauTuyenDung yc : dsYeuCauTuyenDung) {
    			if(yc != null) {
    				res += " " + yc.toString() + "\n";
    			}
    		}
    	}
    	
    	res += "Danh sach ket qua ung tuyen:\n";
    	
    	if(dsKetQua == null || dsKetQua.isEmpty()) {
    		res += " Chua co ket qua ung tuyen!\n";
    	} else {
    		for(KetQuaUngTuyen kq : dsKetQua) {
    			if(kq != null) {
    				res += " " + kq.toString() + "\n";
    			}
    		}
    	}
    	
    	res += "Danh sach phong van:\n";
    	
    	if(dsPhongVan == null || dsPhongVan.isEmpty()) {
    		res += " Chua co phong van!\n";
    	} else {
    		for(PhongVan pv : dsPhongVan) {
    			if(pv != null) {
    				res += " " + pv.toString() + "\n";
    			}
    		}
    	}
    	
    	return res;
    }
    
    public static void main(String[] args) {
    	HoSoUngVien hs1 = new HoSoUngVien(
                "HS01", "Trần Thành Nam", "7/9/2007", "Hà Nội", "Nam",
                "Đại học", "nam.tran@gmail.com", "0987654321", "Cử nhân",
                "Công nghệ thông tin", 1.75, 68.0);
    	
    	hs1.themKinhNghiem("Marketing", 2);

        hs1.themQuaTrinhLamViec(new QuaTrinhLamViec(
                "1/1/2020", "31/12/2021", "Nhân viên MKT",
                "ABC", "0900000000", "", "", "Marketing"));

        hs1.themQuaTrinhLamViec(new QuaTrinhLamViec(
                "1/1/2022", "1/7/2023", "Trưởng nhóm MKT",
                "ABC", "0900000000", "", "", "Marketing"));

        hs1.themQuaTrinhLamViec(new QuaTrinhLamViec(
                "1/1/2023", "31/12/2023", "Lập trình viên",
                "XYZ", "0900000000", "", "", "IT"));

        hs1.themNgoaiNgu("Tiếng Anh", "B2");
        
        

    	HoSoUngVien hs2 = new HoSoUngVien(
                "HS02", "Trương Tùng Dương", "20/05/2003", "TP.HCM", "Gay",
                "Đại học", "anv@gmail.com", "0912345678", "Kỹ sư",
                "Kỹ thuật phần mềm", 1.70, 65.0);
    	

        hs2.themNgoaiNgu("Tiếng Anh", "B2");

        hs2.themQuaTrinhLamViec(new QuaTrinhLamViec(
                "1/1/2023", "31/12/2023", "Java Developer",
                "Dương Tech", "0363636363", "", "",
                "Công nghệ thông tin"));
    	
    	HoSoUngVien hs3 = new HoSoUngVien(
                "HS_BDS01", "Phạm Văn Bình", "12/08/1998", "Hà Nội", "Nam",
                "Đại học", "binh.pv@gmail.com", "0934567890", "Kỹ sư",
                "Quản lý Xây dựng", 1.72, 70.0);
    	
    	HoSoUngVien hs4 = new HoSoUngVien(
                "HS_FIN01", "Lê Thị Mai", "25/11/2001", "TP.HCM", "Nữ",
                "Thạc sĩ", "mai.le@fintech.com", "0977888999", "Thạc sĩ",
                "Tài chính Ngân hàng", 1.65, 52.0);
    	
    	ViTriTuyenDung vt1 = new ViTriTuyenDung(
                "Java Backend Developer", "Hà Nội", 5, 2500, 1200,
                "VT01", "Phát triển hệ thống RESTful API với Spring Boot & MySQL");
    	
    	ViTriTuyenDung vt2 = new ViTriTuyenDung(
                "DevOps Engineer", "TP.HCM", 2, 3000, 1800,
                "VT02", "Quản lý Kubernetes, Docker và CI/CD Pipeline");
            
    	ViTriTuyenDung vt3 = new ViTriTuyenDung(
                "Chuyên viên Quản lý Dự án BĐS", "Hà Nội", 3, 2200, 1500,
                "VT_BDS01", "Giám sát tiến độ và lập quy hoạch dự án đô thị");
    	
    	ViTriTuyenDung vt4 = new ViTriTuyenDung(
                "Fintech Data Analyst", "TP.HCM", 4, 2800, 1600,
                "VT_FIN01", "Phân tích hành vi thanh toán và rủi ro tín dụng"
            );
    	
    	boolean nop1 = vt1.nopHoSo(hs1);
    	boolean nop2 = vt2.nopHoSo(hs2);
    	boolean nop3 = vt3.nopHoSo(hs3);
    	boolean nop4 = vt4.nopHoSo(hs4);
    	
    	boolean nop5 = vt1.nopHoSo(hs1);
    	boolean nop6 = vt2.nopHoSo(hs2);
    	boolean nop7 = vt3.nopHoSo(hs3);
    	boolean nop8 = vt4.nopHoSo(hs4);
    	
    	System.out.println(nop1 + " " + nop2 + " " + nop3 + " " + nop4);
    	System.out.println(nop5 + " " + nop6 + " " + nop7 + " " + nop8);
    	
    	System.out.println("Số ứng viên hiện tại: " + vt1.demSoLuongUngVien());
    	System.out.println("Kiểm tra còn chỉ tiêu khi đã đủ: " + vt2.kiemTraConChiTieu());
    	
    	
    	HoSoUngVien tim = vt1.timHoSo("HS01");
    	System.out.println("Tìm HS01: " + (tim != null ? tim.getHoTen() : "Không thấy"));
    	
    	boolean xoaSuccess = vt2.xoaHoSo("HS02");
        boolean xoaFail = vt2.xoaHoSo("HS999");
        System.out.println(xoaSuccess + " " + xoaFail);
    	
        ArrayList<HoSoUngVien> dsPhuHop = vt3.locHoSoPhuHop();
        System.out.println("Số lượng hồ sơ phù hợp: " + dsPhuHop.size());
        
        double tongDiem = vt4.tinhTongDiem(hs1);
        System.out.println("Tổng điểm ứng viên HS01: " + tongDiem);
    	
    	

    	System.out.println(vt1);
    	
      
      
    	
    	
	}
    
    
}