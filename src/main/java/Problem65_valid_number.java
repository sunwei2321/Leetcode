public class Problem65_valid_number {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean point = false;
        boolean number = false;
        boolean numberAfterE = true;
        boolean e = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '.') {
                if (e || point) {
                    return false;
                }
                point = true;
            } else if (c == 'e') {
                if (e || !number) {
                    return false;
                }
                e = true;
                numberAfterE = false;
            } else if (c == '-' || c == '+') {
                if (i > 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else if (c >= '0' && c <= '9') {
                number = true;
                numberAfterE = true;
            } else {
                return false;
            }
        }
        return number && numberAfterE;
    }
}
