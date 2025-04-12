package algorithm;

import java.util.HashSet;
import java.util.Set;

//快乐数
public class LeetCode202 {

    public boolean isHappy_My(int n) {
        /*思路：
         * 用一个Set集合来存储每次数字平方和的结果
         * 每次计算平方和的时候都在Set集合里面找一下有没有重复的结果，如果有，说明出现了循环，直接返回false
         * 没有重复就接着计算平方和，直到最后结果变为1
         * */

        Set<Integer> set = new HashSet<>();
        //临时变量，用于计算平方和，tmp用于记住n的值，sum用于记住平方和的值，bit表示每一位的数字
        int tmp = 0;
        int sum = 0;
        int bit = 0;

        while (n != 1) {
            //计算平方和
            tmp = n;
            while (tmp != 0) {
                bit = tmp % 10;
                sum += bit * bit;
                tmp /= 10;
            }
            //判断是否重复
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
            sum = 0;
        }
        return true;
    }

    public boolean isHappy(int n) {
        //思路是一样的，但是代码的写法不一样，参考的别人的写法

        Set<Integer> record = new HashSet<>();

        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = nextNumber(n);
        }
        return n==1;
    }

    public int nextNumber(int n) {
        //该方法返回n的每位的平方和
        int sum = 0;
        while (n > 0) {
            int tmp = n%10;
            sum+=tmp*tmp;
            n/=10;
        }
        return sum;
    }
}
