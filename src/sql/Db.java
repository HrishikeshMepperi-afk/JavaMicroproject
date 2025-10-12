package sql;

import java.sql.*;

public class Db {
    static String url = "jdbc:mysql://localhost:3306/microP";
    static String user = "root";
    static String pass = "070906";
    static Connection con = null;
    public Db() throws Exception{
        con = DriverManager.getConnection(url,user,pass);
    }

    public void conClose() throws Exception{
        con.close();
    }

    public void insertUsers(String email, String passwd) throws Exception{
        int number = selectUsers();
        String query = "INSERT INTO users (email, password, userNo) values(?,?,?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1,email);
        stmt.setString(2,passwd);
        stmt.setInt(3,number+1);
        int exec = stmt.executeUpdate();
        if(exec>0){
            System.out.println("stuff got executed");
        }
        stmt.close();

    }

    public int selectUsers() throws Exception{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from users");
        int number = 0;
        while(rs.next()){
            number = rs.getInt("userNo");
        }
        rs.close();
        st.close();

        return number;
    }

    public boolean checkUser(String email) throws Exception{
        String sql = "select 1 from users where email = ? limit 1";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,email);
        ResultSet rs = stmt.executeQuery();
        boolean result = rs.next();
        rs.close();
        stmt.close();
        return result;
    }

    public boolean userAuth(String email, String password) throws Exception{
        String sql = "select 1 from users where email = ? and password = ? limit 1";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            boolean result = rs.next();
            rs.close();
            return result;
        } catch (SQLException e){
            System.out.println("this issue is raised in the method userAuth");
            System.out.println(e);
            return false;
        }
    }

}
