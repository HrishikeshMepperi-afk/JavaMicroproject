package guiPages;

import javax.swing.*;

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


    }
}
