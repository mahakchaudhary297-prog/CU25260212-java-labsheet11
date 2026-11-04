import javax.swing.*;
import java.awt.event.*;

public class Labsheet11Q9 extends JFrame implements ActionListener {
    JTextField tfName, tfRoll, tfCourse;
    JRadioButton rbExc, rbVgood, rbGood, rbAvg, rbPoor;
    ButtonGroup bgRating;
    JCheckBox chkTeach, chkLab, chkMat, chkAssign;
    JTextArea taComments;
    JButton btnSubmit, btnReset;

    public Labsheet11Q9() {
        setTitle("Student Feedback Form");
        setLayout(null);

        JLabel l1 = new JLabel("Name:"); l1.setBounds(30, 20, 100, 25); add(l1);
        tfName = new JTextField(); tfName.setBounds(140, 20, 150, 25); add(tfName);

        JLabel l2 = new JLabel("Roll Number:"); l2.setBounds(30, 55, 100, 25); add(l2);
        tfRoll = new JTextField(); tfRoll.setBounds(140, 55, 150, 25); add(tfRoll);

        JLabel l3 = new JLabel("Course:"); l3.setBounds(30, 90, 100, 25); add(l3);
        tfCourse = new JTextField(); tfCourse.setBounds(140, 90, 150, 25); add(tfCourse);

        JLabel l4 = new JLabel("Rating:"); l4.setBounds(30, 125, 100, 25); add(l4);
        rbExc = new JRadioButton("Excellent", true); rbExc.setBounds(140, 125, 90, 25); add(rbExc);
        rbVgood = new JRadioButton("Very Good"); rbVgood.setBounds(230, 125, 100, 25); add(rbVgood);
        rbGood = new JRadioButton("Good"); rbGood.setBounds(330, 125, 70, 25); add(rbGood);
        rbAvg = new JRadioButton("Average"); rbAvg.setBounds(400, 125, 80, 25); add(rbAvg);
        rbPoor = new JRadioButton("Poor"); rbPoor.setBounds(480, 125, 60, 25); add(rbPoor);
        bgRating = new ButtonGroup();
        bgRating.add(rbExc); bgRating.add(rbVgood); bgRating.add(rbGood); bgRating.add(rbAvg); bgRating.add(rbPoor);

        JLabel l5 = new JLabel("Feedback on:"); l5.setBounds(30, 160, 100, 25); add(l5);
        chkTeach = new JCheckBox("Teaching"); chkTeach.setBounds(140, 160, 90, 25); add(chkTeach);
        chkLab = new JCheckBox("Laboratory"); chkLab.setBounds(230, 160, 100, 25); add(chkLab);
        chkMat = new JCheckBox("Course Material"); chkMat.setBounds(330, 160, 120, 25); add(chkMat);
        chkAssign = new JCheckBox("Assignments"); chkAssign.setBounds(450, 160, 100, 25); add(chkAssign);

        JLabel l6 = new JLabel("Comments:"); l6.setBounds(30, 195, 100, 25); add(l6);
        taComments = new JTextArea(); taComments.setBounds(140, 195, 300, 60); add(taComments);

        btnSubmit = new JButton("Submit"); btnSubmit.setBounds(140, 270, 90, 30); add(btnSubmit);
        btnReset = new JButton("Reset"); btnReset.setBounds(250, 270, 90, 30); add(btnReset);

        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);

        setSize(580, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String rating = "";
            if (rbExc.isSelected()) rating = "Excellent";
            else if (rbVgood.isSelected()) rating = "Very Good";
            else if (rbGood.isSelected()) rating = "Good";
            else if (rbAvg.isSelected()) rating = "Average";
            else if (rbPoor.isSelected()) rating = "Poor";

            String feedbackOn = "";
            if (chkTeach.isSelected()) feedbackOn += "Teaching ";
            if (chkLab.isSelected()) feedbackOn += "Laboratory ";
            if (chkMat.isSelected()) feedbackOn += "Course Material ";
            if (chkAssign.isSelected()) feedbackOn += "Assignments ";

            String info = "Name: " + tfName.getText() + 
                          "\nRoll: " + tfRoll.getText() + 
                          "\nCourse: " + tfCourse.getText() + 
                          "\nRating: " + rating + 
                          "\nFeedback On: " + feedbackOn + 
                          "\nComments: " + taComments.getText();
            JOptionPane.showMessageDialog(this, info);
        } else if (e.getSource() == btnReset) {
            tfName.setText("");
            tfRoll.setText("");
            tfCourse.setText("");
            rbExc.setSelected(true);
            chkTeach.setSelected(false);
            chkLab.setSelected(false);
            chkMat.setSelected(false);
            chkAssign.setSelected(false);
            taComments.setText("");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q9();
    }
}
