package MVCexam.Model;

import java.util.*;
import java.sql.*;

public class AdminModel {

    public ResultSet getVotes() throws Exception {
        try {
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "123456";

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false", user, password);

            Statement st = con.createStatement();

            String sql = "select * from votes";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}