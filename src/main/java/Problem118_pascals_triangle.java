import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem118_pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(1);
        result.add(current);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    newList.add(1);
                } else {
                    newList.add(current.get(j-1) + current.get(j));
                }
            }
            result.add(newList);
            current = newList;
        }

        return result;
    }

}
