package MVCexam.Model;

import java.util.*;
import java.sql.*;

public class VoteModel {

	public void updateVote(String candidate, String username) throws Exception {
		try {
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "123456";

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false", user, password);

			Statement st = con.createStatement();

			String sql = "select * from votes where name = \'" + candidate + "\'";
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				sql = "UPDATE votes set count = count+1 where name=\'" + candidate + "\'";
				int b = st.executeUpdate(sql);
				sql = "UPDATE logins set count = count+1 where name=\'" + username + "\'";
				int c = st.executeUpdate(sql);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
