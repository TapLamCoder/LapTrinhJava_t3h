package businessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dataTransferObject.LienHe;

public class LienHeBL {
	public static int themLienHe(LienHe lh) {
		int smt = 0;
		try (Connection ketNoi = CSDL.getKetNoi()){
			String sql = "insert into lienhe(hoten,dienthoai,hinhanh) values (?,?,?)";
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1,lh.getHoTen());
			pst.setString(2,lh.getDienThoai());
			pst.setString(3, lh.getHinhAnh());
			smt = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Bi loi "+e.getMessage());
		}
		return smt;
	}
}
