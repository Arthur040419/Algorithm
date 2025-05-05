package xiecheng2023_02;

import java.util.Scanner;

//2023年携程秋招技术通用岗第二批笔试
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        //第一个矩阵中1出现的索引
        int[] a = new int[4];
        //第二个矩阵1出现的索引
        int[] b = new int[4];
        for (int i = 0; i < t; i++) {
            //countOne统计1出现的次数
            int countOne = 0;
            //countZero统计0出现的次数
            int countZero=0;
            //统计矩阵中01的数量情况
            int count=0;
            //输入第一个矩阵
            for (int j = 0; j < 4; j++) {
                int num=in.nextInt();
                if(num==0){
                    countZero++;
                } else{
                    a[count++]=j;
                    countOne++;
                }
            }
            count=0;
            //输入第二个矩阵
            for (int j = 0; j < 4; j++) {
                int num=in.nextInt();
                if(num==0){
                    countZero++;
                } else{
                    b[count++]=j;
                    countOne++;
                }
            }
            //如果01数量不匹配，直接返回-1
            if(countZero!=0||countOne!=0){
                System.out.println(-1);
            }

            //接下来处理矩阵
            //如果只有1个1或者1个0
            if(count==1){
                //只有1个1


            }else if(count==3){
                //只有1个0
            }

        }


    }


}
