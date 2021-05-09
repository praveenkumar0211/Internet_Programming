package MVCexam.Model;

import java.util.*;
import java.sql.*;

public class LoginModel {

    public String getData(String username) throws Exception {

        String url = "jdbc:mysql://localhost:3306/ex_db";
        String user = "root";
        String password = "123456";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/ex_db?autoReconnect=true&useSSL=false", user, password);

        Statement st = con.createStatement();

        String sql_String = "select * from login where username = \'" + username + "\'";
        ResultSet rs = st.executeQuery(sql_String);

        if (rs.next()) {
            String res = rs.getString("password");
            return res;
        }

        else {
            return "0";
        }

    }

    public String checkUsername(String username) throws Exception {
        try {
            String url = "jdbc:mysql://localhost:3306/ex_db";
            String user = "root";
            String password = "123456";

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/ex_db?autoReconnect=true&useSSL=false", user, password);

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

    public void appendUser(String username, String pwd, String cd, String ml, String ooad, String fds)
            throws Exception {
        try {
            String user = "root";
            String password = "123456";

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/ex_db?autoReconnect=true&useSSL=false", user, password);

            Statement st = con.createStatement();

            String sql = "insert into login values(\"" + username + "\",\"" + pwd + "\")";
            st.executeUpdate(sql);
            String mark = "insert into student values(\"" + username + "\",\"" + "NULL" + "\",\"" + cd + "\",\"" + ml
                    + "\",\"" + ooad + "\",\"" + fds + "\")";
            st.executeUpdate(mark);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}