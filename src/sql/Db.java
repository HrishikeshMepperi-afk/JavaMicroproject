package sql;

import java.sql.*;

public class Db {
    PreparedStatement stmt = null;
    Statement st = null;
    static String url = "jdbc:mysql://localhost:3306/microP";
    static String user = "root";
    static String pass = "070906";
    Connection con = null;
    public Db() throws Exception{
        con = DriverManager.getConnection(url,user,pass);
    }

    public void insertUsers(String email, String passwd) throws Exception{
        Db counter = new Db();
        int number = counter.selectUsers();
        String query = "INSERT INTO users (email, password, userNo) values(?,?,?)";
        stmt = con.prepareStatement(query);
        stmt.setString(1,email);
        stmt.setString(2,passwd);
        stmt.setInt(3,number+1);
        int exec = stmt.executeUpdate();
        if(exec>0){
            System.out.println("stuff got executed");
        }
    }

    public int selectUsers() throws Exception{
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from users");
        int number = 0;
        while(rs.next()){
            number = rs.getInt("userNo");
        }

        return number;
    }

    public boolean checkUser(String email) throws Exception{
        Db counter = new Db();
        String sql = "select 1 from users where email = ? limit 1";
        stmt = con.prepareStatement(sql);
        stmt.setString(1,email);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }

}
