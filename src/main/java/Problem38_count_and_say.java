public class Problem38_count_and_say {
    public String countAndSay(int n) {
        String say = "1";
        if (n == 1) {
            return say;
        }

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char[] chars = say.toCharArray();
            char current = chars[0];
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == current) {
                    count++;
                } else {
                    sb.append(count).append(current);
                    count = 1;
                    current = chars[j];
                }
            }
            sb.append(count).append(current);
            say = sb.toString();
        }
        return say;
    }
}
