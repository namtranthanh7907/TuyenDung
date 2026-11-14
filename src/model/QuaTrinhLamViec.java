package model;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * 
 */
public class QuaTrinhLamViec {
	
	private static final DateTimeFormatter FORMAT_NGAY = DateTimeFormatter.ofPattern("d/M/uuuu")
			.withResolverStyle(ResolverStyle.STRICT);

    /**
     * Default constructor
     */
    public QuaTrinhLamViec() {
    }

    /**
     * 
     */
    private String tgianBD;

    /**
     * 
     */
    private String tgKetThuc;

    /**
     * 
     */
    private String viTri;

    /**
     * 
     */
    private String tenCongTy;

    /**
     * 
     */
    private String sdt_nguoiLH;

    /**
     * 
     */
    private String moTaCongViec;

    /**
     * 
     */
    private String thanhTich;
    
    private String linhVuc;



    
	public QuaTrinhLamViec(String tgianBD, String tgKetThuc, String viTri, String tenCongTy, String sdt_nguoiLH,
			String moTaCongViec, String thanhTich, String linhVuc) {
		super();
		this.tgianBD = tgianBD;
		this.tgKetThuc = tgKetThuc;
		this.viTri = viTri;
		this.tenCongTy = tenCongTy;
		this.sdt_nguoiLH = sdt_nguoiLH;
		this.moTaCongViec = moTaCongViec;
		this.thanhTich = thanhTich;
		this.linhVuc = linhVuc;
	}
	
	

	public String getLinhVuc() {
		return linhVuc;
	}



	public void setLinhVuc(String linhVuc) {
		this.linhVuc = linhVuc;
	}



	public String getTgianBD() {
		return tgianBD;
	}


	public void setTgianBD(String tgianBD) {
		this.tgianBD = tgianBD;
	}


	public String getTgKetThuc() {
		return tgKetThuc;
	}


	public void setTgKetThuc(String tgKetThuc) {
		this.tgKetThuc = tgKetThuc;
	}


	public String getViTri() {
		return viTri;
	}


	public void setViTri(String viTri) {
		this.viTri = viTri;
	}


