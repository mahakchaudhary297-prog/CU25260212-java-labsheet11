import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q3 extends JFrame implements ActionListener {
    JTextField tfUser;
    JPasswordField pfPass;
    JButton btnLogin, btnReset;

    public Labsheet11Q3() {
        setTitle("Login Form");
        setLayout(null);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(30, 30, 80, 25);
        add(lblUser);

        tfUser = new JTextField();
        tfUser.setBounds(120, 30, 150, 25);
        add(tfUser);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(30, 70, 80, 25);
        add(lblPass);

        pfPass = new JPasswordField();
        pfPass.setBounds(120, 70, 150, 25);
        add(pfPass);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(30, 120, 90, 30);
        add(btnLogin);

        btnReset = new JButton("Reset");
        btnReset.setBounds(140, 120, 90, 30);
        add(btnReset);

        btnLogin.addActionListener(this);
        btnReset.addActionListener(this);

        setSize(320, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String user = tfUser.getText();
            String pass = new String(pfPass.getPassword());
            if (user.equals("admin") && pass.equals("password123")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnReset) {
            tfUser.setText("");
            pfPass.setText("");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q3();
    }
}
