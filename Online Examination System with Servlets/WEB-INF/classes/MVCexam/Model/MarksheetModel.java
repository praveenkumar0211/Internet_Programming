package MVCexam.Model;

import java.util.*;
import java.sql.*;

public class MarksheetModel {

    public Map<String, String> getData(String name, String score) throws Exception {

        String url = "jdbc:mysql://localhost:3306/ex_db";
        String user = "root";
        String password = "123456";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/ex_db?autoReconnect=true&useSSL=false", user, password);

        System.out.println("con--->" + con);

        Statement st = con.createStatement();
        System.out.println("Before Query");

        String q = "UPDATE student SET IP = '" + score + "' WHERE name = '" + name + "'";
        int b = st.executeUpdate(q);

        String s = "select * from student where name = '" + name + "'";
        ResultSet rs = st.executeQuery(s);
        Map<String, String> map = new HashMap<String, String>();
        if (rs.next()) {
            map.put("Internet Programming", rs.getString("IP"));
            map.put("Compiler Design", rs.getString("CD"));
            map.put("Machine Learning", rs.getString("ML"));
            map.put("Object Oriented Analysis", rs.getString("OOAD"));
            map.put("Foundations of Datascience", rs.getString("FDS"));
        }

        // st.executeUpdate(sql);
        // 5.Close st and con : must use finally block
        st.close();
        con.close();

        return map;

    }
}
