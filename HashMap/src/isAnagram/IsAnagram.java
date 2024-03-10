package isAnagram;

import java.util.*;

public class IsAnagram {

    //242. 有效的字母异位词
    public static boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char item : s.toCharArray()) {
            record[item - 'a'] ++;
        }

        for (char item : t.toCharArray()) {
            record[item - 'a'] --;
        }

        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    //383. 赎金信
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomArray = new int[26];
        for (Character c : ransomNote.toCharArray()) {
            ransomArray[c - 'a'] ++;
        }

        int[] magazineArray = new int[26];
        for (Character c : magazine.toCharArray()) {
            magazineArray[c - 'a'] ++;
        }

        for (int i = 0; i < 26; i++) {
            if (ransomArray[i] > magazineArray[i]) {
                return false;
            }
        }
        return true;
    }

    //49. 字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = resultMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            resultMap.put(key, list);
        }
        return new ArrayList<>(resultMap.values());
    }

    //438. 找到字符串中所有字母异位词
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a'] ++;
            pCount[p.charAt(i) - 'a'] ++;
        }
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            sCount[s.charAt(i)-'a'] --;
            sCount[s.charAt(i+p.length())-'a'] ++;
            if (Arrays.equals(sCount, pCount)) {
                result.add(i+1);
            }
        }
        return result;
    }
}
