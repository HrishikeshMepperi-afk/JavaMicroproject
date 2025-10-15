package guiPages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoanCheck extends JPanel {
    public LoanCheck() {
        setLayout(null);

        JLabel work = new JLabel("Where do you work: ");
        work.setBounds(10, 10, 150, 25);
        add(work);

        JTextField workT = new JTextField();
        workT.setBounds(10, 35, 300, 25);
        add(workT);

        JLabel sal = new JLabel("Salary per year: ");
        sal.setBounds(10, 60, 100, 25);
        add(sal);

        JTextField salT = new JTextField();
        salT.setBounds(10, 85, 300, 25);
        add(salT);

        JLabel cred = new JLabel("Credit Score: ");
        cred.setBounds(10,110,200,25);
        add(cred);

        JTextField credT = new JTextField();
        credT.setBounds(10, 135, 300, 25);
        add(credT);

        JLabel label = new JLabel("Submit identification proof: ");
        label.setBounds(10,170, 190,20);
        add(label);

        JButton pdf = new JButton("upload");
        pdf.setBounds(10,200,100,20);
        add(pdf);

        JButton submit = new JButton("submit");
        submit.setBounds(10,245,100,20);
        submit.setText("submit");
        add(submit);

        pdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                //this makes it so that only pdfs are accepted
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Documents", "pdf"));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = fileChooser.getSelectedFile();
                    //the null here makes it independent to the rest of the panels
                    JOptionPane.showMessageDialog(null,"selected file: " + selectedFile.getPath());
                }
            }
        });

       submit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

           }
       });

    }
}
