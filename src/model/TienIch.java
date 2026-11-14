package model;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;
import java.util.regex.Pattern;

public final class TienIch {
	private static final DateTimeFormatter FORMAT_NGAY = DateTimeFormatter.ofPattern("d/M/uuuu")
																.withResolverStyle(ResolverStyle.STRICT);
	
	private static final Pattern KHOANG_TRANG = Pattern.compile("\\s+");
	private static final Pattern DAU = Pattern.compile("\\p{M}+");
	
	
	
	//Chuyển chuỗi ngày thành đối tượng LocalDate
	public static LocalDate parseNgay(String ngay) {
		if(ngay == null || ngay.trim().isEmpty()) {
			return null;
		}
		
		try {
			return LocalDate.parse(ngay.trim(), FORMAT_NGAY);
		} catch(DateTimeParseException e) {
			return null;
		}
	}
	
	
	//Chuẩn hóa một chuỗi văn bản để phục vụ việc tìm kiếm và so sánh
	public static String chuanHoa(String chuoi) {
		if(chuoi == null) {
			return "";
		}
		
		String tmp = chuoi.trim().toLowerCase(Locale.ROOT);
		if(tmp.isEmpty()) {
			return "";
		}
		
		tmp = tmp.replace('đ', 'd');
		tmp = Normalizer.normalize(tmp, Form.NFD);
		tmp = DAU.matcher(tmp).replaceAll("");
		tmp = KHOANG_TRANG.matcher(tmp).replaceAll(" ").trim();
		return tmp;
	}
	
	
	//Kiểm tra hai chuỗi có giống nhau sau khi chuẩn hóa hay không
	public static boolean khop(String a, String b) {
		String x = chuanHoa(a);
		String y = chuanHoa(b);
		
		return !x.isEmpty() && !y.isEmpty() && x.equals(y);
	}
}
