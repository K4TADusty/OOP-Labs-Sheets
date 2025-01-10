public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(1, 4);
        Fraction f3 = new Fraction(1, 3);
        System.out.println(f1.toFloat());
        System.out.println(f2.toFloat());
        System.out.println(f3.toFloat());
        System.out.println("f1 is equal to f2 >> " + f1.equals(f2));
        System.out.println("f1 is equal to f3 >> " + f1.equals(f3));

        Fraction f4 = new Fraction(4, 16);
        System.out.println("Before : " + f4.toFraction());
        f4.simplify();
        System.out.println("After : " + f4.toFraction());
    }
}

class Fraction {
    int topN;
    int btmN;

    public Fraction(int top, int bottom) {
        this.topN = top;
        this.btmN = bottom;
        simplify();
    }

    public Fraction() {
        this.topN = 0;
        this.btmN = 1;
    }

    public void addFraction(Fraction f) {
        this.topN = this.topN * f.btmN + f.topN * this.btmN;
        this.btmN = this.btmN * f.btmN;
        simplify();
    }

    public String toFraction() {
        return this.topN + "/" + this.btmN;
    }

    public double toFloat() {
        return (double) this.topN / this.btmN;
    }

    public boolean equals(Fraction f) {
        return this.topN == f.topN && this.btmN == f.btmN;
    }

    public void simplify() {
        int gcd = gcd(this.topN, this.btmN);
        this.topN /= gcd;
        this.btmN /= gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
