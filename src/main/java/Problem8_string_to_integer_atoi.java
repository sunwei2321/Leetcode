import org.testng.annotations.Test;

public class Problem8_string_to_integer_atoi {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            if (chars[i] == '-') {
                return myAtoi0(chars, i+1, false);
            }

            if (chars[i] == '+') {
                return myAtoi0(chars, i+1, true);
            }

            if (chars[i]>=48 && chars[i]<=57) {
                return myAtoi0(chars, i, true);
            } else {
                return 0;
            }
        }
        return 0;
    }

    private int myAtoi0(char[] chars, int start, boolean positive) {
        int val = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i]>=48 && chars[i]<=57) {
                int v = chars[i]-48;
                if (positive) {
                    if ((Integer.MAX_VALUE - v)/10 < val) {
                        return Integer.MAX_VALUE;
                    } else {
                        val = val * 10 + v;
                    }
                } else {
                    if (val< (Integer.MIN_VALUE +v)/10) {
                        return Integer.MIN_VALUE;
                    } else {
                        val = val*10 - v;
                    }
                }

            } else {
                return val;
            }
        }
        return val;
    }

    @Test
    public void test() {
        Problem8_string_to_integer_atoi p = new Problem8_string_to_integer_atoi();
        System.out.println(p.myAtoi("-000000000001"));
    }
}
