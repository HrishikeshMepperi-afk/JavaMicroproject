package guiPages;

import javax.swing.*;
import java.awt.*;

public class PickLoan extends JPanel{
    public PickLoan() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Pick a loan");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        String[] loanTypes = { "Home Loan", "Student Loan" };
        JComboBox<String> loanDropdown = new JComboBox<>(loanTypes);
        loanDropdown.setAlignmentX(Component.CENTER_ALIGNMENT);
        loanDropdown.setMaximumSize(new Dimension(150, loanDropdown.getPreferredSize().height));

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(loanDropdown);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(submitButton);

        submitButton.addActionListener(e -> {
            String selectedLoan = (String) loanDropdown.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You selected: " + selectedLoan, "Submission", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
