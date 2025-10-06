package youkushengshi2026;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int result = 0;
            int countOne = 0;
            while (num != 0) {
                int tmp = num;
                while (tmp != 0) {
                    if ((tmp & 1) == 1) {
                        countOne++;
                    }
                    tmp >>= 1;
                }
            }
            if(countOne%2==1){
                num^=1;
            }else {

            }
            System.out.println(num);
        }
    }


}
