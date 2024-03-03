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
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1; int j = t.length() - 1;
        int skipS = 0; int skipT = 0;
        while(i >= 0  || j >= 0) {
            //确定右边第一个用#消除不掉的字符
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS ++;
                    i --;
                } else if (skipS > 0) {
                    skipS --;
                    i --;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT ++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            //如果此时两个索引均有效，则要比较对应字符是否相等
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                //如果有一个字符的索引有效，一个无效，则说明两个字符通过#消除后，最终结果的长度不一致
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    //977.有序数组的平方
    public int[] sortedSquares(int[] nums) {
        int left = 0; int right = nums.length - 1;
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
