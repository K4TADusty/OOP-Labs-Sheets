public class Student {
    private String name;
    private int ID;
    private int money;

    public Student() {
    }

    public Student(String name, int ID, int money) {
        this.name = name;
        this.ID = ID;
        this.money = money;
    }

    public int getID() {
        return ID;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
}
