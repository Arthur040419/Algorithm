package shopee_2025_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(9);
        System.out.println(minEffort(test));
    }


    public static int minEffort(ArrayList<Integer> cases) {
        int ans = 0;
        while (cases.size() > 1) {
            Collections.sort(cases);
            int num1 = cases.get(0);
            int num2 = cases.get(1);
            ans = ans + num1 + num2;
            cases.remove(0);
            cases.remove(0);
            cases.add(num1+num2);
        }

        return ans;
    }

}
