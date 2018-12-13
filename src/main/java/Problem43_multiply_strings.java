import org.testng.annotations.Test;

public class Problem43_multiply_strings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] vals = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = num2.length() - 1; j >=0; j--) {
                int val = vals[i+j+1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                vals[i+j+1] = val%10;
                carry = val/10;
            }
            vals[i]+=carry;
        }

        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == 0) {
                continue;
            } else {
                StringBuilder result = new StringBuilder();
                for (int j = i; j < vals.length; j++) {
                    result.append(vals[j]);
                }
                return result.toString();
            }
        }
        return "0";
    }

    @Test
    public void test() {
        new Problem43_multiply_strings().multiply("12", "3");
    }
}
