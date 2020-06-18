import java.util.HashMap;
import java.util.HashSet;

public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {

        String[] mose = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String letter = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = letter.toCharArray();
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < letter.length(); i++) {
            map.put(chars[i], mose[i]);
        }
        for (String word : words) {
            char[] chars1 = word.toCharArray();
            StringBuilder res = new StringBuilder();
            for (char wordChar:chars1) {
                res.append(map.get(wordChar));
            }
            set.add(res.toString());
        }
        return set.size();
    }
}
