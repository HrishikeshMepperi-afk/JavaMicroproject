package guiPages;

import sql.Db;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JPanel {
    public login(){
        setLayout(null);

        JLabel email = new JLabel("email:");
        email.setBounds(10,15,40,25);
        add(email);

        JTextField emailT = new JTextField();
        emailT.setBounds(10,45,300,25);
        add(emailT);

        JLabel password = new JLabel("Password:");
        password.setBounds(10,75,70, 24);
        add(password);

        JTextField passwordT = new JTextField();
        passwordT.setBounds(10,105,300,25);
        add(passwordT);

        JButton submit = new JButton("login");
        submit.setBounds(10,135,75,25);
        add(submit);

        JLabel label = new JLabel("test");
        label.setBounds(10,165,70,24);
        add(label);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailT.getText();
                String password = passwordT.getText();
                try{
                    Db db = new Db();
                    if (db.userAuth(email,password)){
                       label.setText("passed");
                    }
                    else{
                        label.setText("failed");
                    }
                } catch (Exception ex){
                    System.out.println("something went wrong");
                }
            }
        });

    }
}
