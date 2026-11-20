package model;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;

/**
 * 
 */
public class CongTy {

    /**
     * Default constructor
     */
    public CongTy() {
    	this("", "", "", 0, "", "", "", "");
    }
    
    

    /**
     * 
     */
    private String maST;

    /**
     * 
     */
    private String tenCT;

    /**
     * 
     */
    private String linhVuc;

    /**
     * 
     */
    private double vonDL;

    /**
     * 
     */
    private LinkedList<DotTuyenDung> dsDotTuyenDung;

    /**
     * 
     */
    private String ngayTL;

    /**
     * 
     */
    private String diaChi;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String soDienThoai;





    public CongTy(String maST, String tenCT, String linhVuc, double vonDL, LinkedList<DotTuyenDung> dsDotTuyenDung,
			String ngayTL, String diaChi, String email, String soDienThoai) {
		super();
		this.maST = maST;
		this.tenCT = tenCT;
		this.linhVuc = linhVuc;
		this.vonDL = vonDL;
		this.dsDotTuyenDung = (dsDotTuyenDung == null) ? new LinkedList<>() : dsDotTuyenDung;
		this.ngayTL = ngayTL;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}
    
    

	public CongTy(String maST, String tenCT, String linhVuc, double vonDL, String ngayTL, String diaChi, String email,
			String soDienThoai) {
		super();
		this.maST = maST;
		this.tenCT = tenCT;
		this.linhVuc = linhVuc;
		this.vonDL = vonDL;
		this.dsDotTuyenDung = new LinkedList<>();
		this.ngayTL = ngayTL;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}



	public String getMaST() {
		return maST;
	}

	public void setMaST(String maST) {
		this.maST = maST;
	}

	public String getTenCT() {
		return tenCT;
	}

	public void setTenCT(String tenCT) {
		this.tenCT = tenCT;
	}

	public String getLinhVuc() {
		return linhVuc;
	}

	public void setLinhVuc(String linhVuc) {
		this.linhVuc = linhVuc;
	}

	public double getVonDL() {
		return vonDL;
	}

	public void setVonDL(double vonDL) {
		this.vonDL = vonDL;
	}

	public LinkedList<DotTuyenDung> getDsDotTuyenDung() {
		return dsDotTuyenDung;
	}

	public void setDsDotTuyenDung(LinkedList<DotTuyenDung> dsDotTuyenDung) {
		if (dsDotTuyenDung == null) {
	        this.dsDotTuyenDung = new LinkedList<>();
	    } else {
	        this.dsDotTuyenDung = dsDotTuyenDung;
	    }
	}

	public String getNgayTL() {
		return ngayTL;
	}

