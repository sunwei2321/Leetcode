import org.testng.annotations.Test;

public class Problem29_divide_two_integers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        int result = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else {
                dividend += Math.abs(divisor);
                result++;
            }
        }

        if (divisor == Integer.MIN_VALUE) {
            return result;
        }

        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int base = divisor;
        int count = 1;
        while(base <= (dividend >> 1)) {
            base <<= 1;
            count <<= 1;
        }


        while (base!=0) {
            int next = base;
            base >>= 1;

            int nextCount = count;
            count >>= 1;
            if (dividend >= next) {
                dividend -= next;
                result += nextCount;
            }
        }
        return result * (negative ? -1 : 1);
    }

    @Test
    public void test() {
        System.out.print(new Problem29_divide_two_integers().divide(2147483647, 1));
        System.out.print(new Problem29_divide_two_integers().divide(-2147483648, 1));
    }
}
