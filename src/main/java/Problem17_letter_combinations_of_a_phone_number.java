import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem17_letter_combinations_of_a_phone_number {
    public List<String> letterCombinations(String digits) {
        String[] keys = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return generate(0, keys, digits);

    }

    private List<String> generate(int index, String[] keys, String digits) {
        if (index == digits.length()) {
            return new ArrayList<>();
        }

        String val = keys[digits.charAt(index) - '0' - 1];
        List<String> subs = generate(index+1, keys, digits);

        List<String> result = new ArrayList<>();
        for (char c : val.toCharArray()) {
            if (subs.size() == 0) {
                result.add(String.valueOf(c));
            } else {
                for (String sub:subs) {
                    result.add(String.valueOf(c) + sub);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(new Problem17_letter_combinations_of_a_phone_number().letterCombinations("23"));
    }
}