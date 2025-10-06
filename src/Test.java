import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws Exception{}

    public static String getTeam(String students){
        int start = 0;
        int maxLen = 0;
        int curLen = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while(right<students.length()){
            if(!set.contains(students.charAt(right))){
                set.add(students.charAt(right));
                curLen++;
                if(curLen>maxLen){
                    start = left;
                    maxLen = curLen;
                }
                right++;
            }else{
                set.remove(students.charAt(left));
                left++;
                curLen--;
            }
        }
        return students.substring(start,start+maxLen);
    }

class Father{


    public void say(){
        System.out.println("爸爸在说话");
    }

    public static void action(){
        System.out.println("爸爸教训儿子");
    }
}

class Son extends Father{
    public void say(){
        System.out.println("儿子在说话");
    }

    public static void action(){
        System.out.println("儿子哇哇大哭");
    }
}