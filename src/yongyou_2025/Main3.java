package yongyou_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2025用友笔试第三题
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()){
            list.add(sc.nextInt());
        }
        //所需棒棒糖数量
        int count = list.size();
        //每次需要额外的棒棒糖数量
        int extraCount = 0;
        //代表递增还是递减，0为递减，1为递增
        int mode = -1;

        int pre = 0;
        int cur = 1;
        while (cur!=list.size()){
            if(list.get(pre)-list.get(cur)>0){
                //如果是递减
                if(mode==0){
                    count+=extraCount;
                    count+=1;
                    extraCount+=1;
                }else {
                    extraCount = 1;
                    count+=1;
                    mode=0;
                }
            }else if(list.get(pre)-list.get(cur)<0){
                //如果是递增
                if(mode==1){
                    count+=extraCount;
                    count+=1;
                    extraCount+=1;
                }else {
                    extraCount=1;
                    count+=1;
                    mode = 1;
                }
            }else {
                //如果相等
                extraCount=0;
                mode = -1;
            }
        }

        System.out.println(count);
    }


    public int distributeBons (int[] hungers) {
        if(hungers.length==1){
            return 1;
        }

        //所需棒棒糖数量
        int count = hungers.length;
        //每次需要额外的棒棒糖数量
        int extraCount = 0;
        //代表递增还是递减，0为递减，1为递增
        int mode = -1;

        int pre = 0;
        int cur = 1;
        while (cur!=hungers.length){
            if(hungers[pre]-hungers[cur]>0){
                //如果是递减
                if(mode==0){
                    count+=extraCount;
                    count+=1;
                    extraCount+=1;
                }else if(mode==1){

                } else {
                    extraCount = 1;
                    count+=1;
                    mode=0;
                }
            }else if(hungers[pre]-hungers[cur]<0){
                //如果是递增
                if(mode==1){
                    count+=extraCount;
                    count+=1;
                    extraCount+=1;
                }else {
                    extraCount=1;
                    count+=1;
                    mode = 1;
                }
            }else {
                //如果相等
                extraCount=0;
                mode = -1;
            }
            cur++;
            pre++;
        }

        return count;
    }
}
