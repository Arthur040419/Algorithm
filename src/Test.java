

public class Test {
    public static void main(String[] args) throws Exception{
        Father a = new Son();
        a.say();            //对于普通成员方法，调用的是Son类的say方法，说明普通成员方法被子类成功重写了
        a.action();         //对于类静态方法，调用的是Father类的action方法，这说明子类虽然有一个方法名与父类一模一样的静态方法，但是并不算子类重写了父类的该方法
    }
}

class Father{


    public void say(){
        System.out.println("爸爸在说话");
    }

    public static void action(){
        System.out.println("爸爸教训儿子");
    }
}

class Son extends Father{
    public void say(){
        System.out.println("儿子在说话");
    }

    public static void action(){
        System.out.println("儿子哇哇大哭");
    }
}