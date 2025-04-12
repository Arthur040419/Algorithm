package algorithm;


//541.反转字符串II
public class LeetCode541 {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

    public static String reverseStr(String s, int k) {
        /**
         * 思路：
         * 通过字符串长度和k就可以计算出最少要反转的次数为：n=s.length/2k
         * 在第i次反转中，left指针为(i-1)*2k，right指针为left+k-1
         * 如果最后剩下的字符数小于k，那么反转所有剩余字符时的left指针为n*2k，right指针为s.length-1
         * 如果最后剩下的字符数大于k，left指针为n*2k，right指针为left+k-1
         */
        char[] chars = s.toCharArray();
        int n = s.length()/(2*k);
        for (int i = 1; i <= n; i++) {
            int left = (i-1)*2*k;
            int right = left+k-1;
            reverse(left,right,chars);
        }

        int leftChars = s.length()%(2*k);
        if(leftChars<k){
            int left = n*2*k;
            int right = s.length()-1;
            reverse(left,right,chars);
        }else{
            int left=n*2*k;
            int right=left+k-1;
            reverse(left,right,chars);
        }
//        StringBuilder sb = new StringBuilder();
//        sb.append(chars);
//        String result = sb.toString();
//        return new String(chars);
        return String.valueOf(chars);
    }

    public static void reverse(int left,int right,char[] chars){
        while(left<right){
            char tmp = chars[left];
            chars[left]=chars[right];
            chars[right]=tmp;
            left++;
            right--;
        }
    }
}