	public String getTenCongTy() {
		return tenCongTy;
	}


	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}


	public String getSdt_nguoiLH() {
		return sdt_nguoiLH;
	}


	public void setSdt_nguoiLH(String sdt_nguoiLH) {
		this.sdt_nguoiLH = sdt_nguoiLH;
	}


	public String getMoTaCongViec() {
		return moTaCongViec;
	}


	public void setMoTaCongViec(String moTaCongViec) {
		this.moTaCongViec = moTaCongViec;
	}


	public String getThanhTich() {
		return thanhTich;
	}


	public void setThanhTich(String thanhTich) {
		this.thanhTich = thanhTich;
	}
	
	
	//Gọi TienIch.parseNgay() để chuyển chuỗi ngày thành LocalDate
	public LocalDate layNgayBatDau() {
		return TienIch.parseNgay(tgianBD);
	}
	
	
	//Kiểm tra trạng thái làm việc thông qua tinhTrangLamViec() và chuyển chuỗi thành LocalDate
	public LocalDate layNgayKetThuc() {
		if(tinhTrangLamViec()) {
			return LocalDate.now();
		}
		return TienIch.parseNgay(tgKetThuc);
	}

	/**
     * @return
     */

    /**
     * @return
     */
	
	//Xác định ứng viên còn đang làm việc hay không.
    public boolean tinhTrangLamViec() {
    	if (tgKetThuc == null || tgKetThuc.trim().isEmpty()) {
            return true;
        }
        String ketThuc = TienIch.chuanHoa(tgKetThuc);
        
        return "nay".equals(ketThuc)
        		|| "hien tai".equals(ketThuc)
        		|| "present".equals(ketThuc);
    }
    
    
    
    //Kiểm tra tính hợp lệ của khoảng thời gian làm việc.
    public boolean hopLe() {
    	LocalDate batDau = layNgayBatDau();
    	LocalDate ketThuc = layNgayKetThuc();
    	
    	return batDau != null && ketThuc != null && !ketThuc.isBefore(batDau);
    }

    
    //Tính số tháng làm việc của một quá trình
    public int tinhSoThangLamViec() {
    	if(!hopLe()) {
    		return 0;
    	}
    	
    	LocalDate batDat = layNgayBatDau();
    	LocalDate ketThuc = layNgayKetThuc();
    	long soThang = ChronoUnit.MONTHS.between(batDat, ketThuc.plusDays(1));
    	
    	if(soThang <= 0) {
    		return 0;
    	}
    	
    	return soThang > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) soThang;
    }
    
    /**
     * @param vitri
     * @return
     */
    
    
    //Cập nhật chức vụ của ứng viên trong quá trình làm việc
    public void capNhatQuaTrinhLamViec(String vitriMoi) {
        if(vitriMoi == null || vitriMoi.trim().isEmpty()) {
        	return;
        }
        this.viTri = vitriMoi.trim();
    }
    
    public String toString() {
    	return viTri + " tai " + tenCongTy + " (" + tgianBD + " - " + (tinhTrangLamViec() ? "nay" : tgKetThuc)
    			+ "), linh vuc: " + linhVuc;
    }
    
    public static void main(String[] args) {
    	QuaTrinhLamViec qt1 = new QuaTrinhLamViec(
                "1/1/2020", "31/12/2021",
                "Nhân viên MKT", "ABC",
                "0900000000", "Nghiên cứu thị trường",
                "Hoàn thành dự án", "Marketing");

        QuaTrinhLamViec qt2 = new QuaTrinhLamViec(
                "1/1/2022", "Nay",
                "Trưởng nhóm MKT", "ABC",
                "0900000000", "Quản lý nhóm",
                "Đạt KPI", "Marketing");
        
        
        System.out.println("Qua trinh 1: " + qt1);
        System.out.println("Qua trinh 2: " + qt2);
        
        
        System.out.println("\n-----  CHUYEN DOI NGAY -----");

        System.out.println("Ngay bat dau qt1: "
                + qt1.layNgayBatDau().format(FORMAT_NGAY));

        System.out.println("Ngay ket thuc qt1: "
                + qt1.layNgayKetThuc().format(FORMAT_NGAY));

        System.out.println("Ngay bat dau qt2: "
                + qt2.layNgayBatDau().format(FORMAT_NGAY));

        System.out.println("Ngay ket thuc qt2: "
                + qt2.layNgayKetThuc().format(FORMAT_NGAY));

        QuaTrinhLamViec ngaySai = new QuaTrinhLamViec(
                "31/2/2023", "1/3/2023",
                "Tester", "ABC", "0900000000",
                "", "", "IT");

        System.out.println("Ngay khong hop le: "
                + ngaySai.layNgayBatDau());
        
        
        
        
        
        System.out.println("\n-----  TINH TRANG LAM VIEC -----");

        System.out.println("Qt1 da ket thuc: "
                + !qt1.tinhTrangLamViec());

        System.out.println("Qt2 dang lam viec: "
                + qt2.tinhTrangLamViec());

        QuaTrinhLamViec qtHienTai = new QuaTrinhLamViec(
                "1/1/2024", "Hiện tại",
                "Developer", "ABC",
                "0900000000", "", "", "IT");

        QuaTrinhLamViec qtPresent = new QuaTrinhLamViec(
                "1/1/2024", "Present",
                "Developer", "ABC",
                "0900000000", "", "", "IT");

        QuaTrinhLamViec qtRong = new QuaTrinhLamViec(
                "1/1/2024", "",
                "Developer", "ABC",
                "0900000000", "", "", "IT");

        System.out.println("Dang lam viec voi Hien tai: "
                + qtHienTai.tinhTrangLamViec());

        System.out.println("Dang lam viec voi Present: "
                + qtPresent.tinhTrangLamViec());

        System.out.println("Dang lam viec voi ngay ket thuc rong: "
                + qtRong.tinhTrangLamViec());
        
        
        
        System.out.println("\n-----  HOP LE -----");

        System.out.println("Qt1 hop le: " + qt1.hopLe());
        System.out.println("Qt2 hop le: " + qt2.hopLe());
        System.out.println("Qt sai ngay bat dau: " + ngaySai.hopLe());

        QuaTrinhLamViec ngayNguoc = new QuaTrinhLamViec(
                "1/5/2023", "1/4/2023",
                "Tester", "ABC",
                "0900000000", "", "", "IT");

        System.out.println("Ngay ket thuc truoc ngay bat dau: "
                + ngayNguoc.hopLe());
        
        
        
        
        
        System.out.println("\n-----  TINH SO THANG LAM VIEC -----");

        System.out.println("So thang qt1: "
                + qt1.tinhSoThangLamViec());

        System.out.println("So thang qt2: "
                + qt2.tinhSoThangLamViec());

        System.out.println("So thang ngay khong hop le: "
                + ngaySai.tinhSoThangLamViec());

        System.out.println("So thang ngay ket thuc truoc ngay bat dau: "
                + ngayNguoc.tinhSoThangLamViec());
        
        
        
        
        
	}
}