package model;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 
 */
public class ViTriTuyenDung {
	
	public static final String TC_TONG_DIEM = "TONG_DIEM";
	public static final String TC_DIEM_HO_SO = "DIEM_HO_SO";
	public static final String TC_DIEM_PHONG_VAN = "DIEM_PHONG_VAN";
	
	
	
	public static final double HE_SO_HO_SO = 0.4;
	public static final double HE_SO_PHONG_VAN = 0.6;

    /**
     * Default constructor
     */
    public ViTriTuyenDung() {
    	this("", "", 0, 0, 0, "", "");
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
		this.dsHoSoUngVien = (dsHoSoUngVien == null) ? new HashSet<>() : new HashSet<>(dsHoSoUngVien);
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
		this.dsKetQua = (dsKetQua == null) ? new ArrayList<>() : new ArrayList<>(dsKetQua);
		this.dsPhongVan = (dsPhongVan == null) ? new ArrayList<>() : new ArrayList<>(dsPhongVan);
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
		if(soLuong >= demSoTrungTuyen()) {
			this.soLuong = soLuong;
		}	
	}


	public int getMaxLuong() {
		return maxLuong;
	}


	public void setMaxLuong(int maxLuong) {
		if(maxLuong >= minLuong) {
			this.maxLuong = maxLuong;
		}
	}


	public int getMinLuong() {
		return minLuong;
	}


	public void setMinLuong(int minLuong) {
		if(minLuong >= 0 && minLuong <= maxLuong) {
			this.minLuong = minLuong;
		}
	}


	public HashSet<HoSoUngVien> getDsHoSoUngVien() {
		return dsHoSoUngVien == null ? new HashSet<>() : new HashSet<>(dsHoSoUngVien);
	}


	public void setDsHoSoUngVien(HashSet<HoSoUngVien> dsHoSoUngVien) {
		this.dsHoSoUngVien = (dsHoSoUngVien == null) ? new HashSet<>() : new HashSet<>(dsHoSoUngVien);
	}


	public PriorityQueue<AYeuCauTuyenDung> getDsYeuCauTuyenDung() {
		PriorityQueue<AYeuCauTuyenDung> res = new PriorityQueue<>(new Comparator<AYeuCauTuyenDung>() {

			@Override
			public int compare(AYeuCauTuyenDung o1, AYeuCauTuyenDung o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o2.getDoUuTien(), o1.getDoUuTien());
			}
			
			
		});
		if(dsYeuCauTuyenDung != null) {
			res.addAll(dsYeuCauTuyenDung);
		}
		
