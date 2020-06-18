import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(1000000);
        int n = 1000000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println(maxHeap.getSize()+"==========");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            try {
                nums[i] = maxHeap.extractMax();
            } catch (Exception e) {
                System.out.println(i+"==========");
                System.out.println(maxHeap.getSize()+"==========");
                e.printStackTrace();
            }
        }
        for (int i = 0; i < n-1; i++) {
            if (nums[i] < nums[i+1])
                throw new IllegalArgumentException("出错！");
        }
    }
}
