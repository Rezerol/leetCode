package reverseString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseString {

    //344.反转字符串
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }

    //541.反转字符串 II
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < n; i+=2*k) {
            reverse(sChar, i, Math.min(i+k, n) - 1);
        }
        return new String(sChar);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }

    /*
        卡码网：替换数字
        给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。

        例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。

        对于输入字符串 "a5b"，函数应该将其转换为 "anumberb"

        输入：一个字符串 s,s 仅包含小写字母和数字字符。

        输出：打印一个新的字符串，其中每个数字字符都被替换为了number
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stringBuilder.append("number");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    //151. 反转字符串中的单词
    public String reverseWords(String s) {
        //去除首尾空格
        s = s.trim();
        //按空格分割出单词
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        //反转单词
        Collections.reverse(wordList);
        //组装结果
        return String.join(" ", wordList);
    }
    public String reverseWords2(String s) {
        int m = s.length() - 1;
        StringBuilder res = new StringBuilder();

        //去除尾部空格
        while(s.charAt(m) == ' ') {
            m--;
        }

        while (m >= 0) {
            //找到倒数的第一个单词尾部
            int n = m;
            while (m >= 0 && s.charAt(m) != ' ') {
                m--;
            }
            //记录单词
            res.append(s.substring(m+1, n+1) + " ");
            //寻找下一个单词
            while (m >= 0 && s.charAt(m) == ' ') {
                m--;
            }
            n = m;
        }
        return res.toString().substring(0, res.length() - 1);
    }
    public String reverseWords3(String s) {
        //1.去除多余空格
        StringBuilder sb = removeSpace(s);

        //2.整个字符串反转
        reverse(sb, 0, sb.length() - 1);

        //3.反转单词
        reverseWord(sb);

        return sb.toString();
    }
    private StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        //去除首尾空格
        while (s.charAt(left) == ' ') {
            left++;
        }
        while (s.charAt(right) == ' ') {
            right --;
        }

        //去除多余空格
        while (left <= right) {
            if (s.charAt(left) != ' ') {
                sb.append(s.charAt(left));
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(left));
            }
            left++;
        }
        return sb;
    }
    private void reverse(StringBuilder stringBuilder, int left, int right) {
        while (left < right) {
            char temp = stringBuilder.charAt(left);
            stringBuilder.setCharAt(left, stringBuilder.charAt(right));
            stringBuilder.setCharAt(right, temp);
            left++;
            right--;
        }
    }
    private void reverseWord(StringBuilder stringBuilder) {
        int start = 0; int end = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            start = i;
            while (i < stringBuilder.length() && stringBuilder.charAt(i) != ' ') {
                i++;
            }
            end = i - 1;
            reverse(stringBuilder, start, end);
        }
    }

}
