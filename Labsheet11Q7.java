import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q7 extends JFrame implements ActionListener {
    JTextField tfTemp;
    JRadioButton rbC2F, rbF2C;
    ButtonGroup bgConv;
    JButton btnConvert, btnClear;
    JLabel lblResult;

    public Labsheet11Q7() {
        setTitle("Temperature Converter");
        setLayout(null);

        JLabel l1 = new JLabel("Temperature:"); l1.setBounds(30, 30, 90, 25); add(l1);
        tfTemp = new JTextField(); tfTemp.setBounds(130, 30, 120, 25); add(tfTemp);

        rbC2F = new JRadioButton("Celsius to Fahrenheit", true); rbC2F.setBounds(30, 70, 160, 25); add(rbC2F);
        rbF2C = new JRadioButton("Fahrenheit to Celsius"); rbF2C.setBounds(30, 100, 160, 25); add(rbF2C);
        bgConv = new ButtonGroup(); bgConv.add(rbC2F); bgConv.add(rbF2C);

        btnConvert = new JButton("Convert"); btnConvert.setBounds(30, 140, 100, 30); add(btnConvert);
        btnClear = new JButton("Clear"); btnClear.setBounds(140, 140, 100, 30); add(btnClear);

        lblResult = new JLabel("Result: "); lblResult.setBounds(30, 185, 220, 25); add(lblResult);

        btnConvert.addActionListener(this);
        btnClear.addActionListener(this);

        setSize(290, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConvert) {
            try {
                double val = Double.parseDouble(tfTemp.getText());
                if (rbC2F.isSelected()) {
                    double f = (val * 9.0 / 5.0) + 32;
                    lblResult.setText("Result: " + f + " °F");
                } else {
                    double c = (val - 32) * 5.0 / 9.0;
                    lblResult.setText("Result: " + c + " °C");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnClear) {
            tfTemp.setText("");
            lblResult.setText("Result: ");
            rbC2F.setSelected(true);
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q7();
    }
}
