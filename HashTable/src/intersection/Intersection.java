package intersection;

import java.util.*;

public class Intersection {

    //349.两个数组的交集
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i : nums1) {
            nums1Set.add(i);
        }

        for (int i : nums2) {
            if (nums1Set.contains(i)) {
                resSet.add(i);
            }
        }

        return resSet.stream().mapToInt(x -> x).toArray();
    }

    //350. 两个数组的交集 II
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int i : nums1) {
            nums1Map.put(i, nums1Map.getOrDefault(i, 0) + 1);
        }

        List<Integer> countList = new ArrayList<>();
        for (int i : nums2) {
            if (nums1Map.containsKey(i)) {
                countList.add(i);
                int count = nums1Map.get(i) - 1;
                if (count == 0) {
                    nums1Map.remove(i);
                } else {
                    nums1Map.put(i, count);
                }
            }
        }
        return countList.stream().mapToInt(x -> x).toArray();
    }
}
