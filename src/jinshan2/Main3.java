package jinshan2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//实现单例
public class Main3 {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }

}

class Singleton {

    private static Singleton instance;
    private static Lock lock = new ReentrantLock();

    private Singleton() {

    }

    //write your code here......

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized ("Singleton") {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
