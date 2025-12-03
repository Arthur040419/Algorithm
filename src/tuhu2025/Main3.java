package tuhu2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main3 {

    public long calc_purchase_min_cost(long n, long m, long t, long[] x_i, long[] p_i, long[] a_i) {
        // write code here
        int sum = 0;
        for (int i = 0; i < a_i.length; i++) {
            sum += a_i[i];
        }
        if (sum < m) {
            return -1;
        }

        //计算每个供应商的零件平均成本
        double[] cost = new double[p_i.length];
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < x_i.length; i++) {
            cost[i] = (double) (a_i[i] * p_i[i] + 2 * Math.abs(x_i[i]) * t) / a_i[i];
            map.put(cost[i], i);
        }
        Arrays.sort(cost);

        int index = 0;
        long res = 0;
        boolean[] visited = new boolean[a_i.length];
        while (m != 0 && index < n) {
            int i = map.get(cost[index]);
            if (m >= a_i[i]) {
                m -= a_i[i];
                res += a_i[i] * p_i[i] + 2 * Math.abs(x_i[i]) * t;
                visited[i] = true;
            } else {
                res += getLowerCost(visited,m,t,x_i,p_i,a_i);
                m = 0;
            }
            index++;
        }
        return res;
    }

    public long getLowerCost(boolean[] visited, long m, long t, long[] x_i, long[] p_i, long[] a_i) {
        long res = Long.MAX_VALUE;
        for (int i = 0; i < a_i.length; i++) {
            if (!visited[i]) {
                res = Math.min(res, p_i[i] * m + 2 * Math.abs(x_i[i]) * t);
            }
        }
        return res;
    }

}
