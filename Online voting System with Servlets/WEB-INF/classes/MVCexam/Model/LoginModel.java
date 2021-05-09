package MVCexam.Model;

import java.util.*;
import java.sql.*;

public class LoginModel {

	public String getPassword(String username, String pass) throws Exception {
		try {
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "123456";

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false", user, password);

			Statement st = con.createStatement();

			String sql = "select * from logins where name = \'" + username + "\'";
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				if (rs.getString("name").equals("admin")) {
					return "admin";
				} else if ((rs.getString("password").equals(pass)) && (rs.getString("count").equals("0"))) {

					return rs.getString("password");

				} else if (rs.getString("password").equals(pass) && (rs.getString("count").equals("1"))) {

					return "Already voted";
				} else {

					return "Password Incorrect!!";
				}

			}

			else {
				return "Invalid";
			}

		} catch (

		Exception e) {
			System.out.println(e);
			return "0";
		}
	}

	public String checkUsername(String username) throws Exception {
		try {
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "123456";

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/exam_db?autoReconnect=true&useSSL=false", user, password);

			Statement st = con.createStatement();

			String sql = "select * from login where username = \'" + username + "\'";
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				return "exists";
			}

			else {
				return "does not exist";
			}

		} catch (Exception e) {
			System.out.println(e);
			return "0";
		}
	}

}