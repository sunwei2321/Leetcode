import java.util.Stack;

public class Problem71_simplify_path {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            if (str.equals("") || str.equals(".")) {
                continue;
            }
            if (str.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        String result = new String();
        while(!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }

        if (result.length() == 0) {
            return "/";
        } else {
            return result;
        }
    }
}