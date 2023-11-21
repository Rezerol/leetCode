package removeMember;

public class RemoveElement {

    //27.移除元素
    //快慢指针法
    public static int removeElement1(int[] nums, int val) {
        int showIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[showIndex] = nums[fastIndex];
                showIndex++;
            }
        }
        return showIndex;
    }

    //双向指针法
    public static int removeElement2(int[] nums, int val) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            while (leftIndex <= rightIndex && nums[leftIndex] != val) {
                leftIndex++;
            }
            while (leftIndex <= rightIndex && nums[rightIndex] == val) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                nums[leftIndex] = nums[rightIndex];
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }


    //26. 删除有序数组中的重复项
    public static int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != nums[fastIndex - 1]) {
                nums[++slowIndex] = nums[fastIndex];
            }
        }
        return slowIndex+1;
    }

    //283. 移动零
    public static void moveZeroes(int[] nums) {
        int showIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                if (fastIndex != showIndex) {
                    int temp = nums[fastIndex];
                    nums[fastIndex] = nums[showIndex];
                    nums[showIndex++] = temp;
                } else {
                    showIndex++;
                }
            }
        }
    }

    //844. 比较含退格的字符串

}
