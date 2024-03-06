package minSubArrayLen;

import java.util.*;

public class MinSubArrayLen {

    //209.长度最小的子数组
    //暴力解法：O(n2)
    public static int minSubArrayLen1(int s, int[] nums) {
        int result = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum >= s) {
                    result = result > (j-i+1) ? (j-i+1) : result;
                    break;
                }
            }
        }
        if(result == nums.length + 1) {
            return 0;
        }
        return result;
    }
    //滑动窗口：O(n)
    public static int minSubArrayLen2(int s, int[] nums) {
        //i为窗口开始指针
        int i = 0;
        int sum = 0;
        int result = nums.length + 1;
        //j为窗口终止指针
        for (int j = 0; j < nums.length; j++) {
            sum = sum + nums[j];
            if (sum >= s) {
                //在[i,j]区间和满足条件的情况下向前移动窗口开始指针i
                while (sum >= s) {
                    result = Math.min(result, (j - i + 1));
                    sum = sum - nums[i];
                    i++;
                }
            }
        }
        return result == nums.length + 1 ? 0 : result;
    }

    //904.水果成篮
    public static int totalFruit(int[] fruits) {
        //i为窗口左指针
        int i = 0;
        int result = 0;
        //记录窗口内不同数值，及其出现个数，出现个数用于判断是否要删除该数值
        Map<Integer, Integer> cntMap = new HashMap<>();
        //j为窗口右指针
        for (int j = 0; j < fruits.length; j++) {
            cntMap.put(fruits[j], cntMap.getOrDefault(fruits[j],0) + 1);
            //当数值总类超过2时，左指针就要向前移动了
            while (cntMap.size() > 2) {
                cntMap.put(fruits[i], cntMap.get(fruits[i]) - 1);
                //移动时，如果对应数值出现的次数已经清零，则要删除该数值的记录
                if (cntMap.get(fruits[i]) == 0) {
                    cntMap.remove(fruits[i]);
                }
                i++;
            }
            result = Math.max(result, j-i+1);
        }
        return result;
    }

    //76.最小覆盖子串
    public static String minWindow(String s, String t) {
        //维护两个Map记录字符及对应词频
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char item : t.toCharArray()) {
            need.put(item, need.getOrDefault(item, 0) + 1);
        }

        //记录满足条件子串的起始索引和长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        //窗口的两侧指针
        int left = 0, right = 0;
        //满足要求的字符的个数，当match == need.size()时窗口即为合法窗口
        int match = 0;
        while(right < s.length()) {
            //更新窗口
            char rightItem = s.charAt(right);
            //窗口扩大
            right++;
            //这里只用关心need包含的字出现的频率即可
            if (need.containsKey(rightItem)) {
                window.put(rightItem, window.getOrDefault(rightItem, 0) + 1);
                if (Objects.equals(window.get(rightItem), need.get(rightItem))) {
                    match++;
                }
            }

            //寻找最优解
            while(match == need.size()){
                //更新最优窗口大小
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                //缩小窗口
                char leftItem = s.charAt(left);
                //这里为什么要先left++,因为left已经是满足条件的边界，要看下一个是否也是满足条件的边界
                left++;
                if(need.containsKey(leftItem)) {
                    if(Objects.equals(window.get(leftItem), need.get(leftItem))) {
                        match--;
                    }
                    window.put(leftItem, window.get(leftItem)-1);
                }
            }
        }
        //边界问题：start记录的是满足条件的左指针
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    //438.找到字符串中所有字母异位词
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        //统计前p数量字符的词频
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        //判断前p数量字符是否与p异位
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }

        //以p的长度为窗口，在s中向前移动
        for(int i = 0; i < s.length() - p.length(); i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i+p.length()) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                //这里必须是i+1,因为判断的是i+1开始的窗口
                result.add(i+1);
            }
        }
        return result;
    }

    //567. 字符串的排列
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Index = new int[26];
        int[] s2Index = new int[26];

        //记录字符索引位置：
        for(int i = 0; i < s1.length(); i++) {
            s1Index[s1.charAt(i)-'a'] ++;
            s2Index[s2.charAt(i)-'a'] ++;
        }
        if (Arrays.equals(s1Index, s2Index)) {
            return true;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            s2Index[s2.charAt(i)-'a']--;
            s2Index[s2.charAt(i+s1.length()) - 'a']++;
            if (Arrays.equals(s1Index, s2Index)) {
                return true;
            }
        }
        return false;
    }
    //76，438，567通用模型解法
    public static boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        //统计词频
        for (char item : s1.toCharArray()) {
            need.put(item, need.getOrDefault(item, 0) + 1);
        }

        //窗口左右指针
        int left = 0, right = 0;
        int match = 0;
        while(right < s2.length()) {
            char rightItem = s2.charAt(right);
            if (need.containsKey(rightItem)) {
                window.put(rightItem, window.getOrDefault(rightItem, 0) + 1);
                if (Objects.equals(need.get(rightItem), window.get(rightItem))) {
                    match++;
                }
            }

            //满足窗口滑动的条件，有效窗口边界是[left, right]
            while(right-left+1 == s1.length()) {
                if (match == need.size()) {
                    return true;
                }
                char leftItem = s2.charAt(left);
                if (need.containsKey(leftItem)) {
                    if (Objects.equals(need.get(leftItem), window.get(leftItem))) {
                        match--;
                    }
                    window.put(leftItem, window.get(leftItem) - 1);
                }
                left++;
            }
            right++;
        }
        return false;
    }
}
