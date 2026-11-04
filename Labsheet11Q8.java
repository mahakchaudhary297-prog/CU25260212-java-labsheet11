import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Labsheet11Q8 extends JFrame implements ActionListener {
    JTextArea ta;
    JMenuBar mb;
    JMenu fileMenu;
    JMenuItem miNew, miOpen, miSave, miExit;

    public Labsheet11Q8() {
        setTitle("Simple Notepad");
        ta = new JTextArea();
        add(new JScrollPane(ta));

        mb = new JMenuBar();
        fileMenu = new JMenu("File");

        miNew = new JMenuItem("New");
        miOpen = new JMenuItem("Open");
        miSave = new JMenuItem("Save");
        miExit = new JMenuItem("Exit");

        fileMenu.add(miNew);
        fileMenu.add(miOpen);
        fileMenu.add(miSave);
        fileMenu.addSeparator();
        fileMenu.add(miExit);

        mb.add(fileMenu);
        setJMenuBar(mb);

        miNew.addActionListener(this);
        miOpen.addActionListener(this);
        miSave.addActionListener(this);
        miExit.addActionListener(this);

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("New")) {
            ta.setText("");
        } else if (cmd.equals("Open")) {
            JFileChooser fc = new JFileChooser();
            int opt = fc.showOpenDialog(this);
            if (opt == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    ta.setText("");
                    String line;
                    while ((line = br.readLine()) != null) {
                        ta.append(line + "\n");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error reading file.");
                }
            }
        } else if (cmd.equals("Save")) {
            JFileChooser fc = new JFileChooser();
            int opt = fc.showSaveDialog(this);
            if (opt == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    bw.write(ta.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file.");
                }
            }
        } else if (cmd.equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Labsheet11Q8();
    }
}
