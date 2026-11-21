package test;




import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import model.*;

public class TestRunner {

    private static int soPass = 0;
    private static int soFail = 0;

    // Tao mot vi tri tuyen dung de kiem thu
    private static ViTriTuyenDung taoViTri(int chiTieu) {
        return new ViTriTuyenDung(
                "Java Developer",
                "TPHCM",
                chiTieu,
                2500,
                1200,
                "VT_TEST",
                "Kiem thu"
        );
    }

    // Tao ho so ung vien
    private static HoSoUngVien taoHoSo(String maHS) {
        return new HoSoUngVien(
                maHS,
                "Ung vien " + maHS,
                "1/1/2000",
                "TPHCM",
                "Nam",
                "Dai hoc",
                "test@gmail.com",
                "0900000000",
                "Ky su",
                "Cong nghe thong tin",
                1.70,
                60.0
        );
    }

    // Tao ngay tuong lai
    private static String ngayTuongLai(int soNgay) {
        return LocalDate.now().plusDays(soNgay)
                .format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
    }

    // In ket qua kiem thu
    private static void kiemTra(String ten, boolean ketQua) {
        if (ketQua) {
            soPass++;
            System.out.println("[PASS] " + ten);
        } else {
            soFail++;
            System.out.println("[FAIL] " + ten);
        }
    }

