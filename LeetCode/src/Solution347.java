import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a,b)->map.get(a) - map.get(b)
        );

        for (int num:map.keySet()){
            if (queue.size() < k){
                queue.add(num);
            }else {
                if (map.get(num) > map.get(queue.peek())){
                    queue.remove();
                    queue.add(num);
                }
            }
        }

        int[] res = new int[k];
        for (int i = k-1; i >= 0 ; i--) {
            res[i] = queue.remove();
        }
        return res;
    }
}
