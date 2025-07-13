package algorithm;

//11.盛最多水的容器
public class LeetCode11 {

    //最优解法，双指针
    public int maxArea(int[] height) {
        /**
         * 思路：双指针
         * 左指针指向最左边的边界，右指针指向最右边的边界，假设此时左右指针的距离为t
         * 那么此时 体积 area = height[left]*height[right]*t
         * 此时如果我们想获取更大的体积，只能移动左右指针中值较小的那一个，因为移动指针的同时t一定会变小，所以要尝试让另一个边界变大，也就是移动值较小的那个指针
         * 这样一来我们就可以尽可能地找到较大的值，从而不断更新结果
         */

        int area = 0;
        int left = 0;
        int right = height.length-1;

        int curArea = 0;
        while (left<right){
            curArea = (right-left)*Math.min(height[left],height[right]);
            area = Math.max(area,curArea);
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return area;

    }

    public int maxArea_My(int[] height) {
        /**
         * 思路：最简单的暴力解法，遍历每一种垂线的组合
         * 但是肯定会超时
         */

        int area = 0;

        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int curArea = (j-i)*Math.min(height[i],height[j]);
                area = Math.max(area,curArea);
            }
        }
        return area;
    }
}
