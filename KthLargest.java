import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public static void main(String args[]) {


        int k = 3;
        int arr[] = {4,5,8,2};

        int result = KLargest(k, arr);

        //System.out.println(result);

        System.out.println(add(3));
        System.out.println(add(5));
        System.out.println(add(10));
        System.out.println(add(9));
        System.out.println(add(4));

    }

    public static int KLargest (int k, int[] nums) {



        if (minHeap.size() == 0) {
            Arrays.sort(nums);

            int l = nums.length;
            int count = 0;
            int i = l-1;
            while (count < k) {
                minHeap.add(nums[i]);
                i--;
                count++;
            }
        }


        return minHeap.peek();
    }

    public static int add(int val) {
        if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }

        return minHeap.peek();
    }

}
