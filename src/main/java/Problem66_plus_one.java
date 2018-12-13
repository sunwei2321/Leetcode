import java.util.Arrays;

public class Problem66_plus_one {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }

        int[] result = new int[digits.length + 1];
        int carry = 1;

        for (int i = 0; i < digits.length; i++) {
            int sum = digits[digits.length - 1 - i] + carry;
            result[digits.length - i] = sum % 10;
            carry = sum/10;
        }

        if (carry > 0) {
            result[0] = carry;
            return result;
        } else {
            return Arrays.copyOfRange(result, 1, result.length);
        }
    }
}
