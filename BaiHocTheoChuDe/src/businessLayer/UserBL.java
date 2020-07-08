package businessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dataTransferObject.User;

public class UserBL {
	public static User timUser(String userName, String password) {
		User user = null;
		try (Connection ketNoi = CSDL.getKetNoi()){
			Statement stm = ketNoi.createStatement();
			String sql = "select * from user where username='"+userName+"' and password = '"+password+"'";
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassWord(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}