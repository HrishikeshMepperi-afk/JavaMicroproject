package sql;

import java.sql.*;

public class Db {
    Connection con = null;
    PreparedStatement stmt = null;
    static String url = "jdbc:mysql://localhost:3306/microP";
    static String user = "root";
    static String pass = "070906";
    public void insertUsers(String email, String passwd, int age ) throws Exception{
        con = DriverManager.getConnection(url,user,pass);
        String query = "INSERT INTO users (email, password,age) values(?,?,?)";
        stmt = con.prepareStatement(query);
        stmt.setString(1,email);
        stmt.setString(2,passwd);
        stmt.setInt(3,age);
        int exec = stmt.executeUpdate();
        if(exec>0){
            System.out.println("stuff got executed");
        }
    }

    public void selectUsers() throws Exception{
        ResultSet rs = stmt.executeQuery("select * from users");
        while(rs.next()){
            System.out.println(rs.getString("email")+" "+ rs.getString("password"));
        }
    }

}
