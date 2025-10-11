package guiPages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import sql.Db;

public class login extends JPanel {
    public login(){
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

        JLabel warning = new JLabel("");
        warning.setBounds(10,120,250,25);
        add(warning);

        JButton submit = new JButton("Login");
        submit.setBounds(10,165,75,25);
        add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = emailText.getText();
                String password = new String(passwordField.getPassword());
                try{
                    Db db = new Db();
                    if (!db.checkUser(username)){
                        db.insertUsers(username , password);
                        setVisible(false);
                    }
                    else{
                        System.out.println("something went wrong");
                        emailText.setText("");
                        passwordField.setText("");
                        warning.setText("this email is already linked to an account");
                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        });
    }
}
