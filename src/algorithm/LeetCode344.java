package algorithm;


//344.反转字符串
public class LeetCode344 {
    public void reverseString(char[] s) {
        //双指针法
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public void reverseStringWithBitOperation(char[] s) {
        //双指针法-后面回来写的代码-尝试交换操作采用位运算来交换
        int l=0;
        int r=s.length-1;
        while (l<r){
            //采用位运算来实现交换(异或运算)
            s[l]^=s[r];
            s[r]^=s[l];
            s[l]^=s[r];
            l++;
            r--;
        }
    }
}
