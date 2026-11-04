import java.awt.*;
import java.awt.event.*;

public class Labsheet11Q6 extends Frame implements ActionListener {
    TextField tfId, tfName, tfDesig, tfSalary;
    Choice chDept;
    CheckboxGroup cbgGender;
    Checkbox cbMale, cbFemale;
    Button btnSubmit, btnClear;
    TextArea taDisplay;

    public Labsheet11Q6() {
        setLayout(new FlowLayout());

        add(new Label("Employee ID:"));
        tfId = new TextField(20);
        add(tfId);

        add(new Label("Name:"));
        tfName = new TextField(20);
        add(tfName);

        add(new Label("Department:"));
        chDept = new Choice();
        chDept.add("HR"); chDept.add("IT"); chDept.add("Finance"); chDept.add("Sales");
        add(chDept);

        add(new Label("Designation:"));
        tfDesig = new TextField(20);
        add(tfDesig);

        add(new Label("Salary:"));
        tfSalary = new TextField(20);
        add(tfSalary);

        add(new Label("Gender:"));
        cbgGender = new CheckboxGroup();
        cbMale = new Checkbox("Male", cbgGender, true);
        cbFemale = new Checkbox("Female", cbgGender, false);
        add(cbMale); add(cbFemale);

        btnSubmit = new Button("Submit");
        btnClear = new Button("Clear");
        add(btnSubmit); add(btnClear);

        taDisplay = new TextArea(6, 30);
        add(taDisplay);

        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);

        setSize(350, 420);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String info = "ID: " + tfId.getText() + 
                          "\nName: " + tfName.getText() + 
                          "\nDept: " + chDept.getSelectedItem() + 
                          "\nDesignation: " + tfDesig.getText() + 
                          "\nSalary: " + tfSalary.getText() + 
                          "\nGender: " + cbgGender.getSelectedCheckbox().getLabel();
            taDisplay.setText(info);
        } else if (e.getSource() == btnClear) {
            tfId.setText("");
            tfName.setText("");
            chDept.select(0);
            tfDesig.setText("");
            tfSalary.setText("");
            cbgGender.setSelectedCheckbox(cbMale);
            taDisplay.setText("");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q6();
    }
}
