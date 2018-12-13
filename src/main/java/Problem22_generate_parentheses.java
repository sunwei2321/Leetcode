import org.testng.annotations.Test;

import java.util.*;

public class Problem22_generate_parentheses {
    public List<String> generateParenthesis(int n) {


        Map<Integer, List<String>> tmp = new HashMap<>();
        return generateParenthesis0(tmp, n);
    }

    private List<String> generateParenthesis0(Map<Integer, List<String>> tmp, int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return Arrays.asList("");
        }
        for (int i = 0; i < n; i++) {
            List<String> subs;
            if (tmp.containsKey(i)) {
                subs = tmp.get(i);
            } else {
                subs = generateParenthesis0(tmp, i);
                tmp.put(i, subs);
            }
            for (String sub : subs) {
                for (String sub1 : generateParenthesis0(tmp, n-i-1)) {
                    result.add("(" + sub + ")" + sub1);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(new Problem22_generate_parentheses().generateParenthesis(3));
    }
}
