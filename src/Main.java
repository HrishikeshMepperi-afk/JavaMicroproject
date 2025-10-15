import javax.swing.*;
import java.awt.*;

import guiPages.*;

public class Main {
    public static void createAndShowGui(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e){
            System.out.println(e);
        }
        JFrame frame = new JFrame("LoanSanction");
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new CardLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        LoanCheck lc = new LoanCheck();
        register rp = new register();
        login lp = new login();
        mainPanel.add(rp);
        mainPanel.add(lc);
        mainPanel.add(lp);
        lc.setVisible(true);
        rp.setVisible(false);
        lp.setVisible(false);
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