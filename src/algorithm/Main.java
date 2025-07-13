package algorithm;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        //A 135000 B 246
        int[] arr1 = new int[]{1,0};
        int[] arr2 = new int[]{2};

        merge(arr1,arr2);
    }

    public static void merge(int[] arr1,int[] arr2){
        //寻找数组A的最后一个元素
        int indexA = 1;
        while (arr1[indexA-1]<=arr1[indexA]){
            indexA++;
        }

        indexA-=1;

        int indexB = arr2.length-1;
        int last = arr1.length-1;

        while (0<=indexA&&0<=indexB){
            if(arr1[indexA]<=arr2[indexB]){
                arr1[last] = arr2[indexB];
                indexB--;
            }else {
                arr1[last] = arr1[indexA];
                indexA--;
            }
            last--;
        }

        //处理还没遍历完的数组
        if(indexA>=0){
            handleLeftArr(indexA,arr1,last,arr1);
        }
        if(indexB>=0){
            handleLeftArr(indexB,arr2,last,arr1);
        }

        System.out.println(Arrays.toString(arr1));
    }
    public static void handleLeftArr(int index,int[] leftArr,int last, int[] target){
       while (index>=0) {
           target[last] = leftArr[index];
           index--;
           last--;
       }
    }
}
