package test;

import algorithm.LeetCode202;


public class TestMethod {

    //@Test
    public void test(){

        Test2 test2 = new Test2();
        //静态变量
        System.out.println(Test2.a);
        //静态方法
        TestInterface.test4();
        //默认方法
        test2.test3();
    }
}
