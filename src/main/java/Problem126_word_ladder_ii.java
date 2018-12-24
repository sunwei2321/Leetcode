import java.util.*;

public class Problem126_word_ladder_ii {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> matrix = new HashMap<>();
        Map<String, Integer> distanceMap = new HashMap<>();
        List<String> track = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        bfs(beginWord, endWord, wordList, matrix, distanceMap);
        track.add(beginWord);
        dfs(endWord, matrix, distanceMap, track, result);
        return result;
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> matrix, Map<String, Integer> distanceMap) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distanceMap.put(beginWord, 0);
        Set<String> dict = new HashSet();
        for (String str : wordList) {
            dict.add(str);
        }
        int distance = 1;
        while(!queue.isEmpty()) {
            boolean reachEnd = false;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String str = queue.poll();
                List<String> words = getNeighbors(str, dict);
                for (String word : words) {
                    if (!matrix.containsKey(str)) {
                        matrix.put(str, new ArrayList<>());
                    }
                    matrix.get(str).add(word);

                    if (!distanceMap.containsKey(word)) {
                        distanceMap.put(word, distance);
                        queue.offer(word);
                    }

                    if (word.equals(endWord)) {
                        reachEnd = true;
                    }
                }
            }
            if (reachEnd) {
                return;
            }
            distance++;
        }
    }

    private void dfs(String endWord, Map<String, List<String>> matrix, Map<String, Integer> distanceMap, List<String> track, List<List<String>> result) {
        String str = track.get(track.size() - 1);
        if (str.equals(endWord)) {
            result.add(new ArrayList<>(track));
            return;
        }

        if (!matrix.containsKey(str)) {
            return;
        }
        for (String neighbor : matrix.get(str)) {
            if (distanceMap.get(neighbor) == distanceMap.get(str) + 1) {
                track.add(neighbor);
                dfs(endWord, matrix, distanceMap, track, result);
                track.remove(track.size() - 1);
            }
        }
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }
}