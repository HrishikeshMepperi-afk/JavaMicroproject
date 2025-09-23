import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Main {

    static String url = "jdbc:mysql://localhost:3306/microP";
    static String user = "root";
    static String pass = "070906";

    public static void createAndShowGui(){
        JFrame frame = new JFrame("LoanSanction");
        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel email = new JLabel("Email:");
        email.setBounds(10,10,80,25);
        frame.getContentPane().add(email);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(10,35,300,25);
        frame.getContentPane().add(emailText);

        JLabel password = new JLabel("Password: ");
        password.setBounds(10,60,80,25);
        frame.add(password);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(10,85,300,25);
        frame.add(passwordField);

        JButton submit = new JButton("Login");
        submit.setBounds(10,115,75,25);
        frame.add(submit);

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


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                    createAndShowGui();
            }
        });
    }
}