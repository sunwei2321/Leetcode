import org.testng.annotations.Test;

public class Problem10_regular_expression_matching {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() >0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }

        String s1 = s;
        while(s1.length() >0 && (p.charAt(0) == s1.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s1, p.substring(2))) {
                return true;
            }
            s1 = s1.substring(1);
        }
        return isMatch(s1, p.substring(2));
    }

    @Test
    public void test(){
        System.out.println(new Problem10_regular_expression_matching().isMatch("AA", "A*A"));
    }
}
