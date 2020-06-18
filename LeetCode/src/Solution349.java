import java.util.ArrayList;
import java.util.HashSet;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums1) {
            set.add(num);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num:nums2) {
            if (set.contains(num)){
                arrayList.add(num);
                set.remove(num);
            }
        }

        int[] nums = new int[arrayList.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arrayList.get(i);
        }
        return nums;
    }
}
