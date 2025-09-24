import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import guiPages.login;

public class Main {

    static String url = "jdbc:mysql://localhost:3306/microP";
    static String user = "root";
    static String pass = "070906";

    public static void createAndShowGui(){
        JFrame frame = new JFrame("LoanSanction");
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new CardLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        mainPanel.add(new login(url,user,pass));
        frame.add(mainPanel);


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