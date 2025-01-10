public class Main {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.name = "Taravichet";

        MyDate dob = new MyDate();
        dob.day = 8;
        dob.month = 11;
        dob.year = 2023;

        Account acct = new Account();
        acct.name = c.name;
        acct.balance = 500;

        c.DOB = dob;
        c.acct = acct;

        System.out.println("My name is " + c.name + ".");

        c.acct.showInfo();
        c.DOB.showDate();

        c.acct.deposit(500);
        c.acct.showInfo();
        c.acct.withdraw(3000);
        c.acct.showInfo();
    }
}

class Customer {
    String name;
    MyDate DOB;
    Account acct;
}

class MyDate {
    int day;
    int month;
    int year;

    void showDate() {
        System.out.println(day + "/" + month + "/" + year);
    }
}

class Account {
    String name;
    double balance;

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Your account balance is insufficient.");
        }
    }

    void showInfo() {
        System.out.println("In " + name + " account, there is a balance equal to " + balance + " baht.");
    }
}
