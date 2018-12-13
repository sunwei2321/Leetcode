import org.testng.annotations.Test;

public class Problem12_integer_to_roman {
    public String intToRoman(int num) {
        char single;
        char mid;
        char next;

        char[] romans = new char[]{'I','V','X','L','C','D','M'};

        StringBuilder sb = new StringBuilder();
        int i = 1;
        while(num != 0) {
            single = (i > 0 && i < romans.length + 1)? romans[i-1]:0;
            mid = i < romans.length ? romans[i] : 0;
            next = i < romans.length -1 ? romans[i+1]:0;
            int val = num%10;
            num/=10;
            StringBuilder toAppend = new StringBuilder();
            if (val >= 0 && val < 4) {
                for (int j = 0 ; j < val; j++) {
                    toAppend.append(single);
                }
            } else if (val ==4 && val < 9) {
                toAppend.append(single).append(mid);
            } else if (val > 4 && val < 9) {
                toAppend.append(mid);
                for (int j = 5 ; j < val; j++) {
                    toAppend.append(single);
                }
            } else {
                toAppend.append(single).append(next);
            }

            sb.insert(0,toAppend);
            i+=2;
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(new Problem12_integer_to_roman().intToRoman(3999));
    }
}
