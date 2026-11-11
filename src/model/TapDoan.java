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
public class TapDoan {

    /**
     * Default constructor
     */
    public TapDoan() {
    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String ten;

    /**
     * 
     */
    private ListIterator<CongTy> dsCongTy;


    public TapDoan(String id, String ten, ListIterator<CongTy> dsCongTy) {
		super();
		this.id = id;
		this.ten = ten;
		this.dsCongTy = dsCongTy;
	}
    
    

    
	public TapDoan(String id, String ten) {
		super();
		this.id = id;
		this.ten = ten;
		this.dsCongTy = new ArrayList<CongTy>().listIterator();
	}




	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public ListIterator<CongTy> getDsCongTy() {
		return dsCongTy;
	}


	public void setDsCongTy(ListIterator<CongTy> dsCongTy) {
		this.dsCongTy = dsCongTy;
	}

	//khi listiterator chay toi cuoi se khong con gi nua nen phai de no refresh lai tu dau
	public void refresh() {
		if(dsCongTy == null) {
			dsCongTy = new ArrayList<CongTy>().listIterator();
		}
		while(dsCongTy.hasPrevious()) {
			dsCongTy.previous();
		}
	}
	/**
     * @return
     */
	//tinh tong von tap toan tu danh sach cong ty
    public double tongVonTapDoan() {
        double res = 0;
        refresh();
        while(dsCongTy.hasNext()) {
        	res += dsCongTy.next().getVonDL();
        }
        return res;
    }

    /**
     * @return
     */
    
    //sai treeset chi lay lay linh vuc khong bi trung lap, tra ve mot set cac linh vuc
    public TreeSet<String> getSetLinhVuc() {
        TreeSet<String> dsLinhVuc = new TreeSet<String>();
        refresh();
        
        while(dsCongTy.hasNext()) {
        	CongTy ct = dsCongTy.next();
        	
        	if(ct.getLinhVuc() != null) {
        		dsLinhVuc.add(ct.getLinhVuc());
        	}
        }
        return dsLinhVuc;
    }

    /**
     * @param TencT 
     * @return
     */
    
    //them cong ty
    public boolean themCongTy(CongTy ct) {
        // TODO implement here
        if(ct == null || ct.getMaST() == null) {
        	return false;
        }
        if(timCongTy(ct.getMaST()) != null) {
        	return false;
        }
        
        dsCongTy.add(ct);
        return true;
    }

    /**
     * @param maST 
     * @return
     */
    
    //xoa cong ty
    public boolean xoaCongTy(String maST) {
        if(maST == null) {
        	return false;
        }
        refresh();
        while(dsCongTy.hasNext()) {
        	CongTy ct = dsCongTy.next();
        	
        	if(maST.equals(ct.getMaST())) {
        		dsCongTy.remove();
        		return true;
        	}
        }
        return false;
    }

    /**
     * @param maST 
     * @return
     */
    
    // tim kiem cong ty bang ma so thue cong ty
    public CongTy timCongTy(String maST) {
        if(maST == null) {
        	return null;
        }
        
        refresh();
        
        while(dsCongTy.hasNext()) {
        	CongTy ct = dsCongTy.next();
        	
        	if(maST.equals(ct.getMaST())) {
        		return ct;
        	}
        }
        return null;
    }

    /**
     * @return
     */
    
    //dem so luong cong ty hien co
    public int demSoCongTy() {
        int cnt = 0;
        refresh();
        
        while(dsCongTy.hasNext()) {
        	dsCongTy.next();
        	cnt++;
        }
        return cnt;
    }

    /**
     * @return
     */
    
    //sap xep cong ty theo von giam dan(tu cao xuong thap)
    public void sapXepCongTyTheoVon() {
        ArrayList<CongTy> dsTmp = new ArrayList<>();
        refresh();
        
        while(dsCongTy.hasNext()) {
        	dsTmp.add(dsCongTy.next());
        }
        
        Collections.sort(dsTmp, new Comparator<CongTy>() {

			@Override
			public int compare(CongTy o1, CongTy o2) {
				return Double.compare(o2.getVonDL(), o1.getVonDL());
			}
		});
        
        dsCongTy = dsTmp.listIterator();
        
    }

    /**
     * @return
     */
    
    //sap xep cong tu theo ten
    public void sapXepCongTyTheoTen() {
       ArrayList<CongTy> dsTmp = new ArrayList<>();
       refresh();
       
       while(dsCongTy.hasNext()) {
    	   dsTmp.add(dsCongTy.next());
       }
       
       Collections.sort(dsTmp, new Comparator<CongTy>() {
			@Override
			public int compare(CongTy o1, CongTy o2) {
				return o1.getTenCT().compareToIgnoreCase(o2.getTenCT());
			}
       });
       
       dsCongTy = dsTmp.listIterator();
    }
    
    
    //chuyen doi listierator sang arraylist de ap dung vao mot so truong hop dac biet
    public ArrayList<CongTy> layDanhSachCongTy() {
		ArrayList<CongTy> res = new ArrayList<>();
		
		refresh();
		
		while(dsCongTy.hasNext()) {
			CongTy ct = dsCongTy.next();
			
			if(ct != null) {
				res.add(ct);
			
			}
		}
		
		refresh();
		
		
		return res;
	}
    
    
    //chuan hoa ngay theo form dd/MM/yyyy
    private String chuanHoaNgay(String ngay) {
    	if(ngay == null || ngay.trim().isEmpty()) {
    		return null;
    	}
    	
    	
    	StringBuilder sb = new StringBuilder(ngay);
    	
    	if(sb.length() > 1 && sb.charAt(1) == '/') {
    		sb.insert(0, '0');
    	}
    	if(sb.length() > 4 && sb.charAt(4) == '/') {
    		sb.insert(3, '0');
    	}
    	return sb.toString();
    }
    
    //chuyen doi ngay tu String sang localdate
    private LocalDate chuyenDoiNgay(String ngay) {
    	if(ngay == null || ngay.trim().isEmpty()) {
    		return null;
    	}
    	
    	try {
    		DateTimeFormatter dtf = DateTimeFormatter
    				.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
    		
    		return LocalDate.parse(chuanHoaNgay(ngay), dtf);
    	} catch(DateTimeParseException e) {
    		return null;
    	}
    }
    
    //liet ke cong ty theo linh vuc
    public ArrayList<CongTy> locCongTyTheoLinhVuc(String linhVuc) {
    	ArrayList<CongTy> res = new ArrayList<>();
    	
    	if(linhVuc == null) {
    		return res;
    	}
    	
    	ArrayList<CongTy> ds = layDanhSachCongTy();
    	
    	for(CongTy ct : ds) {
    		String lv = ct.getLinhVuc();
    		
    		if(lv != null && lv.equalsIgnoreCase(linhVuc)) {
    			res.add(ct);
    		}
    	}
    	
    	return res;
    }
    
    
    //tim cong ty moi thanh lap
    public CongTy timCongTyMoiThanhLap() {
    	CongTy ctMoi = null;
    	LocalDate ngayMoiNhat = null;
    	
    	ArrayList<CongTy> ds = layDanhSachCongTy();
    	
    	for(CongTy ct : ds) {
    		if(ct == null) {
    			continue;
    		}
    		
    		LocalDate ngayTmp = chuyenDoiNgay(ct.getNgayTL());
    		
    		if(ngayTmp == null) {
    			continue;
    		}
    		
    		if(ngayMoiNhat == null || ngayTmp.isAfter(ngayMoiNhat)) {
    			ngayMoiNhat = ngayTmp;
    			ctMoi = ct;
    		}
    	}
    	
    	return ctMoi;
    }
    
    
    //dem cong ty dua theo linh vuc
    public int demCongTyTheoLinhVuc(String linhVuc) {
    	return locCongTyTheoLinhVuc(linhVuc).size();
    }
    
    //tim cong ty co von cao nhat
    public CongTy timCongTyVonCaoNhat() {
    	CongTy ctMax = null;
    	
    	ArrayList<CongTy> ds = layDanhSachCongTy();
    	
    	for(CongTy ct : ds) {
    		if(ctMax == null || ct.getVonDL() > ctMax.getVonDL()) {
    			ctMax = ct;
    		}
    	}
    	
    	return ctMax;
    }
    
    
    //tim cong ty co von thap nhat
    public CongTy timCongTyVonThapNhat() {
    	CongTy ctMin = null;
    	
    	ArrayList<CongTy> ds = layDanhSachCongTy();
    	
    	for(CongTy ct : ds) {
    		if(ctMin == null || ct.getVonDL() < ctMin.getVonDL()) {
    			ctMin = ct;
    		}
    	}
    	
    	return ctMin;
    }
    
    
    //dem tong vi tri tuyen dung
    public int demTongViTriTuyenDung() {
    	int cnt = 0;
    	
    	ArrayList<CongTy> ds = layDanhSachCongTy();
    	
    	for(CongTy ct : ds) {
    		cnt += ct.demTongViTriTuyenDung();
    	}
    	
    	return cnt;
    }
    
    
    //dem so luong chi tieu dang tuyen
    public int demTongChiTieuDangTuyen() {
    	int cnt = 0;
    	
    	ArrayList<CongTy> ds = layDanhSachCongTy();
    	
    	for(CongTy ct : ds) {
    		cnt += ct.demTongChiTieuDangTuyen();
    	}
    	
    	return cnt;
    }
    
    
    //thong ke ra so cong ty dang lam theo tung linh vuc
    public HashMap<String, Integer> thongKeSoCongTyTheoLinhVuc() {
    	HashMap<String, Integer> res = new HashMap<String, Integer>();
    	
    	ArrayList<CongTy> ds = layDanhSachCongTy();
    	
    	for(CongTy ct : ds) {
    		String linhVuc = ct.getLinhVuc();
    		
    		if(linhVuc == null || linhVuc.trim().isEmpty()) {
    			continue;
    		}
    		
    		linhVuc = linhVuc.trim();
    		
    		String linhVucDaCo = null;
    		
    		for(String key : res.keySet()) {
    			if(key.equalsIgnoreCase(linhVuc)) {
    				linhVucDaCo = key;
    				break;
    			}
    		}
    		
    		if(linhVucDaCo != null) {
    			int soLuong = res.get(linhVucDaCo);
    			res.put(linhVucDaCo, soLuong + 1);
    		} else {
    			res.put(linhVuc, 1);
    		}
    	}
    	return res;
    }
    
    
    //tim cong ty co nhu cau tuyen dung cao nhat
    public CongTy timCongTyCoNhuCauTuyenDungCaoNhat() {
    	CongTy ctMax = null;
    	int maxChiTieu = 0;
    	
    	ArrayList<CongTy> ds = layDanhSachCongTy();
    	
    	for(CongTy ct : ds) {
    		int chiTieu = ct.demTongChiTieuDangTuyen();
    		
    		if(chiTieu > maxChiTieu) {
    			maxChiTieu = chiTieu;
    			ctMax = ct;
    		}
    	}
    	return ctMax;
    }
    
    public String toString() {
    	String res = "";
    	
    	res += "ID tap doan: " + id + ", Ten tap doan: " + ten + "\nDanh sach cong ty:\n";
    	
    	ArrayList<CongTy> ds = layDanhSachCongTy();
    	
    	if(ds == null || ds.isEmpty()) {
    		res += " Chua co Cong ty!\n";
    	} else {
    		for(CongTy ct : ds) {
    			if(ct != null) {
    				res += ct.toString() + "\n";
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

    	HoSoUngVien hs2 = new HoSoUngVien(
                "HS02", "Trương Tùng Dương", "20/05/2003", "TP.HCM", "Gay",
                "Đại học", "anv@gmail.com", "0912345678", "Kỹ sư",
                "Kỹ thuật phần mềm", 1.70, 65.0);
    	
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
        
        ct1.themDotTuyenDung(dtd1);
        ct2.themDotTuyenDung(dtd2);
        ct3.themDotTuyenDung(dtd3);
        
        
        TapDoan td = new TapDoan("TD01", "Tập đoàn LGBT");        
        TapDoan td1 = new TapDoan("TD_BDS", "Tập đoàn Phát triển Đô thị Nam Đẹp Trai");
        TapDoan td2 = new TapDoan("TD_FIN", "Tập đoàn Giải pháp Tài chính Số 36");
        boolean add1 = td.themCongTy(ct1);
        boolean add12 = td.themCongTy(ct2);
        boolean add13 = td.themCongTy(ct3);
        boolean add2 = td1.themCongTy(ct2);
        boolean add3 = td2.themCongTy(ct3);
        boolean add4 = td2.themCongTy(ct3);
        
        System.out.println(add1 + " " + add2 + " " + add3 + " " + add4);
        
        
        System.out.println("Số lượng công ty trong tập đoàn: " + td.demSoCongTy());
        
        CongTy timCT = td.timCongTy("0101234567");
        System.out.println("Tìm công ty MST '0101234567': " + (timCT != null ? timCT.getTenCT() : "null"));
        System.out.println("Tìm công ty không tồn tại: " + td.timCongTy("999"));
        
        boolean xoaSuccess = td.xoaCongTy("0109998887");
        boolean xoaFail = td.xoaCongTy("999");
        
        System.out.println(xoaSuccess + " " + xoaFail);
        
        System.out.println("Số công ty sau khi xóa: " + td.demSoCongTy());
        
        td.themCongTy(ct2);
        
        System.out.println("Tổng vốn tập đoàn: " + td.tongVonTapDoan());
        
        TreeSet<String> setLinhVuc = td.getSetLinhVuc();
        System.out.println("Danh sách lĩnh vực hoạt động: " + setLinhVuc);
        
        HashMap<String, Integer> thongKeLV = td.thongKeSoCongTyTheoLinhVuc();
        System.out.println("Thống kê công ty theo lĩnh vực: " + thongKeLV);
        System.out.println("Số công ty thuộc lĩnh vực 'Công nghệ thông tin': " + td.demCongTyTheoLinhVuc("Công nghệ thông tin"));
        
        CongTy ctVonMax = td.timCongTyVonCaoNhat();
        System.out.println("Công ty có vốn cao nhất: " + (ctVonMax != null ? ctVonMax.getTenCT() : "null"));
        
        CongTy ctVonMin = td.timCongTyVonThapNhat();
        System.out.println("Công ty có vốn thấp nhất: " + (ctVonMin != null ? ctVonMin.getTenCT() : "null"));
        
        CongTy ctMoiTL = td.timCongTyMoiThanhLap();
        System.out.println("Công ty mới thành lập nhất: " + (ctMoiTL != null ? ctMoiTL.getTenCT() : "null"));
        
        td.sapXepCongTyTheoVon();
        System.out.println("Công ty đứng đầu sau khi sắp xếp theo Vốn giảm dần: " + td.getDsCongTy().next().getTenCT());
        
        td.sapXepCongTyTheoTen();
        System.out.println("Công ty đứng đầu sau khi sắp xếp theo Tên A-Z: " + td.getDsCongTy().next().getTenCT());
        
        System.out.println("Tổng số vị trí tuyển dụng toàn Tập đoàn: " + td.demTongViTriTuyenDung());
        
        System.out.println("Tổng chỉ tiêu đang tuyển toàn Tập đoàn: " + td.demTongChiTieuDangTuyen());
        
        CongTy ctNhuCauCaoNhat = td.timCongTyCoNhuCauTuyenDungCaoNhat();
        System.out.println("Công ty có nhu cầu tuyển dụng cao nhất: " + (ctNhuCauCaoNhat != null ? ctNhuCauCaoNhat.getTenCT() : "null"));
        
        System.out.println(td);
        
        
	}

}