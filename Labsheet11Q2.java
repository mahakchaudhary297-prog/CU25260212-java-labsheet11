import java.awt.*;
import java.awt.event.*;

public class Labsheet11Q2 extends Frame implements ActionListener {
    TextField tfNum1, tfNum2, tfResult;
    Button btnAdd, btnSub, btnMul, btnDiv;

    public Labsheet11Q2() {
        setLayout(new FlowLayout());
        add(new Label("Number 1:"));
        tfNum1 = new TextField(10);
        add(tfNum1);

        add(new Label("Number 2:"));
        tfNum2 = new TextField(10);
        add(tfNum2);

        btnAdd = new Button("+");
        btnSub = new Button("-");
        btnMul = new Button("*");
        btnDiv = new Button("/");
        add(btnAdd); add(btnSub); add(btnMul); add(btnDiv);

        add(new Label("Result:"));
        tfResult = new TextField(15);
        tfResult.setEditable(false);
        add(tfResult);

        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);

        setSize(250, 250);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(tfNum1.getText());
            double n2 = Double.parseDouble(tfNum2.getText());
            double res = 0;

            if (e.getSource() == btnAdd) {
                res = n1 + n2;
                tfResult.setText(String.valueOf(res));
            } else if (e.getSource() == btnSub) {
                res = n1 - n2;
                tfResult.setText(String.valueOf(res));
            } else if (e.getSource() == btnMul) {
                res = n1 * n2;
                tfResult.setText(String.valueOf(res));
            } else if (e.getSource() == btnDiv) {
                if (n2 == 0) {
                    tfResult.setText("Error: Div by zero");
                } else {
                    res = n1 / n2;
                    tfResult.setText(String.valueOf(res));
                }
            }
        } catch (NumberFormatException ex) {
            tfResult.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q2();
    }
}
