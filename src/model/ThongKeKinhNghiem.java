package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;



public final class ThongKeKinhNghiem {
	
	private static class NhomLinhVuc {
		private final String tenHienThi;
		private final ArrayList<QuaTrinhLamViec> ds;
		
		private NhomLinhVuc(String tenHienThi) {
			super();
			this.tenHienThi = tenHienThi;
			this.ds = new ArrayList<QuaTrinhLamViec>();;
		}
		
	}
	private static class KetQuaThongKe {
		private final String tenLinhVuc;
		private final int soThang;
			
		private KetQuaThongKe(String tenLinhVuc, int soThang) {
			super();
			this.tenLinhVuc = tenLinhVuc;
			this.soThang = soThang;
			
			
		}
	}
	
	private static String anToan(String s) {
		return s == null ? "" : s.trim();
	}
	
	private static Stack<QuaTrinhLamViec> layDSQuaTrinhLamViec(HoSoUngVien hs) {
		return hs == null ? null : hs.getQuaTrinhLamViec();
	}
	
	public static boolean cungLinhVuc(QuaTrinhLamViec qt, String linhVuc) {
		return qt != null && TienIch.khop(qt.getLinhVuc(), linhVuc);
	}
	
	private static boolean duLieuCongViecHopLe(QuaTrinhLamViec qt) {
		return qt != null && qt.hopLe()
				&& !TienIch.chuanHoa(qt.getLinhVuc()).isEmpty()
				&& !TienIch.chuanHoa(qt.getViTri()).isEmpty()
				&& !TienIch.chuanHoa(qt.getTenCongTy()).isEmpty();
	}
	
	private static Comparator<QuaTrinhLamViec> soSanhNgayBatDau() {
		return new Comparator<QuaTrinhLamViec>() {
			
			@Override
			public int compare(QuaTrinhLamViec o1, QuaTrinhLamViec o2) {
				return o1.layNgayBatDau().compareTo(o2.layNgayBatDau());
			}
		};
	}
	
	public static ArrayList<QuaTrinhLamViec> layQuaTrinhTheoLinhVuc(HoSoUngVien hs, String linhVuc) {
		ArrayList<QuaTrinhLamViec> res = new ArrayList<QuaTrinhLamViec>();
		if(hs == null || linhVuc == null || linhVuc.trim().isEmpty()) {
			return res;
		}
		
		Stack<QuaTrinhLamViec> ds = layDSQuaTrinhLamViec(hs);
		
		if(ds == null || ds.isEmpty()) {
			return res;
		}
		
		for(QuaTrinhLamViec qt : ds) {
			if(cungLinhVuc(qt, linhVuc) && duLieuCongViecHopLe(qt)) {
				res.add(qt);
			}
		}
		
		Collections.sort(res, soSanhNgayBatDau());
		
		return res;
	}
	
	private static int demMucSaiTheoLinhVuc(HoSoUngVien hs, String linhVuc) {
		int cnt = 0;
		Stack<QuaTrinhLamViec> ds = layDSQuaTrinhLamViec(hs);
		
		if(ds == null || linhVuc == null || linhVuc.trim().isEmpty()) {
			return 0;
		}
		
		for(QuaTrinhLamViec qt :ds) {
			if(cungLinhVuc(qt, linhVuc) && !duLieuCongViecHopLe(qt)) {
				cnt++;
			}
		}
		
		return cnt;
	}
	
	private static int tinhKhoangCacNgay(ArrayList<QuaTrinhLamViec> ds) {
		if(ds == null || ds.isEmpty()) {
			return 0;
		}
		
		Collections.sort(ds, soSanhNgayBatDau());
		
		LocalDate batDau = null;
		LocalDate ketThuc = null;
		
		long tong = 0;
		
		for(QuaTrinhLamViec qt : ds) {
			LocalDate bd = qt.layNgayBatDau();
			LocalDate kt = qt.layNgayKetThuc();
			
			if(bd == null || kt == null || kt.isBefore(bd)) {
				continue;
			}
			
			if(ketThuc == null) {
				batDau = bd;
				ketThuc = kt;
			} else if(!bd.isAfter(kt.plusDays(1))) {
				if(kt.isAfter(ketThuc)) {
					ketThuc = kt;
				}
			} else {
				tong += ChronoUnit.MONTHS.between(batDau, ketThuc.plusDays(1));
				batDau = bd;
				ketThuc = kt;
			}
		}
		
		if(ketThuc != null) {
			tong += ChronoUnit.MONTHS.between(batDau, ketThuc.plusDays(1));
		}
		
		return tong > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) Math.max(0, tong);
	}
	
	public static int tinhSoThang(HoSoUngVien hs, String linhVuc) {
		return tinhKhoangCacNgay(layQuaTrinhTheoLinhVuc(hs, linhVuc));
	}
	
	public static int tinhTongSoThang(HoSoUngVien hs) {
		ArrayList<QuaTrinhLamViec> dsHopLe = new ArrayList<QuaTrinhLamViec>();
		Stack<QuaTrinhLamViec> ds = layDSQuaTrinhLamViec(hs);
		
		if(ds == null) {
			return 0;
		}
		
		for(QuaTrinhLamViec qt : ds) {
			if(duLieuCongViecHopLe(qt)) {
				dsHopLe.add(qt);
			}
		}
		
		return tinhKhoangCacNgay(dsHopLe);
	}
	
	
	
}
