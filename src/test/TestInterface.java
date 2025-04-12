package test;

public interface TestInterface {
    //测试接口的属性和方法
    //接口中只能定义常量
    int a=0;

    //普通抽象方法
    void test1();


    //私有方法，只能在接口内部使用
    private void test2(){

    }

    //默认方法
    default void test3(){
        System.out.println("接口的默认方法");
    }

    //静态方法
    static void test4(){
        System.out.println("接口的静态方法");
    }

}
