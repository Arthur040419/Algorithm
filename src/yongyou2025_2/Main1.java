package yongyou2025_2;

import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.substring(1,s.length()-1);
        String[] split = s.split("],\\(");
        int[][] input = new int[split.length][2];
        //获取输入数据
        //对input排序
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < split.length; i++) {
            String numberString = split[i];
            String[] numbers = numberString.split(",");
            input[i][0] = Integer.valueOf(numbers[0]);
            input[i][1] = Integer.valueOf(numbers[1]);
            if(input[i][0]>input[i][1]){
                System.out.println("false");
                return;
            }
            map.put(input[i][0],i);
        }

        StringBuilder sb = new StringBuilder();
        Integer lastEndValue = null;
        while (!map.isEmpty())
        {
            Map.Entry<Integer, Integer> firstEntry = map.firstEntry();
            int firstValue = input[firstEntry.getValue()][0];
            int lastValue = input[firstEntry.getValue()][1];
            if(lastEndValue!=null){
                firstValue = lastEndValue;
            }
            map.pollFirstEntry();
            if(map.isEmpty()){
                lastEndValue = 99;
            }
            if(sb.length()==0){
                sb.append(String.format("(%s,%s],",0,lastValue));
            }else {
                sb.append(String.format("(%s,%s],",firstValue,lastValue));
            }
            lastEndValue = lastValue;
        }
        sb.delete(sb.length()-1,sb.length());

        System.out.println(sb.toString());

    }

}