    private static boolean bangNhau(double a, double b) {
        return Math.abs(a - b) < 0.0001;
    }

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" TEST RUNNER - VI TRI TUYEN DUNG");
        System.out.println("====================================");


        // TEST 01: Them ho so hop le
        ViTriTuyenDung vt1 = taoViTri(2);
        HoSoUngVien hs1 = taoHoSo("HS01");

        kiemTra("Them ho so hop le",
                vt1.nopHoSo(hs1));


        // TEST 02: Khong cho them ho so trung ma
        kiemTra("Khong cho them ho so trung ma",
                !vt1.nopHoSo(taoHoSo("HS01"))
                && vt1.demSoLuongUngVien() == 1);


        // TEST 03: Tim ho so
        kiemTra("Tim ho so theo ma",
                vt1.timHoSo("HS01") == hs1);


        // TEST 04: Xoa ho so
        ViTriTuyenDung vt2 = taoViTri(2);
        vt2.nopHoSo(taoHoSo("HS02"));

        kiemTra("Xoa ho so ton tai",
                vt2.xoaHoSo("HS02")
                && vt2.timHoSo("HS02") == null);


        // TEST 05: Tu choi ho so null va ma rong
        ViTriTuyenDung vt3 = taoViTri(2);

        kiemTra("Kiem tra ho so null va ma rong",
                !vt3.nopHoSo(null)
                && !vt3.nopHoSo(taoHoSo(" ")));


        // TEST 06: Diem ho so khi khong co yeu cau
        ViTriTuyenDung vt4 = taoViTri(2);
        HoSoUngVien hs4 = taoHoSo("HS04");
        vt4.nopHoSo(hs4);

        kiemTra("Diem ho so khi khong co yeu cau = 10",
                bangNhau(vt4.tinhDiemHoSo(hs4), 10.0));


        // TEST 07: Xet duyet ho so
        ViTriTuyenDung vt5 = taoViTri(2);
        HoSoUngVien hs5 = taoHoSo("HS05");
        vt5.nopHoSo(hs5);

        ArrayList<KetQuaUngTuyen> dsKQ5 = vt5.xetDuyetHoSo();

        kiemTra("Xet duyet ho so dat",
                dsKQ5.size() == 1
                && KetQuaUngTuyen.TT_DAT_HO_SO.equals(
                        dsKQ5.get(0).getTrangThaiUngTuyen()));


        // TEST 08: Tao lich va ngan lich trung
        ViTriTuyenDung vt6 = taoViTri(2);
        HoSoUngVien hs6 = taoHoSo("HS06");

        vt6.nopHoSo(hs6);
        vt6.xetDuyetHoSo();

        ArrayList<HoSoUngVien> dsHS6 =
                new ArrayList<>(Arrays.asList(hs6));

        int lichLanDau = vt6.taoLichPhongVan(
                1, ngayTuongLai(1), "9:00",
                "Online", "Zoom", "Nguoi PV", dsHS6
        );

        int lichTrung = vt6.taoLichPhongVan(
                1, ngayTuongLai(1), "10:00",
                "Online", "Zoom", "Nguoi PV", dsHS6
        );

        kiemTra("Tao lich va ngan lich trung",
                lichLanDau == 1 && lichTrung == 0);


        // TEST 09: Tu choi lich co ngay trong qua khu
        ViTriTuyenDung vt7 = taoViTri(2);
        HoSoUngVien hs7 = taoHoSo("HS07");

        vt7.nopHoSo(hs7);
        vt7.xetDuyetHoSo();

        int lichSai = vt7.taoLichPhongVan(
                1, "01/01/2000", "9:00",
                "Online", "Zoom", "Nguoi PV",
                new ArrayList<>(Arrays.asList(hs7))
        );

        kiemTra("Tu choi lich trong qua khu",
                lichSai == 0);


        // TEST 10: Cham diem va chot vong
        ViTriTuyenDung vt8 = taoViTri(2);
        HoSoUngVien hs8 = taoHoSo("HS08");

        vt8.nopHoSo(hs8);
        vt8.xetDuyetHoSo();

        vt8.taoLichPhongVan(
                1, ngayTuongLai(1), "9:00",
                "Online", "Zoom", "Nguoi PV",
                new ArrayList<>(Arrays.asList(hs8))
        );

        boolean chamDiem = vt8.chamDiemPhongVan(
                "VT_TEST-V1-HS08", 8.0, "Tot"
        );

        boolean chamLanHai = vt8.chamDiemPhongVan(
                "VT_TEST-V1-HS08", 9.0, "Cham lai"
        );

        ArrayList<HoSoUngVien> dsDat8 =
                vt8.chotKetQuaVong(1, 6.0);

        kiemTra("Cham diem va chot vong",
                chamDiem
                && !chamLanHai
                && dsDat8.size() == 1);


        // TEST 11: Xep hang va tuyen dung theo chi tieu
        ViTriTuyenDung vt9 = taoViTri(1);

        HoSoUngVien a = taoHoSo("HS09");
        HoSoUngVien b = taoHoSo("HS10");

        vt9.nopHoSo(a);
        vt9.nopHoSo(b);
        vt9.xetDuyetHoSo();

        ArrayList<HoSoUngVien> dsHS9 =
                new ArrayList<>(Arrays.asList(a, b));

        int soLich = vt9.taoLichPhongVan(
                1, ngayTuongLai(1), "9:00",
                "Online", "Zoom", "Nguoi PV", dsHS9
        );

        boolean chamA = vt9.chamDiemPhongVan(
                "VT_TEST-V1-HS09", 9.0, "Tot"
        );

        boolean chamB = vt9.chamDiemPhongVan(
                "VT_TEST-V1-HS10", 7.0, "Kha"
        );

        ArrayList<HoSoUngVien> dsDat9 =
                vt9.chotKetQuaVong(1, 6.0);

        ArrayList<KetQuaUngTuyen> bangXepHang =
                vt9.xepHangUngVien(ViTriTuyenDung.TC_DIEM_PHONG_VAN);

        ArrayList<KetQuaUngTuyen> dsTrungTuyen =
                vt9.chotKetQuaTuyenDung(1);

        kiemTra("Xep hang va tuyen dung dung chi tieu",
                soLich == 2
                && chamA && chamB
                && dsDat9.size() == 2
                && bangXepHang.size() == 2
                && "HS09".equals(
                        bangXepHang.get(0).getHoSo().getMaHS())
                && dsTrungTuyen.size() == 1
                && vt9.demSoTrungTuyen() == 1
                && KetQuaUngTuyen.TT_TRUNGTUYEN.equals(
                        vt9.timKetQua("HS09").getTrangThaiUngTuyen())
                && KetQuaUngTuyen.TT_KHONG_TRUNGTUYEN.equals(
                        vt9.timKetQua("HS10").getTrangThaiUngTuyen()));


        // TEST 12: Chot tuyen dung lan hai
        ArrayList<KetQuaUngTuyen> dsChotLanHai =
                vt9.chotKetQuaTuyenDung(1);

        kiemTra("Chot tuyen dung lan hai khong tuyen trung",
                dsChotLanHai.size() == 1
                && vt9.demSoTrungTuyen() == 1);


        // TONG KET
        System.out.println("\n====================================");
        System.out.println(" TONG KET KIEM THU");
        System.out.println("====================================");
        System.out.println("PASS: " + soPass);
        System.out.println("FAIL: " + soFail);
        System.out.println("TONG: " + (soPass + soFail));

        if (soFail == 0) {
            System.out.println("KET QUA: TAT CA KIEM THU DAT");
        } else {
            System.out.println("KET QUA: CAN KIEM TRA LAI");
        }
    }
}

