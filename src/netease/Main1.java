package netease;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Deque<Character> stack1 = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (c == '{' && stack1.size() < 2) {
                stack1.push(c);
            }else if (c == '{' && stack1.size() >= 2) {
                System.out.println("false");
                return;
            }

            if (c == '}' && stack1.size() >= 2 && stack1.size() < 4) {
                stack1.push(c);
            }else if(c=='}'&&stack1.size()<=1){
                System.out.println("false");
                return;
            }
            if (c != '{' && c != '}' && stack1.size() == 2) {
                sb.append(c);
            }
            if(stack1.size()==4){
                if("".equals(sb.toString())||"                                         ".contains(sb.toString())){
                    System.out.println("false");
                    return;
                }
                stack1.clear();
            }
        }
        System.out.println("true");
    }

}
