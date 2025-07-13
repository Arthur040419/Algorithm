package JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//多线程打印ABC
public class Abc {

    //count用于控制打印次数
    int count = 0;
    //用来控制线程是否打印，比如对于打印A的线程只有当states%3等于0时才打印
    int states = 0;
    Lock lock = new ReentrantLock();

    public Abc(int count) {
        this.count = count;
    }

    //加锁方式
    public void printChar(char targetChar, int targetState) {

        //打印count次
        for (int i = 0; i < count;) {
            //每次打印前加锁
            lock.lock();
            //如果状态正确才打印字符
            if (states % 3 == targetState) {
                System.out.print(targetChar);
                states++;
                i++;
            }
            //打印完后释放锁
            lock.unlock();
        }

    }


    public static void main(String[] args) {
        //打印10次ABC
        Abc abc = new Abc(10);

        //开启三个线程,分别打印A、B、C
        new Thread(() -> {abc.printChar('A', 0);}).start();

        new Thread(() -> {abc.printChar('B', 1);}).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                abc.printChar('C', 2);
            }
        }).start();


    }

}
