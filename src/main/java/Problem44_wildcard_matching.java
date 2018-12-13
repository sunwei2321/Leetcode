public class Problem44_wildcard_matching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] vals = new boolean[s.length() + 1][p.length() + 1];
        vals[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            vals[0][j+1] = vals[0][j] && (p.charAt(j) == '*');
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                char c = p.charAt(j);
                if (c == '*') {
                    vals[i+1][j+1] = vals[i+1][j] || vals[i][j+1];
                } else if (c == '?') {
                    vals[i+1][j+1] = vals[i][j];
                } else {
                    vals[i+1][j+1] = vals[i][j] && (s.charAt(i) == p.charAt(j));
                }
            }
        }
        return vals[s.length()][p.length()];

    }
}
