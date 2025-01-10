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