	public void setNgayTL(String ngayTL) {
		this.ngayTL = ngayTL;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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

	/**
     * @param dot 
     * @return
     */
	
	//them dot tuyen dung
    public boolean themDotTuyenDung(DotTuyenDung dot) {
        if(dot == null) {
        	return false;
        }
        
        if(dsDotTuyenDung == null) {
        	dsDotTuyenDung = new LinkedList<DotTuyenDung>();
        }
        
        if(timDotTuyenDung(dot.getId()) != null) {
        	return false;
        }
        dsDotTuyenDung.add(dot);
        return true;
    }

    /**
     * @param id 
     * @return
     */
    
    //xoa dot tuyen dung
    public boolean xoaDotTuyenDung(String id) {
        if(id == null) {
        	return false;
        }
        
        for(int i = 0; i < dsDotTuyenDung.size(); i++) {
        	 DotTuyenDung dtd = dsDotTuyenDung.get(i);

             if (dtd != null && id.trim().equals(dtd.getId())) {
                 dsDotTuyenDung.remove(i);
                 return true;
             }
        }
        return false;
    }

    /**
     * @param id 
     * @return
     */
    
    //tim dot tuyen dung boi id
    public DotTuyenDung timDotTuyenDung(String id) {
    	if (id == null || id.trim().isEmpty() || dsDotTuyenDung == null) {
            return null;
        }

        for (DotTuyenDung dtd : dsDotTuyenDung) {
            if (dtd != null && id.trim().equals(dtd.getId())) {
                return dtd;
            }
        }
        return null;
    }

    /**
     * @return
     */
    
    //dem tong dot tuyen dung
    public int demSoDotTuyenDung() {
    	int cnt = 0;

        if (dsDotTuyenDung == null) {
            return cnt;
        }

        for (DotTuyenDung dtd : dsDotTuyenDung) {
            if (dtd != null) {
                cnt++;
            }
        }

        return cnt;
    }

    /**
     * @return
     */
    
    
    //dem tong vi tri tuyen dung
    public int demTongViTriTuyenDung() {
    	int cnt = 0;

        if (dsDotTuyenDung == null) {
            return cnt;
        }

        for (DotTuyenDung dtd : dsDotTuyenDung) {
            if (dtd != null) {
                cnt += dtd.demSoViTri();
            }
        }

        return cnt;
        
    }

    /**
     * @return
     */
    
    //sap xep cong ty theo id tang dan
    public void sapXepDotTheoId() {
    	
    	Collections.sort(dsDotTuyenDung, new Comparator<DotTuyenDung>() {

			@Override
			public int compare(DotTuyenDung o1, DotTuyenDung o2) {
				// TODO Auto-generated method stub
				String a = (o1.getId() == null) ? "" : o1.getId();
				String b = (o2.getId() == null) ? "" : o2.getId();
				
				return a.compareTo(b);
			}
    		
		});
        
    }
    
    
    //chuyen ngay tu String sang localdate
    private LocalDate chuyenNgay(String ngay) {
    	if(ngay == null || ngay.trim().isEmpty()) {
    		return null;
    	}
    	
    	try {
    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/uuu", Locale.ROOT)
    												.withResolverStyle(ResolverStyle.STRICT);
    		
    		return LocalDate.parse(ngay.trim(), dtf);
    	} catch(DateTimeParseException e) {
    		return null;
    	}
    }
    
    //tim dot tuyen dung moi nhat
    public DotTuyenDung timDotTuyenDungMoiNhat() {
    	DotTuyenDung dotMoi = null;
    	LocalDate ngayMoi = null;
    	
    	if(dsDotTuyenDung == null) {
    		return null;
    	}
    	
    	for(DotTuyenDung dtd : dsDotTuyenDung) {
    		if(dtd == null) {
    			continue;
    		}
    		
    		LocalDate ngayDang = chuyenNgay(dtd.getNgayDang());
    		
    		if(ngayDang == null) {
    			continue;
    		}
    		
    		if(ngayMoi == null || ngayDang.isAfter(ngayMoi)) {
    			ngayMoi = ngayDang;
    			dotMoi = dtd;
    		}
    	}
    	
    	return dotMoi;
    }
    
    //dem so dot tuyen dung chua het han
    public int demDotTuyenDungConHan() {
    	int cnt = 0;
    	
    	if(dsDotTuyenDung == null) {
    		return 0;
    	}
    	
    	for(DotTuyenDung dtd : dsDotTuyenDung) {
    		if(dtd != null && dtd.kiemTraConHan()) {
    			cnt++;
    		}	
    	}
    	
    	return cnt;
    }
    
    
    //tim dot tuyen dung chi tieu cao nhat
    public DotTuyenDung timDotTuyenDungChiTieuCaoNhat() {
    	DotTuyenDung dotMax = null;

        if (dsDotTuyenDung == null) {
            return null;
        }

        for (DotTuyenDung dtd : dsDotTuyenDung) {
            if (dtd == null) {
                continue;
            }

            int chiTieu = dtd.tongChiTieuTuyenDung();

            if (dotMax == null ||
                chiTieu > dotMax.tongChiTieuTuyenDung()) {
                dotMax = dtd;
            }
        }

        return dotMax;
    }
    
    //tim dot tuyen dung chi tieu thap nhat
    public DotTuyenDung timDotTuyenDungChiTieuThapNhat() {
        DotTuyenDung dotMin = null;
        int minChiTieu = Integer.MAX_VALUE;

        if (dsDotTuyenDung == null) {
            return null;
        }

        for (DotTuyenDung dtd : dsDotTuyenDung) {
            if (dtd == null) {
                continue;
            }

            int chiTieu = dtd.tongChiTieuTuyenDung();

            if (chiTieu < minChiTieu) {
                minChiTieu = chiTieu;
                dotMin = dtd;
            }
        }

        return dotMin;
    }
    
    
    //dem tong chi tieu dang tuyen
    public int demTongChiTieuDangTuyen() {
    	int cnt = 0;
    	
    	if(dsDotTuyenDung == null) {
    		return 0;
    	}
    	
    	for(DotTuyenDung dtd : dsDotTuyenDung) {
    		if(dtd != null && dtd.kiemTraConHan()) {
    			cnt += dtd.tongChiTieuTuyenDung();
    		}
    	}
    	
    	return cnt;
    }
    
    //tim dot tuyen dung co nhieu ho so ung tuyen nhat
    public DotTuyenDung timDotTuyenDungCoNhieuHoSoNhat() {
    	DotTuyenDung dotMax = null;
    	int maxHoSo = -1;
    	
    	if(dsDotTuyenDung == null) {
    		return null;
    	}
    	
    	for(DotTuyenDung dtd : dsDotTuyenDung) {
    		if(dtd == null) {
    			continue;
    		}
    		
    		int soHoSo = dtd.demTongLuotHoSoUngTuyen();
    		
    		if(soHoSo > maxHoSo) {
    			maxHoSo = soHoSo;
    			dotMax = dtd;
    		}
    	}
    	
    	return dotMax; 	
    }
    
    public String toString() {
    	String res = "";
    	
    	res += "Ma so thue: " + maST + ", " + tenCT + ", Linh vuc: " + linhVuc + ", Von: " + vonDL
    			+ ", Ngay thanh lap: " + ngayTL + ", Dia chi: " + diaChi + ", Email: " + email
    			+ "\nDanh sach dot tuyen dung:\n";
    	
    	if(dsDotTuyenDung == null || dsDotTuyenDung.isEmpty()) {
    		res += " Chua co Dot tuyen dung!\n";
    	} else {
    		for(DotTuyenDung dtd : dsDotTuyenDung) {
    			if(dtd != null) {
    				res += dtd.toString() + "\n";
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
    	
    	vt1.nopHoSo(hs1);
    	vt2.nopHoSo(hs2);
    	vt3.nopHoSo(hs3);
    	vt4.nopHoSo(hs4);
    	
    	DotTuyenDung dtd1 = new DotTuyenDung(
                "DTD01", "01/05/2026", "31/12/2026",
                "Tuyển dụng Kỹ sư Phần mềm 2026", "Đợt tuyển dụng nhân sự Backend & DevOps");
    	
    	
    	DotTuyenDung dtd2 = new DotTuyenDung(
                "DTD_BDS_Q3", "15/07/2026", "30/09/2026",
                "Tuyển dụng Nhân sự Phát triển Dự án Đô thị", "Đợt tuyển quy mô lớn cho dự án mới");
    	
    	DotTuyenDung dtd3 = new DotTuyenDung(
                "DTD_FIN_2026", "01/08/2026", "15/11/2026",
                "Tuyển dụng Kỹ sư & Chuyên viên Phân tích Fintech", "Mở rộng khối giải pháp thanh toán số");
    	
    	
    	dtd1.themViTri(vt1);            
    	dtd1.themViTri(vt2);
        dtd2.themViTri(vt3);
        dtd3.themViTri(vt4);
        
        CongTy ct1 = new CongTy(
                "0101234567", "LGBT Software", "Công nghệ thông tin", 1500.0,
                "13/09/1999", "Hà Nội", "recruitment@fpt.com", "02473007300");
        
        CongTy ct2 = new CongTy(
                "0109998887", "VinHomes Land", "Bất động sản", 4500.0,
                "20/02/2010", "Hà Nội", "recruitment@vinhomes.vn", "02439749999");
        
        CongTy ct3 = new CongTy(
                "0312345678", "VNPay Technology", "Tài chính - Công nghệ", 3000.0,
                "08/03/2007", "TP.HCM", "hr@vnpay.vn", "02838228888");
        
        boolean add1 = ct1.themDotTuyenDung(dtd1);
        boolean add11 = ct1.themDotTuyenDung(dtd2);
        boolean add12 = ct1.themDotTuyenDung(dtd3);
        boolean add2 = ct2.themDotTuyenDung(dtd2);
        boolean add3 = ct3.themDotTuyenDung(dtd3);
        boolean add4 = ct3.themDotTuyenDung(dtd3);
        
        System.out.println(add1 + " " + add2 + " " + add3 + " " + add4);
        
        System.out.println("Số lượng đợt tuyển dụng: " + ct1.demSoDotTuyenDung());
        DotTuyenDung timDot = ct1.timDotTuyenDung("DTD01");
        System.out.println("Tìm đợt DTD01: " + (timDot != null ? timDot.getTenDot() : "null"));
        
        boolean xoaSuccess = ct3.xoaDotTuyenDung("DTD_FIN_2026");
        boolean xoaFail = ct3.xoaDotTuyenDung("DTD99");
        
        System.out.println(xoaSuccess + " " + xoaFail);
        
        System.out.println("Số lượng đợt sau khi xóa: " + ct3.demSoDotTuyenDung());
        
        ct3.themDotTuyenDung(dtd3);
        
        ct1.sapXepDotTheoId();
        System.out.println("Đợt tuyển dụng đầu tiên sau khi sắp xếp ID: " + ct1.getDsDotTuyenDung().get(0).getId());
        
        DotTuyenDung dotMoiNhat = ct1.timDotTuyenDungMoiNhat();
        System.out.println("Đợt tuyển dụng có ngày đăng mới nhất: " + (dotMoiNhat != null ? dotMoiNhat.getId() : "null"));
        
        System.out.println("Số đợt tuyển dụng còn hạn: " + ct1.demDotTuyenDungConHan());
        
        System.out.println("Tổng số vị trí tuyển dụng: " + ct1.demTongViTriTuyenDung());
        
        DotTuyenDung dotMaxChiTieu = ct1.timDotTuyenDungChiTieuCaoNhat();
        System.out.println("Đợt có tổng chỉ tiêu cao nhất: " + (dotMaxChiTieu != null ? dotMaxChiTieu.getId() : "null"));
        
        DotTuyenDung dotMinChiTieu = ct1.timDotTuyenDungChiTieuThapNhat();
        System.out.println("Đợt có tổng chỉ tiêu thấp nhất: " + (dotMinChiTieu != null ? dotMinChiTieu.getId() : "null"));
        
        System.out.println("Tổng chỉ tiêu đang tuyển (chỉ đợt còn hạn): " + ct1.demTongChiTieuDangTuyen());
        
        DotTuyenDung dotNhieuHoSo = ct1.timDotTuyenDungCoNhieuHoSoNhat();
        System.out.println("Đợt tuyển dụng có nhiều hồ sơ nhất: " + (dotNhieuHoSo != null ? dotNhieuHoSo.getId() : "null"));
        
        
        System.out.println(ct1);
        
        
	}
}