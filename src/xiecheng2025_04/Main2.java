package xiecheng2025_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String s = "";
        int result = 0;
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                characterList.add(s.charAt(j));
            }
        }
        int left = 0;
        int right = characterList.size()-1;
        while(left<right){
            if(characterList.get(left)!=characterList.get(right)){
                result++;
            }
            left++;
            right--;
        }
        System.out.println(result);
    }
}
