package csp_36;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String move = sc.next();
            for (int j = 0; j < move.length(); j++) {
                char movement = move.charAt(j);
                switch (movement) {
                    case 'f': {
                        //向前移动
                        if(y+1<=n){
                            y=y+1;
                        }
                        break;
                    }
                    case 'b': {
                        //向后移动
                        if(y-1>=1){
                            y=y-1;
                        }
                        break;
                    }
                    case 'l': {
                        //向左移动
                        if(x-1>=1){
                            x=x-1;
                        }
                        break;
                    }
                    case 'r': {
                        //向右移动
                        if(x+1<=n){
                            x=x+1;
                        }
                        break;
                    }

                }
            }
            System.out.println(x+" "+y);
        }

    }
}
