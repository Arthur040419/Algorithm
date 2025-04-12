package csp_36;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int N = sc.nextInt();
        int q = sc.nextInt();
        //使用List集合和Map集合来模拟内存
        List<ArrayDeque<Integer>> cache = new ArrayList<>();
        //written用于记录内存中被修改过的内存块号
        Set<Integer> written = new HashSet<>();
        for (int i = 0; i < N; i++) {
            //Map集合代表每一组，key为内存块号，value为该内存块被存入的时间
            cache.add(new ArrayDeque<>());
        }

        //command表示操作命令
        int command;
        //number代表内存块号
        int number;
        for (int i = 0; i < q; i++) {
            command = sc.nextInt();
            number = sc.nextInt();
            switch (command) {
                case 0: {
                    //读操作
                    //获取组号
                    int gruop = (number / n) % N;
                    ArrayDeque<Integer> cacheGroup = cache.get(gruop);
                    boolean flag = cacheGroup.contains(number);
                    if (!flag) {
                        //如果没有命中就从内存中读取
                       read(number,cacheGroup,written,i);

                    } else {
                        //如果命中了，就更新使用时间
                        cacheGroup.remove(number);
                        cacheGroup.addFirst(number);
                    }
                    break;
                }
                case 1: {
                    //写操作
                    //获取组号
                    int gruop = (number / n) % N;
                    ArrayDeque<Integer> cacheGroup = cache.get(gruop);
                    boolean flag = cacheGroup.contains(number);
                    if(!flag){
                        //如果未命中
                        //从内存中读取数据
                        read(number,cacheGroup,written,i);
                        //并在内存中修改
                        written.add(number);
                    }else {
                        //如果命中
                        //直接在内存中修改
                        cacheGroup.remove(number);
                        cacheGroup.addFirst(number);
                        //在written中记录被修改的内存块号
                        written.add(number);
                    }
                    break;
                }
            }


        }
    }


    public static void read(Integer number,ArrayDeque<Integer> cacheGroup,Set<Integer> written ,int a){
        //存入缓存时要先判断是否还有空余位置
        if (cacheGroup.size() < 4) {
            //有空余位置就直接存入
            cacheGroup.addFirst(number);
        }else {
            //没有空余位置就替换最后一个
            Integer last = cacheGroup.peekLast();
            //判断要被替换的内存块是否被修改
            if(written.contains(last)){
                //如果被修改过就写入内存
                System.out.println(1+" "+last);
            }
            //替换内存
            cacheGroup.pollLast();
            cacheGroup.addFirst(number);
            written.remove(last);
        }
        //如果未命中，从内存中读取数据，并存入缓存
        System.out.println(0 + " " + number);
    }

}
