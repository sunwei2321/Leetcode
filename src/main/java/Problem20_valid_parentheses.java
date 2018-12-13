import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem20_valid_parentheses {
    public boolean isValid(String s) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('{', '}');
        charMap.put('[', ']');


        Map<Character, Character> charMap1 = new HashMap<>();
        charMap1.put(')', '(');
        charMap1.put('}', '{');
        charMap1.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if (charMap.containsKey(c)) {
                stack.push(c);
            } else {
                Character val = charMap1.get(c);
                if (stack.size() > 0  && stack.peek().equals(val)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
