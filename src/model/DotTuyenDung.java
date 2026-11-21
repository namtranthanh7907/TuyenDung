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
public class DotTuyenDung {

    /**
     * Default constructor
     */
    public DotTuyenDung() {
    	this.dsViTriTuyenDung = new ArrayList<>();
    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String ngayDang;

    /**
     * 
     */
    private String ngayHetHan;

    /**
     * 
     */
    private ArrayList<ViTriTuyenDung> dsViTriTuyenDung;

    /**
     * 
     */
    private String tenDot;

    /**
     * 
     */
    private String moTaDot;



    public DotTuyenDung(String id, String ngayDang, String ngayHetHan, ArrayList<ViTriTuyenDung> dsViTriTuyenDung,
			String tenDot, String moTaDot) {
		super();
		this.id = id;
		this.ngayDang = ngayDang;
		this.ngayHetHan = ngayHetHan;
		this.dsViTriTuyenDung = (dsViTriTuyenDung == null) ? new ArrayList<>() : dsViTriTuyenDung;
		this.tenDot = tenDot;
		this.moTaDot = moTaDot;
	}

    
    
	public DotTuyenDung(String id, String ngayDang, String ngayHetHan,
			String tenDot, String moTaDot) {
		super();
		this.id = id;
		this.ngayDang = ngayDang;
		this.ngayHetHan = ngayHetHan;
		this.dsViTriTuyenDung = new ArrayList<>();
		this.tenDot = tenDot;
		this.moTaDot = moTaDot;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(String ngayDang) {
		this.ngayDang = ngayDang;
	}

	public String getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public ArrayList<ViTriTuyenDung> getDsViTriTuyenDung() {
		return dsViTriTuyenDung;
	}

	public void setDsViTriTuyenDung(ArrayList<ViTriTuyenDung> dsViTriTuyenDung) {
		this.dsViTriTuyenDung = (dsViTriTuyenDung == null) ? new ArrayList<>() : dsViTriTuyenDung;
	}

	public String getTenDot() {
		return tenDot;
	}

	public void setTenDot(String tenDot) {
		this.tenDot = tenDot;
	}

	public String getMoTaDot() {
		return moTaDot;
	}

	public void setMoTaDot(String moTaDot) {
		this.moTaDot = moTaDot;
	}

	/**
     * @param vt 
     * @return
     */
	
	//them vi tri tuyen dung
    public boolean themViTri(ViTriTuyenDung vt) {
        if(vt == null || vt.getMaViTri() == null || vt.getMaViTri().trim().isEmpty()) {
        	return false;
        }
        
        if(dsViTriTuyenDung == null) {
        	dsViTriTuyenDung = new ArrayList<>();
        }
        
        if(timViTri(vt.getMaViTri()) != null) {
        	return false;
        }
        dsViTriTuyenDung.add(vt);
        return true;
    }

    /**
     * @param maViTri 
     * @return
     */
    
    //xoa vi tri tuyen dung
    public boolean xoaViTri(String maViTri) {
        if(maViTri == null || maViTri.trim().isEmpty() || dsViTriTuyenDung == null) {
        	return false;
        }
        
        String maCanTim = maViTri.trim();
        for(int i = 0; i < dsViTriTuyenDung.size(); i++) {
        	ViTriTuyenDung vt = dsViTriTuyenDung.get(i);
        	if (vt == null || vt.getMaViTri() == null) {
                continue;
            }

            if (maCanTim.equals(vt.getMaViTri().trim())) {
                dsViTriTuyenDung.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * @param maViTri 
     * @return
     */
    
    //tim vi tri tuyen dung dua vao ma vi tri tuyen dung
    public ViTriTuyenDung timViTri(String maViTri) {
        if(maViTri == null || maViTri.trim().isEmpty() || dsViTriTuyenDung == null) {
        	return null;
        }
        
        String maCanTim = maViTri.trim();
        
        for(ViTriTuyenDung vt : dsViTriTuyenDung) {
        	if (vt == null || vt.getMaViTri() == null) {
                continue;
            }

            if (maCanTim.equals(vt.getMaViTri().trim())) {
                return vt;
            }
        }
        return null;
    }

    /**
     * @return
     */
    
    //kiem tra xem ngay hom nay da het han cua dot tuyen dung chua
    public boolean kiemTraConHan() {
    	if (ngayHetHan == null || ngayHetHan.trim().isEmpty()) {
            return false;
        }

        try {
            DateTimeFormatter dtf = DateTimeFormatter
                    .ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

            String ngay = chuanHoaNgay(ngayHetHan.trim());

            if (ngay == null) {
                return false;
            }

            LocalDate han = LocalDate.parse(ngay, dtf);

            return !LocalDate.now().isAfter(han);

        } catch (DateTimeParseException e) {
            return false;
        }
    }

    
    /**
     * @return
     */
    
    //dem so vi tri tuyen dung
    public int demSoViTri() {
        return dsViTriTuyenDung.size();
    }

    /**
     * @return
     */
    
    //tinh tong chi tieu tuyen dung
    public int tongChiTieuTuyenDung() {
        int sum = 0;
        
        for(ViTriTuyenDung vt : dsViTriTuyenDung) {
        	sum += vt.getSoLuong();
        }
        return sum;
    }

    /**
     * @return
     */
    
    //tim vi tri tuyen dung luong cao nhat
    public ViTriTuyenDung timViTriLuongCaoNhat() {
        ViTriTuyenDung max = null;
        
        for(ViTriTuyenDung vt : dsViTriTuyenDung) {
        	if(max == null || vt.getMaxLuong() > max.getMaxLuong()) {
        		max = vt;
        	}
        }
        return max;
    }

    /**
     * @param minLuong 
     * @return
     */
    
    //loc vi tri theo luong toi thieu
    public ArrayList<ViTriTuyenDung> locViTriTheoLuongToiThieu(int minLuong) {
        ArrayList<ViTriTuyenDung> res = new ArrayList<>();
        
        for(ViTriTuyenDung vt : dsViTriTuyenDung) {
        	if(vt.getMinLuong() >= minLuong) {
        		res.add(vt);
        	}
        }
        return res;
    }

    /**
     * @return
     */
    
    //sap xep vi tri theo ten
    public void sapXepViTriTheoTen() {
        Collections.sort(dsViTriTuyenDung, new Comparator<ViTriTuyenDung>() {

			@Override
			public int compare(ViTriTuyenDung o1, ViTriTuyenDung o2) {
				return o1.getTenViTri().compareToIgnoreCase(o2.getTenViTri());
			}
        	
		});
        
    }

    /**
     * @param moTaMoi 
     * @return
     */
    
    //cap nhat mo ta moi
    public void capNhatMoTa(String moTaMoi) {
        this.moTaDot = moTaMoi;
       
    }

    //chuan hoa ngay theo dinh dang dd/MM/yyyy
    public String chuanHoaNgay(String ngay) {
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
    
    //dem tong so luong ung vien
    public int demTongLuotHoSoUngTuyen() {
    	int cnt = 0;
    	
    	if(dsViTriTuyenDung == null) {
    		return cnt;
    	}
    	
    	for(ViTriTuyenDung vt : dsViTriTuyenDung) {
    		if(vt != null) {
    			cnt += vt.demSoLuongUngVien();
    		}
    	}
    	
    	return cnt;
    }
    
    
    //dem xem vi tri tuyen dung con chi tieu hay khong
    public int demViTriConChiTieu() {
    	int cnt = 0;
    	
    	if(dsViTriTuyenDung == null) {
    		return cnt;
    	}
    	
    	for(ViTriTuyenDung vt : dsViTriTuyenDung) {
    		if(vt != null && vt.kiemTraConChiTieu()) {
    			cnt++;
    		}
    	}
    	
    	return cnt;
    }
    
    //tim vi tri co so luong tuyen dung cao nhat
    public ViTriTuyenDung timViTriCoSoLuongTuyenCaoNhat() {
    	ViTriTuyenDung vtMax = null;
    	int maxSoLuong = -1;
    	
    	if(dsViTriTuyenDung == null) {
    		return null;
    	}
    	
    	for(ViTriTuyenDung vt : dsViTriTuyenDung) {
    		if(vt == null) {
    			continue;
    		}
    		
    		int soLuong = vt.getSoLuong();
    		
    		if(soLuong > maxSoLuong) {
    			maxSoLuong = soLuong;
    			vtMax = vt;
    		}
    	}
    	return vtMax;
    }
    
    //tim vi tri tuyen dung co nhieu ho so ung tuyen nhat
    public ViTriTuyenDung timViTriCoNhieuHoSoNhat() {
    	ViTriTuyenDung vtMax = null;
    	int maxHoSo = -1;
    	
    	
    	if(dsViTriTuyenDung == null) {
    		return null;
    	}
    	
    	for(ViTriTuyenDung vt : dsViTriTuyenDung) {
    		if(vt == null) {
    			continue;
    		}
    		
    		int soHoSo = vt.demSoLuongUngVien();
    		
    		if(soHoSo > maxHoSo) {
    			maxHoSo = soHoSo;
    			vtMax = vt;
    		}
    	}
    	
    	return vtMax;
    }
    
    
    //dem tong ho so dat yeu cau
    public int demTongHoSoDatYeuCau() {
    	int cnt = 0;
    	
    	if(dsViTriTuyenDung == null) {
    		return cnt;
    	}
    	
    	for(ViTriTuyenDung vt : dsViTriTuyenDung) {
    		if(vt == null) {
    			continue;
    		}
    		
    		ArrayList<HoSoUngVien> dsPhuHop = vt.locHoSoPhuHop();
    		
    		if(dsPhuHop != null) {
    			cnt += dsPhuHop.size();
    		}
    	}
    	
    	return cnt;
    }
    
    public String toString() {
    	String res = "";
    	
    	res += "ID dot tuyen dung: " + id + ", Ngay dang: " + ngayDang + ", Ngay het han: " + ngayHetHan
    			+ ", Ten dot: " + tenDot + ", Mo ta dot: " + moTaDot
    			+ "\nDanh sach vi tri tuyen dung:\n";
    	
    	if(dsViTriTuyenDung == null || dsViTriTuyenDung.isEmpty()) {
    		res += " Chua co Vi tri tuyen dung!\n";
    	} else {
    		for(ViTriTuyenDung vt : dsViTriTuyenDung) {
    			if(vt != null) {
    				res += vt.toString() + "\n";
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
    	
    	
    	boolean add1 = dtd1.themViTri(vt1);            
    	boolean add2 = dtd1.themViTri(vt2);
    	boolean add3 = dtd2.themViTri(vt3);
    	boolean add4 = dtd3.themViTri(vt4);
    	boolean add5 = dtd3.themViTri(vt4);
    	
    	System.out.println(add1 + " " + add2 + " " + add3 + " " + add4 + " " + add5);
    	
    	System.out.println("Số lượng vị trí tuyển dụng: " + dtd1.demSoViTri());
    	ViTriTuyenDung timVT = dtd1.timViTri("VT02");
        System.out.println("Tìm vị trí VT02: " + (timVT != null ? timVT.getTenViTri() : "Không thấy"));
        System.out.println("Tìm vị trí không tồn tại: " + dtd2.timViTri("VT99"));
        
        boolean xoaSuccess = dtd1.xoaViTri("VT02");
        boolean xoaFail = dtd2.xoaViTri("VT99");
        
        System.out.println(xoaSuccess + " " + xoaFail);
        
        System.out.println("Số lượng vị trí sau khi xóa: " + dtd1.demSoViTri());
        
        dtd1.themViTri(vt2);
        
        System.out.println("Đợt tuyển dụng DTD01 (hạn 31/12/2030) còn hạn: " + dtd3.kiemTraConHan());
        
        DotTuyenDung dtdHetHan = new DotTuyenDung("DTD_OLD", "01/01/2020", "01/02/2020", "Tuyển dụng 2020", "Tìm kiếm thằng cốt dưới biển");
        System.out.println("Đợt tuyển dụng DTD_OLD (hạn 01/02/2020) còn hạn: " + dtdHetHan.kiemTraConHan());
        
        System.out.println("Tổng chỉ tiêu tuyển dụng (5 + 2 + 3): " + dtd3.tongChiTieuTuyenDung());
        
        ViTriTuyenDung vtMaxLuong = dtd1.timViTriLuongCaoNhat();
        System.out.println("Vị trí lương cao nhất: " + (vtMaxLuong != null ? vtMaxLuong.getTenViTri() : "null"));
        
        ViTriTuyenDung vtMaxSoLuong = dtd1.timViTriCoSoLuongTuyenCaoNhat();
        System.out.println("Vị trí chỉ tiêu tuyển cao nhất: " + (vtMaxSoLuong != null ? vtMaxSoLuong.getTenViTri() : "null"));
        
        ArrayList<ViTriTuyenDung> dsLuongCao = dtd1.locViTriTheoLuongToiThieu(1200);
        System.out.println("Số vị trí có minLuong >= 1200: " + dsLuongCao.size());
        
        dtd1.sapXepViTriTheoTen();
        System.out.println("Vị trí đầu tiên sau khi sắp xếp theo tên: " + dtd1.getDsViTriTuyenDung().get(0).getTenViTri());
        
        System.out.println("Tổng số lượt hồ sơ đã nộp: " + dtd2.demTongLuotHoSoUngTuyen());
        
        System.out.println("Tổng số hồ sơ đạt yêu cầu: " + dtd1.demTongHoSoDatYeuCau());
        
        ViTriTuyenDung vtNhieuHoSo = dtd1.timViTriCoNhieuHoSoNhat();
        System.out.println("Vị trí có nhiều hồ sơ nộp nhất: " + (vtNhieuHoSo != null ? vtNhieuHoSo.getTenViTri() : "null"));
        
        System.out.println("Số vị trí còn chỉ tiêu tuyển dụng: " + dtd1.demViTriConChiTieu());
        
        System.out.println(dtd1.toString());
	}
}