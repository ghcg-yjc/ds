import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums1){
            if (map.get(num) != null){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int num:nums2){
            if (map.get(num) != null){
                if (map2.get(num) != null)
                    map2.put(num,map2.get(num)+1);
                else
                    map2.put(num,1);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        Set<Integer> keySet = map2.keySet();
        int count;
        for (int num:keySet) {
            count = Math.min(map.get(num),map2.get(num));
            for (int i = 0; i < count; i++) {
                arrayList.add(num);
            }
        }
        int[] nums = new int[arrayList.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arrayList.get(i);
        }
        return nums;
    }
}
