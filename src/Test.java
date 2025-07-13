import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws Exception{
        String s1 = "abc";
        String s2 = "bac";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
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