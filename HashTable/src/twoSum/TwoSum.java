package twoSum;

import java.util.*;

public class TwoSum {

    //1.两数之和
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = record.get(target - nums[i]);
                return res;
            }
            record.put(nums[i], i);
        }
        return res;
    }

    //15.三数之和 a+b+c = 0, 双指针法
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            //a去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //b,c去重
                    while (left < right && nums[right-1] == nums[right]) {right--;}
                    while (left < right && nums[left] == nums[left+1]) {left++;}

                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    //18.四数之和
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j = i+1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right-1]) {right --;}
                        while (left < right && nums[left] == nums[left+1]) {left++;}
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    //454. 四数相加 II
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> record = new HashMap<>();
        int res = 0;

        for (int i : nums1) {
            for (int j : nums2) {
                record.put(i+j, record.getOrDefault(i+j, 0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                res += record.getOrDefault(0-i-j, 0);
            }
        }
        return res;
    }
}
