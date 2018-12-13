import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem89_gray_code {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return Arrays.asList(0);
        }

        int mask = 1;
        List<Integer> current = Arrays.asList(0, 1);
        for (int i = 2; i <= n; i++) {
            mask = mask << 1;
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < current.size(); j++) {
                l.add(current.get(j));
            }

            for (int j = current.size() - 1; j >= 0; j--) {
                l.add(current.get(j)|mask);
            }
            current = l;
        }
        return current;
    }

    @Test
    public void test() {
        System.out.println(new Problem89_gray_code().grayCode(2).toString());
    }
}
