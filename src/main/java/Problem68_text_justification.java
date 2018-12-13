import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem68_text_justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int last = 0;
        while(last < words.length) {
            int length = words[last].length();
            int current = last + 1;
            while(current < words.length) {
                if (words[current].length() + length + 1 > maxWidth) {
                    break;
                } else {
                    length += words[current].length() + 1;
                    current++;
                }
            }

            int wordCount = current - last - 1;
            StringBuilder sb = new StringBuilder();
            if (wordCount == 0) {
                sb.append(words[current - 1]);
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else if (current == words.length) {
                for (int i = last; i < current; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                }

                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int allSpaces = maxWidth - length;
                int avgSpaces = allSpaces / wordCount;
                int moreSpaces = allSpaces % wordCount;

                for (int i = last; i < current; i++) {
                    sb.append(words[i]);
                    if (i != current - 1) {
                        for (int j = 0; j <= (avgSpaces + ((i - last) < moreSpaces ? 1 : 0)); j++){
                            sb.append(" ");
                        }
                    }
                }
            }
            result.add(sb.toString());
            last = current;
        }

        return result;
    }

    @Test
    public void test() {
        new Problem68_text_justification().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }
}
