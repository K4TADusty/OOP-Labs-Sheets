
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class ChatDemo extends JFrame implements ActionListener {
    private JTextArea jta;
    private JTextField jtf;
    private JButton submit, reset;
    private static final String FILE_PATH = "C:\\My work\\Programming\\Java\\OOP\\Lab\\ChatDemo.dat";

    public ChatDemo(){
        setTitle("ChatDemo");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                saveExit();
                System.exit(0);
            }
        });
        setLayout(new BorderLayout());
        jta = new JTextArea(20, 45);
        jta.setEditable(false);
        JScrollPane sp = new JScrollPane(jta);
        jtf = new JTextField(45);
        submit = new JButton("Submit");
        reset = new JButton("Reset");
        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout());
        jp.setPreferredSize(new Dimension(500, 60));
        jp.add(jtf);
        jp.add(submit);
        jp.add(reset);
        add(sp, BorderLayout.CENTER);
        add(jp, BorderLayout.SOUTH);
        submit.addActionListener(this);
        reset.addActionListener(this);
        setVisible(true);
        loadFile();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            appendText();
        } else if (e.getSource() == reset) {
            jta.setText("");
            saveExit();
        }
    }

    private void appendText() {
        String inputText = jtf.getText().trim();
        if (!inputText.isEmpty()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String timestamp = dtf.format(LocalDateTime.now());
            jta.append(timestamp + " - " + inputText + "\n");
            jtf.setText("");
        }
    }
    
    private void saveExit() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(jta.getText());
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadFile() {
        if (Files.exists(Paths.get(FILE_PATH))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                jta.read(reader, null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new ChatDemo();
    }
}
