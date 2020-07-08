package businessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CSDL {
	private static Connection ketNoi;
	public static Connection getKetNoi() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3308/qllienhe?useUnicode=true&characterEncoding=UTF-8";
			ketNoi = DriverManager.getConnection(url, "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ketNoi;
	}
}