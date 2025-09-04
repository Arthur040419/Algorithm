import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws Exception{
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 1)));


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