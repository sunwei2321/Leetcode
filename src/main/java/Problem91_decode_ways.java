import org.testng.annotations.Test;

public class Problem91_decode_ways {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] matrix = new int[s.length()+1];
        matrix[0] = 1;
        matrix[1] = s.charAt(0) != '0' ? 1 : 0;

        for(int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first > 0 && first <= 9) {
                matrix[i] += matrix[i-1];
            }
            if (second >= 10 && second <= 26) {
                matrix[i] += matrix[i-2];
            }
        }
        return matrix[s.length()];
    }

    @Test
    public void test() {
        System.out.println(new Problem91_decode_ways().numDecodings("01"));
        System.out.println(new Problem91_decode_ways().numDecodings("101"));
        System.out.println(new Problem91_decode_ways().numDecodings("27"));
    }
}
