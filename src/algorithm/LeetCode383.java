package algorithm;


//383.赎金信
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        /**思路：
         * 创建一个长度为26的整形数组ch[]，ch[0]代表字母a出现的次数，ch[1]代表字母b出现的次数，以此类推
         * 首先遍历ransomNote中的字符，用ch[]来统计每一个字符出现的次数
         * 接着遍历magazine中的字符，每遍历一个字符就在ch[]中让其对应的次数减1
         * 最后判断ch[]中是否存在大于0的元素，如果存在说明ransomNote不能由magazine的字符构成，反之则能。
         */

        if(ransomNote.length()>magazine.length()){
            //如果ransomNote的长度大于magazine，说明ransomNote根本不可能由magazine构成
            return false;
        }

        //创建数组
        int[] ch = new int[26];
        //遍历ransomNote中的字符
        for (int i = 0; i < ransomNote.length(); i++) {
            ch[ransomNote.charAt(i)-'a']++;
        }
        //遍历magazine中的字符
        for (int i = 0; i < magazine.length(); i++) {
            ch[magazine.charAt(i)-'a']--;
        }
        //判断ch[]中是否存在大于0的元素
        for (int i : ch) {
            if(i>0){
                return false;
            }
        }
        return true;
    }
}
