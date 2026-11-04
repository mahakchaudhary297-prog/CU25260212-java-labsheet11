import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q4 extends JFrame implements ActionListener {
    JTextField tfEng, tfMath, tfJava, tfDbms, tfCn;
    JButton btnCalc;
    JLabel lblResult;

    public Labsheet11Q4() {
        setTitle("Student Marksheet");
        setLayout(null);

        JLabel l1 = new JLabel("English:"); l1.setBounds(30, 30, 100, 25); add(l1);
        tfEng = new JTextField(); tfEng.setBounds(140, 30, 100, 25); add(tfEng);

        JLabel l2 = new JLabel("Mathematics:"); l2.setBounds(30, 70, 100, 25); add(l2);
        tfMath = new JTextField(); tfMath.setBounds(140, 70, 100, 25); add(tfMath);

        JLabel l3 = new JLabel("Java:"); l3.setBounds(30, 110, 100, 25); add(l3);
        tfJava = new JTextField(); tfJava.setBounds(140, 110, 100, 25); add(tfJava);

        JLabel l4 = new JLabel("DBMS:"); l4.setBounds(30, 150, 100, 25); add(l4);
        tfDbms = new JTextField(); tfDbms.setBounds(140, 150, 100, 25); add(tfDbms);

        JLabel l5 = new JLabel("Computer Networks:"); l5.setBounds(30, 190, 130, 25); add(l5);
        tfCn = new JTextField(); tfCn.setBounds(160, 190, 80, 25); add(tfCn);

        btnCalc = new JButton("Calculate Result");
        btnCalc.setBounds(50, 230, 190, 30);
        add(btnCalc);

        lblResult = new JLabel("");
        lblResult.setBounds(30, 270, 250, 80);
        add(lblResult);

        btnCalc.addActionListener(this);

        setSize(320, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double eng = Double.parseDouble(tfEng.getText());
            double math = Double.parseDouble(tfMath.getText());
            double java = Double.parseDouble(tfJava.getText());
            double dbms = Double.parseDouble(tfDbms.getText());
            double cn = Double.parseDouble(tfCn.getText());

            double total = eng + math + java + dbms + cn;
            double percentage = total / 5.0;
            String status = "Pass";
            if (eng < 40 || math < 40 || java < 40 || dbms < 40 || cn < 40) {
                status = "Fail";
            }

            char grade = 'F';
            if (status.equals("Pass")) {
                if (percentage >= 90) grade = 'A';
                else if (percentage >= 80) grade = 'B';
                else if (percentage >= 70) grade = 'C';
                else if (percentage >= 60) grade = 'D';
                else grade = 'E';
            }

            lblResult.setText("<html>Total: " + total + "<br>Percentage: " + percentage + "%<br>Status: " + status + "<br>Grade: " + grade + "</html>");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric marks.");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q4();
    }
}
