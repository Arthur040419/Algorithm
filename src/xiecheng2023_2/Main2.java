package xiecheng2023_2;

import java.util.Scanner;

//题2
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] bits = {'0','1'};
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            int index = i;
            int tmpCost = 0;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)!=bits[index]){
                    tmpCost+=j+1;
                }
                index=(index+1)%2;
            }
            cost=Math.min(cost,tmpCost);
        }
        System.out.println(cost);
    }
}
