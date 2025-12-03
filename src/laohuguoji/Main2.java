package laohuguoji;

//分隔数组的最优平衡值
public class Main2 {

    public int splitArray(int[] nums, int k, int limit) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum * k > sum) {
            return -1;
        }

        return 0;
    }
}
