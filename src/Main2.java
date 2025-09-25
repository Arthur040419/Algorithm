import java.util.Random;
import java.util.Scanner;

public class Main2{

    public static void main(String[] args) {
        // 随机生成一个 1-100 的整数， 让一个玩家猜，玩家每次可以猜两个数字，游戏会告诉玩家哪个数字更接近，如此循环直到最终猜对。
        int num = new Random().nextInt(1,100);

        Scanner sc = new Scanner(System.in);
        System.out.println("请选择输入模式～");
        Input input = null;
        int mode = sc.nextInt();
        if(mode == 1){
            //手动输入
            while (sc.hasNext()){
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                int closer = n1;
                if(n1==num||n2==num) {
                    System.out.println("恭喜你，猜中了，答案是" + num);
                    return;
                }
                if(Math.abs(n2-num)<Math.abs(n1-num)){
                    closer = n2;
                }
                System.out.println(closer+"更接近最终答案～");
            }
        }else if(mode == 2) {
            //随机数策略

        }else if(mode ==3){
            //二分法策略

        }


    }

}
