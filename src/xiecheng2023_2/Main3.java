package xiecheng2023_2;

import java.util.*;

//题3
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        LinkedList<Character> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(list1.isEmpty()||list1.peekLast()!=s.charAt(i)){
                list1.add(s.charAt(i));
                count++;
                if(list1.size()>1){
                    list2.add(count);
                    count=0;
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= list2.size()-k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum+=list2.get(i+j);
            }
            res = Math.max(res,sum);
        }
        System.out.println(res);
    }
}
