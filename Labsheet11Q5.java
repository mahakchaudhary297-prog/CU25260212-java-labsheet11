import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q5 extends JFrame implements ActionListener {
    JTextField tfName;
    JComboBox<String> cbCourse;
    JRadioButton rbMale, rbFemale;
    ButtonGroup bgGender;
    JCheckBox chkJava, chkPython, chkC;
    JButton btnSubmit, btnReset;

    public Labsheet11Q5() {
        setTitle("Course Selection Form");
        setLayout(null);

        JLabel l1 = new JLabel("Name:"); l1.setBounds(30, 30, 80, 25); add(l1);
        tfName = new JTextField(); tfName.setBounds(120, 30, 150, 25); add(tfName);

        JLabel l2 = new JLabel("Course:"); l2.setBounds(30, 70, 80, 25); add(l2);
        cbCourse = new JComboBox<>(new String[]{"BTech", "BCA", "MCA", "BSc"});
        cbCourse.setBounds(120, 70, 150, 25); add(cbCourse);

        JLabel l3 = new JLabel("Gender:"); l3.setBounds(30, 110, 80, 25); add(l3);
        rbMale = new JRadioButton("Male", true); rbMale.setBounds(120, 110, 70, 25); add(rbMale);
        rbFemale = new JRadioButton("Female"); rbFemale.setBounds(190, 110, 80, 25); add(rbFemale);
        bgGender = new ButtonGroup(); bgGender.add(rbMale); bgGender.add(rbFemale);

        JLabel l4 = new JLabel("Subjects:"); l4.setBounds(30, 150, 80, 25); add(l4);
        chkJava = new JCheckBox("Java"); chkJava.setBounds(120, 150, 70, 25); add(chkJava);
        chkPython = new JCheckBox("Python"); chkPython.setBounds(190, 150, 70, 25); add(chkPython);
        chkC = new JCheckBox("C++"); chkC.setBounds(270, 150, 70, 25); add(chkC);

        btnSubmit = new JButton("Submit"); btnSubmit.setBounds(50, 200, 90, 30); add(btnSubmit);
        btnReset = new JButton("Reset"); btnReset.setBounds(160, 200, 90, 30); add(btnReset);

        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);

        setSize(380, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String name = tfName.getText();
            String course = (String) cbCourse.getSelectedItem();
            String gender = rbMale.isSelected() ? "Male" : "Female";
            String subjects = "";
            if (chkJava.isSelected()) subjects += "Java ";
            if (chkPython.isSelected()) subjects += "Python ";
            if (chkC.isSelected()) subjects += "C++ ";

            String info = "Name: " + name + "\nCourse: " + course + "\nGender: " + gender + "\nSubjects: " + subjects;
            JOptionPane.showMessageDialog(this, info);
        } else if (e.getSource() == btnReset) {
            tfName.setText("");
            cbCourse.setSelectedIndex(0);
            rbMale.setSelected(true);
            chkJava.setSelected(false);
            chkPython.setSelected(false);
            chkC.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q5();
    }
}
