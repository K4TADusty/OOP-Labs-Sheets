package Week_9;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class TellerGUI extends JFrame {
    private JFrame fr;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;

    private JTextField blank;
    private JLabel lBalance;
    private JLabel lBalanceNum;
    private JLabel lAmount;
    private JButton btnDeposit;
    private JButton btnWithdraw;
    private JButton btnExit;

    private Account account;

    public TellerGUI() {
        account = new Account(6000);

        fr = new JFrame("Teller GUI");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        blank = new JTextField();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        lBalance = new JLabel("Balance");
        lBalanceNum = new JLabel(String.valueOf(account.getBalance()));
        lAmount = new JLabel("Amount");
        blank = new JTextField();
        btnDeposit = new JButton("Deposit");
        btnWithdraw = new JButton("Withdraw");
        btnExit = new JButton("Exit");

        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new FlowLayout());

        p1.add(lBalance);
        p1.add(lBalanceNum);

        p2.add(lAmount);
        p2.add(blank);

        p3.add(btnDeposit);
        p3.add(btnWithdraw);
        p3.add(btnExit);

        fr.setLayout(new GridLayout(4, 1));
        fr.add(p1);
        fr.add(p2);
        fr.add(p3);
        fr.add(p4);
        fr.pack();
        fr.setVisible(true);

        btnDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(blank.getText());
                account.deposit(amount);
                lBalanceNum.setText(String.valueOf(account.getBalance()));
            }
        });

        btnWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(blank.getText());
                account.withdraw(amount);
                lBalanceNum.setText(String.valueOf(account.getBalance()));
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        TellerGUI test = new TellerGUI();
    }
}