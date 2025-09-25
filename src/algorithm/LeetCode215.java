package algorithm;

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
