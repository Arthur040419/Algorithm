package algorithm;

//有效的字母异位词
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        /*新建一个长度为26的整形数组，将每个字母依次映射为不同的索引，如：a映射为0，b映射为1，以此类推
        * 首先遍历s的字符，每遍历一个字符就在对应索引位置+1
        * 再遍历t的字符，每遍历一个字符就在对应索引位置-1
        * 最后判断数组中是否存在不为0的位置，如果存在不为0的位置，说明s或t其中一个字符串存在多出来的字符
        */

        //创建数组
        int[] arr = new int[26];
        //遍历字符串s
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        //遍历字符串t
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)-'a']--;
        }
        //检查数组是否存在非0的位置
        for (int i : arr) {
            if(i!=0){
                return false;
            }
        }
        //如果数组所有位置都为0，说明t是s的字母异位词
        return true;
    }
}