		return res;
	}


	public void setDsYeuCauTuyenDung(PriorityQueue<AYeuCauTuyenDung> dsYeuCauTuyenDung) {
		this.dsYeuCauTuyenDung = new PriorityQueue<>(new Comparator<AYeuCauTuyenDung>() {

			@Override
			public int compare(AYeuCauTuyenDung o1, AYeuCauTuyenDung o2) {
				return Integer.compare(o2.getDoUuTien(), o1.getDoUuTien());
			}
			
			
		});
		
		if(dsYeuCauTuyenDung != null) {
			this.dsYeuCauTuyenDung.addAll(dsYeuCauTuyenDung);
		}
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
		return dsKetQua == null ? new ArrayList<>() : new ArrayList<>(dsKetQua);
	}


	public void setDsKetQua(ArrayList<KetQuaUngTuyen> dsKetQua) {
		this.dsKetQua = (dsKetQua == null) ? new ArrayList<>() : new ArrayList<>(dsKetQua);
	}


	public ArrayList<PhongVan> getDsPhongVan() {
		return dsPhongVan == null ? new ArrayList<>() : new ArrayList<>(dsPhongVan);
	}


	public void setDsPhongVan(ArrayList<PhongVan> dsPhongVan) {
		this.dsPhongVan = (dsPhongVan == null) ? new ArrayList<>() : new ArrayList<>(dsPhongVan);
	}


	/**
     * @param yc 
     * @return
     */
	
	//them mot yeu cau cua vi tri tuyen dung
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
    //xoa yeu cau tuyen dung duoc chi dinh cua vi tri tuyen dung
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
    
    
    //tiep nhan ho so sau khi kiem tra thong tin ho so
    public boolean nopHoSo(HoSoUngVien hs) {
        if(hs == null || hs.getMaHS() == null || hs.getMaHS().trim().isEmpty()) {
        	return false;
        }
        
        if(dsHoSoUngVien == null) {
        	dsHoSoUngVien = new HashSet<>();
        }
        
        String maHS = hs.getMaHS().trim();
        
        hs.setMaHS(maHS);
        
        if(timHoSo(maHS) != null) {
        	return false;
        }
        
        return dsHoSoUngVien.add(hs);
    }

    /**
     * @param maHoSo 
     * @return
     */
    
    //xoa ho so ung vien theo ma ho so neu chua co ket qua ung tuyen hoac lich phong van lien quan
    public boolean xoaHoSo(String maHoSo) {
        if(maHoSo == null || maHoSo.trim().isEmpty() || dsHoSoUngVien == null) {
        	return false;
        }
        
        String maHS = maHoSo.trim();
        
        if(timKetQua(maHS) != null) {
        	return false;
        }
        
        if(dsPhongVan != null) {
        	for(PhongVan pv : dsPhongVan) {
        		if(pv != null && pv.getHoSo() != null && maHS.equals(pv.getHoSo().getMaHS())) {
        			return false;
        		}
        		
        	}
        }
        
        Iterator<HoSoUngVien> it = dsHoSoUngVien.iterator();
        
        while(it.hasNext()) {
        	HoSoUngVien hs = it.next();
        	
        	if(hs != null && maHS.equals(hs.getMaHS())) {
        		it.remove();
        		return true;
        	}
        }
        
        return false;
        
        
    }

    /**
     * @param maHoSo 
     * @return
     */
    
    //tim kiem va tra ve ho so ung vien theo ma ho so
    public HoSoUngVien timHoSo(String maHoSo) {
        if(maHoSo == null || maHoSo.trim().isEmpty()) {
        	return null;
        }
        
        if(dsHoSoUngVien == null || dsHoSoUngVien.isEmpty()) {
        	return null;
        }
        
        for(HoSoUngVien hs : dsHoSoUngVien) {
        	if(hs == null || hs.getMaHS() == null) {
        		continue;
        	}
        	if(maHoSo.trim().equals(hs.getMaHS().trim())) {
        		return hs;
        	}
        }
        return null;
    }

    /**
     * @param hs 
     * @return
     */
    
    //kiem tra ung vien co dap ung duoc yeu cau tuyen dung bat buoc hay khong
    public boolean kiemTraYeuCau(HoSoUngVien hs) {
        if(hs == null) {
        	return false;
        }
        
        if(dsYeuCauTuyenDung == null || dsYeuCauTuyenDung.isEmpty()) {
        	return true;
        }
        
        for(AYeuCauTuyenDung yc : dsYeuCauTuyenDung) {
        	if(yc == null) {
        		continue;
        	}
        	
        	if(yc.isBatBuoc() && !yc.kiemTra(hs)) {
        		return false;
        	}
        }
        
        return true;
    }

    /**
     * @return
     */
    
    //loc va tra ve danh sach ho so ung vien dap ung duoc yeu cau tuyen dung
    public ArrayList<HoSoUngVien> locHoSoPhuHop() {
        ArrayList<HoSoUngVien> res = new ArrayList<>();
        
        if(dsHoSoUngVien == null || dsHoSoUngVien.isEmpty()) {
        	return res;
        }
        
        for(HoSoUngVien hs : dsHoSoUngVien) {
        	if(hs != null && kiemTraYeuCau(hs)) {
        		res.add(hs);
        	}
        }
        return res;
    }

    /**
     * @return
     */
    
    //dem so ho so ung vien hien co trong danh sach
    public int demSoLuongUngVien() {
        return dsHoSoUngVien.size();
    }

    /**
     * @return
     */
    
    //kiem tra vi tri tuyen dung con chi tieu de tuyen hay khong
    public boolean kiemTraConChiTieu() {
    	return demSoTrungTuyen() < soLuong;
    }

    /**
     * @param hs 
     * @return
     */
    
    //tinh tong diem dap ung yeu cau cua ung vien dua tren tung tieu chi va do uu tien
    public double tinhTongDiem(HoSoUngVien hs) {
        if(hs == null) {
        	return 0;
        }
        
        double res = 0;
        
        for(AYeuCauTuyenDung yc : dsYeuCauTuyenDung) {
        	if(yc == null) {
        		continue;
        	}
        	
        	double diem = yc.chamDiemUngVien(hs);
        	
        	if(Double.isNaN(diem) || diem < 0 || diem > 1) {
        		return 0;
        	}
        	
        	res += diem * yc.getDoUuTien();
        }
        
        return res;
    }

    /**
     * @param pv 
     * @return
     */
    
    //them mot phong van vao danh sach sau khi kiem tra
    public boolean themPhongVan(PhongVan pv) {
        if(pv == null || pv.getIdPV() == null || pv.getIdPV().trim().isEmpty() 
        			|| pv.getHoSo() == null || pv.getViTri() != this) {
        	return false;
        }
        
        if(dsPhongVan == null) {
        	dsPhongVan = new ArrayList<>();
        }
        
        HoSoUngVien hs = timHoSo(pv.getHoSo().getMaHS());
        
        if(hs == null || hs != pv.getHoSo()) {
        	return false;
        }
        
        
        
        if(timPhongVan(pv.getIdPV()) != null) {
        	return false;
        }
        
        if(coiLichDangHoatDong(hs, pv.getVong())) {
        	return false;
        }
        
        return dsPhongVan.add(pv);
        
        
    }

    /**
     * @param maPV 
     * @return
     */
    
    //xoa phong van theo ma phong van
    public boolean xoaPhongVan(String maPV) {
    	if (maPV == null || maPV.trim().isEmpty() || dsPhongVan == null) {
            return false;
        }
    	
    	String maCanTim = maPV.trim();
        
        for(int i = 0; i < dsPhongVan.size(); i++) {
        	PhongVan pv = dsPhongVan.get(i);
        	
        	if(pv == null || pv.getIdPV() == null) {
        		continue;
        	}
        	
        	if(maCanTim.equals(pv.getIdPV().trim())) {
        		if(!PhongVan.TT_CHUA.equals(pv.getTrangThaiPhongVan())) {
        			return false;
        		}
        		
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
    
    //tim va tra ve mot phong van theo ma phong van
    public PhongVan timPhongVan(String maPV) {
        if(maPV == null || maPV.trim().isEmpty() || dsPhongVan == null) {
        	return null;
        }
        
        String ma = maPV.trim();
        
        for(PhongVan pv : dsPhongVan) {
        	if (pv == null || pv.getIdPV() == null) {
                continue;
            }

            if (ma.equals(pv.getIdPV().trim())) {
                return pv;
            }
        }
        return null;
    }

    /**
     * @return
     */
    
    //lay danh sach phong van
    public ArrayList<PhongVan> layDanhSachPhongVan() {
        return new ArrayList<>(dsPhongVan);
    }

    
    //lay ngay hien tai theo dinh dang
    private String homNay() {
    	return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    //tao ma ket qua ung tuyen dua tuye nma vi tri cua ung vien
    private String taoMaKetQua(HoSoUngVien hs) {
    	return (maViTri == null ? "" : maViTri) + "-" + hs.getMaHS();
    }
    //tao ma phong van ban dau dua tren ma vi tri. so vong va ho so ung vien
    private String taoMaPhongVan(int vong, HoSoUngVien hs) {
    	return (maViTri == null ? "" : maViTri) + "-V" + vong + "-" + hs.getMaHS();
    }
    //tao ma phong van khong bi trung lap va bo sung hau to neu do la lan thu 2 tro len
    private String taoMaPhongVanMoi(int vong, HoSoUngVien hs) {
    	String maGoc = taoMaPhongVan(vong, hs);
    	String maMoi = maGoc;
    	
    	int soLan = 2;
    	
    	while(timPhongVan(maMoi) != null) {
    		maMoi = maGoc + "-L" + soLan;
    		soLan++;
    	}
    	return maMoi;
    }
    
    ///kiem tra ung vien da co lich phong van hay chua
    private boolean coiLichDangHoatDong(HoSoUngVien hs, int vong) {
    	if(hs == null || dsPhongVan == null) {
    		return false;
    	}
    	
    	for(PhongVan pv : dsPhongVan) {
    		if(pv == null || pv.getHoSo() == null) {
    			continue;
    		}
    		
    		boolean cungUngVien = hs.getMaHS().equals(pv.getHoSo().getMaHS());
    		boolean cungVong = pv.getVong() == vong;
    		boolean chuaHuy = !PhongVan.TT_HUY.equals(pv.getTrangThaiPhongVan());
    		
    		if(cungUngVien && cungVong && chuaHuy) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    
    //tinh diem ho so ung vien theo thang diem 10
    public double tinhDiemHoSo(HoSoUngVien hs) {
    	if(hs == null || dsYeuCauTuyenDung == null) {
    		return 0;
    	}
    	
    	double tongUuTien = 0;
    	
    	for(AYeuCauTuyenDung yc : dsYeuCauTuyenDung) {
    		if(yc != null) {
    			tongUuTien += yc.getDoUuTien();
    		}
    	}
    	
    	if(tongUuTien <= 0) {
    		return 10.0;
    	}
    	
    	double diem = tinhTongDiem(hs) / tongUuTien * 10;
    	
    	return Math.max(0, Math.min(10, diem));
    }
    
    //tim va tra ve ket qua ung tuyen thao ma ho so
    public KetQuaUngTuyen timKetQua(String maHS) {
    	if(maHS == null || maHS.trim().isEmpty() || dsKetQua == null) {
    		return null;
    	}
    	
    	String maCanTim = maHS.trim();
    	
    	
    	for(KetQuaUngTuyen kq : dsKetQua) {
    		if(kq == null || kq.getHoSo() == null || kq.getHoSo().getMaHS() == null) {
    			continue;
    		}
    		
    		if(maCanTim.equals(kq.getHoSo().getMaHS().trim())) {
    			return kq;
    		}
    	}
    	
    	return null;
    }
    
    //tim ket qua da ton tai, neu chua thi tao ket qua moi
    private KetQuaUngTuyen layHoacTaoKetQua(HoSoUngVien hs) {
    	KetQuaUngTuyen kq = timKetQua(hs.getMaHS());
    	
    	if(kq == null) {
    		kq = new KetQuaUngTuyen(taoMaKetQua(hs), hs, KetQuaUngTuyen.TT_CHO, homNay(), this, 0);
    		
    		dsKetQua.add(kq);
    	}
    	return kq;
    }
    
    //kiem tra xem ung vien da co cuoc phong van hay chua
    private boolean coPhongVan(HoSoUngVien hs) {
    	for(PhongVan pv : dsPhongVan) {
    		if(pv != null && hs.equals(pv.getHoSo())) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    //xet duyet ho so ung vien, kiem tra yeu cau, tinh diem va cap nhat trang thai ung tuyen
    public ArrayList<KetQuaUngTuyen> xetDuyetHoSo() {
    	ArrayList<KetQuaUngTuyen> res = new ArrayList<>();
    	
    	if(dsHoSoUngVien == null || dsHoSoUngVien.isEmpty()) {
    		return res;
    	}
    	
    	for(HoSoUngVien hs : dsHoSoUngVien) {
    		if(hs == null) {
    			continue;
    		}
    		
    		KetQuaUngTuyen kq = layHoacTaoKetQua(hs);
    		if(kq == null) {
    			continue;
    		}
    		
    		String trangThai = kq.getTrangThaiUngTuyen();
    		
    		
    		if(!KetQuaUngTuyen.TT_CHO.equals(trangThai) && !KetQuaUngTuyen.TT_DAT_HO_SO.equals(trangThai)) {
    			continue;
    		}
    		
    		boolean dat = kiemTraYeuCau(hs);
    		
    		double diemHoSo = tinhDiemHoSo(hs);
    		double diemPhongVan = tinhDiemPhongVanTB(hs);
    		
    		kq.setDiemHoSo(diemHoSo);
    		kq.setDiemPhongVan(diemPhongVan);
    		kq.setDiemTongKet(HE_SO_HO_SO * diemHoSo + HE_SO_PHONG_VAN * diemPhongVan);
    		
    		kq.setNgayDanhGia(homNay());
    		
    		
    		if(dat) {
    			kq.capNhatTrangThai(KetQuaUngTuyen.TT_DAT_HO_SO);
    			res.add(kq);
    		} else {
    			kq.capNhatTrangThai(KetQuaUngTuyen.TT_LOAI);
    		}
    	}
    	return res;
    }
    
    //dem tong so ung vien co trang thai trung tuyen
    public int demSoTrungTuyen() {
    	int cnt = 0;
    	
    	if(dsKetQua == null) {
    		return 0;
    	}
    	
    	for(KetQuaUngTuyen kq : dsKetQua) {
    		if(kq != null && KetQuaUngTuyen.TT_TRUNGTUYEN.equals(kq.getTrangThaiUngTuyen())) {
    			cnt++;
    		}
    	}
    	
    	return cnt;
    }
    
    
    //kiem tra ung vien da hoan thanh va dat yeu cau cua cuoc phong van hay chua
    private boolean daDatVong(HoSoUngVien hs, int vong) {
    	if(hs == null || dsPhongVan == null) {
    		return false;
    	}
    	
    	for(PhongVan pv : dsPhongVan) {
    		if(pv == null || pv.getHoSo() == null) {
    			continue;
    		}
    		
    		boolean cungUngVien = hs.getMaHS().equals(pv.getHoSo().getMaHS());
    		boolean cungVong = pv.getVong() == vong;
    		boolean daPhongVan = PhongVan.TT_DA.equals(pv.getTrangThaiPhongVan());
    		boolean ketQuaDat = PhongVan.KQ_DAT.equals(pv.getKetQuaVongPhongVan());
    		
    		if(cungUngVien && cungVong && daPhongVan && ketQuaDat) {
    			return true;
    		}
    	}
    	return false;
    }
    
    //tao lich phong van cho ung vien du dieu kien o vong 1
    public int taoLichPhongVan(int vong, String ngay, String gio, String hinhThuc, String diaDiem,
    		String nguoiPV, ArrayList<HoSoUngVien> dsUngVien) {
    	if(vong < 1 || dsUngVien == null || dsHoSoUngVien == null || dsKetQua == null) {
    		return 0;
    	}
    	
    	int cnt = 0;
    	
    	for(HoSoUngVien hs : dsUngVien) {
    		if(hs == null || hs.getMaHS() == null || hs.getMaHS().trim().isEmpty()) {
    			continue;
    		}
    		
    		HoSoUngVien ungVien = timHoSo(hs.getMaHS());
    		
    		if(ungVien == null) {
    			continue;
    		}
    		
    		KetQuaUngTuyen kq = layHoacTaoKetQua(ungVien);
    		
    		if(kq == null) {
    			continue;
    		}
    		
    		String trangThai = kq.getTrangThaiUngTuyen();
    		
    		if(KetQuaUngTuyen.TT_LOAI.equals(trangThai)
    				|| KetQuaUngTuyen.TT_TRUNGTUYEN.equals(trangThai)
    				|| KetQuaUngTuyen.TT_KHONG_TRUNGTUYEN.equals(trangThai)) {
    			continue;
    			
    		}
    		
    		if(vong == 1) {
    			boolean duDieuKien = KetQuaUngTuyen.TT_DAT_HO_SO.equals(trangThai)
    					|| KetQuaUngTuyen.TT_PHONG_VAN.equals(trangThai);
    			if(!duDieuKien || daDatVong(ungVien, 1)) {
    				continue;
    			}
    		}
    		
    		
    		
    		if(vong > 1) {
    			if(!KetQuaUngTuyen.TT_PHONG_VAN.equals(trangThai) || !daDatVong(ungVien, vong - 1)
    					|| daDatVong(ungVien, vong)) {
    				continue;
    			}
    		}
    		
    		if(coiLichDangHoatDong(ungVien, vong)) {
    			continue;
    		}
    		
    		String maPhongVan = taoMaPhongVanMoi(vong, ungVien);
    		
    		PhongVan pv = new PhongVan(maPhongVan, ungVien, this, "", "",
    				hinhThuc, diaDiem, nguoiPV, PhongVan.TT_CHUA, 0, "", "");
    		
    		pv.setVong(vong);
    		
    		if(!pv.datLich(ngay, gio)) {
    			continue;
    		}
    		
    		if(themPhongVan(pv)) {
    			kq.capNhatTrangThai(KetQuaUngTuyen.TT_PHONG_VAN);
    			cnt++;
    		}
    	}
    	return cnt;
    }
    
    
    //loc va tra ve danh sach phong van theo so vong
    public ArrayList<PhongVan> layPhongVanTheoVong(int vong) {
    	ArrayList<PhongVan> res = new ArrayList<>();
    	
    	for(PhongVan pv : dsPhongVan) {
    		if(pv != null && pv.getVong() == vong) {
    			res.add(pv);
    		}
    	}
    	return res;
    }
    
    
    //lay danh sach ung vien theo so vong phong van
    public ArrayList<HoSoUngVien> layDanhSachUngVienPhongVan(int vong) {
    	ArrayList<HoSoUngVien> res = new ArrayList<>();
    	
    	for(PhongVan pv : layPhongVanTheoVong(vong)) {
    		if(pv.getHoSo() != null && !PhongVan.TT_HUY.equals(pv.getTrangThaiPhongVan())) {
    			res.add(pv.getHoSo());
    		}
    	}
    	return res;
    }
    
    
    //tim phong van va cham diem, cap nhat nhan xet cho ung vien
    public boolean chamDiemPhongVan(String maPV, double diem, String nhanXet) {
    	PhongVan pv = timPhongVan(maPV);
    	
    	if(pv == null || Double.isNaN(diem) || diem < 0 || diem > 10) {
    		return false;
    	}
    	
    	if(PhongVan.TT_HUY.equals(pv.getTrangThaiPhongVan())) {
    		return false;
    	}
    	
    	
    	return pv.chamDiem(diem, nhanXet);
    }
    
    //kiem tra phong van da hoan tat theo vong phong van
    private boolean kiemTraVongDaHoanTat(int vong) {
    	if(vong < 1 || dsPhongVan == null) {
    		return false;
    	}
    	
    	boolean coLich = false;
    	
    	for(PhongVan pv : dsPhongVan) {
    		if(pv == null || pv.getVong() != vong) {
    			continue;
    		}
    		
    		if(PhongVan.TT_HUY.equals(pv.getTrangThaiPhongVan())) {
    			continue;
    		}
    		
    		coLich = true;
    		
    		String ketQua = pv.getKetQuaVongPhongVan();
    		double diem = pv.getDiemPhongVan();
    		
    		if(pv.getHoSo() == null || !PhongVan.TT_DA.equals(pv.getTrangThaiPhongVan())
    				|| Double.isNaN(diem) || diem <0 || diem > 10
    				|| (!PhongVan.KQ_DAT.equals(ketQua) && !PhongVan.KQ_KHONG_DAT.equals(ketQua))) {
    			return false;
    		}
    	}
    	
    	return coLich;
    }
    
    
    //kiem tra xem trong danh sach vong van theo phong da cham diem chua
    private boolean kiemTraVongDaChamDiem(int vong) {
    	if(vong < 1 || dsPhongVan == null) {
    		return false;
    	}
    	
    	boolean coLichHopLe = false;
    	
    	for(PhongVan pv : dsPhongVan) {
    		if(pv == null || pv.getVong() != vong) {
    			continue;
    		}
    		
    		if(PhongVan.TT_HUY.equals(pv.getTrangThaiPhongVan())) {
    			continue;
    		}
    		
    		coLichHopLe = true;
    		
    		
    		double diem = pv.getDiemPhongVan();
    		
    		if(pv.getHoSo() == null || !PhongVan.TT_DA.equals(pv.getTrangThaiPhongVan())
    				|| Double.isNaN(diem) || diem < 0 || diem > 10) {
    			return false;
    		}
    		
    		
    	}
    	
    	return coLichHopLe;
    }
    
    //chot ket qua vong dua tren diem chuan, so vong phong van
    public ArrayList<HoSoUngVien> chotKetQuaVong(int vong, double diemChuan) {
    	ArrayList<HoSoUngVien> dsDat = new ArrayList<>();
    	
    	if(vong < 1 || Double.isNaN(diemChuan) || diemChuan < 0 || diemChuan > 10) {
    		return dsDat;
    	}
    	
    	if(!kiemTraVongDaChamDiem(vong)) {
    		return dsDat;
    	}
    	
    	
    	HashSet<String> maHoSoDaThem = new HashSet<>();
    	
    	for(PhongVan pv : layPhongVanTheoVong(vong)) {
    		
    		if(pv == null || pv.getVong() != vong || PhongVan.TT_HUY.equals(pv.getTrangThaiPhongVan())) {
    			continue;
    		}
    		
    		if(pv.getHoSo() == null) {
    			continue;
    		}
    		
    		
    		String ketQua = pv.getKetQuaVongPhongVan();
    		
    		if(ketQua == null || ketQua.trim().isEmpty()) {
    			ketQua = pv.kiemTraDat(diemChuan) ? PhongVan.KQ_DAT : PhongVan.KQ_KHONG_DAT;
    			
    			if(!pv.capNhatKetQua(ketQua)) {
    				continue;
    			}
    		}
    		
    		HoSoUngVien hs = pv.getHoSo();
    		
    		KetQuaUngTuyen kq = timKetQua(hs.getMaHS());
    		
    		if(PhongVan.KQ_DAT.equals(ketQua)) {
    			if(kq != null && KetQuaUngTuyen.TT_PHONG_VAN.equals(kq.getTrangThaiUngTuyen())) {
    				if(maHoSoDaThem.add(hs.getMaHS())) {
    					dsDat.add(hs);
    				}
    			}
    		} else if(PhongVan.KQ_KHONG_DAT.equals(ketQua)) {
    			if(kq != null) {
    				kq.capNhatTrangThai(KetQuaUngTuyen.TT_LOAI);
    			}
    		}
    		
    	}
    	
    	return dsDat;
    }
    
    //tinh diem trung binh phong van cua ung vien sau khi da hoan thanh cac vong phong van
    public double tinhDiemPhongVanTB(HoSoUngVien hs) {
    	if(hs == null) {
    		return 0;
    	}
    	
    	double tongDiem = 0;
    	int soLanPhongVan = 0;
    	
    	for(PhongVan pv : dsPhongVan) {
    		if(pv == null || pv.getHoSo() == null) {
    			continue;
    		}
    		
    		if(!hs.equals(pv.getHoSo())) {
    			continue;
    		}
    		
    		if(!PhongVan.TT_DA.equals(pv.getTrangThaiPhongVan())) {
    			continue;
    		}
    		
    		double diem = pv.getDiemPhongVan();
    		
    		if(Double.isNaN(diem) || diem < 0 || diem > 10) {
    			continue;
    		}
    		
    		tongDiem +=	diem;
    		soLanPhongVan++;
    	}
    	
    	return soLanPhongVan == 0 ? 0 : tongDiem / soLanPhongVan;
    }
    
    
    //tinh diem tong ket cua ung vien dua tren diem ho so va diem phong van
    public double tinhDiemTongKet(HoSoUngVien hs) {
    	if(hs == null) {
    		return 0;
    	}
    	
    	return HE_SO_HO_SO * tinhDiemHoSo(hs) + HE_SO_PHONG_VAN * tinhDiemPhongVanTB(hs);
    }
    
    
    //cap nhat lai ho so sau khi da co diem ho so, phong van, tong ket
    private void capNhatKetQua() {
    	if(dsKetQua == null) {
    		return;
    	}
    	
    	for(KetQuaUngTuyen kq : dsKetQua) {
    		if(kq == null || kq.getHoSo() == null) {
    			continue;
    		}
    		
    		HoSoUngVien hs = kq.getHoSo();
    		
    		double diemHoSo = tinhDiemHoSo(hs);
    		double diemPhongVan = tinhDiemPhongVanTB(hs);
    		double diemTongKet = tinhDiemTongKet(hs);
    		
    		
    		kq.setDiemHoSo(diemHoSo);
    		kq.setDiemPhongVan(diemPhongVan);
    		kq.setDiemTongKet(diemTongKet);
    	}
    }
    
    
    //lay diem cua ung vien theo tieu chi duoc chon
    private double layDiemTheoTieuChi(KetQuaUngTuyen kq, String tieuChi) {
    	if(kq == null) {
    		return 0;
    	}
    	if(TC_DIEM_HO_SO.equals(tieuChi)) {
    		return kq.getDiemHoSo();
    	}
    	
    	if(TC_DIEM_PHONG_VAN.equals(tieuChi)) {
    		return kq.getDiemPhongVan();
    	}
    	
    	return kq.getDiemTongKet();
    }
    
    
    //lay ma ho so cua ung vien tu ket qua ung tuyen 
    private String maHSCuaKetQua(KetQuaUngTuyen kq) {
    	if(kq == null || kq.getHoSo() == null || kq.getHoSo().getMaHS() == null) {
    		return "";
    	}
    	
    	return kq.getHoSo().getMaHS().trim();
    }
    
    
    //kiem da ung vien da dat toan bo cac vong phong vantu vong dau den vong cuoi hay chua
    private boolean daDatTatCaCacVong(HoSoUngVien hs, int vongCuoi) {
    	if(hs == null || vongCuoi < 1) {
    		return false;
    	}
    	
    	for(int vong = 1; vong <= vongCuoi; vong++) {
    		if(!daDatVong(hs, vong)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    
    ////kiem tra cac vong phong van da hoan tat het hay chua
    private boolean kiemTraCacVongDaHoanTat(int vongCuoi) {
    	if(vongCuoi < 1) {
    		return false;
    	}
    	
    	for(int vong = 1; vong <= vongCuoi; vong++) {
    		if(!kiemTraVongDaHoanTat(vong)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    //chot ket qua tyuen dung sau vong phong van cuoi cung
    public ArrayList<KetQuaUngTuyen> chotKetQuaTuyenDung(int vongCuoi) {
    	ArrayList<KetQuaUngTuyen> dsTrungTuyen = new ArrayList<>();
    	
    	if(vongCuoi < 1 || soLuong <= 0 || dsKetQua == null) {
    		return dsTrungTuyen;
    	}
    	
    	if(!kiemTraCacVongDaHoanTat(vongCuoi)) {
    		return dsTrungTuyen;
    	}
    	
    	capNhatKetQua();
    	
    	for(KetQuaUngTuyen kq : dsKetQua) {
    		if(kq != null && KetQuaUngTuyen.TT_TRUNGTUYEN.equals(kq.getTrangThaiUngTuyen())) {
    			dsTrungTuyen.add(kq);
    		}
    	}
    	
    	ArrayList<KetQuaUngTuyen> dsDuDieuKien = new ArrayList<>();
    	
    	for(KetQuaUngTuyen kq : dsKetQua) {
    		if(kq == null || kq.getHoSo() == null) {
    			continue;
    		}
    		
    		if(!KetQuaUngTuyen.TT_PHONG_VAN.equals(kq.getTrangThaiUngTuyen())) {
    			continue;
    		}
    		
    		if(daDatTatCaCacVong(kq.getHoSo(), vongCuoi)) {
    			dsDuDieuKien.add(kq);
    		}
    	}
    	
    	Collections.sort(dsDuDieuKien, soSanhXepHang(TC_TONG_DIEM));
    	
    	int chiTieuConLai = Math.max(0, soLuong - demSoTrungTuyen());
    	
    	
    	for(int i = 0; i < dsDuDieuKien.size(); i++) {
    		KetQuaUngTuyen kq = dsDuDieuKien.get(i);
    		
    		if(i < chiTieuConLai) {
    			kq.capNhatTrangThai(KetQuaUngTuyen.TT_TRUNGTUYEN);
    			
    			dsTrungTuyen.add(kq);
    		} else{
    			kq.capNhatTrangThai(KetQuaUngTuyen.TT_KHONG_TRUNGTUYEN);
    		}
    		
    		kq.setNgayDanhGia(homNay());
    	}
    			
    	return dsTrungTuyen;
    }
    //sap xep ket qua tuyen dung theo tieu chi duoc chon
    private Comparator<KetQuaUngTuyen> soSanhXepHang(final String tieuChi) {
    	return new Comparator<KetQuaUngTuyen>() {
			
			@Override
			public int compare(KetQuaUngTuyen o1, KetQuaUngTuyen o2) {
				if(o1 == o2) {
					return 0;
				}
				
				if(o1 == null) {
					return 1;
				}
				if(o2 == null) {
					return -1;
				}
				
				int c = Double.compare(layDiemTheoTieuChi(o2, tieuChi), layDiemTheoTieuChi(o1, tieuChi));
				
				if(c != 0) {
					return c;
				}
				
				c = Double.compare(o2.getDiemHoSo(), o1.getDiemHoSo());
				
				if(c != 0) {
					return c;
				}
				
				return maHSCuaKetQua(o1).compareTo(maHSCuaKetQua(o2));
			}
						
			
		};
    }
    
    //xep hang ung vien dua theo diem
    public ArrayList<KetQuaUngTuyen> xepHangUngVien(String tieuChi) {
    	
    	ArrayList<KetQuaUngTuyen> res = new ArrayList<>();
    	
    	if(!TC_TONG_DIEM.equals(tieuChi) && !TC_DIEM_HO_SO.equals(tieuChi)
    			&& !TC_DIEM_PHONG_VAN.equals(tieuChi)) {
    		return res;
    	}
    	
    	if(dsKetQua == null || dsKetQua.isEmpty()) {
    		return res;
    	}
    	
    	capNhatKetQua();
    	
    	
    	
    	for(KetQuaUngTuyen kq : dsKetQua) {
    		if(kq == null || kq.getHoSo() == null) {
    			continue;
    		}
    		
    		String trangThai = kq.getTrangThaiUngTuyen();
    		
    		if(KetQuaUngTuyen.TT_LOAI.equals(trangThai) || KetQuaUngTuyen.TT_KHONG_TRUNGTUYEN.equals(trangThai)) {
    			continue;
    		}
    		
    		res.add(kq);
    	}
    	
    	Collections.sort(res, soSanhXepHang(tieuChi));
    	
    	return res;
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
    
    public static void demoTuyenChon() {
    	
    	ViTriTuyenDung vt = new ViTriTuyenDung("Java Developer", "TPHCM", 2, 2500, 1200, "VT01", "Lap trinh backend");
    	
    	YC_KNghiem ycKN = new YC_KNghiem("Công nghệ thông tin", 2);
    	ycKN.setBatBuoc(true);
    	ycKN.setDoUuTien(5);
    	
    	YC_NgoaiNgu ycNN = new YC_NgoaiNgu("Tiếng Anh", "B2");
    	ycNN.setDoUuTien(3);
    	
    	vt.themYeuCau(ycKN);
    	vt.themYeuCau(ycNN);
    	
    	HoSoUngVien nam = new HoSoUngVien("HS01", "Trần Thành Nam", "7/9/2007", "TPHCM", "Nam", "Đại học",
    			"nam@gmail.com", "0987654321", "Kỹ sư", "Công nghệ thông tin", 1.70, 60.0);
    	nam.themKinhNghiem("Công nghệ thông tin", 3);
    	nam.themNgoaiNgu("Tiếng Anh", "B2");
    	
    	HoSoUngVien duong = new HoSoUngVien("HS02", "Trương Tùng Dương", "15/3/1996", "TPHCM", "Nam", "Đại học",
    			"duong@gmail.com", "0123456789", "Kỹ sư", "Công nghệ thông tin", 1.78, 72.0);
    	duong.themKinhNghiem("Công nghệ thông tin", 2);
    	duong.themNgoaiNgu("Tiếng Anh", "B1");
    	
    	
    	HoSoUngVien mai = new HoSoUngVien("HS03", "Lê Thị Mai", "25/11/2001", "TPHCM", "Nữ", "Thạc sĩ",
    			"mai@gmail.com", "0977888999", "Thạc sĩ", "Công nghệ thông tin", 1.65, 52.0);
    	mai.themKinhNghiem("Công nghệ thông tin", 5);
    	
    	HoSoUngVien hung = new HoSoUngVien("HS04", "Phạm Văn Hùng", "12/8/1998", "Hà Nội", "Nam", "Đại học",
    			"hung@gmail.com", "0934567890", "Kỹ sư", "Công nghệ thông tin", 1.72, 70.0);
    	hung.themKinhNghiem("Công nghệ thông tin", 4);
    	hung.themNgoaiNgu("Tiếng Anh", "C1");
      
    	System.out.println("=====  LOC HO SO =====");
    	System.out.println("Nộp hồ sơ: Nam=" + vt.nopHoSo(nam) + ", Dương=" + vt.nopHoSo(duong)
    			+ ", Mai=" + vt.nopHoSo(mai) + ", Hùng=" + vt.nopHoSo(hung));
    	
    	for(KetQuaUngTuyen kq : vt.xetDuyetHoSo()) {
    		System.out.println(kq);
    	}
    	
    	
    	System.out.println("\n=====  PHONG VAN VONG 1 (chuan 6.0) =====");
    	ArrayList<HoSoUngVien> dsMoi = new ArrayList<>(Arrays.asList(nam, duong, mai, hung));
    	
    	System.out.println("Số cuộc phỏng vấn tạo được: "
    			+ vt.taoLichPhongVan(1, "25/11/2026", "9:00", "Online", "Zoom", "Anh Hùng", dsMoi));
    	
    	vt.chamDiemPhongVan("VT01-V1-HS01", 8.0, "Tốt");
    	vt.chamDiemPhongVan("VT01-V1-HS02", 5.0, "Yếu kỹ thuật");
    	vt.chamDiemPhongVan("VT01-V1-HS03", 7.0, "Khá");
    	vt.chamDiemPhongVan("VT01-V1-HS04", 6.5, "Đạt");
    	
    	ArrayList<HoSoUngVien> dat1 = vt.chotKetQuaVong(1, 6.0);
    	System.out.print("Đạt vòng 1:");
    	for(HoSoUngVien hs : dat1) {
    		System.out.print(" " + hs.getHoTen() + ";");
    	}
    	System.out.println("\nTrạng thái Dương: " + vt.timKetQua("HS02").getTrangThaiUngTuyen() + " (mong đợi: Loai)");
    	
    	
    	
    	System.out.println("\n=====  PHONG VAN VONG 2 (chuan 7.0) =====");
    	System.out.println("Thử xếp Dương (đã bị loại) vào vòng 2, số cuộc tạo được: "
    			+ vt.taoLichPhongVan(2, "25/11/2026", "14:00", "Trực tiếp", "Phòng 301", "Chị Lan", new ArrayList<>(Arrays.asList(duong))) + " (mong đợi: 0)");
    	System.out.println("Số cuộc phỏng vấn vòng 2 tạo được: "
    			+ vt.taoLichPhongVan(2, "25/11/2026", "14:00", "Trực tiếp", "Phòng 301", "Chị Lan", dat1));
    	
    	vt.chamDiemPhongVan("VT01-V2-HS01", 9.0, "Rất tốt");
    	vt.chamDiemPhongVan("VT01-V2-HS03", 7.5, "Khá");
    	vt.chamDiemPhongVan("VT01-V2-HS04", 7.0, "Đạt");
    	
    	ArrayList<HoSoUngVien> dat2 = vt.chotKetQuaVong(2, 7.0);
    	System.out.print("Đạt vòng 2:");
    	for(HoSoUngVien hs : dat2) {
    		System.out.print(" " + hs.getHoTen() + ";");
    	}
    	System.out.println();
    	
    	for(PhongVan pv : vt.layPhongVanTheoVong(2)) {
    		System.out.println(pv);
    	}
    	
    	System.out.println("\n=====  XEP HANG =====");
    	String[] tieuChi = { TC_TONG_DIEM, TC_DIEM_PHONG_VAN, TC_DIEM_HO_SO };
    	
    	for(String tc : tieuChi) {
    		System.out.println("-- Theo " + tc + ":");
    		
    		int hang = 1;
    		for(KetQuaUngTuyen kq : vt.xepHangUngVien(tc)) {
    			System.out.println(hang++ + ". " + kq);
    		}
    	}
    	
    	
    	System.out.println("\n===== CHOT KET QUA TUYEN DUNG =====");

    	ArrayList<KetQuaUngTuyen> dsTrungTuyen =
    	        vt.chotKetQuaTuyenDung(2);

    	System.out.println("Danh sach trung tuyen:");

    	for (KetQuaUngTuyen kq : dsTrungTuyen) {
    	    System.out.println(kq);
    	}

    	System.out.println("Tong so trung tuyen: " + vt.demSoTrungTuyen());

    	System.out.println("\nTrang thai tat ca ung vien:");

    	for (KetQuaUngTuyen kq : vt.getDsKetQua()) {
    	    System.out.println(kq);
    	}
    	
    	
    	System.out.println("\n===== KIEM TRA CHOT LAN 2 =====");

    	ArrayList<KetQuaUngTuyen> dsTrungTuyenLan2 =
    	        vt.chotKetQuaTuyenDung(2);

    	System.out.println("So ung vien tra ve lan 2: "
    	        + dsTrungTuyenLan2.size());

    	System.out.println("Tong so trung tuyen: "
    	        + vt.demSoTrungTuyen());
    	
    	System.out.println("\n===== KIEM TRA HUY VA DAT LAI LICH =====");

    	ViTriTuyenDung vtTest = new ViTriTuyenDung(
    	        "Java Developer", "TPHCM", 1, 2500, 1200,
    	        "VT_TEST", "Kiem tra dat lai lich"
    	);

    	HoSoUngVien hsTest = new HoSoUngVien(
    	        "HS_TEST", "Ung vien Test", "1/1/2000",
    	        "TPHCM", "Nam", "Dai hoc",
    	        "test@gmail.com", "0900000000",
    	        "Ky su", "Cong nghe thong tin", 1.70, 60.0
    	);

    	// 1. Them ho so va xet duyet
    	System.out.println("Nop ho so: " + vtTest.nopHoSo(hsTest));
    	System.out.println("Ho so dat: " + vtTest.xetDuyetHoSo().size());

    	// 2. Tao lich phong van lan dau
    	String ngay1 = LocalDate.now().plusDays(1)
    	        .format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));

    	String ngay2 = LocalDate.now().plusDays(2)
    	        .format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));

    	int lanDau = vtTest.taoLichPhongVan(
    	        1, ngay1, "9:00", "Online",
    	        "Zoom", "Nguoi phong van", new ArrayList<>(Arrays.asList(hsTest))
    	);

    	System.out.println("Tao lich lan dau: " + lanDau);

    	// 3. Tim lich cu va huy
    	PhongVan pvCu = vtTest.timPhongVan("VT_TEST-V1-HS_TEST");

    	boolean huy = pvCu != null && pvCu.huyPhongVan();

    	System.out.println("Huy lich cu: " + huy);

    	// 4. Tao lai lich
    	int lanHai = vtTest.taoLichPhongVan(
    	        1, ngay2, "14:00", "Online",
    	        "Zoom", "Nguoi phong van", new ArrayList<>(Arrays.asList(hsTest))
    	);

    	System.out.println("Tao lai lich: " + lanHai);

    	// 5. Kiem tra lich cu va lich moi
    	for (PhongVan pv : vtTest.layPhongVanTheoVong(1)) {
    	    System.out.println(pv);
    	}

    	// 6. Cham diem lich moi va chot vong
    	boolean chamDiem = vtTest.chamDiemPhongVan(
    	        "VT_TEST-V1-HS_TEST-L2", 8.0, "Dat yeu cau"
    	);

    	System.out.println("Cham diem lich moi: " + chamDiem);

    	ArrayList<HoSoUngVien> dsDat = vtTest.chotKetQuaVong(1, 6.0);

    	System.out.println("So ung vien dat vong 1: " + dsDat.size());
    	
    	System.out.println("\n===== CHOT TUYEN DUNG SAU KHI DAT LAI LICH =====");

    	ArrayList<KetQuaUngTuyen> dsTrungTuyenTest =
    	        vtTest.chotKetQuaTuyenDung(1);

    	System.out.println("So ung vien trung tuyen: "
    	        + dsTrungTuyenTest.size());

    	System.out.println("Tong so trung tuyen: "
    	        + vtTest.demSoTrungTuyen());

    	System.out.println("Trang thai ung vien: "
    	        + vtTest.timKetQua("HS_TEST").getTrangThaiUngTuyen());
    	
    	
    	
    	
    	System.out.println("\n===== KIEM TRA CHAM DIEM HAI LAN =====");

    	boolean chamLanHai = vtTest.chamDiemPhongVan(
    	        "VT_TEST-V1-HS_TEST-L2", 9.0, "Cham lai"
    	);

    	System.out.println("Cham diem lan 2: " + chamLanHai);

    	PhongVan pvMoi = vtTest.timPhongVan(
    	        "VT_TEST-V1-HS_TEST-L2"
    	);

    	System.out.println("Diem hien tai: " + pvMoi.getDiemPhongVan());


    	System.out.println("\n===== KIEM TRA TAO LICH TRUNG =====");

    	int lichTrung = vtTest.taoLichPhongVan(
    	        1, ngay2, "14:00", "Online",
    	        "Zoom", "Nguoi phong van",
    	        new ArrayList<>(Arrays.asList(hsTest))
    	);

    	System.out.println("So lich trung duoc tao: " + lichTrung);
    	
    	System.out.println("\n===== KIEM TRA THEM LICH TRUNG TRUC TIEP =====");

    	PhongVan pvTrung = new PhongVan(
    	        "VT_TEST-V1-HS_TEST-L3",
    	        hsTest,
    	        vtTest,
    	        "",
    	        "",
    	        "Online",
    	        "Zoom",
    	        "Nguoi phong van",
    	        PhongVan.TT_CHUA,
    	        0,
    	        "",
    	        ""
    	);

    	pvTrung.setVong(1);
    	pvTrung.datLich(ngay2, "15:00");

    	boolean themTrung = vtTest.themPhongVan(pvTrung);

    	System.out.println("Them lich trung truc tiep: " + themTrung);
    	
    	System.out.println("\n===== KIEM TRA HUY PHONG VAN DA HOAN THANH =====");

    	PhongVan pvDaCham = vtTest.timPhongVan(
    	        "VT_TEST-V1-HS_TEST-L2"
    	);

    	boolean huySauCham = pvDaCham.huyPhongVan();

    	System.out.println("Huy lich da cham diem: " + huySauCham);

    	System.out.println("Trang thai hien tai: "
    	        + pvDaCham.getTrangThaiPhongVan());

    	System.out.println("Diem hien tai: "
    	        + pvDaCham.getDiemPhongVan());
    	
    	System.out.println("\n===== KIEM TRA SETTER PHONG VAN =====");

    	PhongVan pvSetter = new PhongVan(
    	        "PV_SETTER_TEST",
    	        hsTest,
    	        vtTest,
    	        ngay2,
    	        "15:00",
    	        "Online",
    	        "Zoom",
    	        "Nguoi phong van",
    	        PhongVan.TT_DA,
    	        8.0,
    	        "Tot",
    	        PhongVan.KQ_DAT
    	);


    	System.out.println("Trang thai: " + pvSetter.getTrangThaiPhongVan());
    	System.out.println("Diem: " + pvSetter.getDiemPhongVan());
    	System.out.println("Ket qua: " + pvSetter.getKetQuaVongPhongVan());
    	
    	
    	System.out.println("\n===== KIEM TRA CONSTRUCTOR KHONG HOP LE =====");

    	PhongVan pvSai = new PhongVan(
    	        "PV_SAI",
    	        hsTest,
    	        vtTest,
    	        "99/99/2026",
    	        "25:99",
    	        "Online",
    	        "Zoom",
    	        "Nguoi phong van",
    	        PhongVan.TT_DA,
    	        8.0,
    	        "Tot",
    	        PhongVan.KQ_DAT
    	);

    	System.out.println("Trang thai: " + pvSai.getTrangThaiPhongVan());
    	System.out.println("Diem: " + pvSai.getDiemPhongVan());
    	System.out.println("Ket qua: " + pvSai.getKetQuaVongPhongVan());
    	
    	System.out.println("\n===== KIEM TRA QUY TRINH CHAM DIEM =====");

    	PhongVan pvApiTest = new PhongVan(
    	        "PV_API_TEST",
    	        hsTest,
    	        vtTest,
    	        "",
    	        "",
    	        "Online",
    	        "Zoom",
    	        "Nguoi phong van",
    	        PhongVan.TT_CHUA,
    	        0,
    	        "",
    	        ""
    	);

    	// Tao lich hop le
    	System.out.println("Tao lich: "
    	        + pvApiTest.datLich(ngay2, "16:00"));

    	// Thu cap nhat ket qua truoc khi cham diem
    	System.out.println("Cap nhat ket qua truoc cham diem: "
    	        + pvApiTest.capNhatKetQua(PhongVan.KQ_DAT));

    	// Cham diem
    	System.out.println("Cham diem: "
    	        + pvApiTest.chamDiem(8.5, "Tot"));

    	// Thu cap nhat ket qua khong hop le
    	System.out.println("Cap nhat ket qua sai: "
    	        + pvApiTest.capNhatKetQua("Khong hop le"));

    	// Cap nhat ket qua hop le
    	System.out.println("Cap nhat ket qua dung: "
    	        + pvApiTest.capNhatKetQua(PhongVan.KQ_DAT));

    	// Thu thay doi ket qua lan hai
    	System.out.println("Cap nhat ket qua lan hai: "
    	        + pvApiTest.capNhatKetQua(PhongVan.KQ_KHONG_DAT));
    	
    	System.out.println("\n===== KIEM TRA GIOI HAN DIEM =====");

    	PhongVan pvDiemTest = new PhongVan(
    	        "PV_DIEM_TEST",
    	        hsTest,
    	        vtTest,
    	        "",
    	        "",
    	        "Online",
    	        "Zoom",
    	        "Nguoi phong van",
    	        PhongVan.TT_CHUA,
    	        0,
    	        "",
    	        ""
    	);

    	pvDiemTest.datLich(ngay2, "17:00");

    	System.out.println("Diem -1: "
    	        + pvDiemTest.chamDiem(-1, "Test"));

    	System.out.println("Diem 10.1: "
    	        + pvDiemTest.chamDiem(10.1, "Test"));

    	System.out.println("Diem NaN: "
    	        + pvDiemTest.chamDiem(Double.NaN, "Test"));

    	System.out.println("Diem duong vo cung: "
    	        + pvDiemTest.chamDiem(Double.POSITIVE_INFINITY, "Test"));

    	System.out.println("Diem 10: "
    	        + pvDiemTest.chamDiem(10.0, "Test"));

    	System.out.println("Diem cuoi cung: "
    	        + pvDiemTest.getDiemPhongVan());
    	
    	System.out.println("\n===== KIEM TRA NGAY GIO DAT LICH =====");

    	PhongVan pvLichTest = new PhongVan(
    	        "PV_LICH_TEST", hsTest, vtTest,
    	        "", "", "Online", "Zoom",
    	        "Nguoi phong van", PhongVan.TT_CHUA,
    	        0, "", ""
    	);

    	System.out.println("Ngay khong hop le: "
    	        + pvLichTest.datLich("99/99/2026", "9:00"));

    	System.out.println("Gio khong hop le: "
    	        + pvLichTest.datLich(ngay2, "25:99"));

    	System.out.println("Ngay da qua: "
    	        + pvLichTest.datLich("20/11/2026", "9:00"));

    	System.out.println("Gio da qua trong hom nay: "
    	        + pvLichTest.datLich("21/11/2026", "00:01"));

    	System.out.println("Dat lich tuong lai: "
    	        + pvLichTest.datLich(ngay2, "9:00"));

    	System.out.println("Doi lich: "
    	        + pvLichTest.doiLich(ngay2, "10:00"));

    	System.out.println("Ngay sau doi: "
    	        + pvLichTest.getNgayPhongVan());

    	System.out.println("Gio sau doi: "
    	        + pvLichTest.getGioPhongVan());

    	System.out.println("Cham diem: "
    	        + pvLichTest.chamDiem(7.5, "Tot"));

    	System.out.println("Doi lich sau khi da phong van: "
    	        + pvLichTest.doiLich(ngay2, "11:00"));
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
    	
    	System.out.println();
    	
    	demoTuyenChon();
	}
    
    
}