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
            String trinhDoHocVan, String email, String soDienThoai, String bangCap, String chuyenNghanh,
            double chieuCao, double canNang) {
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
     * 
     */
    //Chuyển ngày sinh từ kiểu String sang LocalDate thông qua TienIch.parseNgay()
    public int tinhTuoi() {
        LocalDate sinh = TienIch.parseNgay(ngaySinh);
        if (sinh == null || sinh.isAfter(LocalDate.now())) {
            return -1;
        }

        return Period.between(sinh, LocalDate.now()).getYears();
    }

    /**
     * @param linhvuc
     * @param soNam
     * @return
     */
    //Tìm kiếm một khóa trong HashMap theo tên được truyền vào
    //Sử dụng TienIch.khop() để so sánh, không phân biệt chữ hoa, chữ thường, dấu tiếng Việt và khoảng trắng thừa.
    public String timKhoa(HashMap<String, ?> ds, String ten) {
        if (ds == null || ten == null || ten.trim().isEmpty()) {
            return null;
        }

        for (String key : ds.keySet()) {
            if (TienIch.khop(key, ten)) {
                return key;
            }
        }

        return null;
    }
    //Thêm số năm kinh nghiệm của ứng viên
    public void themKinhNghiem(String linhVuc, int soNam) {
        if (linhVuc == null || linhVuc.trim().isEmpty() || soNam < 0) {
            return;
        }

        if (linhVuc_KNghiem == null) {
            linhVuc_KNghiem = new HashMap<String, Integer>();
        }

        String khoa = timKhoa(linhVuc_KNghiem, linhVuc);

        if (khoa == null) {
            khoa = linhVuc.trim();
        }

        linhVuc_KNghiem.put(khoa, soNam);

    }

    /**
     * @param linhvuc
     * @return
     */
    
    //Tìm số năm kinh nghiệm của ứng viên theo lĩnh vực
    public int laySoNamKinhNghiem(String linhVuc) {
        if (linhVuc == null || linhVuc.trim().isEmpty() || linhVuc_KNghiem == null) {
            return 0;
        }

        String khoa = timKhoa(linhVuc_KNghiem, linhVuc);
        if (khoa == null) {
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
    //Thêm tên ngoại ngữ và trình độ
    public void themNgoaiNgu(String ten, String trinhDo) {
        if (ten == null || trinhDo == null || ten.trim().isEmpty() || trinhDo.trim().isEmpty()) {
            return;
        }

        if (dsNgoaiNgu == null) {
            dsNgoaiNgu = new HashMap<String, String>();
        }

        String khoa = timKhoa(dsNgoaiNgu, ten);
        if (khoa == null) {
            khoa = ten.trim();
        }
        dsNgoaiNgu.put(khoa, trinhDo.trim());

    }

    
    //Tìm trình độ của một ngoại ngữ
    public String layTrinhDoNgoaiNgu(String ten) {
        if (ten == null || ten.trim().isEmpty() || dsNgoaiNgu == null) {
            return null;
        }

        String khoa = timKhoa(dsNgoaiNgu, ten);

        return khoa == null ? null : dsNgoaiNgu.get(khoa);
    }

    /**
     * @param qt
     * @return
     */
    
    //Thêm một quá trình làm việc
    public void themQuaTrinhLamViec(QuaTrinhLamViec qt) {
        if (qt == null || !qt.hopLe()) {
            return;
        }

        if (quaTrinhLamViec == null) {
            quaTrinhLamViec = new Stack<QuaTrinhLamViec>();
        }

        quaTrinhLamViec.push(qt);

    }

    /**
     * @return
     */
    
    
    //lấy ra quá trình làm việc gần đây
    public QuaTrinhLamViec layQuaTrinhLamViec() {
        if (quaTrinhLamViec == null || quaTrinhLamViec.isEmpty()) {
            return null;
        }

        return quaTrinhLamViec.peek();
    }

    /**
     * @param yc
     * @return
     */
    
    //Kiểm tra hồ sơ ứng viên có thỏa mãn một yêu cầu tuyển dụng hay không
    public boolean kiemTraYeuCau(AYeuCauTuyenDung yc) {
        return yc != null && yc.kiemTra(this);
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
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
        if (diaChi == null) {
            return;
        }

        this.diaChiThuongTru = diaChi;

    }

    
    //tính số tháng làm việc của một lĩnh vực
    public int tinhSoThangLamViec(String linhVuc) {
        return ThongKeKinhNghiem.tinhSoThang(this, linhVuc);
    }
    
    
    //lấy số năm kinh nghiệm của một lĩnh vực
    public int laySoNamKinhNghiemTongHop(String linhVuc) {
        return Math.max(laySoNamKinhNghiem(linhVuc), tinhSoThangLamViec(linhVuc) / 12);
    }

    
    //nội dung tóm tắt kinh nghiệm của ứng viên theo lĩnh vực, gồm số thấng, số năm làm việc, chức vụ
    public String tomTatKinhNghiem(String linhVuc) {
        int thang = tinhSoThangLamViec(linhVuc);
        
        int thangKinhNghiem = laySoNamKinhNghiem(linhVuc) * 12;
        
        int tongThang = Math.max(thang, thangKinhNghiem);
        if(tongThang == 0) {
        	return hoTen + ": chua co kinh nghiem trong linh vuc " + linhVuc;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(hoTen).append(": ");
        
        if (tongThang >= 12) {
            sb.append(tongThang / 12).append(" năm ");
        }
        if (tongThang % 12 > 0) {
            sb.append(tongThang % 12).append(" tháng ");
        }
        sb.append("trong lĩnh vực ").append(linhVuc);
        
        ArrayList<QuaTrinhLamViec> ds = ThongKeKinhNghiem.layQuaTrinhTheoLinhVuc(this, linhVuc);
        
        if(!ds.isEmpty()) {
        	sb.append(". Chức vụ: ");
        	String dau = "";
        	for (QuaTrinhLamViec qt : ds) {
            sb.append(dau).append(qt.getViTri());
            dau = ", ";
        	
        }
        
        }
        return sb.toString();
    }

    
    //liệt kê lĩnh vực ứng viên tứng làm
    public String tomTatLinhVuc() {
        if (quaTrinhLamViec == null || quaTrinhLamViec.isEmpty()) {
            return "Chua co kinh nghiem";
        }

        LinkedHashMap<String, String> dsLinhVuc = new LinkedHashMap<>();

        for (QuaTrinhLamViec qt : quaTrinhLamViec) {
            if (qt == null) {
                continue;
            }

            String lv = qt.getLinhVuc();

            if (lv == null || lv.trim().isEmpty()) {
                continue;
            }

            lv = lv.trim();

            String khoa = TienIch.chuanHoa(lv);

            if (!khoa.isEmpty()) {
                dsLinhVuc.putIfAbsent(khoa, lv);
            }
        }

        if (dsLinhVuc.isEmpty()) {
            return "Chua co linh vuc kinh nghiem hop le";
        }

        return String.join(", ", dsLinhVuc.values());
    }

    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("Ma ho so: ").append(maHS).append(", ");
    	sb.append("Ho ten: ").append(hoTen).append(", ");
    	sb.append("Ngay sinh: ").append(ngaySinh).append(", ");
    	sb.append("Tuoi: ").append(tinhTuoi()).append(", ");
    	sb.append("Dia chi thuong tru: ").append(diaChiThuongTru).append(", ");
    	sb.append("Gioi tinh: ").append(gioiTinh).append(", ");
    	sb.append("Trinh do hoc van: ").append(trinhDoHocVan).append(", ");
    	sb.append("Email: ").append(email).append(", ");
    	sb.append("So dien thoai: ").append(soDienThoai).append(", ");
    	sb.append("Bang cap: ").append(bangCap).append(", ");
    	sb.append("Chuyen nganh: ").append(chuyenNghanh).append(", ");
    	sb.append("Chieu cao: ").append(chieuCao).append(" m, ");
    	sb.append("Can nang: ").append(canNang).append(" kg\n");
    	
    	sb.append("Kinh nghiem theo linh vuc\n");
    	sb.append(linhVuc_KNghiem == null ? "Chua co" : linhVuc_KNghiem);
    	
    	sb.append("\nNgoai ngu\n");
    	sb.append(dsNgoaiNgu == null ? "Chua co" : dsNgoaiNgu);
    	
    	sb.append("\nQua trinh lam viec\n");
    	if(quaTrinhLamViec == null || quaTrinhLamViec.isEmpty()) {
    		sb.append("Chua co qua trinh lam viec");
    	} else {
    		for(int i = 0; i < quaTrinhLamViec.size(); i++) {
    			sb.append(i + 1).append(", ");
    			sb.append(quaTrinhLamViec.get(i));
    		}
    	}
    	
    	return sb.toString();
    }

    public static void main(String[] args) {
    	HoSoUngVien a = new HoSoUngVien(
                "HS01", "Trần Thành Nam", "7/9/2007", "TPHCM", "Nam",
                "Đại học", "nam@gmail.com", "0987654321", "Kỹ sư",
                "Công nghệ thông tin", 1.75, 60.0);

        a.themKinhNghiem("Marketing", 2);

        a.themQuaTrinhLamViec(new QuaTrinhLamViec(
                "1/1/2020", "31/12/2021", "Nhân viên MKT",
                "ABC", "0900000000", "", "", "Marketing"));

        a.themQuaTrinhLamViec(new QuaTrinhLamViec(
                "1/1/2022", "1/7/2023", "Trưởng nhóm MKT",
                "ABC", "0900000000", "", "", "Marketing"));

        a.themQuaTrinhLamViec(new QuaTrinhLamViec(
                "1/1/2023", "31/12/2023", "Lập trình viên",
                "XYZ", "0900000000", "", "", "IT"));

        a.themNgoaiNgu("Tiếng Anh", "B2");

        HoSoUngVien hs = new HoSoUngVien(
                "HS002", "Trương Tùng Dương", "15/3/2004", "TPHCM", "Nam",
                "Đại học", "gay@gmail.com", "0123456789", "Kỹ sư",
                "Công nghệ thông tin", 1.72, 64.0);

        hs.themKinhNghiem("Java", 2);
        hs.themNgoaiNgu("Tiếng Anh", "B2");

        hs.themQuaTrinhLamViec(new QuaTrinhLamViec(
                "1/1/2023", "31/12/2023", "Java Developer",
                "Dương Tech", "0363636363", "", "",
                "Công nghệ thông tin"));

        
        System.out.println(a);
        System.out.println(hs);
        
 

        System.out.println("Tuoi Tran Thanh Nam: " + a.tinhTuoi());
        System.out.println("Tuoi Truong Tung Duong: " + hs.tinhTuoi());
        
        System.out.println("\n----- TIM KHOA -----");
        
        System.out.println("Tim khoa Marketing: "
                + a.timKhoa(a.getLinhVuc_KNghiem(), "marketing"));

        System.out.println("Tim khoa khong ton tai: "
                + a.timKhoa(a.getLinhVuc_KNghiem(), "Ke toan"));
        
        
        
        
        
        System.out.println("\n-----  KINH NGHIEM -----");
        
        System.out.println("Kinh nghiem Marketing: "
                + a.laySoNamKinhNghiem("Marketing"));

        System.out.println("Kinh nghiem IT: "
                + a.laySoNamKinhNghiem("IT"));

        System.out.println("Kinh nghiem khong ton tai: "
                + a.laySoNamKinhNghiem("Ke toan"));

        a.themKinhNghiem("Java", 3);

        System.out.println("Sau khi them Java: "
                + a.laySoNamKinhNghiem("Java"));

        a.themKinhNghiem("Marketing", 4);

        System.out.println("Sau khi cap nhat Marketing: "
                + a.laySoNamKinhNghiem("Marketing"));

        a.themKinhNghiem("C#", -1);

        System.out.println("Kinh nghiem C# sau khi them -1: "
                + a.laySoNamKinhNghiem("C#"));
        
        
        
        
        System.out.println("\n----- NGOAI NGU -----");

        System.out.println("Trinh do tieng Anh: "
                + a.layTrinhDoNgoaiNgu("Tiếng Anh"));

        System.out.println("Ngoai ngu khong ton tai: "
                + a.layTrinhDoNgoaiNgu("Tiếng Nhật"));

        a.themNgoaiNgu("Tiếng Nhật", "N3");

        System.out.println("Sau khi them tieng Nhat: "
                + a.layTrinhDoNgoaiNgu("Tiếng Nhật"));

        a.themNgoaiNgu("Tiếng Anh", "C1");

        System.out.println("Sau khi cap nhat tieng Anh: "
                + a.layTrinhDoNgoaiNgu("Tiếng Anh"));
        
        
        
        System.out.println("\n-----  QUA TRINH LAM VIEC -----");

        System.out.println("So qua trinh cua Nam: "
                + a.getQuaTrinhLamViec().size());

        System.out.println("Qua trinh gan nhat cua Nam: "
                + a.layQuaTrinhLamViec());

        System.out.println("Qua trinh cua Duong: "
                + hs.layQuaTrinhLamViec());

        a.themQuaTrinhLamViec(null);

        System.out.println("So qua trinh sau khi them null: "
                + a.getQuaTrinhLamViec().size());
        
        
        System.out.println("\n-----  THONG KE KINH NGHIEM -----");

        System.out.println(a.tomTatKinhNghiem("marketing"));

        System.out.println("So thang Marketing: "
                + a.tinhSoThangLamViec("Marketing"));

        System.out.println("So thang IT: "
                + a.tinhSoThangLamViec("IT"));

        System.out.println("So nam kinh nghiem tong hop Marketing: "
                + a.laySoNamKinhNghiemTongHop("Marketing"));

        System.out.println("So nam kinh nghiem tong hop Java cua Duong: "
                + hs.laySoNamKinhNghiemTongHop("Java"));

        System.out.println("Cac linh vuc cua Nam: "
                + a.tomTatLinhVuc());

        System.out.println("Tong thang moi linh vuc: "
                + ThongKeKinhNghiem.tinhTongSoThang(a));

        
        
    }
    
    
    

}