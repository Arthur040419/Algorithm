package algorithm;

//5.最长回文字串
public class LeetCode5 {
    /**
     * 思路：
     * 对于一个字符串，如果它的首尾不同，那么它一定不是回文串，如果它首尾相同，并且去掉首尾的子字符串是回文串，那么这个字符串也一定是回文串
     * 1.定义dp数组  dp[i][j]表示从下标i到下标j的子字符串是否为回文串
     * 2.定义状态转移方程
     * 有两种情况，对于长度为2的字串，只要首尾字符串相同，那它就是回文串
     * 对于长度大于2的子串，首尾字符相同的同时，只要去掉首尾的子串是回文串，它就是回文串
     * 3.初始化dp数组，对于长度为1的子串，一定是回文串，所以初始化dp[i][i]为true
     * 4.确定遍历顺序，由于长度越长的字符串的判断依赖于它的子串，因此按长度从小到大来遍历
     */
    public String longestPalindrome(String s) {
        //特殊处理
        if (s.length() < 2) return s;
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        }

        //最长回文串的起始位置
        int begin = 0;
        //最大长度,最少存在一个长度为1的回文串
        int maxLen = 1;

        //定义dp数组
        boolean[][] dp = new boolean[s.length()][s.length()];

        //初始化dp数组
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        //遍历dp数组
        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                if (s.charAt(i) == s.charAt(i + len - 1)) {
                    if(len==2){
                        dp[i][i+len-1]=true;
                    }else {
                        dp[i][i+len-1] = dp[i+1][i+len-2];
                    }
                }
                if(dp[i][i+len-1]&&len>maxLen){
                    maxLen = len;
                    begin = i;
                }

            }

        }
        return s.substring(begin,begin+maxLen);

    }
}
