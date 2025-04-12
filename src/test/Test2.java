package test;

public class Test2 implements TestInterface{
    @Override
    public void test1() {
        System.out.println("实现方法");
    }

    @Override
    public void test3() {
        System.out.println("重写接口的默认方法");
    }
}
