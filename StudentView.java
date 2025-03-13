
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class StudentView extends JFrame implements ActionListener {
    private Student student;
    private JTextField tfID, tfName, tfMoney;
    private JLabel id, name, money;
    private JButton deposit, withdraw;
    private static final String FILE_PATH = "C:\\My work\\Programming\\Java\\OOP\\Lab\\StudentM.dat";

    public StudentView() {
        student = loadStudent();
        setTitle("StudentView");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new GridLayout(4,2));

        id = new JLabel("  ID:");
        name = new JLabel("  Name:");
        money = new JLabel("  Money:");

        tfID = new JTextField(String.valueOf(student.getID()));
        tfName = new JTextField(student.getName());
        tfMoney = new JTextField(String.valueOf(student.getMoney()));
        tfMoney.setEditable(false);

        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");

        add(id);
        add(tfID);
        add(name);
        add(tfName);
        add(money);
        add(tfMoney);
        add(deposit);
        add(withdraw);

        deposit.addActionListener(this);
        withdraw.addActionListener(this);

        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                student.setName(tfName.getText());
                student.setID(Integer.parseInt(tfID.getText()));
                student.setMoney(Integer.parseInt(tfMoney.getText()));
                saveFile();
                System.exit(0);
            }
        });
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            student.setMoney(student.getMoney() + 100);
        } else if (e.getSource() == withdraw && student.getMoney() >= 100) {
            student.setMoney(student.getMoney() - 100);
        }
        tfMoney.setText(String.valueOf(student.getMoney()));
    }

    private void saveFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            writer.println(student.getID());
            writer.println(student.getName());
            writer.println(student.getMoney());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Student loadStudent() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                int money = Integer.parseInt(reader.readLine());

                return new Student(name, id, money);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return new Student();
    }

    public static void main(String[] args) {
        new StudentView();
    }
}
