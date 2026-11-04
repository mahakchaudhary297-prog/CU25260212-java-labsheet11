import java.awt.*;
import java.awt.event.*;

public class Labsheet11Q1 extends Frame implements ActionListener {
    TextField tfName, tfRoll, tfCourse;
    Checkbox cbMale, cbFemale;
    CheckboxGroup cbgGender;
    Choice chSem;
    Button btnSubmit, btnReset;
    TextArea taDisplay;

    public Labsheet11Q1() {
        setLayout(new FlowLayout());
        add(new Label("Name:"));
        tfName = new TextField(20);
        add(tfName);

        add(new Label("Roll Number:"));
        tfRoll = new TextField(20);
        add(tfRoll);

        add(new Label("Course:"));
        tfCourse = new TextField(20);
        add(tfCourse);

        add(new Label("Gender:"));
        cbgGender = new CheckboxGroup();
        cbMale = new Checkbox("Male", cbgGender, true);
        cbFemale = new Checkbox("Female", cbgGender, false);
        add(cbMale);
        add(cbFemale);

        add(new Label("Semester:"));
        chSem = new Choice();
        chSem.add("1st"); chSem.add("2nd"); chSem.add("3rd"); chSem.add("4th");
        chSem.add("5th"); chSem.add("6th"); chSem.add("7th"); chSem.add("8th");
        add(chSem);

        btnSubmit = new Button("Submit");
        btnReset = new Button("Reset");
        add(btnSubmit);
        add(btnReset);

        taDisplay = new TextArea(5, 30);
        add(taDisplay);

        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);

        setSize(350, 400);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String gender = cbgGender.getSelectedCheckbox().getLabel();
            String info = "Name: " + tfName.getText() + "\nRoll: " + tfRoll.getText() + 
                          "\nCourse: " + tfCourse.getText() + "\nGender: " + gender + 
                          "\nSemester: " + chSem.getSelectedItem();
            taDisplay.setText(info);
        } else if (e.getSource() == btnReset) {
            tfName.setText("");
            tfRoll.setText("");
            tfCourse.setText("");
            cbgGender.setSelectedCheckbox(cbMale);
            chSem.select(0);
            taDisplay.setText("");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q1();
    }
}
