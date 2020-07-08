package chuDeCSDL_MySQL;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KetNoiCSDL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//buoc 1: nap trinh dieu khien
		Class.forName("com.mysql.jdbc.Driver");
		//buoc 2: tao chuoi ket noi
		String url = "jdbc:mysql://localhost:3308/qlsv?useUnicode=true&characterEncoding=UTF-8";
		//buoc 3: tao ket noi
		Connection ketNoi = DriverManager.getConnection(url, "root", "");
		//buoc 4: tao phat bieu
		Statement stm = ketNoi.createStatement();
		//buoc 5: thuc hien cau truy van
		String sql = "select * from thongtinsinhvien";
		ResultSet rs = stm.executeQuery(sql);
		//buoc 6: xu ly ket qua
		String masv,hosv,tensv,makh;
		int hocBong;
		Date ngaySinh;
		String gioiTinh;
		
		while(rs.next()) {
			masv = rs.getString("MaHocSinh");
			hosv = rs.getString("HoHocSinh");
			tensv = rs.getString("TenHocSinh");
			ngaySinh = rs.getDate("NgaySinh");
			gioiTinh = (rs.getBoolean("GioiTinh")?"Nam":"Nu");
//			hocBong = rs.getInt("hocbong");
			makh = rs.getString("MaKhoa");
			System.out.println(String.format("%s %s %s %s %s %s",masv,hosv,tensv,ngaySinh,gioiTinh,makh));
		}
		//buoc 7: dong ket noi
		ketNoi.close();
	}

}