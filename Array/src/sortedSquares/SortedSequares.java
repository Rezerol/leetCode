package sortedSquares;

public class SortedSequares {

    //977.有序数组的平方, 双指针法
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        int pos = nums.length - 1;
        while (left <= right) {
            //nums是非严格递增的，且有可能包含负数，因此
            //在负数区间，左边的数平方值最大，正数区间，右边的数平方值最大
            //比较两边值中平方数大的逆序放到结果中，即可拿到结果
            if(nums[left] * nums[left] < nums[right] * nums[right]) {
                res[pos] = nums[right] * nums[right];
                right --;
            } else {
                res[pos] = nums[left] * nums[left];
                left ++;
            }
            pos --;
        }
        return res;
    }
}
