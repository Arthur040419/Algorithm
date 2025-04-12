package test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test1 {
    public static void main(String[] args) {
        //PriorityQueue优先队列
        Queue<Student> queue = new PriorityQueue<>();
        //添加元素
        queue.add(new Student("arthur",30));
        queue.offer(new Student("sky",23));
        queue.offer(new Student("liren",20));
        System.out.println(queue);
        //移除并获取元素
        System.out.println(queue.poll());
        System.out.println(queue.remove());
//        System.out.println(queue.remove());
        System.out.println(queue);
        //获取元素但不删除
        System.out.println(queue.peek());
        System.out.println(queue.element());
        System.out.println(queue);

    }
}

//实现了Comparable接口的类就是可以进行比较的类，注意该接口是泛型接口，最好指定一下要比较的类
class Student implements Comparable<Student>{

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 重写比较逻辑，这里根据学生年龄按升序排序
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Student o) {
        //重写compareTo方法，自定义比较逻辑
        return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
