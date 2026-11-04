import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q10 extends JFrame implements ActionListener {
    JTextField tfAccNo, tfName, tfBalance, tfAmount;
    JButton btnDeposit, btnWithdraw, btnBalance, btnClear;
    double balance = 0.0;

    public Labsheet11Q10() {
        setTitle("Mini Banking Application");
        setLayout(null);

        JLabel l1 = new JLabel("Account No:"); l1.setBounds(30, 30, 100, 25); add(l1);
        tfAccNo = new JTextField(); tfAccNo.setBounds(140, 30, 150, 25); add(tfAccNo);

        JLabel l2 = new JLabel("Customer Name:"); l2.setBounds(30, 70, 100, 25); add(l2);
        tfName = new JTextField(); tfName.setBounds(140, 70, 150, 25); add(tfName);

        JLabel l3 = new JLabel("Current Balance:"); l3.setBounds(30, 110, 100, 25); add(l3);
        tfBalance = new JTextField("0.0"); tfBalance.setBounds(140, 110, 150, 25); tfBalance.setEditable(false); add(tfBalance);

        JLabel l4 = new JLabel("Amount:"); l4.setBounds(30, 150, 100, 25); add(l4);
        tfAmount = new JTextField(); tfAmount.setBounds(140, 150, 150, 25); add(tfAmount);

        btnDeposit = new JButton("Deposit"); btnDeposit.setBounds(30, 200, 95, 30); add(btnDeposit);
        btnWithdraw = new JButton("Withdraw"); btnWithdraw.setBounds(135, 200, 95, 30); add(btnWithdraw);
        btnBalance = new JButton("Check Balance"); btnBalance.setBounds(240, 200, 120, 30); add(btnBalance);
        btnClear = new JButton("Clear"); btnClear.setBounds(370, 200, 80, 30); add(btnClear);

        btnDeposit.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnBalance.addActionListener(this);
        btnClear.addActionListener(this);

        setSize(490, 290);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDeposit) {
            try {
                double amt = Double.parseDouble(tfAmount.getText());
                if (amt > 0) {
                    balance += amt;
                    tfBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(this, "Successfully deposited: " + amt);
                } else {
                    JOptionPane.showMessageDialog(this, "Enter valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter numeric amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnWithdraw) {
            try {
                double amt = Double.parseDouble(tfAmount.getText());
                if (amt > 0) {
                    if (balance >= amt) {
                        balance -= amt;
                        tfBalance.setText(String.valueOf(balance));
                        JOptionPane.showMessageDialog(this, "Successfully withdrew: " + amt);
                    } else {
                        JOptionPane.showMessageDialog(this, "Insufficient balance!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Enter valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter numeric amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnBalance) {
            JOptionPane.showMessageDialog(this, "Current Balance: " + balance);
        } else if (e.getSource() == btnClear) {
            tfAccNo.setText("");
            tfName.setText("");
            tfAmount.setText("");
            balance = 0.0;
            tfBalance.setText("0.0");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q10();
    }
}
