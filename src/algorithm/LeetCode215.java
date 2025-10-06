package algorithm;

//215.数组中的第K个最大元素_Review
public class LeetCode215_Review {

    public static void main(String[] args) {
        int[] test = {3,2,1,5,6,4};
        System.out.println(findKthLargest(test, 2));
    }


    public static int findKthLargest(int[] nums, int k) {
        /**
         * 思路1：快速选择，快速排序的改进方法
         * 我们知道快速排序在排序数组时是先找一个基准值，然后将所有小于基准值的放在基准值左边，所有大于基准值的放在基准值右边
         * 那么，假设被放到左边的元素有x个，被放到右边的元素有y个，那么就可以认为基准值是整个序列中的第y+1个大
         * 所以回到这一题，我们使用基于快速排序改进来的快速选择法，每找到一个基准值，判断该基准值的右边一共有多少个数，如果该数字是k-1，那么就可以认为基准值是最终答案，并不需要关系具体的排序。
         *
         */

        return quickChoice(nums,0,nums.length-1,k);

    }

    public static int quickChoice(int[] nums, int left, int right, int k) {
        //取最右边的作为基准值
        int standard = nums[right];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[l] <= standard) {
                l++;
            }

            while (l < r && nums[r] >= standard) {
                r--;
            }

            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        if (right - l + 1 == k) {
            return standard;
        } else if (right - l + 1 > k) {
            return quickChoice(nums, l, right - 1, k);
        } else {
            return quickChoice(nums, left, l - 1, k - right + l - 1);
        }   
     }        
   }

//215.数组中第k大的数
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, heapSize, 0);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, heapSize, i);
        }
    }

    public void maxHeapify(int[] nums, int heapSize, int i) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums,largest,i);
            maxHeapify(nums, heapSize, largest);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
