package generateMatrix;

import java.util.ArrayList;
import java.util.List;

public class GenerateMatrix {

    //59.螺旋矩阵 II
    public static int[][] generateMatrix(int n) {
        //画圈的圈数，也是循环数
        int loop = 0;

        int[][] res = new int[n][n];
        //起始位置[start][start]
        int start = 0;
        int row = 0, col = 0;

        //赋值计数
        int count = 1;

        //n维的矩阵，走一圈，上下都经历，因此循序数是n/2
        while (loop++ < n/2) {
            //从左到右，闭开区间[start, n-loop)赋值，
            for (col = start; col < n - loop; col ++) {
                res[start][col] = count;
                count++;
            }

            //从上到下
            for (row = start; row < n - loop; row++) {
                res[row][col] = count;
                count++;
            }

            //从右到左
            for (; col >= loop; col--) {
                res[row][col] = count;
                count++;
            }

            //从下到上
            for (; row >= loop; row--) {
                res[row][col] = count;
                count++;
            }
            start++;
        }

        //如果除不整，则中心要赋值一个
        if (n%2 == 1) {
            res[start][start] = count;
        }
        return res;
    }
    //更简单的思路,定义四条边界
    public static int[][] generateMatrix1(int n) {
        int[][] res = new int[n][n];
        int count = 1;

        //定义出四条边界
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        //对于变量的边界定义：
        //从左到右填充：填充的列肯定在[left, right]区间内
        //从上到下填充：填充的行肯定在[top, bottom]区间内
        //从右到左填充：填充的列肯定在[right, left]区间内
        //从下到上填充：填充的行肯定在[bottom, top]区间内
        while (true) {
            //从左到右填充，填充完时对应上边界也就缩小1；
            for (int j = left; j <=right; j++) {
                res[top][j] = count++;
            }
            //上边界向下缩小
            top++;
            if (top > bottom) {
                break;
            }
            //从上到下填充，填充完时对应右边界也就缩小1；
            for (int i = top; i <= bottom; i++) {
                res[i][right] = count++;
            }
            //右边界向左缩小
            right--;
            if (right < left) {
                break;
            }
            //从右到左填充，填充完时对应下边界也就缩小1；
            for (int j = right; j >= left; j--) {
                res[bottom][j] = count++;
            }
            //下边界向上缩小
            bottom--;
            if(bottom < top) {
                break;
            }
            //从下到上填充，填充完时对应做边界也就缩小1；
            for (int i = bottom; i >= top; i--) {
                res[i][left] = count++;
            }
            //左边界向右缩小
            left++;
            if (left > right) {
                break;
            }
        }
        return res;
    }

    //54.螺旋矩阵
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

        while (true) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            for (int j = right; j >= left; j--) {
                res.add(matrix[bottom][j]);
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return res;
    }

}
