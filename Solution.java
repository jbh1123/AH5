import java.util.HashMap;
import java.util.TreeMap;

class Solution {
    public static char mostFrequentChar(String s) {
        var sAsCharArray = s.toCharArray();
        var charFreqMap = new TreeMap<Character, Integer>();
        var indexCharFirstScene = new HashMap<Character, Integer>();
        int maxFreq = 1;

        for (int i = 0; i < sAsCharArray.length; i++) {
            char c = sAsCharArray[i];
            indexCharFirstScene.putIfAbsent(c, i);

            var currFreq = charFreqMap.putIfAbsent(c, 1);
            if (currFreq != null) {
                charFreqMap.put(c, currFreq + 1);
                maxFreq = Math.max(currFreq + 1, maxFreq);
            }
        }
        int finalMaxFreq = maxFreq;

        return charFreqMap.entrySet().stream().filter(
                element -> element.getValue() == finalMaxFreq).reduce(
                (a, b) -> (
                        indexCharFirstScene.get(a.getKey()) <
                        indexCharFirstScene.get(b.getKey())
                        ) ? a : b).get().getKey();
    }

    public static void main(String[] args) {
        // Try out your test cases:
        System.out.println(Solution.mostFrequentChar("bookeeper")); // -> 'e'
        System.out.println(Solution.mostFrequentChar("david")); // -> 'd'
        System.out.println(Solution.mostFrequentChar("mississippi")); // -> 'i'
        System.out.println(Solution.mostFrequentChar("eleventennine")); // -> 'e'
    }

}
