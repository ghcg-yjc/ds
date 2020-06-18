public class NumArray {
    private int[] arr;
    private int sum;

    public NumArray(int[] nums) {
        arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        sum = 0;
    }

    public int sumRange(int i, int j) {
        sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(arr);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
