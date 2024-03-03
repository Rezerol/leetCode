package binarySearch;

public class BinarySearch {

    /**
     * 二分查找规律
     *
     * 初始化：
     * int left = 0;
     * int right = nums.length - 1;
     * 循环条件：
     * left <= right
     * 右边取值：
     * right = mid - 1;
     * 左边取值：
     * left = mid + 1;
     * 查询条件：
     * 找 >= target 时， nums[mid] >= target时，right = mid - 1;
     * 找 >  target 时， nums[mid] >  target时，right = mid - 1;
     * 找 <= target 时， nums[mid] <= target时，left = mid + 1;
     * 找 <  target 时， nums[mid] <  target时，left = mid + 1;
     * 返回值：
     * 求大于（含等于）， 返回left
     * 求小于（含等于）， 返回right
     * 核心思想：[left, right]为满足条件值区间范围，
     * 所以找左边界(即：大于等于)，是left, 找右边界(即：小于等于)，是right
     *
     */


    //704.二分查找
    public static int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    //35.搜索插入位置
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }

    //34.在排序数组中查找元素的第一个和最后一个位置
    public static int[] searchRange(int[] nums, int target) {
        int leftBorder = findBorder(nums, target, true);
        int rightBorder = findBorder(nums, target, false) - 1;
        if (leftBorder <= rightBorder
                && rightBorder < nums.length
                && nums[leftBorder] == target
                && nums[rightBorder] == target) {
            return new int[] {leftBorder, rightBorder};
        }
        return new int[]{-1,-1};
    }

    private static int findBorder(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    //69.x的平方根
    //其实就是二分查找，寻找右边界，这里注意超出int范围
    public int mySqrt(int x) {
        int left = 0, right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid*mid <= x) {
                left = mid + 1;
                res = left;
            } else {
                right = mid - 1;
            }
        }
        return res-1;
    }

    //367.有效的完全平方数
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid*mid == num) {
                return true;
            } else if ((long) mid*mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
