package shopee_2025_2;

public class Main1 {

    public static void main(String[] args) {

    }


    public static int[] minAvailableDuration(int[][] A, int[][] B, int duration) {

        int[] result = new int[2];
        for (int[] timeA : A) {
            for (int[] timeB : B) {
                if(timeB[0]<timeA[0]||timeB[0]>timeA[1]){
                    continue;
                }
                int start = Math.max(timeA[0],timeB[0]);
                int end = Math.min(timeA[1],timeB[1]);
                if(end-start>=duration){
                    result[0] = start;
                    result[1] = start+duration;
                    return result;
                }
            }
        }
        return null;

    }

}
