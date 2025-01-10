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

    private void simplify() {
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
