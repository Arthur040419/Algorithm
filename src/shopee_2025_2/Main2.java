package shopee_2025_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) {
        int[] test = {10, 3};
        System.out.println(FindLargestNumber(test));
    }

    public static String FindLargestNumber(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            String max = null;
            int isVisited = 0;
            for (int j = 0; j < nums.length; j++) {
                String tmp = nums[j] + "";
                if (!visited[j] && max == null) {
                    max = tmp;
                }
                if (!visited[j] && tmp.charAt(0) >= max.charAt(0)) {
                    if (tmp.charAt(0) == max.charAt(0)) {
                        if(tmp.length()==max.length()){
                            max = tmp;
                            isVisited = j;
                        }else if(tmp.length()>max.length()){
                            int maxIndex = 1;
                            while (maxIndex<max.length()){
                                if(tmp.charAt(maxIndex)>max.charAt(maxIndex)){
                                    max = tmp;
                                    isVisited = j;
                                }
                                maxIndex++;
                            }
                        }
                    } else if (tmp.charAt(0) > max.charAt(0)) {
                        max = tmp;
                        isVisited = j;
                    }
                }

            }
            visited[isVisited] = true;
            result.append(max);
        }

        return result.toString();

    }

}
