import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem77_combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || n < k) {
            return Collections.EMPTY_LIST;
        }
        return combine0(n, k ,1);
    }

    private List<List<Integer>> combine0(int n, int k, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 1) {
            for (int i = start; i <= n; i++) {
                result.add(Arrays.asList(i));
            }
        } else {
            for (int i = 0; i < (n - k - start + 2); i++) {
                int current = start + i;
                List<List<Integer>> subs = combine0(n, k - 1, start + 1 + i);
                for (List<Integer> sub : subs) {
                    List<Integer> newSub = new ArrayList<>();
                    newSub.add(current);
                    newSub.addAll(sub);
                    result.add(newSub);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Integer>> result = new Problem77_combinations().combine(4, 2);
        for (List<Integer> sub : result) {
            System.out.println(sub.toString());
        }
    }
}
