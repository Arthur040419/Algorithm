package tuhu2025;

public class Main1 {

    public int[] finalRewards(int[] rewards) {
        // write code here

        int[] res = new int[rewards.length];
        for (int i = 0; i < rewards.length; i++) {
            for (int j = i + 1; j < rewards.length; j++) {
                if (rewards[j] <= rewards[i]) {
                    res[i] = rewards[i] + rewards[j];
                    break;
                }
            }
            if (res[i] == 0) {
                res[i] = rewards[i];
            }
        }
        return res;
    }

}
