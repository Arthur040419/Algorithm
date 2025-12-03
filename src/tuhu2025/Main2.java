package tuhu2025;

import java.util.Arrays;

public class Main2 {

    public int countNoActivityDays(int days, int[][] activities) {
        // write code here
        Arrays.sort(activities, ((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        }));
        int res = activities[0][0] - 1;
        int curEnd = activities[0][1];
        for (int i = 1; i < activities.length; i++) {
            if (activities[i][0] > curEnd) {
                res += activities[i][0] - curEnd - 1;
                curEnd = activities[i][1];
            } else {
                curEnd = Math.max(curEnd, activities[i][1]);
            }
        }
        res += days - curEnd;
        return res;
    }

}
