package isHappy;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {

    //202.快乐数
    public boolean isHappy(int n) {
        Set<Integer> record  = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp*temp;
            n = n / 10;
        }
        return sum;
    }
}
