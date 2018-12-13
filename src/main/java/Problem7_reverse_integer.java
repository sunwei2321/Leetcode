import org.testng.annotations.Test;

public class Problem7_reverse_integer {
    public int reverse(int x) {
        if (x < 0) {
            return -1 * reverse0(x * -1);
        } else {
            return reverse0(x);
        }
    }

    private int reverse0(int x) {
        int current = x;
        int result = 0;
        while (current != 0) {
            int last = current % 10;
            current/=10;
            if ((Integer.MAX_VALUE - last)/10 < result) {
                return 0;
            } else {
                result = (result * 10 + last);
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(new Problem7_reverse_integer().reverse(-2147483412));
    }
}
