package xiecheng2023_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//携程2023春招第二批笔试-题1
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int tmp = num;
        List<Integer> nums = new ArrayList<>();
        while(tmp>0){
            nums.add(tmp%10);
            tmp/=10;
        }
        long res=0;
        for (int i = 0; i < nums.size(); i++) {
            long bit = (int)Math.pow(10,nums.size()-i);
            res = (long)(num/bit*10)+(long)(num%bit);
            if(i!=0){
                for (int j = 0; j < 10; j++) {
                    res+=j*bit;
                    if(res%7==0){
                        System.out.println(res);
                        return;
                    }
                    res-=j*bit;
                }
            }else {
                if(res%7==0){
                    System.out.println("0"+res);
                    return;
                }
                for (int j = 1; j < 10; j++) {
                    res+=j*bit;
                    if(res%7==0){
                        System.out.println(res);
                        return;
                    }
                    res-=j*bit;
                }
            }

        }
    }

}
