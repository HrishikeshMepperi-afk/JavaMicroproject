package guiPages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JPanel {
    public login(String url, String user, String pass){
        setLayout(null);

        JLabel email = new JLabel("Email:");
        email.setBounds(10,10,80,25);
        add(email);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(10,35,300,25);
        add(emailText);

        JLabel password = new JLabel("Password: ");
        password.setBounds(10,60,80,25);
        add(password);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(10,85,300,25);
        add(passwordField);

        JButton submit = new JButton("Login");
        submit.setBounds(10,115,75,25);
        add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = emailText.getText();
                String password = new String(passwordField.getPassword());
                System.out.println(username);
                System.out.println(password);

                Connection conn = null;
                PreparedStatement stmt = null;

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(url, user, pass);
                    String sql = "INSERT INTO users (email, password) values(?,?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1,username);
                    stmt.setString(2,password);
                    int rows = stmt.executeUpdate();
                    ResultSet rs = stmt.executeQuery("select * from users");
                    while(rs.next()){
                        System.out.print(rs.getString("email")+" "+ rs.getString("password"));
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    System.out.println(ex);
                }


            }
        });
    }
}
