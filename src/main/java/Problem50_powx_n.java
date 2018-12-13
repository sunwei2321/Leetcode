public class Problem50_powx_n {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (x == 1) {

        }

        double result = 1;
        if (n == Integer.MIN_VALUE) {
            n = Integer.MIN_VALUE + 1;
            result = x;
        }
        if (n < 0) {
            return 1/(pow0(x, Math.abs(n))*result);
        } else {
            return pow0(x, n);
        }
    }

    private double pow0(double x, int n) {
        if (n == 1) {
            return x;
        }

        if (n%2 == 0) {
            double val = pow0(x, n/2);
            return val*val;
        } else {
            double val = pow0(x, n/2);
            return val*val*x;
        }
    }
}
