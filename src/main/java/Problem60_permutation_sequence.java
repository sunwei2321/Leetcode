import java.util.ArrayList;
import java.util.List;

public class Problem60_permutation_sequence {
    public String getPermutation(int n, int k) {
        int product = 1;
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            product *=i;
            num.add(i);
        }

        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            product /= i;
            int index = k / product;
            k = k % product;
            sb.append(num.get(index));
            num.remove(index);
        }

        return sb.toString();
    }
}
