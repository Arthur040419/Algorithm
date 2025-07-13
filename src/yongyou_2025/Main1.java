package yongyou_2025;

import java.util.*;

//用友2025笔试第一题
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //存放已经相识的员工的序号
        Set<Integer> set = new HashSet<>();

        //初始化set
        set.add(sc.nextInt());
        set.add(sc.nextInt());

        //需要介绍的次数
        int r = 0;

        //直接相识的员工数组
        int[] entry = new int[2];

        //存放与set集合中的员工没有任何关系的entry
        List<int[]> list = new ArrayList<>();

        //先处理与set集合中员工有联系的entry
        for (int i = 1; i < m; i++) {
            entry[0] = sc.nextInt();
            entry[1] = sc.nextInt();

            if (!set.contains(entry[0]) && !set.contains(entry[1])) {
                list.add(entry);
            }else {
                set.add(entry[0]);
                set.add(entry[1]);
            }
        }

        //处理list中的关系
        for (int[] relation : list) {
            if(!set.contains(relation[0])&&!set.contains(relation[1])){
                r++;
            }
            set.add(relation[0]);
            set.add(relation[1]);
        }

        //处理剩下的员工
        r+=n-set.size();

        System.out.println(r);
    }
}
